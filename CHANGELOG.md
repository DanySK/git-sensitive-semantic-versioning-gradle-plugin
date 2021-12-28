## [0.3.4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.3...0.3.4) (2021-12-28)


### Bug Fixes

* **deps:** update plugin dokka to v1.6.10 ([aaf5470](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aaf54705c09795ce7194bfabefad206c93957404))

## [0.3.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.2...0.3.3) (2021-12-22)


### Bug Fixes

* **deps:** update dependency gradle to v7.3.3 ([a3e36ba](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a3e36ba993ce681c6602bba93539b6a6fd623a9f))

## [0.3.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.1...0.3.2) (2021-12-15)


### Bug Fixes

* **deps:** update dependency gradle to v7.3.2 ([630e56d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/630e56d09dbfa0154164678e213a2e78ce19a8a1))

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
