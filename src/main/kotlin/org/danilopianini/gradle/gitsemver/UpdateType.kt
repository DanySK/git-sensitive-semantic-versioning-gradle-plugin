package org.danilopianini.gradle.gitsemver

/**
 * The type of update that the commits represents.
 * The following types are supported:
 *
 * - [NONE] for commits that do not represent an update
 * - [PATCH] for bug fixes
 * - [MINOR] for new features
 * - [MAJOR] for breaking changes
 *
 * [NONE] < [PATCH] < [MINOR] < [MAJOR]
 */
enum class UpdateType {
    NONE, PATCH, MINOR, MAJOR
}

object UpdateVersion {

    /**
     * Increments the [version] according to the [updateType].
     * If [updateType] is [UpdateType.NONE], the [version] is returned unchanged.
     * If [updateType] is [UpdateType.PATCH], the [version] is incremented as a patch.
     * If [updateType] is [UpdateType.MINOR], the [version] is incremented as a minor.
     * If [updateType] is [UpdateType.MAJOR], the [version] is incremented as a major.
     *
     * @param version the last tagged version
     * @param updateType the type of update
     */
    fun incrementVersion(version: SemanticVersion, updateType: UpdateType): SemanticVersion =
        when (updateType) {
            UpdateType.MAJOR -> version.incrementMajor()
            UpdateType.MINOR -> version.incrementMinor()
            UpdateType.PATCH -> version.incrementPatch()
            UpdateType.NONE -> version
        }
}
