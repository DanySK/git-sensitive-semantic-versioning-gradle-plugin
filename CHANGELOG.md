## [0.3.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.0...0.3.1) (2021-12-01)


### Bug Fixes

* **deps:** update dependency gradle to v7.3.1 ([21988c6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/21988c6b6e72aefca8845b5ec2c4eb2aca6bea0b))

# 0.3.0

* The plugin does not require anymore to call `version = computeGitSemVer()`
* If configuration-time version setting is required, it can be achieved via:
```kotlin
gitSemVer {
    assignGitSemanticVersion()
}
```
