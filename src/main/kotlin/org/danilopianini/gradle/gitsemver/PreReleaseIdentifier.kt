package org.danilopianini.gradle.gitsemver

/**
 * A SemVer 2.0 pre-release (or build metadata) identifier, rendered after a [prefix].
 * Strict semantic versions use '-' for the pre-release and '+' for the build metadata,
 * while [GeneralizedSemanticVersion]s may use any prefix.
 */
data class PreReleaseIdentifier(
    val prefix: String = "-",
    private val segments: List<DotSeparatedIdentifier> = emptyList(),
) : Comparable<PreReleaseIdentifier> {
    /**
     * The dot-separated identifiers, as strings.
     */
    val identifiers: List<String> get() = segments.map { it.toString() }

    constructor(prefix: String, identifier: String) : this(
        prefix,
        identifier
            .split(".")
            .filter { it.isNotBlank() }
            .map { segment ->
                // leading zeroes indicate an alphanumeric identifier
                segment.takeIf { segment == "0" || segment.first() in '1'..'9' }
                    ?.toBigIntegerOrNull()
                    ?.let { DotSeparatedIdentifier.NumericIdentifier(it) }
                    ?: DotSeparatedIdentifier.AlphanumericIdentifier(segment)
            },
    )

    /**
     * Whether this pre-release identifier contains anything.
     */
    fun isEmpty(): Boolean = segments.isEmpty()

    /**
     * Creates the same identifier, with [identifier] appended. Blank identifiers are ignored.
     */
    operator fun plus(identifier: String): PreReleaseIdentifier =
        PreReleaseIdentifier(prefix, (identifiers + identifier).joinToString("."))

    override fun toString() = segments.takeIf { it.isNotEmpty() }
        ?.joinToString(separator = ".", prefix = prefix).orEmpty()

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
    override fun compareTo(other: PreReleaseIdentifier): Int = when {
        this.isEmpty() && other.isEmpty() -> 0
        segments.isEmpty() -> 1 // this is empty, other is not
        other.segments.isEmpty() -> -1 // this is not empty, other is
        else -> segments.asSequence().zip(other.segments.asSequence())
            .map { (thisSegment, otherSegment) -> thisSegment.compareTo(otherSegment) }
            .firstOrNull { it != 0 }
            ?: compareValues(segments.size, other.segments.size)
    }

    /**
     * Creates the same identifier, rendered after [prefix].
     */
    fun withPrefix(prefix: String): PreReleaseIdentifier = copy(prefix = prefix)

    /**
     * Constants and utilities for working with pre-release identifiers.
     */
    companion object {
        /**
         * An empty pre-release identifier.
         */
        val EMPTY: PreReleaseIdentifier = PreReleaseIdentifier()
    }
}
