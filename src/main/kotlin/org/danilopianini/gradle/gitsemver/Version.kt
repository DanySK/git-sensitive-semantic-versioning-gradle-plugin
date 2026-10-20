package org.danilopianini.gradle.gitsemver

/**
 * A version with the structure of a semantic version: [major].[minor].[patch][preRelease][buildMetadata],
 * where [preRelease] and [buildMetadata] are rendered after their own prefix.
 */
interface Version {
    /**
     * The build metadata.
     */
    val buildMetadata: PreReleaseIdentifier

    /**
     * True if this version is in the form [major].[minor].[patch], with no further identifiers.
     */
    val isStable: Boolean get() = preRelease.isEmpty() && buildMetadata.isEmpty()

    /**
     * The major version.
     */
    val major: ULong

    /**
     * The minor version.
     */
    val minor: ULong

    /**
     * The patch version.
     */
    val patch: ULong

    /**
     * The pre-release.
     */
    val preRelease: PreReleaseIdentifier

    /**
     * Renders this version in at most [maxLength] characters.
     * The build metadata is shortened first, starting from its first identifier,
     * which is dropped (along with its separator) once it would become empty.
     * If the version is still too long, it is truncated, and any trailing separator is removed.
     */
    fun toString(maxLength: Int): String

    /**
     * Creates the same version, with [identifier] appended to the [buildMetadata].
     */
    fun withBuildMetadata(identifier: String): Version
}
