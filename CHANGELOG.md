# 0.3.0

* The plugin does not require anymore to call `version = computeGitSemVer()`
* If configuration-time version setting is required, it can be achieved via:
```kotlin
gitSemVer {
    assignGitSemanticVersion()
}
```
