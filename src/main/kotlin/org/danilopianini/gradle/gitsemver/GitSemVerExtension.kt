package org.danilopianini.gradle.gitsemver

import org.danilopianini.gradle.gitsemver.GitSemVer.Companion.runCommand
import org.danilopianini.gradle.gitsemver.GitSemVer.Companion.withRadix
import org.danilopianini.gradle.gitsemver.GitSemVerExtension.Companion.propertyWithDefault
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.slf4j.Logger
import java.lang.IllegalStateException

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
    val distanceCounterRadix: Property<Int> = project.propertyWithDefault(36),
    val versionPrefix: Property<String> = project.propertyWithDefault(""),
) {

    private val tagMatcher = """^(\w*)\s+tag\s+refs\/tags\/(.*)$""".toRegex()

    private fun Project.runCommand(vararg cmd: String) = projectDir.runCommand(*cmd)

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

    fun computeVersion(): String {
        with (project) {
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
            println("Reachable SemVer tags: $reachableSemVerTags")
            val closestTag = reachableSemVerTags.firstOrNull()
            logger.debug("Closest SemVer tag: $closestTag")
            println("Closest SemVer tag: $closestTag")
            val fullHash = fullHash.get()
            val printCommitCommand = "git rev-parse ${if (fullHash) "" else "--short "}HEAD".split(" ")
            val hash = runCommand(*printCommitCommand.toTypedArray())
                ?: System.currentTimeMillis().toString()
            fun separatorFromBaseAndIdentifier(base: SemanticVersion, identifier: String) = when {
                identifier.isBlank() -> ""
                base.preRelease.isEmpty() -> preReleaseSeparator.get()
                else -> preReleaseSeparator.get()
            }
            if (closestTag == null) {
                val base = computeMinVersion(logger)
                val identifier = noTagIdentifier.orElse("").get()
                val separator = separatorFromBaseAndIdentifier(base, identifier)
                return "$base$separator$identifier${buildMetadataSeparator.get()}$hash"
            }
            if (!closestTag.buildMetadata.isEmpty()) {
                logger.warn("Build metadata of closest tag $closestTag will be ignored.")
            }
            val distance = runCommand("git", "rev-list", "--count", "$closestTag..HEAD")?.toULong()
            require(distance != null) {
                "Bug in git SemVer plugin: [distance? $distance]." +
                    "Please report at: " +
                    "https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues"
            }
            if (distance == 0UL) {
                return closestTag.toString()
            }
            val base: SemanticVersion = closestTag.withoutBuildMetadata()
            val devString = developmentIdentifier.get()
            val separator = separatorFromBaseAndIdentifier(base, devString)
            val distanceString = distance.withRadix(
                distanceCounterRadix.get(),
                developmentCounterLength.get()
            )
            val buildSeparator = buildMetadataSeparator.get()
            return "$base$separator$devString$distanceString$buildSeparator$hash"
                .take(maxVersionLength.get())
        }
    }

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
        const val extensionName = "gitSemVer"
        inline fun <reified T> Project.propertyWithDefault(default: T): Property<T> =
            objects.property(T::class.java).apply { convention(default) }
    }
}
