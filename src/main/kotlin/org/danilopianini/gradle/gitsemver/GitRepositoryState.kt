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
     * The HEAD commit, or null if there is none (e.g., outside a repository, or in a repository with no commits).
     * Queries that find HEAD (e.g., [commitsSince]) store it, otherwise git is asked for it on first access.
     * Concurrent accesses may find it more than once, which is harmless.
     */
    @Volatile
    private var head: Commit? = null
        get() = field ?: runSuccessfullyOrNull("log", "-1", "--no-decorate", COMMIT_FORMAT)
            ?.toCommits()
            ?.firstOrNull()
            ?.also { field = it }

    /**
     * The commits reachable from HEAD but not from [revision], most recent first (hence, HEAD first, if any).
     * Fails if git cannot list them, as [revision] is expected to come from this repository.
     */
    fun commitsSince(revision: String): Sequence<Commit> =
        runSuccessfully("log", "--no-decorate", COMMIT_FORMAT, "$revision..HEAD").output.toCommits()
            .also { commits -> commits.firstOrNull()?.let { head = it } }

    /**
     * The hash of the HEAD commit, abbreviated unless [full] is true,
     * or null if there is no commit to point to (e.g., outside a repository, or in a repository with no commits).
     */
    fun headHash(full: Boolean): String? = head?.let { if (full) it.hash else it.abbreviatedHash }

    /**
     * Whether tracked files have uncommitted changes (untracked files are ignored).
     * Outside a repository, there is nothing to be dirty.
     */
    fun isWorkingTreeDirty(): Boolean =
        runSuccessfullyOrNull("status", "--porcelain", "--untracked-files=no")?.isNotEmpty() ?: false

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

    private fun String.toCommits(): Sequence<Commit> = takeIf { it.isNotEmpty() }
        ?.lineSequence()
        ?.map { line ->
            val (hash, abbreviatedHash, subject) = line.split(FIELD_SEPARATOR, limit = 3)
            Commit(hash, abbreviatedHash, subject)
        }
        .orEmpty()

    private companion object {
        // Full hash, abbreviated hash, and subject, separated by FIELD_SEPARATOR
        private const val COMMIT_FORMAT = "--format=%H%x00%h%x00%s"

        // Separates the fields of a commit in the output of git log (%x00), as it cannot appear in a subject
        private const val FIELD_SEPARATOR = '\u0000'
    }
}
