package org.danilopianini.gradle.gitsemver

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

/**
 * A Plugin configuring the project for publishing on Maven Central
 */
class GitSemVer : Plugin<Project> {

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun apply(project: Project) {
        with(project) {
            /*
             * Recursively scan project directory. If git repo is found, rely on GitSemVerExtension to inspect it.
             */
            val extension = project.createExtension<GitSemVerExtension>(GitSemVerExtension.extensionName, project)
            project.afterEvaluate {
                with(extension) {
                    assignGitSemanticVersion()
                }
            }
            tasks.create("printGitSemVer") {
                it.doLast {
                    println("Version computed by ${GitSemVer::class.java.simpleName}: ${extension.computeVersion()}")
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
