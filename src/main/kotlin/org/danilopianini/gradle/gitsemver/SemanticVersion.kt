package org.danilopianini.gradle.gitsemver

/**
 * A class representing semantic versions:
 * [major].[minor].[patch]-[preRelease]+[buildMetadata].
 * It is a [Version] whose [preRelease] and [buildMetadata] use the standard SemVer prefixes,
 * delegating its structure to a [GeneralizedSemanticVersion], and ordered by the SemVer 2.0 precedence.
 */
class SemanticVersion private constructor(private val generalized: GeneralizedSemanticVersion) :
    Version by generalized,
    Comparable<SemanticVersion> {

    init {
        require(preRelease.prefix == "-" && buildMetadata.prefix == "+") {
            "Semantic versions must prefix the pre-release with '-' and the build metadata with '+': $generalized"
        }
    }

    constructor(
        major: ULong,
        minor: ULong,
        patch: ULong,
        preRelease: PreReleaseIdentifier = PreReleaseIdentifier.EMPTY,
        buildMetadata: PreReleaseIdentifier = PreReleaseIdentifier.EMPTY,
    ) : this(GeneralizedSemanticVersion(major, minor, patch, preRelease.withPrefix("-"), buildMetadata.withPrefix("+")))

    constructor(
        major: String,
        minor: String,
        patch: String,
        preRelease: String = "",
        buildMetadata: String = "",
    ) : this(
        major.toULong(),
        minor.toULong(),
        patch.toULong(),
        PreReleaseIdentifier("-", preRelease),
        PreReleaseIdentifier("+", buildMetadata),
    )

    /*
     * Precedence refers to how versions are compared to each other when ordered.
     * Precedence MUST be calculated by separating the version into major, minor, patch and pre-release identifiers
     * in that order (Build metadata does not figure into precedence).
     * Precedence is determined by the first difference when comparing each of these identifiers from left to right
     * as follows: Major, minor, and patch versions are always compared numerically.
     * - Example: 1.0.0 < 2.0.0 < 2.1.0 < 2.1.1.
     *
     */
    override fun compareTo(other: SemanticVersion): Int = compareBy<SemanticVersion> { it.major }
        .thenBy { it.minor }
        .thenBy { it.patch }
        .thenBy { it.preRelease }
        .thenBy { it.buildMetadata }
        .compare(this, other)

    override fun equals(other: Any?): Boolean = other is SemanticVersion && generalized == other.generalized

    override fun hashCode(): Int = generalized.hashCode()

    /**
     * Creates a new [SemanticVersion] with the [major] version increased by 1 and the [minor] and [patch] reset to 0.
     */
    fun incrementMajor(): SemanticVersion =
        SemanticVersion(generalized.copy(major = major + 1u, minor = 0u, patch = 0u))

    /**
     * Creates a new [SemanticVersion] with the [minor] version increased by 1 and the [patch] reset to 0, while
     * keeping the [major] version.
     */
    fun incrementMinor(): SemanticVersion = SemanticVersion(generalized.copy(minor = minor + 1u, patch = 0u))

    /**
     * Creates a new [SemanticVersion] with the [patch] version increased by 1, while keeping the [major] and [minor]
     * versions.
     */
    fun incrementPatch(): SemanticVersion = SemanticVersion(generalized.copy(patch = patch + 1u))

    override fun toString() = generalized.toString()

    /**
     * Creates the same SemanticVersion, but without build metadata.
     */
    fun withoutBuildMetadata(): SemanticVersion =
        SemanticVersion(generalized.copy(buildMetadata = PreReleaseIdentifier("+", "")))

    /**
     * Constants and utilities for working with semantic versions.
     */
    companion object {
        private const val MATCH_VERSION =
            """(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)"""
        private const val MATCH_OPTION =
            """(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?"""
        private const val MATCH_BUILD_INFO =
            """(?:\+([0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?"""

        /**
         * [String] version of a regular expression matching a SemVer.
         */
        const val SEM_VER_REGEX_STRING = "$MATCH_VERSION$MATCH_OPTION$MATCH_BUILD_INFO"

        /**
         * A [Regex] matching a valid semantic version.
         */
        val semVerRegex = Regex("^$SEM_VER_REGEX_STRING$")

        /**
         * Parses a [String] producing a [SemanticVersion], or null if the version can't be parsed.
         */
        fun fromStringOrNull(input: String): SemanticVersion? = semVerRegex.matchEntire(input)?.let { match ->
            val (major, minor, patch, preRelease, buildInfo: String) = match.destructured
            SemanticVersion(major, minor, patch, preRelease, buildInfo)
        }
    }
}
