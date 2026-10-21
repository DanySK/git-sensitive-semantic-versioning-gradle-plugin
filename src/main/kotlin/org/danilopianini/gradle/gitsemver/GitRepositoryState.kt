package org.danilopianini.gradle.gitsemver

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.LoadingCache
import java.io.File
import org.danilopianini.gradle.gitsemver.source.GitCommandExecutionResult
import org.danilopianini.gradle.gitsemver.source.GitCommandExecutionResult.Failure
import org.danilopianini.gradle.gitsemver.source.GitCommandExecutionResult.Success
import org.danilopianini.gradle.gitsemver.source.GitCommandValueSource
import org.gradle.api.provider.ProviderFactory

/**
 * The state of the git repository containing [directory], as needed to compute a version.
 * The repository is assumed to not change during a build, so each git command runs at most once per instance.
 * Queries return raw git information: interpreting it according to the configuration is up to the caller.
 */
internal class GitRepositoryState(providerFactory: ProviderFactory, private val directory: File) {

    /**
     * Results of the git commands, keyed by their arguments (without the leading `git`), loaded on first access.
     */
    private val commandResults: LoadingCache<List<String>, GitCommandExecutionResult> =
        Caffeine.newBuilder().build { arguments ->
            providerFactory.of(GitCommandValueSource::class.java) {
                it.parameters { params ->
                    params.commands.set(listOf("git") + arguments)
                    params.directory.set(directory)
                }
            }.get()
        }

    /**
     * The number of commits reachable from HEAD but not from [revision].
     * Fails if git cannot compute it, as [revision] is expected to come from this repository.
     */
    fun distanceFrom(revision: String): Long = runSuccessfully("rev-list", "--count", "$revision..HEAD").output.toLong()

    /**
     * The hash of the HEAD commit, abbreviated unless [full] is true,
     * or null if there is no commit to point to (e.g., outside a repository, or in a repository with no commits).
     */
    fun headHash(full: Boolean): String? =
        runSuccessfullyOrNull("log", "-1", "--format=%${if (full) "H" else "h"}")?.takeIf { it.isNotEmpty() }

    /**
     * Whether tracked files have uncommitted changes (untracked files are ignored).
     * Outside a repository, there is nothing to be dirty.
     */
    fun isWorkingTreeDirty(): Boolean =
        runSuccessfullyOrNull("status", "--porcelain", "--untracked-files=no")?.isNotEmpty() ?: false

    /**
     * The subjects of the last [count] commits, starting from HEAD.
     * Fails if git cannot list them, as the caller is expected to know that they exist.
     */
    fun lastCommitMessages(count: Long): List<String> =
        runSuccessfully("log", "--oneline", "-$count", "--no-decorate", "--format=%s")
            .output
            .takeIf { it.isNotEmpty() }
            ?.lines()
            .orEmpty()

    /**
     * The names of the tags reachable from HEAD, or null if git cannot list them (e.g., outside a repository).
     * Lightweight tags are included only if [includeLightweightTags] is true.
     */
    fun reachableTags(includeLightweightTags: Boolean): List<String>? {
        val tags = when {
            includeLightweightTags -> runSuccessfullyOrNull("tag", "--merged", "HEAD")?.lines()
            else ->
                // Annotated tags are tag objects, lightweight tags point directly to a commit
                runSuccessfullyOrNull(
                    "for-each-ref",
                    "--merged",
                    "HEAD",
                    "--format=%(objecttype) %(refname:short)",
                    "refs/tags",
                )?.lines()
                    ?.filter { it.startsWith("tag ") }
                    ?.map { it.removePrefix("tag ") }
        }
        return tags?.filter { it.isNotEmpty() }
    }

    private fun run(vararg arguments: String): GitCommandExecutionResult = commandResults[arguments.asList()]

    private fun runSuccessfully(vararg arguments: String): Success = when (val result = run(*arguments)) {
        is Failure -> error(
            "git ${arguments.joinToString(" ")} failed in $directory with exit code ${result.exitCode}. " +
                "This is likely a bug in the git SemVer plugin, please report it at: " +
                "https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues",
        )
        is Success -> result
    }

    private fun runSuccessfullyOrNull(vararg arguments: String): String? = (run(*arguments) as? Success)?.output
}
