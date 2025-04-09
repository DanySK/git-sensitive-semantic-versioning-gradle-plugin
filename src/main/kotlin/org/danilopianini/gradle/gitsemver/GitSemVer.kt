package org.danilopianini.gradle.gitsemver

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ProviderFactory
import javax.inject.Inject

/**
 * A Plugin for comuting the project version based on the status of the local git repository.
 */
class GitSemVer
@Inject
constructor(
    private val providerFactory: ProviderFactory,
    private val objectFactory: ObjectFactory,
) : Plugin<Project> {
    override fun apply(project: Project): Unit = with(project) {
        val extension = createExtension<GitSemVerExtension>(
            GitSemVerExtension.EXTENSION_NAME,
            this,
            providerFactory,
            objectFactory,
            projectDir,
            version,
            logger,
        )
        afterEvaluate {
            extension.assignGitSemanticVersion()
        }
        tasks.register("printGitSemVer") {
            val forceVersion = properties[extension.forceVersionPropertyName.get()]
            it.doLast {
                println(
                    "Version computed by ${GitSemVer::class.java.simpleName}: " +
                        "${forceVersion ?: extension.computeVersion()}",
                )
            }
        }
    }

    private companion object {
        private inline fun <reified T> Project.createExtension(name: String, vararg args: Any?): T =
            project.extensions.create(name, T::class.java, *args)
    }
}
