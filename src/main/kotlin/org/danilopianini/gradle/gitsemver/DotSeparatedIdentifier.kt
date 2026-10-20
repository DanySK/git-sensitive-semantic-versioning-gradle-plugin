package org.danilopianini.gradle.gitsemver

import java.math.BigInteger

/**
 * A dot-separated identifier.
 */
sealed class DotSeparatedIdentifier : Comparable<DotSeparatedIdentifier> {
    /**
     * Numeric [identifier].
     */
    data class NumericIdentifier(val identifier: BigInteger) : DotSeparatedIdentifier() {
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
                is AlphanumericIdentifier -> -1
            }
        }
        is AlphanumericIdentifier -> {
            when (other) {
                is AlphanumericIdentifier -> identifier.compareTo(other.identifier)
                is NumericIdentifier -> 1
            }
        }
    }
}
