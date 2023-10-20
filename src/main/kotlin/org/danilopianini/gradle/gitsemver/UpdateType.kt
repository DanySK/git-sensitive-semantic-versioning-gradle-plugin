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
    NONE, PATCH, MINOR, MAJOR;

    /**
     * Increments the [version] according to the enum value.
     * If it is [UpdateType.NONE], the [version] is returned unchanged.
     * If it is [UpdateType.PATCH], the [version] is incremented as a patch.
     * If it is [UpdateType.MINOR], the [version] is incremented as a minor.
     * If it is [UpdateType.MAJOR], the [version] is incremented as a major.
     *
     * @param version the last tagged version
     */
    fun incrementVersion(version: SemanticVersion): SemanticVersion =
        when (this) {
            NONE -> version
            PATCH -> version.incrementPatch()
            MINOR -> version.incrementMinor()
            MAJOR -> version.incrementMajor()
        }
}
