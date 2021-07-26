package org.danilopianini.gradle.gitsemver

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A Plugin for comuting the project version based on the status of the local git repository.
 */
class GitSemVer : Plugin<Project> {

    @OptIn(ExperimentalUnsignedTypes::class)
    override fun apply(project: Project) {
        with(project) {
            /*
             * Recursively scan project directory. If git repo is found, rely on GitSemVerExtension to inspect it.
             */
            val extension = project.createExtension<GitSemVerExtension>(GitSemVerExtension.EXTENSION_NAME, project)
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
    }
}
