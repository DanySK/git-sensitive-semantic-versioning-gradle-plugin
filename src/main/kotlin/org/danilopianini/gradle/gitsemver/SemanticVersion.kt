package org.danilopianini.gradle.gitsemver

@OptIn(ExperimentalUnsignedTypes::class)
data class SemanticVersion(
    val major: ULong,
    val minor: ULong,
    val patch: ULong,
    val preRelease: PreReleaseIdentifier,
    val buildMetadata: PreReleaseIdentifier,
) : Comparable<SemanticVersion> {

    val isStable: Boolean get() = preRelease.isEmpty() && buildMetadata.isEmpty()

    constructor(
        major: String,
        minor: String,
        patch: String,
        preRelease: String,
        buildMetadata: String,
    ) : this(
        major.toULong(),
        minor.toULong(),
        patch.toULong(),
        PreReleaseIdentifier("-", preRelease),
        PreReleaseIdentifier("+", buildMetadata),
    )

    private fun <T : Comparable<T>> compareOrNull(v1: T, v2: T) = v1.compareTo(v2).takeIf { it != 0 }

    override fun toString() = "$major.$minor.$patch$preRelease$buildMetadata"

    fun withoutBuildMetadata(): SemanticVersion = copy(buildMetadata = PreReleaseIdentifier("+", ""))

    @OptIn(ExperimentalUnsignedTypes::class)
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
        const val semVerRegexString = "^$MATCH_VERSION$MATCH_OPTION$MATCH_BUILD_INFO$"
        val semVerRegex = semVerRegexString.toRegex()

        fun fromStringOrNull(input: String): SemanticVersion? = semVerRegex.matchEntire(input)?.let { match ->
            val (major, minor, patch, preRelease, buildInfo) = match.destructured
            SemanticVersion(major, minor, patch, preRelease, buildInfo)
        }
    }
}

@OptIn(ExperimentalUnsignedTypes::class)
data class PreReleaseIdentifier(
    val prefix: String,
    private val segments: List<DotSeparatedIdentifier>,
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
            }
    )

    fun isEmpty(): Boolean = segments.isEmpty()

    override fun toString() = segments.takeIf { it.isNotEmpty() }?.joinToString(separator = ".", prefix = prefix) ?: ""

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
         * - Example: 1.0.0-alpha < 1.0.0-alpha.1 < 1.0.0-alpha.beta < 1.0.0-beta < 1.0.0-beta.2 < 1.0.0-beta.11 < 1.0.0-rc.1 < 1.0.0.
         */
        segments.asSequence().zip(other.segments.asSequence())
            .map { it.first.compareTo(it.second) }
            .find { it != 0 }
            ?: segments.size.compareTo(other.segments.size)

    sealed class DotSeparatedIdentifier : Comparable<DotSeparatedIdentifier> {

        data class NumericIdentifier(val identifier: ULong) : DotSeparatedIdentifier() {
            override fun toString() = identifier.toString()
        }

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
    }
}
