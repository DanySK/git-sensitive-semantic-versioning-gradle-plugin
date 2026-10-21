package org.danilopianini.gradle.gitsemver

/**
 * A commit, identified by its full [hash] and its [abbreviatedHash], with the [subject] of its message.
 */
internal data class Commit(val hash: String, val abbreviatedHash: String, val subject: String)
