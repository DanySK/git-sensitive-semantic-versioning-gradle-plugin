package org.danilopianini.gradle.gitsemver

/**
 * A [Version] whose [preRelease] and [buildMetadata] may be rendered after any prefix.
 * Depending on the prefixes and identifiers, the result may not be a valid [SemanticVersion]:
 * see [toSemanticVersionOrNull].
 */
data class GeneralizedSemanticVersion(
    override val major: ULong,
    override val minor: ULong,
    override val patch: ULong,
    override val preRelease: PreReleaseIdentifier = PreReleaseIdentifier("-", ""),
    override val buildMetadata: PreReleaseIdentifier = PreReleaseIdentifier("+", ""),
) : Version {
    /**
     * The strict [SemanticVersion] corresponding to the rendered version, or null if it is not valid SemVer.
     * Notably, build metadata prefixed by '-' is read as part of the pre-release.
     */
    fun toSemanticVersionOrNull(): SemanticVersion? = SemanticVersion.fromStringOrNull(toString())

    override fun toString(): String = "$major.$minor.$patch$preRelease$buildMetadata"

    /**
     * Renders this version in at most [maxLength] characters.
     * The build metadata is shortened first, starting from its first identifier,
     * which is dropped (along with its separator) once it would become empty.
     * If the version is still too long, it is truncated, and any trailing separator is removed.
     */
    override fun toString(maxLength: Int): String {
        val rendered = toString()
        val metadata = buildMetadata.identifiers
        return when {
            rendered.length <= maxLength -> rendered
            metadata.isEmpty() -> {
                val separators = ".${preRelease.prefix}${buildMetadata.prefix}"
                rendered.take(maxLength).trimEnd { it in separators }
            }
            else -> {
                val excess = rendered.length - maxLength
                val first = metadata.first()
                val shortened = when {
                    excess < first.length -> listOf(first.dropLast(excess)) + metadata.drop(1)
                    else -> metadata.drop(1)
                }
                copy(buildMetadata = PreReleaseIdentifier(buildMetadata.prefix, shortened.joinToString(".")))
                    .toString(maxLength)
            }
        }
    }

    /**
     * Creates the same version, with [identifier] appended to the [buildMetadata].
     */
    override fun withBuildMetadata(identifier: String): GeneralizedSemanticVersion =
        copy(buildMetadata = buildMetadata + identifier)

    /**
     * Creates the same version, with [identifier] appended to the [preRelease].
     */
    fun withPreRelease(identifier: String): GeneralizedSemanticVersion = copy(preRelease = preRelease + identifier)

    /**
     * Factories for [GeneralizedSemanticVersion].
     */
    companion object {
        /**
         * Creates a [GeneralizedSemanticVersion] with the same identifiers as [version],
         * rendered after the provided prefixes.
         */
        fun from(
            version: Version,
            preReleasePrefix: String = version.preRelease.prefix,
            buildMetadataPrefix: String = version.buildMetadata.prefix,
        ): GeneralizedSemanticVersion = GeneralizedSemanticVersion(
            version.major,
            version.minor,
            version.patch,
            version.preRelease.withPrefix(preReleasePrefix),
            version.buildMetadata.withPrefix(buildMetadataPrefix),
        )
    }
}
