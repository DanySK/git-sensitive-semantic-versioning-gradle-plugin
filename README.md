# Git sensitive Semantic Versioning (SemVer) Gradle Plugin
A Gradle plugin for Git-sensitive Semantic Versioning

## Rationale
[Semantic Versioning](https://semver.org/) introduces a way to meaningfully version software.
At the same time, git carries the project history with it.
It sounds rather reasonable to mix them together, and have the project react to the git status.

This plugin assumes you use git tags to mark releases, by tagging your project with tag names such as `0.1.2`.
It then uses git to compute the version, in terms of both git hash and distance from the latest tag.

The plugin generates the following:

* "Archeo" versions for the development before initializing git, in the form of `0.1.0-archeo+time`
* "Pre-development" versions for the development before marking the first release, in the form of `0.1.0-dev+hash`
* "Stable" versions if a tag is present, in the form `0.1.0`
* "Development" versions for changes over a tag, in the form `0.1.1-dev01-hash`, with the number after `dev` counting the distance in commits since the last tag.

## Usage

### Importing the plugin

```kotlin
plugins {
    id("org.danilopianini.git-sensitive-semantic-versioning") version "0.1.0"
}
// Rest of your buildscript using project.version
```

### Plugin options

```kotlin
import org.danilopianini.gradle.gitsemver.UpdateType
...
gitSemVer {
    minimumVersion.set("0.1.0")
    developmentIdentifier.set("dev")
    noTagIdentifier.set("archeo")
    fullHash.set(false) // set to true if you want to use the full git hash
    maxVersionLength.set(Int.MAX_VALUE) // Useful to limit the maximum version length, e.g. Gradle Plugins have a limit on 20
    developmentCounterLength.set(2) // How many digits after `dev`
    enforceSemanticVersioning.set(true) // Whether the plugin should stop if the resulting version is not a valid SemVer, or just warn
    computeReleaseVersion.set(false) // You can decide whether the generated version should be for releases or pre-releases (default behaviour)
    // The separator for the pre-release block.
    // Changing it to something else than "+" may result in non-SemVer compatible versions
    preReleaseSeparator.set("-")
    // The separator for the build metadata block.
    // Some systems (notably, the Gradle plugin portal) do not support versions with a "+" symbol.
    // In these cases, changing it to "-" is appropriate.
    buildMetadataSeparator.set("+")
    distanceCounterRadix.set(36) // The radix for the commit-distance counter. Must be in the 2-36 range.
    // A prefix on tags that should be ignored when computing the Semantic Version.
    // Many project are versioned with tags named "vX.Y.Z", de-facto building valid SemVer versions but for the leading "v".
    // If it is the case for some project, setting this property to "v" would make these tags readable as SemVer tags.
    versionPrefix.set("")
    // This reproduces the behavior of the plugin at version 0.x.y: ignores non-annotated (lightweight) tags.
    excludeLightweightTags()
    // Compute the next upgrade type (major/minor/patch) based on commit messages; defaults to patch regardless of the commits.
    commitNameBasedUpdateStrategy { UpdateType.PATCH }
}
```

### Manually forcing the version computation early

The plugin sets the project version by scheduling a call to the `assignGitSemanticVersion()` using `project.afterEvaluate`.
This should be fine for most use cases, but you might need the version of the project to be set early in the configuration phase.
If so, you can manually call `assignGitSemanticVersion()` from within the plugin configuration block *after* all options have been configured
(if any configuration was performed):
```kotlin
gitSemVer {
    // Your configuration
    assignGitSemanticVersion()
}
```

Inside the configuration block is also available the `computeVersion()` is also available to recompute (but do not set)
the version.

### Manually force the version

The plugin allows the user to manually set the version via a gradle property that, if present, will be used as the version of the project.
By default, the property name is `forceVersion`, but you can change the property name by setting the `forceVersionPropertyName` property of the plugin with a custom name.

`./gradlew -PforceVersion=1.2.3 <task list>` will result in the project version being set to `1.2.3`.

If a custom property name is used, the plugin will look for the property with the given name:

```kotlin
gitSemVer {
    forceVersionPropertyName.set("myCustomPropertyVersion")
}
```

`./gradlew -PmyCustomPropertyVersion=1.2.3 <task list>` will result in the project version being set to `1.2.3`.

### Compute the version for release

By default, the extension calculates the version for pre-releases, but you can
force the calculation of the version for releases by setting the `computeReleaseVersion`
property to `true`. However, manually forcing the version (as described in
[Manually force the version](#manually-force-the-version)) still takes priority
over this property.

Consider the following configuration example:

```kotlin
// task that the release fulfils
project.tasks.register("release")

gitSemVer {
    computeReleaseVersion.set(
        project.tasks.named("release").map {
            project.gradle.taskGraph.hasTask(it)
        }
    )
}
```

With this configuration, the extension will calculate the pre-release version
until you force the release by executing the ‘release’ task. As soon as you
decide to release the project, the extension will calculate the release version
for you.

In combination with conventional commits, which will be described below, this
almost completely frees you from manually determining the project version. You
only have to decide what the ‘release’ task should do during execution. Probably
`git commit ...` and `git tag ...`, using `project.version` for this, but that's
up to you.

### Using conventional commits?

This plugin can be configured to use the [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/) to determine the next version
through another plugin developed by [Andrea Brighi](https://github.com/AndreaBrighi).
Visit the [conventional commits extension for git-sensitive-semantic-versioning-gradle-plugin](https://github.com/AndreaBrighi/conventional-commit-strategy-for-git-sensitive-semantic-versioning-gradle-plugin) to learn more.

## Contributing to the project

I gladly review pull requests and I'm happy to improve the work.
If the software was useful to you, please consider supporting my development activity
[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donate_SM.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=5P4DSZE5DV4H2&currency_code=EUR)
