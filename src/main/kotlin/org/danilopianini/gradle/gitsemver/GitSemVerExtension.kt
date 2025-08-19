package org.danilopianini.gradle.gitsemver

import com.github.benmanes.caffeine.cache.Caffeine
import java.io.File
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toJavaDuration
import org.danilopianini.gradle.gitsemver.source.GitCommandValueSource
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.slf4j.Logger

/**
 * The plugin extension with the DSL.
 *
 * Supports the following properties:
 * - [minimumVersion], defaulting to 0.1.0
 * - [developmentIdentifier], the identifier for the in-development versions
 * - [noTagIdentifier], the identifier for early versions of the project, when no tags are available yet
 * - [fullHash], whether to use the full commit hash as build metadata
 * - [maxVersionLength], cuts the version to the specified length. Useful for some destinations,
 *      e.g., the Gradle Plugin Portal, which limits version numbers to 20 chars.
 * - [developmentCounterLength], how many digits to use for the counter
 * - [enforceSemanticVersioning], whether the system should fail or just warn
 *      in case a non-SemVer compatible version gets produced
 * - [computeReleaseVersion], determines whether the version is to be calculated for the release or pre-release
 *      (default behavior)
 * - [preReleaseSeparator], how to separate the pre-release information.
 *      Changing this value may generate non-SemVer-compatible versions.
 * - [buildMetadataSeparator], how to separate the pre-release information.
 *      Some destinations (e.g., the Gradle Plugin Portal) do not support the default value '+'.
 *      A reasonable alternative is using '-', lifting the build metadata to a pre-release segment.
 * - [distanceCounterRadix], the radix for the commit counter. Defaults to base 36. Bases from 2 to 36 allowed.
 * - [versionPrefix], to be used in case tags are prefixed with some symbols before the semantic version
 *      (e.g., v1.0.0 is prefixed with "v").
 * - [includeLightweightTags], to be used in case lightweight tags should be considered.
 * - [forceVersionPropertyName], the name of the property that, if set, will force the plugin to use the specified
 *      version. By default, the property name is "forceVersion".
 */
open class GitSemVerExtension
@JvmOverloads
constructor(
    private val project: Project,
    private val providerFactory: ProviderFactory,
    private val objectFactory: ObjectFactory,
    private val projectDir: File,
    private val version: String,
    private val logger: Logger,
    val buildMetadataSeparator: Property<String> = objectFactory.propertyWithDefault("+"),
    val computeReleaseVersion: Property<Boolean> = objectFactory.propertyWithDefault(false),
    val developmentCounterLength: Property<Int> = objectFactory.propertyWithDefault(2),
    val developmentIdentifier: Property<String> = objectFactory.propertyWithDefault("dev"),
    val distanceCounterRadix: Property<Int> = objectFactory.propertyWithDefault(DEFAULT_RADIX),
    val enforceSemanticVersioning: Property<Boolean> = objectFactory.propertyWithDefault(true),
    val forceVersionPropertyName: Property<String> = objectFactory.propertyWithDefault("forceVersion"),
    val fullHash: Property<Boolean> = objectFactory.propertyWithDefault(false),
    val includeLightweightTags: Property<Boolean> = objectFactory.propertyWithDefault(true),
    val maxVersionLength: Property<Int> = objectFactory.propertyWithDefault(Int.MAX_VALUE),
    val minimumVersion: Property<String> = objectFactory.propertyWithDefault("0.1.0"),
    val noTagIdentifier: Property<String> = objectFactory.propertyWithDefault("archeo"),
    val preReleaseSeparator: Property<String> = objectFactory.propertyWithDefault("-"),
    val versionPrefix: Property<String> = objectFactory.propertyWithDefault(""),
    private var updateStrategy: (List<String>) -> UpdateType = { _ -> UpdateType.PATCH },
) {

    private val versions = Caffeine.newBuilder()
        .expireAfterAccess(1.minutes.toJavaDuration())
        .build<Pair<String, String>, String> { _ -> computeVersion() }

    private fun minSemanticVersion(): SemanticVersion = minimumVersion.map {
        checkNotNull(SemanticVersion.fromStringOrNull(it)) {
            "Invalid minimum version does not conform to Semantic Versioning 2.0: $it"
        }
    }.get()

    /**
     * The version computed by the plugin, computed lazily.
     * Avoid calling this property's `toString()` method during the configuration phase,
     * as it will trigger the computation of the version, which should happen as late as possible.
     */
    val gitSensitiveSemanticVersion = object {
        val version: String by lazy {
            val forcedVersion = project.properties[forceVersionPropertyName.get()]?.toString()
                ?.also { forcedVersion ->
                    project.logger.lifecycle(
                        "Forcing {} version to {} as per property '{}'",
                        project.name,
                        forcedVersion,
                        forceVersionPropertyName.get(),
                    )
                }
            val computedVersion = forcedVersion ?: run {
                val repoLocation = runCommand("git", "rev-parse", "--show-toplevel")
                val headCommitHash = runCommand("git", "rev-parse", "HEAD")
                when {
                    repoLocation != null && headCommitHash != null -> versions[repoLocation to headCommitHash]
                    else -> {
                        project.logger.warn(
                            "Could not detect the git repository location ({}) and the HEAD commit hash ({}). " +
                                "The version will be forcibly recomputed.",
                            repoLocation,
                            headCommitHash,
                        )
                        computeVersion()
                    }
                }
            }
            when (val resultingVersion = SemanticVersion.fromStringOrNull(computedVersion)) {
                null -> {
                    val error = "Invalid Semantic Versioning 2.0 version: $resultingVersion"
                    if (enforceSemanticVersioning.get()) error(error) else logger.warn(error)
                    computedVersion
                }
                else -> resultingVersion.toString()
            }
        }

        override fun equals(other: Any?): Boolean = when (other) {
            is GitSemVerExtension -> toString() == other.toString()
            else -> error(
                "Git-Sensitive Semantic Versions should not be compared with other objects. " +
                    "Call `toString()` and compare the String form instead.",
            )
        }

        override fun hashCode(): Int = toString().hashCode()

        override fun toString(): String = version
    }

    /**
     * Sets the strategy to be used to compute the version increment
     * based on the commit messages since the last tag.
     * The default strategy is to increment the patch version.
     *
     * @param strategy a function that takes the list of commit messages since the last tag
     * and returns the update type
     */
    fun commitNameBasedUpdateStrategy(strategy: (List<String>) -> UpdateType) {
        updateStrategy = strategy
    }

    private fun computeMinVersion(): SemanticVersion {
        val minVersion = minimumVersion.get()
        val minSemVer = SemanticVersion.fromStringOrNull(minVersion)?.withoutBuildMetadata()
        requireNotNull(minSemVer) {
            "Invalid minimum version does not conform to Semantic Versioning 2.0: $minVersion"
        }
        if (!minSemVer.buildMetadata.isEmpty()) {
            logger.warn("Minimum version $minSemVer build metadata will be ignored.")
        }
        return minSemVer
    }

    /**
     * Finds the closest tag compatible with Semantic Version, or returns null if none is available.
     */
    fun findClosestTag(): SemanticVersion? {
        val reachableCommits = runCommand("git", "rev-list", "HEAD")?.lines()?.toSet().orEmpty()
        val tagMatcher = Regex(
            """^(\w*)\s+(${
                if (includeLightweightTags.get()) "commit|" else ""
            }tag)\s+refs/tags/${
                versionPrefix.get()
            }(${
                SemanticVersion.SEM_VER_REGEX_STRING
            })$""",
        )
        logger.debug("Reachable commits: {}", reachableCommits)
        return runCommand("git", "for-each-ref", "refs/tags", "--sort=-version:refname")
            ?.lineSequence()
            ?.mapNotNull { tagMatcher.matchEntire(it)?.destructured }
            ?.mapNotNull { (commit, type: String, semVer, major, minor, patch, option, build) ->
                val actualRef = when (type) {
                    "commit" -> commit
                    "tag" -> runCommand("git", "rev-list", "-n1", versionPrefix.get() + semVer)
                    else -> error("Unknown tag ref type '$type' (expected 'tag' or 'commit')")
                }
                actualRef.takeIf { it in reachableCommits }?.let {
                    SemanticVersion(major, minor, patch, option, build)
                }
            }?.firstOrNull()
    }

    /**
     * Computes a valid Semantic Versioning 2.0 version based on the status of the current git repository.
     */
    fun computeVersion(): String {
        val closestTag = findClosestTag()
        logger.debug("Closest SemVer tag: {}", closestTag)
        val fullHash = fullHash.get()
        val printCommitCommand = "git log -1 --format=%${if (fullHash) "H" else "h"}".split(" ")
        val hash = runCommand(*printCommitCommand.toTypedArray())
            ?.takeIf { it.isNotBlank() }
            ?.also {
                val regex = "[0-9a-f]{${if (fullHash) GIT_HASH_LENGTH else GIT_SHORT_HASH_LENGTH}}"
                check(it.matches(regex.toRegex())) {
                    "Invalid commit hash (should have matched $regex): $it"
                }
            }
            ?: System.currentTimeMillis().toString()
        return when (closestTag) {
            null -> {
                /**
                 * No tags found, the version is the minimum version, with the hash as build metadata.
                 */
                val base = computeMinVersion()
                val identifier = noTagIdentifier.getOrElse("")
                val computeReleaseVersion = computeReleaseVersion.get()
                val separator = if (identifier.isBlank()) "" else preReleaseSeparator.get()
                val buildSeparator = buildMetadataSeparator.get()
                if (computeReleaseVersion) {
                    "$base".take(maxVersionLength.get())
                } else {
                    "$base$separator$identifier$buildSeparator$hash".take(maxVersionLength.get())
                }
            }
            else -> {
                if (!closestTag.buildMetadata.isEmpty()) {
                    logger.warn("Build metadata of closest tag $closestTag will be ignored.")
                }
                val commitRange = "${versionPrefix.get()}$closestTag..HEAD"
                val distance = runCommand("git", "rev-list", "--count", commitRange)?.toLong()
                requireNotNull(distance) {
                    "Bug in git SemVer plugin: [distance? $distance]. Please report at: " +
                        "https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues"
                }
                when (distance) {
                    0L -> closestTag.toString()
                    else -> {
                        val lastCommits = runCommand(
                            "git",
                            "log",
                            "--oneline",
                            "-$distance",
                            "--no-decorate",
                            "--format=%s",
                        )?.lines().orEmpty()
                        val currentVersion = maxOf(
                            updateStrategy(lastCommits).incrementVersion(closestTag),
                            minSemanticVersion(),
                        ).withoutBuildMetadata()
                        val devString = developmentIdentifier.get()
                        val computeReleaseVersion = computeReleaseVersion.get()
                        val separator = if (devString.isBlank()) "" else preReleaseSeparator.get()
                        val distanceString = distance.withRadix(
                            distanceCounterRadix.get(),
                            developmentCounterLength.get(),
                        )
                        val buildSeparator = buildMetadataSeparator.get()
                        if (computeReleaseVersion) {
                            "$currentVersion".take(maxVersionLength.get())
                        } else {
                            "$currentVersion$separator$devString$distanceString$buildSeparator$hash"
                                .take(maxVersionLength.get())
                        }
                    }
                }
            }
        }
    }

    /**
     * modifies the version of the current project, assigning the value computed by [computeVersion].
     */
    fun assignGitSemanticVersion() {
        project.version = gitSensitiveSemanticVersion
    }

    /**
     * If called, the system will also consider non-annotated tags.
     */
    fun excludeLightweightTags() {
        includeLightweightTags.set(false)
    }

    override fun toString(): String = """
        $EXTENSION_NAME {
            buildMetadataSeparator = "${buildMetadataSeparator.get()}"
            computeReleaseVersion = ${computeReleaseVersion.get()}
            developmentCounterLength = ${developmentCounterLength.get()}
            developmentIdentifier = "${developmentIdentifier.get()}"
            distanceCounterRadix = ${distanceCounterRadix.get()}
            enforceSemanticVersioning = "${enforceSemanticVersioning.get()}"
            forceVersionPropertyName = "${forceVersionPropertyName.get()}"
            fullHash = ${fullHash.get()}
            includeLightweightTags = ${includeLightweightTags.get()}
            maxVersionLength = ${maxVersionLength.get()}
            minimumVersion = "${minimumVersion.get()}"
            noTagIdentifier = "${noTagIdentifier.get()}"
            preReleaseSeparator = "${preReleaseSeparator.get()}"
            versionPrefix = "${versionPrefix.get()}"
        }
    """.trimIndent()

    protected fun runCommand(vararg cmd: String) = processCommand(*cmd)

    private fun processCommand(vararg cmd: String) = createValueSourceProvider(*cmd)
        .get()
        .trim()
        .takeIf { it.isNotEmpty() }

    private fun createValueSourceProvider(vararg cmd: String): Provider<String> =
        providerFactory.of(GitCommandValueSource::class.java) {
            it.parameters { params ->
                params.commands.set(objectFactory.listProperty(String::class.java).value(cmd.asList()))
                params.directory.set(projectDir)
            }
        }

    /**
     * The name of the extension, namely of the DSL entry-point.
     */
    companion object {
        /**
         * The name of the extension, namely of the DSL entry-point.
         */
        const val EXTENSION_NAME = "gitSemVer"

        private const val DEFAULT_RADIX = 36
        private const val GIT_HASH_LENGTH = 40
        private const val GIT_SHORT_HASH_LENGTH = 7

        private inline fun <reified T : Any> ObjectFactory.propertyWithDefault(default: T): Property<T> =
            property(T::class.java).apply { convention(default) }

        private fun Long.withRadix(radix: Int, digits: Int? = null) = toString(radix).let {
            if (digits == null || it.length >= digits) {
                it
            } else {
                it.padStart(digits, '0')
            }
        }
    }
}
