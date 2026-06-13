package org.danilopianini.gradle.gitsemver

import java.util.concurrent.ConcurrentHashMap
import org.gradle.api.logging.Logging
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters

/**
 * Collects forced versions across all projects and reports them once per build.
 */
abstract class ForcedVersionLoggerService :
    BuildService<BuildServiceParameters.None>,
    AutoCloseable {

    private val forcedVersions = ConcurrentHashMap<String, ForcedVersion>()

    /**
     * Records that [projectPath] has resolved its version from [propertyName].
     */
    fun record(projectPath: String, propertyName: String, version: String) {
        forcedVersions[projectPath] = ForcedVersion(propertyName, version)
    }

    override fun close() {
        val entries = forcedVersions.entries.sortedBy { it.key }
        if (entries.isEmpty()) {
            return
        }
        val forced = entries.map { it.value }.distinct()
        if (forced.size == 1) {
            forced.single().let { forcedVersion ->
                logger.lifecycle(
                    "Forcing version to {} as per property '{}'",
                    forcedVersion.version,
                    forcedVersion.propertyName,
                )
            }
        } else {
            logger.lifecycle("Forced versions:")
            entries.forEach { (projectPath, forcedVersion) ->
                logger.lifecycle(
                    "  {} -> {} as per property '{}'",
                    projectPath,
                    forcedVersion.version,
                    forcedVersion.propertyName,
                )
            }
        }
    }

    private data class ForcedVersion(val propertyName: String, val version: String)

    private companion object {
        private val logger = Logging.getLogger(ForcedVersionLoggerService::class.java)
    }
}
