package org.danilopianini.gradle.gitsemver

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A Plugin for comuting the project version based on the status of the local git repository.
 */
class GitSemVer : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            /*
             * Recursively scan project directory. If git repo is found, rely on GitSemVerExtension to inspect it.
             */
            val extension = project.createExtension<GitSemVerExtension>(GitSemVerExtension.EXTENSION_NAME, project)
            project.afterEvaluate {
                with(extension) {
                    properties[extension.forceVersionPropertyName.get()]?.let {
                        require(SemanticVersion.semVerRegex.matches(it.toString())) {
                            "The version '$it' is not a valid semantic versioning format"
                        }
                        project.logger.lifecycle(
                            "Forcing version to $it, mandated by property '$forceVersionPropertyName'",
                        )
                        project.version = it.toString()
                    } ?: run { assignGitSemanticVersion() }
                }
            }
            tasks.register("printGitSemVer") {
                it.doLast {
                    println(
                        "Version computed by ${GitSemVer::class.java.simpleName}: " +
                            "${properties[extension.forceVersionPropertyName.get()] ?: extension.computeVersion()}",
                    )
                }
            }
        }
    }

    companion object {
        private inline fun <reified T> Project.createExtension(name: String, vararg args: Any?): T =
            project.extensions.create(name, T::class.java, *args)
    }
}
