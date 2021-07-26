package org.danilopianini.gradle.gitsemver

import org.danilopianini.gradle.gitsemver.GitSemVerExtension.Companion.runCommand
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.slf4j.Logger
import java.io.File
import java.lang.IllegalStateException

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
 * - [preReleaseSeparator], how to separate the pre-relase information.
 *      Changing this value may generate non-SemVer-compatible versions.
 * - [buildMetadataSeparator], how to separate the pre-relase information.
 *      Some destinations (e.g., the Gradle Plugin Portal) do not support the default value '+'.
 *      A reasonable alternative is using '-', lifting the build metadata to a pre-release segment.
 * - [distanceCounterRadix], the radix for the commit counter. Defaults to base 36. Bases from 2 to 36 allowed.
 * - [versionPrefix], to be used in case tags are prefixed with some symbols before the semantic version
 *      (e.g., v1.0.0 is prefixed with "v").
 */
@ExperimentalUnsignedTypes
open class GitSemVerExtension @JvmOverloads constructor(
    private val project: Project,
    val minimumVersion: Property<String> = project.propertyWithDefault("0.1.0"),
    val developmentIdentifier: Property<String> = project.propertyWithDefault("dev"),
    val noTagIdentifier: Property<String> = project.propertyWithDefault("archeo"),
    val fullHash: Property<Boolean> = project.propertyWithDefault(false),
    val maxVersionLength: Property<Int> = project.propertyWithDefault(Int.MAX_VALUE),
    val developmentCounterLength: Property<Int> = project.propertyWithDefault(2),
    val enforceSemanticVersioning: Property<Boolean> = project.propertyWithDefault(true),
    val preReleaseSeparator: Property<String> = project.propertyWithDefault("-"),
    val buildMetadataSeparator: Property<String> = project.propertyWithDefault("+"),
    val distanceCounterRadix: Property<Int> = project.propertyWithDefault(DEFAULT_RADIX),
    val versionPrefix: Property<String> = project.propertyWithDefault(""),
) {

    private val tagMatcher = """^(\w*)\s+tag\s+refs\/tags\/(.*)$""".toRegex()

    private fun computeMinVersion(logger: Logger): SemanticVersion {
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
    fun Project.findClosestTag(): SemanticVersion? {
        val reachableCommits = runCommand("git", "rev-list", "HEAD")?.lines() ?: emptyList()
        logger.debug("Reachable commits: $reachableCommits")
        val reachableSemVerTags = runCommand("git", "for-each-ref", "refs/tags")
            ?.lineSequence()
            ?.mapNotNull { tagMatcher.matchEntire(it)?.destructured }
            ?.mapNotNull { (_, tag) ->
                tag.takeIf { runCommand("git", "rev-list", "-n", "1", tag) in reachableCommits }
            }
            ?.map { it.removePrefix(versionPrefix.get()) }
            ?.mapNotNull(SemanticVersion::fromStringOrNull)
            ?.sortedDescending()
            ?.toList()
            ?: emptyList()
        logger.debug("Reachable SemVer tags: $reachableSemVerTags")
        return reachableSemVerTags.firstOrNull()
    }

    /**
     * Computes a valid Semantic Versioning 2.0 version based on the status of the current git repository.
     */
    fun computeVersion(): String {
        with(project) {
            val closestTag = findClosestTag()
            logger.debug("Closest SemVer tag: $closestTag")
            val fullHash = fullHash.get()
            val printCommitCommand = "git rev-parse ${if (fullHash) "" else "--short "}HEAD".split(" ")
            val hash = runCommand(*printCommitCommand.toTypedArray())
                ?: System.currentTimeMillis().toString()
            return when (closestTag) {
                null -> {
                    val base = computeMinVersion(logger)
                    val identifier = noTagIdentifier.orElse("").get()
                    val separator = if (identifier.isBlank()) "" else preReleaseSeparator.get()
                    return "$base$separator$identifier${buildMetadataSeparator.get()}$hash"
                }
                else -> {
                    if (!closestTag.buildMetadata.isEmpty()) {
                        logger.warn("Build metadata of closest tag $closestTag will be ignored.")
                    }
                    val distance = runCommand("git", "rev-list", "--count", "$closestTag..HEAD")?.toULong()
                    require(distance != null) {
                        "Bug in git SemVer plugin: [distance? $distance]." +
                                "Please report at: " +
                                "https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues"
                    }
                    when (distance) {
                        0UL -> closestTag.toString()
                        else -> {
                            val base: SemanticVersion = closestTag.withoutBuildMetadata()
                            val devString = developmentIdentifier.get()
                            val separator = if (devString.isBlank()) "" else preReleaseSeparator.get()
                            val distanceString = distance.withRadix(
                                distanceCounterRadix.get(),
                                developmentCounterLength.get()
                            )
                            val buildSeparator = buildMetadataSeparator.get()
                            "$base$separator$devString$distanceString$buildSeparator$hash".take(maxVersionLength.get())
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
        val computedVersion = computeVersion()
        val resultingVersion = SemanticVersion.fromStringOrNull(computedVersion)
        if (resultingVersion == null) {
            val error = "Invalid Semantic Versioning 2.0 version: ${project.version}"
            if (enforceSemanticVersioning.get()) {
                throw IllegalStateException(error)
            } else {
                project.logger.warn(error)
            }
            project.version = computedVersion
        } else {
            project.version = resultingVersion.toString()
        }
    }

    companion object {

        /**
         * The name of the extension, namely of the DSL entry-point.
         */
        const val EXTENSION_NAME = "gitSemVer"

        private const val DEFAULT_RADIX = 36

        private inline fun <reified T> Project.propertyWithDefault(default: T): Property<T> =
            objects.property(T::class.java).apply { convention(default) }

        private fun Project.runCommand(vararg cmd: String) = projectDir.runCommandInFolder(*cmd)

        private fun File.runCommandInFolder(vararg cmd: String) = Runtime.getRuntime()
            .exec(cmd, emptyArray(), this)
            .inputStream
            .bufferedReader()
            .readText()
            .trim()
            .takeIf { it.isNotEmpty() }

        private fun ULong.withRadix(radix: Int, digits: Int? = null) = toString(radix).let {
            if (digits == null || it.length >= digits) it
            else generateSequence { "0" }.take(digits - it.length).joinToString("") + it
        }
    }
}
