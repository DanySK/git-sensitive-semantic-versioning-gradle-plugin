package org.danilopianini.gradle.gitsemver

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.lang.IllegalStateException

/**
 * A Plugin configuring the project for publishing on Maven Central
 */
class GitSemVer : Plugin<Project> {

    private val tagMatcher = """^(\w*)\s+tag\s+refs\/tags\/(.*)$""".toRegex()

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun apply(project: Project) {
        with(project) {
            /*
             * Recursively scan project directory. If git repo is found, rely on GitSemVerExtension to inspect it.
             */
            val extension = project.createExtension<GitSemVerExtension>(GitSemVerExtension.extensionName, project)
            fun runCommand(vararg cmd: String) = projectDir.runCommand(*cmd)
            fun computeMinVersion(): SemanticVersion {
                val minVersion = extension.minimumVersion.get()
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
                val reachableCommits = runCommand("git", "rev-list", "HEAD")?.lines() ?: emptyList()
                logger.debug("Reachable commits: $reachableCommits")
                val reachableSemVerTags = runCommand("git", "for-each-ref", "refs/tags")
                    ?.lineSequence()
                    ?.mapNotNull { tagMatcher.matchEntire(it)?.destructured }
                    ?.mapNotNull { (_, tag) ->
                        tag.takeIf { runCommand("git", "rev-list", "-n", "1", tag) in reachableCommits }
                    }
                    ?.mapNotNull(SemanticVersion::fromStringOrNull)
                    ?.sortedDescending()
                    ?.toList()
                    ?: emptyList()
                logger.debug("Reachable SemVer tags: $reachableSemVerTags")
                println("Reachable SemVer tags: $reachableSemVerTags")
                val closestTag = reachableSemVerTags.firstOrNull()
                logger.debug("Closest SemVer tag: $closestTag")
                println("Closest SemVer tag: $closestTag")
                val fullHash = extension.fullHash.get()
                val printCommitCommand = "git rev-parse ${if (fullHash) "" else "--short "}HEAD".split(" ")
                val hash = runCommand(*printCommitCommand.toTypedArray())
                    ?: System.currentTimeMillis().toString()
                fun separatorFromBaseAndIdentifier(base: SemanticVersion, identifier: String) = when {
                    identifier.isBlank() -> ""
                    base.preRelease.isEmpty() -> extension.preReleaseSeparator.get()
                    else -> extension.preReleaseSeparator.get()
                }
                if (closestTag == null) {
                    val base = computeMinVersion()
                    val identifier = extension.noTagIdentifier.orElse("").get()
                    val separator = separatorFromBaseAndIdentifier(base, identifier)
                    return "$base$separator$identifier${extension.buildMetadataSeparator.get()}$hash"
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
                val devString = extension.developmentIdentifier.get()
                val separator = separatorFromBaseAndIdentifier(base, devString)
                val distanceString = distance.withRadix(
                    extension.distanceCounterRadix.get(),
                    extension.developmentCounterLength.get()
                )
                val buildSeparator = extension.buildMetadataSeparator.get()
                return "$base$separator$devString$distanceString$buildSeparator$hash"
                    .take(extension.maxVersionLength.get())
            }
            project.afterEvaluate {
                project.version = computeVersion()
                val resultingVersion = SemanticVersion.fromStringOrNull(project.version.toString())
                if (resultingVersion == null) {
                    val error = "Invalid Semantic Versioning 2.0 version: ${project.version}"
                    if (extension.enforceSemanticVersioning.get()) {
                        throw IllegalStateException(error)
                    } else {
                        logger.warn(error)
                    }
                }
            }
            tasks.create("printGitSemVer") {
                it.doLast {
                    println("Version computed by ${GitSemVer::class.java.simpleName}: ${project.version}")
                }
            }
        }
    }
    companion object {

        private inline fun <reified T> Project.createExtension(name: String, vararg args: Any?): T =
            project.extensions.create(name, T::class.java, *args)

        fun File.runCommand(vararg cmd: String) = Runtime.getRuntime()
            .exec(cmd, emptyArray(), this)
            .inputStream
            .bufferedReader()
            .readText()
            .trim()
            .takeIf { it.isNotEmpty() }

        @OptIn(ExperimentalUnsignedTypes::class)
        fun ULong.withRadix(radix: Int, digits: Int? = null) = toString(radix).let {
            if (digits == null || it.length >= digits) it
            else generateSequence { "0" }.take(digits - it.length).joinToString("") + it
        }
    }
}
