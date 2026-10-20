# AGENTS.md

Guidance for AI coding agents working in this repository.

## Project overview

A Gradle plugin (written in Kotlin) that computes the project version from the state of the local git repository,
enforcing [Semantic Versioning 2.0](https://semver.org/).
See `README.md` for the user-facing behavior and the full list of options.

- Plugin IDs: `org.danilopianini.git-sensitive-semantic-versioning-gradle-plugin` (long)
  and `org.danilopianini.git-sensitive-semantic-versioning` (short).
  A legacy ID, `org.danilopianini.git-semver`, is declared in `src/main/resources/META-INF/gradle-plugins/`.
- Implementation class: `org.danilopianini.gradle.gitsemver.GitSemVer`.
- The build itself applies a *published* release of this plugin (`gitSemVer` in `gradle/libs.versions.toml`),
  not the sources in this repo.

## Layout

- `src/main/kotlin/org/danilopianini/gradle/gitsemver/`
  - `GitSemVer.kt`: plugin entry point; creates the extension, sets `project.version`,
    registers the `printGitSemVer` task.
  - `GitSemVerExtension.kt`: the `gitSemVer { }` DSL and the version computation logic.
    The version is a lazily computed `CharSequence`: keep computation as late as possible
    and avoid triggering it during configuration.
  - `SemanticVersion.kt`, `UpdateType.kt`: SemVer model, parsing, and bump strategies.
  - `ForcedVersionLoggerService.kt`: shared build service for the `forceVersion` property warning.
  - `source/GitCommandValueSource.kt`: runs git through a Gradle `ValueSource`
    (configuration-cache friendly — do not shell out to git by other means).
- `src/test/kotlin/`: Kotest (`StringSpec`) tests using Gradle TestKit against temporary git repositories.
- `src/functionalTest/groovy/`: Spock functional tests (separate `functionalTest` JVM test suite),
  run in parallel as configured in `src/functionalTest/resources/SpockConfig.groovy`.

## Building and testing

Always use the wrapper:

```bash
./gradlew build              # compile, run all tests and QA checks
./gradlew test               # Kotest unit/TestKit tests
./gradlew functionalTest     # Spock functional tests
./gradlew check              # tests + static analysis (ktlint, detekt, ...)
./gradlew ktlintFormat       # auto-fix Kotlin formatting
```

Notes:

- Tests create real git repositories and invoke `git`; a working `git` executable is required.
- Kotlin compiles with `allWarningsAsErrors = true`: any new warning breaks the build.
- QA is provided by `org.danilopianini.gradle-kotlin-qa` (ktlint, detekt, etc.).
  Do not suppress findings without a good reason.
- Multi-JVM testing compiles against the oldest Java supported by Gradle,
  so avoid APIs newer than that.
- CI runs on Linux, macOS, and Windows: keep paths, line endings, and process invocations portable.

## Code style

- Follow `.editorconfig`: ktlint `intellij_idea` style, 4-space indent, max line length 120, final newline.
- Use Gradle lazy APIs (`Property`, `Provider`, `ValueSource`) and keep the plugin
  configuration-cache compatible.
- Public API (extension properties, classes) must have KDoc; keep the extension's KDoc and the
  README's option list in sync when adding or changing options.
- Add tests for behavior changes: TestKit/Kotest in `src/test`, end-to-end scenarios in `src/functionalTest`.

## Commits and releases

- Commit messages must follow [Conventional Commits](https://www.conventionalcommits.org/)
  (enforced by a git `commit-msg` hook installed by the build; a `pre-commit` hook runs `ktlintCheck`).
- Releases are fully automated by `semantic-release` (`release.config.mjs`) from the commit history:
  never bump versions, edit `CHANGELOG.md`, or create tags manually.
- Dependency updates are handled by Renovate; do not mass-update versions in
  `gradle/libs.versions.toml` unless asked.
- Do not modify the CI workflows in `.github/workflows/` or publishing configuration unless explicitly asked.
