package org.danilopianini.gradle.gitsemver

import com.palantir.gradle.gitversion.GitVersionPlugin
import com.palantir.gradle.gitversion.VersionDetails
import groovy.lang.Closure
import org.gradle.api.Plugin
import org.gradle.api.Project

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
            val isInTracking = generateSequence(projectDir) { it.parentFile }
                .any { it.list { _, name -> name == ".git" }.isNotEmpty() }
            val extension = project.createExtension<GitSemVerExtension>(GitSemVerExtension.extensionName, project)
            fun computeVersion() = if (isInTracking) {
                plugins.apply(GitVersionPlugin::class.java)
                val versionDetails: VersionDetails = property("versionDetails")
                    ?.takeIf { it is Closure<*> }
                    ?.let { it as Closure<*> }
                    ?.call()
                    ?.takeIf { it is VersionDetails }
                    ?.let { it as VersionDetails }
                    ?: throw IllegalStateException("Unable to fetch the git version for this repository")
                GitStatusInfo(extension, versionDetails)
            } else {
                GitStatusInfo(extension)
            }.toVersion()
            project.version = { computeVersion() }
            tasks.create("printGitSemVer") {
                it.doLast {
                    println("Version computed by ${GitSemVer::class.java.simpleName}: ${computeVersion()}")
                }
            }
        }
    }
    companion object {
        private inline fun <reified T> Project.createExtension(name: String, vararg args: Any?): T = project.extensions.create(name, T::class.java, *args)
    }
}

data class GitStatusInfo(val extension: GitSemVerExtension,
                         val hash: String,
                         val baseVersion: String,
                         val identifier: String,
                         val commitDistance: Int?
) {
    constructor(extension: GitSemVerExtension, versionDetails: VersionDetails? = null):
        this(extension,
            hash = versionDetails
                ?.run { if (extension.fullHash.get()) gitHashFull else gitHash }
                ?: System.currentTimeMillis().base36(),
            baseVersion = versionDetails?.lastTag
                ?.takeIf { it.isSemVer }
                ?: extension.minimumVersion.get()
                .takeIf { it.isSemVer }
                ?: throw IllegalArgumentException("${extension.minimumVersion.get()} is not Semantic Versioning compatible"),
            identifier = (if (versionDetails?.lastTag == null) extension.noTagIdentifier else extension.developmentIdentifier).get(),
            commitDistance = versionDetails?.commitDistance?.takeIf { versionDetails.isTagged })

    val hasTag: Boolean
        get() = commitDistance != null

    fun toVersion() = baseVersion.takeOr(hasTag && commitDistance == 0) {
        "$it-$identifier${
            commitDistance?.minus(1).base36(extension.developmentCounterLength.get())
        }+$hash".take(extension.maxVersionLength.get())
    }.takeOr ({ matches(semVerRegex) }) {
        throw IllegalStateException(
            "Version ${it} does not match Semantic Versioning requirements. Please considering reporting the error to the developer")
    }

    companion object {
        private const val semVer = """^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(-(0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(\.(0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*)?(\+[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*)?${'$'}"""
        val semVerRegex = semVer.toRegex()

        inline fun <T> T.takeOr(condition: Boolean, op: (T)->T) = if (condition) this else op(this)
        inline fun <T> T.takeOr(condition: T.()->Boolean, op: (T)->T) = if (condition()) this else op(this)

        fun Long.base36(digits: Int? = null) = toString(36).let {
            if (digits == null || it.length >= digits) it
            else generateSequence {"0"}.take(digits - it.length).joinToString("") + it
        }

        fun Int?.base36(digits: Int? = null): String = this?.toLong()?.base36(digits) ?: ""

        val String.isSemVer: Boolean
            get() = matches(semVerRegex)

        val VersionDetails?.isTagged: Boolean
            get() = this?.lastTag?.isSemVer ?: false

    }
}