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
    id ("org.danilopianini.git-sensitive-semantic-versioning") version "0.1.0"
}
gitSemVer {
    version = computeGitSemVer() // THIS IS MANDATORY, AND MUST BE LAST IN BLOCK
 }
// Rest of your buildscript using project.version
```

### Plugin options

```kotlin
gitSemVer {
    minimumVersion.set("0.1.0")
    developmentIdentifier.set("dev")
    noTagIdentifier.set("archeo")
    fullHash.set(false) // set to true if you want to use the full git hash
    maxVersionLength.set(Int.MAX_VALUE) // Useful to limit the maximum version length, e.g. Gradle Plugins have a limit on 20
    developmentCounterLength.set(2) // How many digits after `dev`
    version = computeGitSemVer() // THIS IS MANDATORY, AND MUST BE LAST IN THIS BLOCK!
}
// Rest of your buildscript using project.version
```

## Contributing to the project

I gladly review pull requests and I'm happy to improve the work.
If the software was useful to you, please consider supporting my development activity
[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donate_SM.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=5P4DSZE5DV4H2&currency_code=EUR)
