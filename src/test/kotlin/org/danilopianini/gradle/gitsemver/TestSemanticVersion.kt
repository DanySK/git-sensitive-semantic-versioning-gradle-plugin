package org.danilopianini.gradle.gitsemver

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class TestSemanticVersion {

    @Test
    fun `semantic versions dot segments with leading zeros are treated as alphanumeric`() {
        assertNotEquals("1.0.0+01".semVer(), "1.0.0+1".semVer())
        assertFalse("1.0.0+01".semVer() < "1.0.0+9999999999999".semVer())
        assertTrue("1.0.0+01".semVer() > "1.0.0+9999999999999".semVer())
    }

    @Test
    fun `all sorting examples from the semver 2 specification should work`() {
        val correctlySorted: List<List<SemanticVersion>> = listOf(
            "1.0.0 < 2.0.0 < 2.1.0 < 2.1.1",
            "1.0.0-alpha < 1.0.0",
            "1.0.0-alpha < 1.0.0-alpha.1 < 1.0.0-alpha.beta < 1.0.0-beta " +
                "< 1.0.0-beta.2 < 1.0.0-beta.11 < 1.0.0-rc.1 < 1.0.0",
        ).map { versionList -> versionList.split(" < ").map { it.semVer() } }
        (1..10).map { Random(it) }.forEach {
            correctlySorted.forEach { reference ->
                assertEquals(reference, reference.shuffled().sorted())
            }
        }
    }

    companion object {
        private fun String.semVer() = requireNotNull(SemanticVersion.fromStringOrNull(this))
    }
}
