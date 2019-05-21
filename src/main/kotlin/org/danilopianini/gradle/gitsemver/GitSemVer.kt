package org.danilopianini.gradle.gitsemver

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.lang.IllegalStateException

/**
 * A Plugin configuring the project for publishing on Maven Central
 */
class GitSemVer : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            /*
             * Recursively scan project directory. If git repo is found, rely on GitSemVerExtension to inspect it.
             * Otherwise,
             */
            val extension = project.createExtension<GitSemVerExtension>(GitSemVerExtension.extensionName, project)
            fun runCommand(vararg cmd: String) = projectDir.runCommand(*cmd)
            fun computeVersion(): String {
                val description = runCommand("git", "describe", "--abbrev=100")
                val hasAtLeastOneTag = description != null
                fun fullVersion(): String {
                    val tag = runCommand("git", "describe", "--no-abbrev") ?: extension.minimumVersion.get()
                    val isAtTag = hasAtLeastOneTag && description == tag
                    if (isAtTag) {
                        return tag
                    }
                    val devString = if (hasAtLeastOneTag) extension.developmentIdentifier.get() else extension.noTagIdentifier.get()
                    val printCommitCommand = "git rev-parse ${if (extension.fullHash.get()) "" else "--short "}HEAD".split(" ")
                    val hash = runCommand(*printCommitCommand.toTypedArray())
                        ?: System.currentTimeMillis().toString()
                    val distance = description
                        ?.let { """-(?<distance>\d+)-.+$""".toRegex().matchEntire(it)?.groups?.get(0)?.value?.toLong() ?: 0L }
                        ?.base36(extension.developmentCounterLength.get())
                        ?: ""
                    return "$tag-$devString$distance+$hash"
                }
                val result = fullVersion().take(extension.maxVersionLength.get())
                if (result.isSemVer) {
                    return result
                }
                throw IllegalStateException("Computed version: $result does not match Semantic Versioning 2.0 requirements.")
            }
            extension.gitSemVer = ::computeVersion
            tasks.create("printGitSemVer") {
                it.doLast {
                    println("Version computed by ${GitSemVer::class.java.simpleName}: ${project.version}")
                }
            }
        }
    }
    companion object {
        private const val semVer = """^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(-(0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(\.(0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*)?(\+[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*)?${'$'}"""
        val semVerRegex = semVer.toRegex()
        val String.isSemVer: Boolean
            get() = matches(semVerRegex)
        private inline fun <reified T> Project.createExtension(name: String, vararg args: Any?): T = project.extensions.create(name, T::class.java, *args)
        fun File.runCommand(vararg cmd: String) = Runtime.getRuntime().exec(cmd, emptyArray(), this).inputStream.bufferedReader().readText()
            .trim()
            .takeIf { it.length > 0 }
        fun Long.base36(digits: Int? = null) = toString(36).let {
            if (digits == null || it.length >= digits) it
            else generateSequence { "0" }.take(digits - it.length).joinToString("") + it
        }
    }
}
