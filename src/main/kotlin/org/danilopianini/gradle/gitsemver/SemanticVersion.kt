package org.danilopianini.gradle.gitsemver

/**
 * A class representing semantic versions:
 * [major].[minor].[patch]-[preRelease]+[buildMetadata].
 */
data class SemanticVersion(
    val major: ULong,
    val minor: ULong,
    val patch: ULong,
    val preRelease: PreReleaseIdentifier = PreReleaseIdentifier.EMPTY,
    val buildMetadata: PreReleaseIdentifier = PreReleaseIdentifier.EMPTY,
) : Comparable<SemanticVersion> {

    /**
     * True if this version is in the form [major].[minor].[patch], with no further identifiers.
     */
    val isStable: Boolean get() = preRelease.isEmpty() && buildMetadata.isEmpty()

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

    /**
     * Creates a new [SemanticVersion] with the [major] version increased by 1 and the [minor] and [patch] reset to 0.
     */
    fun increaseMajor(): SemanticVersion = copy(major = major + 1u, minor = 0u, patch = 0u)

    /**
     * Creates a new [SemanticVersion] with the [minor] version increased by 1 and the [patch] reset to 0, while
     * keeping the [major] version.
     */
    fun increaseMinor(): SemanticVersion = copy(minor = minor + 1u, patch = 0u)

    /**
     * Creates a new [SemanticVersion] with the [patch] version increased by 1, while keeping the [major] and [minor]
     * versions.
     */
    fun increasePatch(): SemanticVersion = copy(patch = patch + 1u)

    override fun toString() = "$major.$minor.$patch$preRelease$buildMetadata"

    /**
     * Creates the same SemanticVersion, but without build metadata.
     */
    fun withoutBuildMetadata(): SemanticVersion = copy(buildMetadata = PreReleaseIdentifier("+", ""))

    override fun compareTo(other: SemanticVersion): Int =
        /*
         * Precedence refers to how versions are compared to each other when ordered.
         * Precedence MUST be calculated by separating the version into major, minor, patch and pre-release identifiers
         * in that order (Build metadata does not figure into precedence).
         * Precedence is determined by the first difference when comparing each of these identifiers from left to right
         * as follows: Major, minor, and patch versions are always compared numerically.
         * - Example: 1.0.0 < 2.0.0 < 2.1.0 < 2.1.1.
         *
         */
        when {
            major != other.major -> major.compareTo(other.major)
            minor != other.minor -> minor.compareTo(other.minor)
            patch != other.patch -> patch.compareTo(other.patch)
            else -> preRelease.compareTo(other.preRelease).takeUnless { it == 0 }
                ?: buildMetadata.compareTo(buildMetadata)
        }

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
        const val semVerRegexString = "$MATCH_VERSION$MATCH_OPTION$MATCH_BUILD_INFO"

        /**
         * A [Regex] matching a valid semantic version.
         */
        val semVerRegex = Regex("^$semVerRegexString$")

        /**
         * Parses a [String] producing a [SemanticVersion], or null if the version can't be parsed.
         */
        fun fromStringOrNull(input: String): SemanticVersion? = semVerRegex.matchEntire(input)?.let { match ->
            val (major, minor, patch, preRelease, buildInfo) = match.destructured
            SemanticVersion(major, minor, patch, preRelease, buildInfo)
        }
    }
}

/**
 * A SemVer 2.0 pre-release identifier, with a selectable [prefix].
 */
data class PreReleaseIdentifier(
    val prefix: String = "-",
    private val segments: List<DotSeparatedIdentifier> = emptyList(),
) : Comparable<PreReleaseIdentifier> {

    init {
        require(prefix in validPrefixes) {
            "Invalid prefix $prefix. Valid prefixes: $validPrefixes"
        }
    }

    constructor(prefix: String, identifier: String) : this(
        prefix,
        identifier.split(".")
            .filter { it.isNotBlank() }
            .map { segment ->
                segment.toULongOrNull()
                    ?.let { DotSeparatedIdentifier.NumericIdentifier(it) }
                    ?: DotSeparatedIdentifier.AlphanumericIdentifier(segment)
            },
    )

    /**
     * Whether this pre-release identifier contains anything.
     */
    fun isEmpty(): Boolean = segments.isEmpty()

    override fun toString() = segments.takeIf { it.isNotEmpty() }
        ?.joinToString(separator = ".", prefix = prefix)
        .orEmpty()

    override fun compareTo(other: PreReleaseIdentifier): Int =
        /*
         * Precedence for two pre-release versions with the same major, minor, and patch version MUST be determined by
         * comparing each dot separated identifier from left to right until a difference is found as follows:
         * - Identifiers consisting of only digits are compared numerically.
         * - Identifiers with letters or hyphens are compared lexically in ASCII sort order.
         * - Numeric identifiers always have lower precedence than non-numeric identifiers.
         * - A larger set of pre-release fields has a higher precedence than a smaller set, if all of the preceding
         *   identifiers are equal.
         *
         * - Example:
         *   1.0.0-alpha < 1.0.0-alpha.1 < 1.0.0-alpha.beta < 1.0.0-beta
         *   < 1.0.0-beta.2 < 1.0.0-beta.11 < 1.0.0-rc.1 < 1.0.0.
         */
        segments.asSequence().zip(other.segments.asSequence())
            .map { it.first.compareTo(it.second) }
            .find { it != 0 }
            ?: segments.size.compareTo(other.segments.size)

    /**
     * A dot-separated identifier.
     */
    sealed class DotSeparatedIdentifier : Comparable<DotSeparatedIdentifier> {

        /**
         * Numeric [identifier].
         */
        data class NumericIdentifier(val identifier: ULong) : DotSeparatedIdentifier() {
            override fun toString() = identifier.toString()
        }

        /**
         * Alphanumeric [identifier].
         */
        data class AlphanumericIdentifier(val identifier: String) : DotSeparatedIdentifier() {

            init {
                require(!identifier.contains(".")) {
                    "Sub-identifiers in semVer cannot contain dots. Error at: $identifier"
                }
                require(identifier.isNotBlank()) {
                    "Sub-identifiers can't be empty or blank: '$identifier'."
                }
            }

            override fun toString() = identifier
        }

        override fun compareTo(other: DotSeparatedIdentifier) = when (this) {
            is NumericIdentifier -> {
                when (other) {
                    is NumericIdentifier -> identifier.compareTo(other.identifier)
                    else -> -1
                }
            }

            is AlphanumericIdentifier -> {
                when (other) {
                    is AlphanumericIdentifier -> identifier.compareTo(other.identifier)
                    else -> 1
                }
            }
        }
    }

    companion object {
        private val validPrefixes = listOf("+", "-")

        /**
         * An empty pre-release identifier.
         */
        val EMPTY: PreReleaseIdentifier = PreReleaseIdentifier()
    }
}
