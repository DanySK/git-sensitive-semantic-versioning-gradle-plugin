package org.danilopianini.gradle.gitsemver

import java.io.File
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
    val gitSensitiveSemanticVersion = object : CharSequence {
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
            val computedVersion = forcedVersion ?: computeVersion()
            when (val resultingVersion = SemanticVersion.fromStringOrNull(computedVersion)) {
                null -> {
                    val error = "Invalid Semantic Versioning 2.0 version: $computedVersion"
                    if (enforceSemanticVersioning.get()) error(error) else logger.warn(error)
                    computedVersion
                }
                else -> resultingVersion.toString()
            }
        }

        override val length: Int get() = version.length

        override fun equals(other: Any?): Boolean = when (other) {
            is GitSemVerExtension -> toString() == other.toString()
            else -> error(
                "Git-Sensitive Semantic Versions should not be compared with other objects. " +
                    "Call `toString()` and compare the String form instead.",
            )
        }

        override fun get(index: Int): Char = version[index]

        override fun hashCode(): Int = toString().hashCode()

        override fun toString(): String = version

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence =
            version.subSequence(startIndex, endIndex)
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
    fun latestReachableVersion(): SemanticVersion? {
        val reachableTags = when {
            includeLightweightTags.get() ->
                runCommand("git", "tag", "--merged", "HEAD")
            else ->
                runCommand("git", "for-each-ref", "--merged", "HEAD", "--format='%(refname:short)'", "refs/tags")
        }
        logger.info("Reachable tags: {}", reachableTags)
        return reachableTags?.lineSequence()
            ?.filter { it.startsWith(versionPrefix.get()) }
            ?.map { it.removePrefix(versionPrefix.get()) }
            ?.mapNotNull { SemanticVersion.fromStringOrNull(it) }
            ?.maxOrNull()
    }

    /**
     * Computes a valid Semantic Versioning 2.0 version based on the status of the current git repository.
     */
    fun computeVersion(): String {
        val latestReachableVersion = latestReachableVersion()
        logger.debug("Closest Semantic Version: {}", latestReachableVersion)
        val hash: String = hashOrTimeStamp()
        return when (latestReachableVersion) {
            null -> {
                /*
                 * No tags found, the version is the minimum version, with the hash as build metadata.
                 */
                val base = computeMinVersion()
                when {
                    computeReleaseVersion.get() -> base.toString()
                    else -> {
                        val preRelease = noTagIdentifier.get()
                            .takeIf { it.isNotBlank() }
                            ?.let { preReleaseSeparator.get() + it }
                            .orEmpty()
                        "$base${preRelease}${buildMetadataSeparator.get()}$hash"
                    }
                }
            }
            else -> {
                if (!latestReachableVersion.buildMetadata.isEmpty()) {
                    logger.warn("Build metadata of closest tag $latestReachableVersion will be ignored.")
                }
                val commitRange = "${versionPrefix.get()}$latestReachableVersion..HEAD"
                val distance = runCommand("git", "rev-list", "--count", commitRange)?.toLong()
                requireNotNull(distance) {
                    "Bug in git SemVer plugin: [distance? $distance]. Please report at: " +
                        "https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues"
                }
                when (distance) {
                    0L -> latestReachableVersion.toString()
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
                            updateStrategy(lastCommits).incrementVersion(latestReachableVersion),
                            minSemanticVersion(),
                        ).withoutBuildMetadata()
                        when {
                            computeReleaseVersion.get() -> currentVersion.toString()
                            else -> {
                                val devString = developmentIdentifier.get()
                                val separator = if (devString.isBlank()) "" else preReleaseSeparator.get()
                                val distanceString = distance.withRadix(
                                    distanceCounterRadix.get(),
                                    developmentCounterLength.get(),
                                )
                                val buildSeparator = buildMetadataSeparator.get()
                                "$currentVersion$separator$devString$distanceString$buildSeparator$hash"
                            }
                        }
                    }
                }
            }
        }.also { println("Pre-cut: XXX${it}XXX") }.take(maxVersionLength.get())
            .also { println("Post-cut: XXX${it}XXX") }
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

    private fun hashOrTimeStamp(): String {
        val printCommitCommand = "git log -1 --format=%${if (fullHash.get()) "H" else "h"}".split(" ")
        val hash: String = runCommand(*printCommitCommand.toTypedArray())
            ?.takeIf { it.isNotBlank() }
            ?.trim()
            ?.also {
                val regex = "[0-9a-f]{$GIT_SHORT_HASH_LENGTH,$GIT_HASH_LENGTH}"
                check(it.matches(regex.toRegex())) {
                    "Invalid commit hash (should have matched $regex): $it"
                }
            }
            ?: System.currentTimeMillis().toString()
        check(hash.none { it.isWhitespace() }) {
            "Invalid commit hash/timestamp: $hash (whitespace characters are not allowed)"
        }
        return hash
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
