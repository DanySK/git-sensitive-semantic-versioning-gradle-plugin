package org.danilopianini.gradle.gitsemver

/**
 * An object that analyzes commit messages and assigns a [SemanticVersion] to them.
 */
object ConventionalCommit {

    private const val PATCH_COMMIT_REGEX = """^fix(\([^)]+\))?: .+$"""
    private const val MINOR_COMMIT_REGEX = """^(feat|perf)(\([^)]+\))?: .+$"""
    private const val MAJOR_COMMIT_REGEX = """^[a-z]+(\([^)]+\))?!: .+$"""

    private fun isPatchCommit(message: String): Boolean = message.matches(PATCH_COMMIT_REGEX.toRegex())
    private fun isMinorCommit(message: String): Boolean = message.matches(MINOR_COMMIT_REGEX.toRegex())
    private fun isMajorCommit(message: String): Boolean = message.matches(MAJOR_COMMIT_REGEX.toRegex())

    /**
     * Computes the [CommitType] of a commit message, if any.
     */
    fun computeCommitType(message: String): CommitType? = when {
        isPatchCommit(message) -> CommitType.PATCH
        isMinorCommit(message) -> CommitType.MINOR
        isMajorCommit(message) -> CommitType.MAJOR
        else -> null
    }

    /**
     * Increments the [version] according to the [commitType].
     * If [commitType] is null, the [version] is returned unchanged.
     * If [commitType] is [CommitType.PATCH], the [version] is incremented as a patch.
     * If [commitType] is [CommitType.MINOR], the [version] is incremented as a minor.
     * If [commitType] is [CommitType.MAJOR], the [version] is incremented as a major.
     *
     * @param version the last tagged version
     * @param commitType the max type of the commit
     */
    fun incrementVersion(version: SemanticVersion, commitType: CommitType?): SemanticVersion = when (commitType) {
        CommitType.PATCH -> version.increasePatch()
        CommitType.MINOR -> version.increaseMinor()
        CommitType.MAJOR -> version.increaseMajor()
        null -> version
    }

    /**
     * The type of commit.
     *
     * - [PATCH] for bug fixes
     * - [MINOR] for new features
     * - [MAJOR] for breaking changes
     *
     * [PATCH] < [MINOR] < [MAJOR]
     */
    enum class CommitType {
        PATCH, MINOR, MAJOR
    }
}
