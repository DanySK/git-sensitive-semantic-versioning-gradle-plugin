package org.danilopianini.gradle.gitsemver

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TestGeneralizedSemanticVersion {

    @Test
    fun `conversion from strict semantic versions keeps all identifiers`() {
        val strict = requireNotNull(SemanticVersion.fromStringOrNull("1.0.0-rc.1+build.5"))
        assertEquals("1.0.0-rc.1+build.5", GeneralizedSemanticVersion.from(strict).toString())
        assertEquals("1.0.0-rc.1-build.5", GeneralizedSemanticVersion.from(strict, "-", "-").toString())
        val withoutPreRelease = GeneralizedSemanticVersion.from(strict).copy(preRelease = PreReleaseIdentifier.EMPTY)
        assertEquals("1.0.0+build.5.dirty", withoutPreRelease.withBuildMetadata("dirty").toString())
    }

    @Test
    fun `shortening drops build metadata from the first identifier`() {
        val dirty = version(listOf("dev01"), listOf("abc1234", "dirty"), buildMetadataSeparator = "-")
        assertEquals("1.2.4-dev01-abc1234.dirty", dirty.toString(Int.MAX_VALUE))
        assertEquals("1.2.4-dev01-ab.dirty", dirty.toString(20))
        assertEquals("1.2.4-dev01-dirty", dirty.toString(17))
        assertEquals("1.2.4-dev01-di", dirty.toString(14))
        assertEquals("1.2.4-dev01", dirty.toString(11))
    }

    @Test
    fun `shortening never leaves a trailing separator`() {
        val development = version(listOf("dev01"), listOf("abc1234"))
        assertEquals("1.2.4-dev01", development.toString(12))
        assertEquals("1.2.4", development.toString(6))
        assertEquals("1.2.4-dev", development.toString(9))
    }

    @Test
    fun `strict versions are derived from the rendered version`() {
        assertEquals(
            "1.2.4-dev01+abc1234",
            version(listOf("dev01"), listOf("abc1234")).toSemanticVersionOrNull().toString(),
        )
        val liftedMetadata = version(listOf("dev01"), listOf("abc1234"), buildMetadataSeparator = "-")
            .toSemanticVersionOrNull()
        assertEquals("1.2.4-dev01-abc1234", liftedMetadata.toString())
        assertEquals(true, liftedMetadata?.buildMetadata?.isEmpty())
        assertNull(version(listOf("dev01"), preReleaseSeparator = "#").toSemanticVersionOrNull())
    }

    @Test
    fun `versions are rendered with the configured separators`() {
        assertEquals("1.2.4", version().toString())
        assertEquals("1.2.4-dev01+abc1234.dirty", version(listOf("dev01"), listOf("abc1234", "dirty")).toString())
        assertEquals(
            "1.2.4#dev01@abc1234",
            version(listOf("dev01"), listOf("abc1234"), preReleaseSeparator = "#", buildMetadataSeparator = "@")
                .toString(),
        )
        assertEquals("1.2.4+abc1234", version(listOf("", ""), listOf("abc1234", "")).toString())
    }

    companion object {
        private fun version(
            preRelease: List<String> = emptyList(),
            buildMetadata: List<String> = emptyList(),
            preReleaseSeparator: String = "-",
            buildMetadataSeparator: String = "+",
        ) = GeneralizedSemanticVersion(
            1u,
            2u,
            4u,
            PreReleaseIdentifier(preReleaseSeparator, preRelease.joinToString(".")),
            PreReleaseIdentifier(buildMetadataSeparator, buildMetadata.joinToString(".")),
        )
    }
}
