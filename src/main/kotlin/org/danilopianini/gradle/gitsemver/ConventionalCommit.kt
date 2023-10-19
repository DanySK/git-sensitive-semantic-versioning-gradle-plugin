package org.danilopianini.gradle.gitsemver

/**
 * An object that analyzes commit messages using the [Conventional Commit specification](https://www.conventionalcommits.org/en/v1.0.0/) and assigns a [SemanticVersion] to them.
 */
object ConventionalCommit {

    private const val PATCH_COMMIT_REGEX = """^fix(\([^)]+\))?: .+$"""
    private const val MINOR_COMMIT_REGEX = """^(feat|perf)(\([^)]+\))?: .+$"""
    private const val MAJOR_COMMIT_REGEX =
        """(^[a-z]+(\([^)]+\))?!: .+$)|(^[a-z]+(\([^)]+\))?!?: .+BREAKING CHANGE: .*$)"""

    private fun isPatchCommit(message: String): Boolean = message.matches(PATCH_COMMIT_REGEX.toRegex())
    private fun isMinorCommit(message: String): Boolean = message.matches(MINOR_COMMIT_REGEX.toRegex())
    private fun isMajorCommit(message: String): Boolean = message.matches(MAJOR_COMMIT_REGEX.toRegex())

    /**
     * Computes the [UpdateType] of a list of commits according to the [Conventional Commit specification](https://www.conventionalcommits.org/en/v1.0.0/).
     *
     * @param commits the list of commits to analyze
     * @return the [UpdateType] of the commits
     */
    fun semanticVersionUpdate(commits: List<String>): UpdateType =
        commits.maxOfOrNull { commit ->
            when {
                isMajorCommit(commit) -> UpdateType.MAJOR
                isMinorCommit(commit) -> UpdateType.MINOR
                isPatchCommit(commit) -> UpdateType.PATCH
                else -> UpdateType.NONE
            }
        } ?: UpdateType.NONE
}
