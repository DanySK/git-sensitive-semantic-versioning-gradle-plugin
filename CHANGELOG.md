## [6.0.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/6.0.0...6.0.1) (2025-08-14)

### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2.2.10 ([#1014](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1014)) ([8517e5c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8517e5ce84c8d5e317dfaf73cd7cf9175cb0be18))
* **deps:** update kotest to v6.0.0.m16 ([#1012](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1012)) ([9a8acec](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9a8acec4bea86c468bc49d7df03a31fc7037637d))
* **deps:** update plugin gitsemver to v6 ([#1011](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1011)) ([d39c749](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d39c749688ec5e1b651fc5b5d229549904b2a8f8))
* **deps:** update plugin kotlin-qa to v0.93.1 ([#1015](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1015)) ([8267c5b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8267c5bb184f763b6675cdd24c867d1c300ebe81))
* **deps:** update plugin multijvmtesting to v4.0.2 ([#1016](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1016)) ([ab35462](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ab35462b9ac8fcbbb0a61fc52ee7ad423e152d56))
* **deps:** update plugin multijvmtesting to v4.0.3 ([#1018](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1018)) ([5fdfdcc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5fdfdccb4fc7381ca658a8ba456527da613d672c))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.29 ([#1017](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1017)) ([4f3bce9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4f3bce9b143670536591e3daeb6ab488f3ce0612))
* **deps:** update plugin publishoncentral to v9.1.2 ([#1013](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1013)) ([088dd1d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/088dd1d14c4c7fe093fc94c12b222f47957eb270))

## [6.0.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.8...6.0.0) (2025-08-11)

### ⚠ BREAKING CHANGES

* drop support for Java older than 17. Java 17 will be required by Gradle 9 (#1006)

### Features

* drop support for Java older than 17. Java 17 will be required by Gradle 9 ([#1006](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1006)) ([28264c0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/28264c00f9ffc45fa44a316c8ca30f37dabc2ca6))

### Dependency updates

* **core-deps:** update dependency gradle to v9 ([#988](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/988)) ([14755dd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/14755dd14122d39d818e915ee470c01c569c96cd))
* **deps:** update plugin gitsemver to v5.1.8 ([#1010](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1010)) ([c9da5da](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c9da5dae84f6448cb2dee9fb4776a76c675a5659))

### Performance improvements

* avoid string concatenation in logger prints ([#1005](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1005)) ([82c51fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/82c51fca1b7bc6af4f106d427b344ede064bea44))

### Build and continuous integration

* **deps:** update danysk/action-checkout action to v0.2.24 ([#1002](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1002)) ([cb07969](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cb079699263dd9b301e3bd2ca8d7293ea99b6722))
* drop the use of deprecated `KotlinCompilerVersion.VERSION` ([#1004](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1004)) ([dd70ab9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dd70ab9dfaa50cddaf082631e8d940bb218f8275))

### Style improvements

* import the linting rules from AlchemistSimulator/alchemist ([#1008](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1008)) ([6af5d78](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6af5d78d4561d1a04d928fdda269248664bfda60))

## [5.1.8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.7...5.1.8) (2025-08-11)

### Dependency updates

* **deps:** update dependency com.github.ben-manes.caffeine:caffeine to v3.2.2 ([#976](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/976)) ([4f6d66b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4f6d66bb26ceaf38f5702572e478b3245d56aa48))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.136 ([#972](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/972)) ([19b9616](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/19b9616d70fb756ba8bb68cf1b6a92f685441f78))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.137 ([#979](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/979)) ([082268f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/082268f493955c2a881deb63ab1c24ce5bcce002))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.138 ([#980](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/980)) ([64f4ca2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/64f4ca26cbce18abd47ccbce59d311c3b34c81ee))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.139 ([#992](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/992)) ([4fc4e38](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4fc4e38982c1197c34d5049caea5598159918458))
* **deps:** update kotest to v6.0.0.m10 ([#990](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/990)) ([58f88ff](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/58f88ff7f14798d933c3b05db11f00a04c08b18d))
* **deps:** update kotest to v6.0.0.m11 ([#993](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/993)) ([18f6b4b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/18f6b4b7cfd2391ab185da76e95f92784f06c885))
* **deps:** update kotest to v6.0.0.m12 ([#994](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/994)) ([f8d505b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f8d505bc9d5cdf39374d86436f289481f9b36489))
* **deps:** update kotest to v6.0.0.m13 ([#998](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/998)) ([f6da4b2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f6da4b214f7887410cc1ea1bc14dae01c6d4a0a6))
* **deps:** update kotest to v6.0.0.m14 ([#999](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/999)) ([cdda484](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cdda484b63589f8eb7cffcd289ea50d138af9e82))
* **deps:** update kotest to v6.0.0.m15 ([#1000](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1000)) ([7dec147](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7dec147132cba006d5159c6dda1a021aa27054e5))
* **deps:** update kotest to v6.0.0.m5 ([#974](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/974)) ([9d9d4a5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9d9d4a51151fdecba5dc6e33d30c552b1af31f50))
* **deps:** update kotest to v6.0.0.m6 ([#983](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/983)) ([01ab3db](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/01ab3db96b56caec1824b8a0fba4e0b698626bf3))
* **deps:** update kotest to v6.0.0.m8 ([#984](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/984)) ([295bae4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/295bae41130d2cd745501074ca127bda17891b21))
* **deps:** update kotest to v6.0.0.m9 ([#987](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/987)) ([3d71968](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3d7196828a4bd47caf583ad02e18736635d7cd04))
* **deps:** update node.js to 22.18 ([#989](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/989)) ([03baa9c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/03baa9c72117c0062dc964c1ca923a230f612b4d))
* **deps:** update plugin com.gradle.develocity to v4.1 ([#978](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/978)) ([d701b29](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d701b29b140ea460af3dba9eb69aeee5d79676be))
* **deps:** update plugin gitsemver to v5.1.7 ([#968](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/968)) ([b7288bf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b7288bfca6091c45c7babee90371151a5e0c8d8b))
* **deps:** update plugin kotlin-qa to v0.90.2 ([#969](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/969)) ([222637f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/222637fe22e78ffefe690b1dae0bcb883a28a663))
* **deps:** update plugin kotlin-qa to v0.91.0 ([#973](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/973)) ([366590a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/366590a8d00ef675761ea871c1afff301eb8dbe2))
* **deps:** update plugin kotlin-qa to v0.92.0 ([#982](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/982)) ([02d725f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/02d725f9c76382bf256576cba70b0d2d20cf25e0))
* **deps:** update plugin kotlin-qa to v0.93.0 ([#986](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/986)) ([2706d21](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2706d21789c7c60df53eee8dcbba10450cc1cb22))
* **deps:** update plugin multijvmtesting to v3.5.4 ([#970](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/970)) ([8d5e716](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8d5e716a3a4e7aae85cb3063e0980c70c2648400))
* **deps:** update plugin multijvmtesting to v3.6.0 ([#981](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/981)) ([02d14b9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/02d14b9257b96712f91fc17c91071584188aec34))
* **deps:** update plugin multijvmtesting to v3.6.1 ([#996](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/996)) ([346861d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/346861db84ec38f51e12293e8b379b4fa55310c4))
* **deps:** update plugin multijvmtesting to v4 ([#997](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/997)) ([7183f47](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7183f477b9688dd3cce138aad6eb70a0b3f101be))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.28 ([#975](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/975)) ([b63f8ac](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b63f8acb64f29b2d78e7f5fb950f8326f67c8417))
* **deps:** update plugin publishoncentral to v9.0.7 ([#971](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/971)) ([65d5ba4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/65d5ba49d8dbccbbea18cbfb59e64ff98342c801))
* **deps:** update plugin publishoncentral to v9.0.8 ([#977](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/977)) ([682c2fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/682c2fcdd9cbf9936749d7cd1346af878bf69dd5))
* **deps:** update plugin publishoncentral to v9.1.0 ([#985](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/985)) ([9549b74](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9549b74e46bc7a5dc5510bd9477a136e9d8d268b))

### Documentation

* fix typo in class comment ([b21edaa](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b21edaa129608eddcc4ed38e5ca46fc05fe4621a))
* fix typos in KDoc ([0889a71](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0889a71c7b50f3efb0e6ddcbb512cd9d9f515a0d))
* **readme:** fix the documentation as suggested by [@piotrminkina](https://github.com/piotrminkina) ([c3bd098](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c3bd0981429e54a13b16cae5cb72ac55e181c459))

### Tests

* remove references to Gradle's internal `TemporaryFolder` ([#1009](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1009)) ([ba7f1b9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ba7f1b9ecfc7a81b249ca90d3cc06846e6a17f09))

### Build and continuous integration

* **deps:** update actions/checkout action to v4.3.0 ([#1001](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1001)) ([5a19624](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5a1962404546f92f20ad9d308496077b325b733a))
* **deps:** update actions/checkout action to v5 ([#1003](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1003)) ([83634f5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/83634f524d482eff1976c4c2c98aa89dbd3695e0))
* **deps:** update danysk/build-check-deploy-gradle-action action to v4.0.2 ([#991](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/991)) ([2465e5e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2465e5ef52f759f311e1133dafc00eb79ce85f2e))
* **deps:** update danysk/build-check-deploy-gradle-action action to v4.0.3 ([#995](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/995)) ([43234ec](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/43234ec1d06c40cdd448cc10e35179f2d6ef759b))

### General maintenance

* forbid nullable type parameters in support functions ([#1007](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/1007)) ([e2e3fad](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e2e3fadf09a22125b1da4143c3a4a3c7093ddc9b))

## [5.1.7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.6...5.1.7) (2025-07-04)

### Dependency updates

* **core-deps:** update dependency gradle to v8.14.3 ([#967](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/967)) ([0a67004](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0a670044868c8e11b1ee54e829bd03e91e4f3d9d))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.135 ([#966](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/966)) ([47b3c1a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/47b3c1a5f82fca899ca96d67399589ea640cdcca))
* **deps:** update plugin gitsemver to v5.1.6 ([#964](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/964)) ([66e47a2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/66e47a2dc38ff0ac5bf5fa369b738cfc31aad35b))
* **deps:** update plugin multijvmtesting to v3.5.3 ([#965](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/965)) ([98d18c3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/98d18c3ceea09e651ad996824fa7024ea52816c1))

## [5.1.6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.5...5.1.6) (2025-06-30)

### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2.2.0 ([#956](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/956)) ([32ee03e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/32ee03ecb266bd1b6226726ba4e95afbd5adc179))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.134 ([#963](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/963)) ([b08daf0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b08daf026bbbfad1d8e7b3f9eb76eb40c3227e3c))
* **deps:** update plugin gitsemver to v5.1.5 ([#962](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/962)) ([b74be4a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b74be4af831b90fcd3cf1d376da32ba4e7172862))
* **deps:** update plugin kotlin-qa to v0.90.1 ([#961](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/961)) ([a1d8363](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a1d83630040bb17d28e03fb5bad75b451b46d39b))
* **deps:** update plugin multijvmtesting to v3.5.2 ([#958](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/958)) ([32dd214](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/32dd214028f564feeef7b538e2f476fdca009509))

### Build and continuous integration

* migrate to the `compilerOptions` DSL ([f612067](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f612067a12117774f4220a1d7b95d31533660b36))

## [5.1.5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.4...5.1.5) (2025-06-29)

### Dependency updates

* **deps:** update dependency com.github.ben-manes.caffeine:caffeine to v3.2.1 ([#952](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/952)) ([2d53f6d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2d53f6d2407c81c6c47d9edd2ce354692608196a))
* **deps:** update node.js to 22.17 ([#960](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/960)) ([8a055fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8a055fcc33e7049e6eb2cf6b7e7b49a1a3b8a92c))
* **deps:** update plugin gitsemver to v5.1.4 ([#949](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/949)) ([e5beb5c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e5beb5c2c4114a17cbb6a73b64ac966e56073a2e))
* **deps:** update plugin kotlin-qa to v0.88.0 ([#946](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/946)) ([61f3f48](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/61f3f481e968e948f6813a14214c87c8c8da8d62))
* **deps:** update plugin kotlin-qa to v0.89.1 ([#947](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/947)) ([21cc58d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/21cc58dbfeb85824b7f6c448d4929ac333d56506))
* **deps:** update plugin multijvmtesting to v3.5.1 ([#950](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/950)) ([204b7f8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/204b7f8f518ecd2f780faac94b9d3180398d2130))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.26 ([#951](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/951)) ([3a6efdb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3a6efdba10533a4387a5444f126aed1f743db9a4))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.27 ([#959](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/959)) ([9371eca](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9371ecaf2996d2eee98824ba6c788d7762907a6c))

### Bug Fixes

* **ci:** migrate to Maven Central Portal ([4d34f2f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4d34f2fb48e805c799cd9a7bcec2fcd87f50aa9b))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v4 ([#953](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/953)) ([2d5ff7d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2d5ff7dc03e9cb1ad571eb64575cdff39eec3470))
* **deps:** update danysk/build-check-deploy-gradle-action action to v4.0.1 ([#955](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/955)) ([83f038d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/83f038d239e0d595aae5e1b06190eb82f40c570e))

## [5.1.4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.3...5.1.4) (2025-06-06)

### Dependency updates

* **core-deps:** update dependency gradle to v8.14.2 ([#939](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/939)) ([9dd919d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9dd919dbaaa6d708fae3f816d34d649e7d843466))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.128 ([#934](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/934)) ([9c059fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9c059fcb52c53d3aaad0393b74bc93568e15dea4))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.133 ([#940](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/940)) ([0a37211](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0a37211a762ec209b043c1a9fbc6e0acb7d55ddb))
* **deps:** update node.js to 22.16 ([#945](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/945)) ([956c4a1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/956c4a18a9487d6d49198dc1d8ab2b7b09323cf0))
* **deps:** update plugin com.gradle.develocity to v4.0.2 ([#941](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/941)) ([4249be1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4249be1e7c73956fd55664b91b7930315da3e3bd))
* **deps:** update plugin gitsemver to v5.1.3 ([#930](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/930)) ([53aad5c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/53aad5c15ceb2d241398d7359b6fa75f5ed21794))
* **deps:** update plugin kotlin-qa to v0.86.2 ([#931](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/931)) ([6cab063](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6cab063603965c7fb9d6c6e1a5732f6e67aaea11))
* **deps:** update plugin kotlin-qa to v0.87.0 ([#938](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/938)) ([19f91a2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/19f91a2a9834d35db1c30fa9892da91374473a56))
* **deps:** update plugin kotlin-qa to v0.87.1 ([#942](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/942)) ([1831a6d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1831a6da5416de71473aead15c60feaa85cbb749))
* **deps:** update plugin multijvmtesting to v3.4.2 ([#932](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/932)) ([c852dae](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c852daef336a2042d6d47daf0e0dd5dc995223f3))
* **deps:** update plugin multijvmtesting to v3.4.3 ([#943](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/943)) ([13fef44](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/13fef441a03932b6c902c11fc3a48853463f021d))
* **deps:** update plugin multijvmtesting to v3.5.0 ([#948](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/948)) ([496c836](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/496c836ba5575ebfb6b3a1272b0e1fe9f4e3f9d9))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.24 ([#933](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/933)) ([1cc8b30](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1cc8b3016d46737ea209d57c1b329be6ae788236))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.25 ([#944](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/944)) ([4e0c95a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4e0c95a59f100f126c2001f15dbbbf1bdc6eb31d))
* **deps:** update plugin org.gradle.toolchains.foojay-resolver-convention to v1 ([#937](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/937)) ([26e895b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/26e895b8964966e534b214b7e1be0dd33b57de87))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.19 ([#935](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/935)) ([aae296d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aae296d27d66bd47efc5861cee49ebffe45573ba))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.20 ([#936](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/936)) ([2f53019](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2f53019d8aa61fffc04b06b16106c7e7982d4faa))

## [5.1.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.2...5.1.3) (2025-05-13)

### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2.1.21 ([#929](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/929)) ([47a6388](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/47a63883caefae5c52aa71ac5fee3ba6cf9e18dd))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.126 ([#924](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/924)) ([24ad0b5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/24ad0b530c7c43725029e47868540b07417a5f72))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.127 ([#925](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/925)) ([ca702cf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ca702cf013e2ce27e0790828c6c99083becd12c2))
* **deps:** update kotest to v6.0.0.m4 ([#928](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/928)) ([3d426d7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3d426d72f7762dc9b8c31625077da473af21f797))
* **deps:** update plugin com.gradle.develocity to v4.0.1 ([#919](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/919)) ([c4c97e8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c4c97e83e779d3bc567c833763c84d7b1e1ba1f0))
* **deps:** update plugin gitsemver to v5.1.2 ([#920](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/920)) ([55e9f42](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/55e9f42cd41376cd4db9a47a74580978bd7c5d15))
* **deps:** update plugin kotlin-qa to v0.86.1 ([#922](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/922)) ([e995d31](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e995d31e4b6d3b753b33d406df3b27fb6e47e02c))
* **deps:** update plugin multijvmtesting to v3.4.1 ([#921](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/921)) ([b58c48e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b58c48e1d7772835f0b7ce9745cb176f5b67550a))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.23 ([#923](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/923)) ([f0c2df8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f0c2df82eb21559e27360b314236b62a644d9bf5))
* **deps:** update plugin publishoncentral to v8.0.7 ([#926](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/926)) ([a8fb798](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a8fb798641fc88d4c31b92d38cfeffb975122878))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.18 ([#927](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/927)) ([1c1e725](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1c1e7257025e4b12c1ce05058d1f72b5e65a38fe))

## [5.1.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.1...5.1.2) (2025-04-25)

### Dependency updates

* **core-deps:** update dependency gradle to v8.14 ([#918](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/918)) ([c14077e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c14077e99e1c92dd26740a06948b7b6325893975))
* **deps:** update node.js to 22.15 ([#917](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/917)) ([ad2ff01](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ad2ff0157d1dbf2e46dff94f21964405a336c5bf))
* **deps:** update plugin gitsemver to v5 ([#912](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/912)) ([3ba4585](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3ba458537918c922ca48688f94bec1d10899e138))
* **deps:** update plugin multijvmtesting to v3.4.0 ([#914](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/914)) ([f3ca827](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f3ca827bf8f41b4b97c4c4efa9a01956c5807883))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.17 ([#913](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/913)) ([5b9a32d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5b9a32dfc7389f93f0cefcab629492d45e676044))

## [5.1.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.1.0...5.1.1) (2025-04-14)

### Bug Fixes

* **ci:** fix the release task name ([9b18cd6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9b18cd6982a808ebf87bab28429cc56898cecb1b))

## [5.1.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/5.0.0...5.1.0) (2025-04-14)

### Features

* add computeReleaseVersion property to support release versions ([#910](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/910)) ([8284517](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/82845177ac9102bf5188af51e2ee8457299d789f))

### Dependency updates

* **deps:** update plugin org.gradle.toolchains.foojay-resolver-convention to v0.10.0 ([#909](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/909)) ([2ed04ef](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2ed04efdf837f6248d7e37357d62c2e7cb1b0285))

### Build and continuous integration

* **deps:** update actions/setup-node action to v4.4.0 ([#911](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/911)) ([4827a02](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4827a02685d98ea531bb7cb30601379416f88604))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.16 ([#908](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/908)) ([4de2b3a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4de2b3a944e0b3fb8082d03ff90c58c1df19b52c))
* **deps:** update dependency windows github actions runner to v2025 ([#907](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/907)) ([bcd87e7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bcd87e799cf807731ad154308040ac0c067f5226))

## [5.0.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/4.0.5...5.0.0) (2025-04-09)

### ⚠ BREAKING CHANGES

* fix early version enforcement, switch to intellij idea code style, improve performance by caching

### Dependency updates

* **deps:** update kotest to v6.0.0.m3 ([#903](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/903)) ([24a1981](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/24a1981c7cdbe494e7cf1d5ffa85b1893154d07f))
* **deps:** update plugin com.gradle.develocity to v4 ([#905](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/905)) ([8826e24](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8826e24253d7183842ecb2642efb69c9a0aef4e6))
* **deps:** update plugin kotlin-qa to v0.78.3 ([#895](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/895)) ([29c64a6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/29c64a61736e12d17e86f76953a466e1b65dcaa4))
* **deps:** update plugin kotlin-qa to v0.79.0 ([#896](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/896)) ([732e153](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/732e153403e5fa19a13b699897cca8ff60eef277))
* **deps:** update plugin kotlin-qa to v0.81.1 ([#897](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/897)) ([8d80de9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8d80de9406a62d05d6ae06538eeece8e626cc1a4))
* **deps:** update plugin kotlin-qa to v0.83.1 ([#899](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/899)) ([60b314c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/60b314c30eb0dde0ddd6d02579404ab90a940992))
* **deps:** update plugin kotlin-qa to v0.84.1 ([#900](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/900)) ([2d6a41c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2d6a41c94a81906163e75ee292303dc143de18aa))
* **deps:** update plugin kotlin-qa to v0.85.0 ([#902](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/902)) ([ed001a0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ed001a0a77d1d6ec86cb2c10d3576ff8e5503832))
* **deps:** update plugin multijvmtesting to v3.2.4 ([#891](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/891)) ([fc1418a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fc1418a4fa188004698adf8030af76e8080b2964))
* **deps:** update plugin multijvmtesting to v3.3.0 ([#894](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/894)) ([88947f9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/88947f9b768fd607f2c8a3e68d0d3b7c776359f0))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.22 ([#893](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/893)) ([9118dea](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9118dead8c84b82091f5dec417d41732339a170d))
* **deps:** update plugin publishoncentral to v8.0.5 ([#892](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/892)) ([881756e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/881756e3f6ae0549f9351b06fae6dbc98b48355e))
* **deps:** update plugin publishoncentral to v8.0.6 ([#904](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/904)) ([ca2dac6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ca2dac610406b9ab12ca33b65e7925501fc19d82))

### Bug Fixes

* fix early version enforcement, switch to intellij idea code style, improve performance by caching ([db20f2a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/db20f2ac994ff7921f60f1cea0129af322b46b6f))

### Tests

* do not change the git global configuration and disable signing locally to tests ([2de8106](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2de8106a864ff73e93c1952bd1702fdc728f6bde))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.14 ([#901](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/901)) ([2c62952](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2c629520dbaf08fe87e4e22143e8332113f93f39))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.15 ([#906](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/906)) ([4def66d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4def66d52ebce2b6b3325a5a0e3c4b4286826b8f))

### Style improvements

* remove trailing space ([b2c91cd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b2c91cd0473de4d332b4a25e8f1b2dadd627ec74))

## [4.0.5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/4.0.4...4.0.5) (2025-03-20)

### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2.1.20 ([#890](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/890)) ([03638cf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/03638cf80d57bd1418c56faf00348cb5be96e7f1))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.21 ([#882](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/882)) ([e89c97a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e89c97a8cda80526b84ad0f56d43f8a8239b7731))
* **deps:** update plugin publishoncentral to v8.0.4 ([#886](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/886)) ([7af20d2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7af20d258017cd6ca772bf2a15a1a2f8a340d752))
* **deps:** update plugin tasktree to v4.0.1 ([#887](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/887)) ([17b27aa](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/17b27aa8ebed70a4bc24dbe8ac71cecb5ae974a0))

### Build and continuous integration

* **deps:** update actions/setup-node action to v4.3.0 ([#888](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/888)) ([691d27a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/691d27abd3ef8e942647e5836b8e4f49435ad75f))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.11 ([#884](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/884)) ([8986e04](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8986e0441de2bbd252c0a7faeda71cec3ed11a10))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.12 ([#885](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/885)) ([bdbd20c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bdbd20c78326cb2ba4088679a8bd77126e4ec2a3))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.13 ([#889](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/889)) ([ac5fab4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ac5fab4f1ec66d95d15a08cbe5b418b92067f4ab))

## [4.0.4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/4.0.3...4.0.4) (2025-02-25)

### Dependency updates

* **core-deps:** update dependency gradle to v8.13 ([#883](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/883)) ([07c7173](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/07c7173ed7d422d9bc540b66330e0a06dd5d828b))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.120 ([#871](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/871)) ([ac289d5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ac289d5cfde3ac7fb5999bf520ca135e8f1f4377))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.121 ([#872](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/872)) ([36a5100](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/36a5100311d648b5876f5eb918b1500c30ddaab6))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.122 ([#873](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/873)) ([3ad0d11](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3ad0d11a176c1add7b326dad272682e8b4bd6aa9))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.123 ([#875](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/875)) ([8b423dd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8b423ddbb033331b3a7d9c085a9869a7f406df87))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.124 ([#876](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/876)) ([c33427d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c33427d06b582607864a75225b46548e5883bc72))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.125 ([#880](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/880)) ([41acd62](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/41acd62964856cb59a47f3b6ddbb3f7d7c111f51))
* **deps:** update kotest to v6.0.0.m2 ([#870](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/870)) ([0205125](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/02051250973659755bc1cfa993d3f3be4b295e3c))
* **deps:** update node.js to 22.14 ([#874](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/874)) ([102988b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/102988b845906c1724bf276c0efc0ce3c790e754))
* **deps:** update node.js to v22 ([9d3f3a3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9d3f3a326465d04eef915fbc115eee214ea94808))
* **deps:** update plugin com.gradle.develocity to v3.19.2 ([#878](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/878)) ([af07821](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/af07821539012d619f5dc7cd9ba25485bb27d012))
* **deps:** update plugin gitsemver to v4 ([#862](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/862)) ([bd7d7ee](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bd7d7ee020ad3692023cb704637944fcf59c5a7e))
* **deps:** update plugin gradle-plugin-publish to v1.3.1 ([#867](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/867)) ([7216e44](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7216e4455f442b27ba3a86571dd666c1ddc761d0))
* **deps:** update plugin multijvmtesting to v3.2.3 ([#881](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/881)) ([b481bf9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b481bf9f6a1d53490830a2482784664bc0a4329d))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.20 ([#863](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/863)) ([fe74a66](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fe74a66fa9f04452e31a01342dff87428104eece))
* **deps:** update plugin publishoncentral to v8 ([#853](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/853)) ([cbbcd68](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cbbcd68fcad441efc61d6bd171c54e83cde9db45))
* **deps:** update plugin publishoncentral to v8.0.3 ([#869](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/869)) ([5b0dbcc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5b0dbcc770fbee39407a15df6f072dd613ac9e61))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.10 ([#879](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/879)) ([772c1af](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/772c1af32ea2fb4248c985c1e203d72976badd82))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.7 ([#866](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/866)) ([db701a0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/db701a07fc487cdc8df73b815aa944cb0a251897))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.8 ([#868](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/868)) ([e25a40e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e25a40e871194ad39d17600a32f72c091662ebb3))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.9 ([#877](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/877)) ([c04c7bd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c04c7bdd0a33bec40a9ac9b5d8e896bd482d820d))
* **renovate:**  use `with` when importing the configuration instead of `assert` ([#865](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/865)) ([b0d3f1e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b0d3f1e5edca1c3691941d4f4f13522a8be9aa78))

## [4.0.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/4.0.2...4.0.3) (2025-01-27)

### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2.1.10 ([#825](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/825)) ([623c57d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/623c57d845533e798ca189ccc46d416f39f5bf5f))
* **deps:** update plugin multijvmtesting to v3.2.2 ([#864](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/864)) ([e98957a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e98957a6ae61efd5d481d12763945f382b548581))
* **deps:** update plugin publishoncentral to v7 ([#852](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/852)) ([028209f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/028209f5f5e6be96e659edf0792e65e1963b2170))

## [4.0.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/4.0.1...4.0.2) (2025-01-27)

### Dependency updates

* **core-deps:** update dependency gradle to v8.12.1 ([#824](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/824)) ([d3476ca](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d3476ca60718c01306ea37318ce7793e3f81d9eb))
* **deps:** update plugin multijvmtesting to v3 ([#849](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/849)) ([d4ffed5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d4ffed5d1b26b7a8c9cb02e73012d8fe9db7511f))

## [4.0.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/4.0.0...4.0.1) (2025-01-27)

### Dependency updates

* **core-deps:** update dependency gradle to v8.11.1 ([#811](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/811)) ([8190632](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/81906324d1ae600d232e7df51e8e441d4e5fc53c))
* **deps:** update plugin multijvmtesting to v2 ([#848](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/848)) ([f871e67](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f871e67e45218f09bcf3889aae7c69220b4a9647))

### Build and continuous integration

* drop unreleased staging repos on OSSRH ([ef1e3c9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ef1e3c99778faca891d6a8aca1cf4658474015df))

## [4.0.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.10...4.0.0) (2025-01-27)

### ⚠ BREAKING CHANGES

* update plugin kotlin-qa to v0.78.0 (#838)

### Dependency updates

* **deps:** update dependency io.kotest to v6 ([c886fad](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c886fadfff07c0e44f8f823ff1dc22dc0be811f9))
* **deps:** update plugin gitsemver to v3.1.10 ([#861](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/861)) ([14834ee](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/14834eed670006e09ab8f86a5418d11f2bc546cb))

### Style improvements

* update plugin kotlin-qa to v0.78.0 ([#838](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/838)) ([88cead4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/88cead446d39432f6df4fa81f0a02a760f4ccd51))

## [3.1.10](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.9...3.1.10) (2025-01-27)

### Dependency updates

* **deps:** update plugin gitsemver to v3.1.9 ([#856](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/856)) ([60316bd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/60316bdc7a38932fe68ab15639933008de1a23d5))
* **deps:** update plugin multijvmtesting to v1 ([455d1a6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/455d1a62d9b81f0d0d454cf035e4fb0f4321daf1))

### Documentation

* **deps:** update dependency org.jetbrains.dokka to v2 ([#858](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/858)) ([0cf5ea1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0cf5ea1bc7470a61f955e44dbda8f593f34f40b6))

### Build and continuous integration

* **deps:** update actions/setup-node action to v4.2.0 ([#857](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/857)) ([6d5f2f5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6d5f2f5b35991fd39dbe8cb5c7ba0431f476a879))
* **deps:** update danysk/action-checkout action to v0.2.22 ([ebf64ce](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ebf64ceafa7de77a2479fee055db48f6d7874151))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.7.6 ([#847](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/847)) ([950de3d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/950de3d09a4b82776f290ee288b4bc0d61ee388e))
* **deps:** update dependency ubuntu github actions runner to v24 ([#854](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/854)) ([3d17cab](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3d17cabe911fe4bd31122dd579bc3d7f61347026))
* provide a codecov token ([#851](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/851)) ([c33e155](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c33e1550a4313a86caa3b38a61c64a6edcbccbd5))

## [3.1.9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.8...3.1.9) (2025-01-27)

### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2.0.21 ([06d61ba](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/06d61ba1e9a76c830dede387c33549419c720c77))
* **deps:** update node.js to 20.18 ([#815](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/815)) ([01f161f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/01f161ff1755dd3b9acb1890ca352c795dd115bb))
* **deps:** update plugin com.gradle.develocity to v3.18.2 ([#816](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/816)) ([473af4c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/473af4cf0f907c91e990bf407d546286b00f3ffb))
* **deps:** update plugin com.gradle.develocity to v3.19.1 ([#826](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/826)) ([d18c9a1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d18c9a1d4b92c94e46ed464988f83052a30a5467))
* **deps:** update plugin gitsemver to v3.1.8 ([#832](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/832)) ([fca8385](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fca8385814ff0af33c2caf674874d4a228d4d1f6))
* **deps:** update plugin gradle-plugin-publish to v1.3.0 ([#817](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/817)) ([6312bac](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6312bacffcc7633618fe6c3c613e578f23b3615a))
* **deps:** update plugin kotlin-qa to v0.66.1 ([#821](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/821)) ([52d30f1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/52d30f158d16ff8708d2dfa40b034ce90869c723))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.19 ([ddd5b7e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ddd5b7ee7878c8550d23dc704da5f18aa043e9cf))
* **deps:** update plugin org.gradle.toolchains.foojay-resolver-convention to v0.9.0 ([#839](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/839)) ([b8c1d4a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b8c1d4a12a19ad523c0d94fdb3be6d1c49cf5052))
* **deps:** update plugin publishoncentral to v5.1.11 ([e0ea3c8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e0ea3c8510730a3d6321e1109b3d8a90718cd687))

### Build and continuous integration

* **deps:** update actions/checkout action to v4.2.2 ([#840](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/840)) ([733b6d0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/733b6d0b73f8e08d71c19e7be8bc8b1a7839b2c8))
* **deps:** update actions/setup-node action to v4.1.0 ([#841](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/841)) ([85ebb3a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/85ebb3aee3e2a96f41aee880edc124d67b7c39c8))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.2.0 ([#842](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/842)) ([2a988c7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2a988c7b4150cb1579fb247a248f1ae7b2674a20))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.3.0 ([#843](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/843)) ([2643919](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/26439190ccd64b4dcc18ccff720fec9e4ddcfbc8))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.6.0 ([#846](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/846)) ([dde9ae1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dde9ae164d35a3bd375b4a16b77537b1f56f3cd6))

## [3.1.8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.7...3.1.8) (2025-01-26)

### Dependency updates

* **core-deps:** update dependency gradle to v8.10.2 ([#810](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/810)) ([c7e9077](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c7e907758fc04473933d49c0cf79608bdf30a088))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.119 ([ac6851c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ac6851c87d38350a0325ce0865373c1c1411cea1))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.87 ([cfb12d1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cfb12d14a0167720f04ca3d724b7d2f81712fe2f))
* **deps:** update kotest to v5.9.1 ([f77eb57](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f77eb578950bc41fcb37d2a66ea6d86d223c61c6))
* **deps:** update node.js to 20.15 ([4b18bd1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4b18bd1d9b6a18740afa6a0f9b78072871353490))
* **deps:** update node.js to 20.16 ([#813](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/813)) ([b6aa29f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b6aa29fb8254b8005ffc9d841fbcf3861dacc710))
* **deps:** update plugin com.gradle.enterprise to v3.17.5 ([ec03b9e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ec03b9e85b49f896f8e9a860738eb7b17dd4e82a))
* **deps:** update plugin gitsemver to v3.1.7 ([0c7d541](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0c7d541700c61542a81f640d521985a7ff158007))
* **deps:** update plugin kotlin-qa to v0.62.1 ([bc10e83](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bc10e83472bfdad7eca5b9980fb3eeecff3e1d62))
* **deps:** update plugin kotlin-qa to v0.62.3 ([c82996c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c82996cbd94577dcd3435007d1c40fad156cf1ef))
* **deps:** update plugin kotlin-qa to v0.65.2 ([#820](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/820)) ([1078e09](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1078e092d56a3a453f9057b1d12de81f8ee56184))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.7 ([751b24b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/751b24b665695fa2ac27e7a1b5f0638e5e8601d9))
* **deps:** update plugin publishoncentral to v5.1.2 ([cf97cf9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cf97cf9a196af3e9ebf6cdb44e71927c7078f07e))
* **deps:** update plugin publishoncentral to v5.1.3 ([b0d90b0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b0d90b01c3bcada1a9728e65b6ee7a82f3bbf53e))
* **deps:** update plugin tasktree to v4 ([c738290](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c738290f11d34ec914c0fbd60b5e116c6f4ee31c))
* **deps:** update semantic-release-preconfigured-conventional-commits to 1.1.89 ([4a90dd2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4a90dd20a87019f6290937f99dfc28a3cc084881))

### Build and continuous integration

* add the gradle wrapper's `distributionSha256Sum` ([8b8397a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8b8397afa6ae57122d28c8b5dfae39f0f767942c))
* **deps:** update actions/checkout action to v4.1.7 ([ea2dc79](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ea2dc79905114d81d3fe0c15bea2305c4a6ed5bd))
* **deps:** update actions/setup-node action to v4.0.3 ([a37f2e5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a37f2e5ecb670ec41ea51fbeefcb9dd0cd7cb326))
* **deps:** update danysk/action-checkout action to v0.2.19 ([c1de2cd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c1de2cd8e6244e18fa973aceb174e55dc2e5fed7))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.21 ([f66fe60](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f66fe6066ac500d5e0a1ccd3b6f33357f85be85a))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.22 ([9a8efd7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9a8efd7eb2e55ca8c8a4afc9793f128d64715907))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.24 ([cbc2dcf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cbc2dcf466b8230925a1594c6d50e79eab822fd8))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3 ([0fb01c5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0fb01c5e8b19f2e139fe294b991c82e7131dbeb1))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.1.0 ([940ad11](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/940ad11a51f869280fe7bcbc62cf874d5c823ed6))
* do not retry to release on failure ([7c3ced1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7c3ced1c9a3901bd98caa413205e8f59c5c322a1))
* explicitly read the username from the repository secrets ([272739b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/272739b161aa7b17d1bff3463e8947242a4da609))
* install node from the spec in package.json ([adba793](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/adba7934e584a2885565ee16f4ab083ab4aa6fcf))
* move the concurrency management inside the dispatcher workflow ([0c79fb1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0c79fb17aa1240cce7f123512cdbd7d1fd57d77d))
* pinpoint the version of the github actions runners ([692d678](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/692d6786a6133a4728e7772c6b876ffd7495c34d))
* switch to Develocity ([#787](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/787)) ([1af08fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1af08fc967d43996f5c52a4badd62f1fdf249d58))

## [3.1.7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.6...3.1.7) (2024-05-31)


### Dependency updates

* **core-deps:** update dependency gradle to v8.8 ([320bd44](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/320bd440e04632238b90708c213ceb76763ff706))
* **deps:** update node.js to 20.14 ([39a7dad](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/39a7dadb64a0594676f4a1cf16c072e05d8d814c))
* **deps:** update plugin gitsemver to v3.1.6 ([97e0a3a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/97e0a3a9b6eeb58b4dd5f66810fa1b026c171cd9))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.6 ([e5a8dd4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e5a8dd4887a9507972918a0d9d2a02ca239d4673))

## [3.1.6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.5...3.1.6) (2024-05-21)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v2 ([0d8383e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0d8383e313ddeecb1bfcf4d80fceae30027e4faf))
* **deps:** update dependency io.kotest:kotest-assertions-core-jvm to v5.9.0 ([878b438](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/878b4385d14c1a7ddd954669400d234b6504cef0))
* **deps:** update node.js to 20.13 ([0094e35](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0094e357a04694655c92e5e123d8da6e295c9443))
* **deps:** update plugin com.gradle.enterprise to v3.17.3 ([76ba56e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/76ba56ecbe4b0d2ef16b83203828de21017e0f33))
* **deps:** update plugin com.gradle.enterprise to v3.17.4 ([f07eb1d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f07eb1d69bdf0bf03ba80516c00d21c69595c72d))
* **deps:** update plugin gitsemver to v3.1.5 ([1594152](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/15941529ec70d169dd90d44e7c95e423463c508c))
* **deps:** update plugin kotlin-qa to v0.61.1 ([663e1a2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/663e1a27c1bd2e6139c665e18fc2b63d0986d8d0))
* **deps:** update plugin kotlin-qa to v0.62.0 ([4713e71](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4713e7194500061143e3f352b633e72f8fc40da0))
* **deps:** update plugin publishoncentral to v5.1.1 ([d560ca6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d560ca6b323da86dbcbf7bd0686ca9128b731d49))


### Build and continuous integration

* **deps:** update actions/checkout action to v4.1.5 ([9df455f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9df455f2b9603210b3d0a524626525c1e854caf0))
* **deps:** update actions/checkout action to v4.1.6 ([43b4a35](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/43b4a35e9be96d4a7f81d481a205faa7c8d84f08))
* **deps:** update danysk/action-checkout action to v0.2.17 ([d169356](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d16935665d38ca0908a4d02653614fcefd12ce8b))
* **deps:** update danysk/action-checkout action to v0.2.18 ([419838b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/419838b1fd44f7b28e8b2af00fe5b0816617a2f1))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.19 ([e05bd99](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e05bd99114c473bbdacd233e0fbcf9df30a1cee5))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.20 ([1e68a76](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1e68a7606fe019d0347fcac6709b3b568a2baeb0))

## [3.1.5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.4...3.1.5) (2024-05-07)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.9.24 ([0f2aceb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0f2acebc2cf8cb6549d1a78a5d9416ef6db50813))
* **deps:** update node.js to 20.12 ([8fe9597](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8fe9597473f5ea6d037730eb0bc6da0acb853a93))
* **deps:** update plugin com.gradle.enterprise to v3.17 ([584c034](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/584c0344f6a20a7b4b3d72250659e238400c49e2))
* **deps:** update plugin com.gradle.enterprise to v3.17.1 ([c282741](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c2827417ecfa7309b658cffde55dbc4122979ef4))
* **deps:** update plugin com.gradle.enterprise to v3.17.2 ([201b138](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/201b13878930393171628b1bd56242ccef119933))
* **deps:** update plugin gitsemver to v3.1.4 ([eee047d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/eee047ddc510d24ac8dcd88fd252042d15b3c1bc))
* **deps:** update plugin kotlin-qa to v0.61.0 ([b4b51b9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b4b51b9b060450a8e22b32bc339c03e22ed9efe0))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.4 ([f4c1d9a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f4c1d9a103367bb5b3da93ba792081c0ec86c214))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.5 ([69ab016](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/69ab01628af9daf2b3da7efdcda7201e34b77b87))
* **deps:** update plugin publishoncentral to v5.1.0 ([ecdaafc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ecdaafc6afb997dcebfe5eebcfd5c6bea1671bbf))
* **deps:** update plugin tasktree to v3 ([df24b22](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/df24b22c8b0a1f3131b419cbb13ec74c7579e5ef))


### Build and continuous integration

* **deps:** update actions/checkout action to v4.1.3 ([c464adb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c464adb7507acb4959a247605b4df75963235e09))
* **deps:** update actions/checkout action to v4.1.4 ([87e850f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/87e850f016e166b5923f2f6e386582e6659037b5))
* **deps:** update danysk/action-checkout action to v0.2.15 ([5031c40](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5031c403e00d7680b6a6fcd8658eecd966b4a63d))
* **deps:** update danysk/action-checkout action to v0.2.16 ([ca8c63a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ca8c63a8b2fe989af72214c2571b5b02cc2f5871))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.11 ([c02ab40](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c02ab40fca80e7fdd0593277a1e70176ff67ad8f))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.12 ([7442568](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/744256810ec25cb9d533a94b0d05472e594830c0))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.13 ([2becdf4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2becdf4d5026f83aaa079b59940d6281f14f8e79))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.14 ([fb2e648](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fb2e648613a96c349c61feb7dee36933be0d347f))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.15 ([e2e3c0e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e2e3c0ec93ceaa4e27c5ad1a75b5b55cbace74b6))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.16 ([e5a6901](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e5a69019fc69d641959183ad122d6eba0c273445))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.17 ([f6d68eb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f6d68ebed21fd40951613c4ae08a1912932672ae))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.18 ([91a4c90](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/91a4c90f477c7a3b4eb18d9dcb37a9320f5058ef))

## [3.1.4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.3...3.1.4) (2024-03-22)


### Dependency updates

* **core-deps:** update dependency gradle to v8.7 ([6484638](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/64846383b5a948ecbb476ca52c5c941d807567fb))
* **deps:** update kotest to v5.8.1 ([e207d37](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e207d372f854f583651dfc89177ee6082d85e66b))
* **deps:** update plugin gitsemver to v3.1.3 ([3b721c2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3b721c2f7aece4068655463d28ccff90c866ba67))
* **deps:** update plugin kotlin-qa to v0.60.3 ([67392c0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/67392c0d4ffa6f191cc36a1da89213217e7e97a3))
* **deps:** update plugin kotlin-qa to v0.60.4 ([62e6ece](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/62e6ececa4c71d8b7bc112342cb4eb2402a95096))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.3 ([b6fc14c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b6fc14c59ea66278d1b45c163938d0272661fe85))
* **deps:** update plugin publishoncentral to v5.0.25 ([fb6f03e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fb6f03e0aead6e9ab9f0824bd4b6d4a470ac9124))
* **deps:** update plugin publishoncentral to v5.0.26 ([ceea7e3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ceea7e395a56074e4a684ee1af6b608816ee77e3))


### Build and continuous integration

* **deps:** update actions/checkout action to v4.1.2 ([6b77beb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6b77beb663dcd54c8db08f4e09699c67a3ccc7f1))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.10 ([005577d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/005577d4a8e65e1abb3adb1a0a34566c0c358351))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.7 ([a8a1874](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a8a1874c2963df639d054b41ffb7b71875e7ed1a))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.8 ([f7a42f7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f7a42f7288f4a73a65207370573585b8d0af10cf))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.9 ([446f458](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/446f4586be2ac16337fc9f405e76eeb39af19ee2))

## [3.1.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.2...3.1.3) (2024-03-07)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.9.23 ([0ce1de9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0ce1de9805c440e724a93bbffa2f6a0d299dbd9b))
* **deps:** update plugin gitsemver to v3.1.2 ([6c17ec0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6c17ec0c4f59ddb273f072dc3c071a3bc2f5d4ea))
* **deps:** update plugin kotlin-qa to v0.60.2 ([026abc5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/026abc5d3e2bbe5cf5a588346d0c5e4cc74b4b98))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.2 ([b22a880](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b22a88060d53de4fbb75d3d668355e883e8990f0))
* **deps:** update plugin publishoncentral to v5.0.24 ([d0b72a3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d0b72a3c7d119bbdf38721baf7d8bc3881d03fec))

## [3.1.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.1...3.1.2) (2024-03-04)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.9.20 ([4b2896e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4b2896edb9fb49ef790e8a4486d90d00b8a9c324))
* **deps:** update plugin gitsemver to v3.1.1 ([31b6c9c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/31b6c9c808440941a0a885087e951e7b53166628))
* **deps:** update plugin kotlin-qa to v0.59.1 ([bc62dc7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bc62dc7d90c2a18289ff14538c74f8809556d97f))
* **deps:** update plugin kotlin-qa to v0.60.0 ([934d9d5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/934d9d548c48be779b560c64b8884eecc8619764))
* **deps:** update plugin kotlin-qa to v0.60.1 ([36b1df6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/36b1df614daaef097fb3b47450ce222eb8af1ff1))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.1 ([eb72dc8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/eb72dc89bc1fea38ce0eb1b4281b07808252967d))
* **deps:** update plugin publishoncentral to v5.0.23 ([9590c36](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9590c36bae49012eb3455ee356bfdd2fa5329aaf))


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.3.0 ([ffe14a5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ffe14a51022094914d47bced0b8cb0cdc09f3757))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.3.1 ([37c4672](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/37c46721222f1916d8be12f12ee3b554209f7a38))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.3.2 ([2fe1aab](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2fe1aab0fccb6c1687974c38d06af4101e2bd10c))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.0 ([8f45606](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8f4560697afd7c28c8098f2357c410db9d2f30ba))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.1 ([e8f8a46](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e8f8a464141d7b33345305183aa82412eb59b760))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.2 ([00f10e0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/00f10e03e1bc6db4bbbb3c3d4b5b31ef45ca7cb0))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.3 ([32aa777](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/32aa777d17a7cd4df85c7d9028cf230a7514b407))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.4 ([2e00089](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2e000897616921bf0cf462b834c9f0ce0920a7bd))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.5 ([167948b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/167948bac1e7a36d0c63f73b026f258bc20335eb))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.4.6 ([1b43e5f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1b43e5f0fc485d0d1a145f5dd608c42d67110be2))

## [3.1.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.1.0...3.1.1) (2024-02-02)


### Dependency updates

* **core-deps:** update dependency gradle to v8.6 ([551350c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/551350ccf60bab755d46754a0734d68c71cc0792))
* **deps:** update plugin com.gradle.enterprise to v3.16.2 ([999f3db](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/999f3dbeaabcf746b12a2c5f4b3bce1579c75a1f))
* **deps:** update plugin gitsemver to v3.1.0 ([a3ffbb0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a3ffbb0ff7f7bce5c878cc787e86c7043e307bce))
* **deps:** update plugin kotlin-qa to v0.59.0 ([5aa2cc0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5aa2cc0da04b132afa28d5d6a839fe4b73f9a8a2))
* **deps:** update plugin multijvmtesting to v0.5.8 ([7b2685c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7b2685c34aca909535ac886d1f5ced7c0731543c))


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.15 ([b4808b4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b4808b427160c53063ccd83ec83d20b3cdd206ea))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.16 ([ab7b693](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ab7b693d063ce66013562fbeb380cf6789f90902))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.17 ([80934db](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/80934dbbae6a4e284cabed4550341210640a1af5))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.18 ([f716d25](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f716d253c205108655aca3dec49671f1222e2bfc))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.19 ([f24b6b6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f24b6b6a2a964df6ab5fe8ed5222c95f32f6cbf3))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.20 ([11a0066](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/11a006647549252c9615dfe75a96930c78ff8770))

## [3.1.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/3.0.0...3.1.0) (2024-01-21)


### Features

* relax `runCommand` function visibility to `protected` ([#680](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/680)) ([aab38c7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aab38c727c78a17b4ece90d60915e7d796980bea))


### Dependency updates

* **deps:** update plugin gitsemver to v3 ([b797fb0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b797fb0a5bc3b279b298253a75abe3285a439af8))

## [3.0.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/2.0.5...3.0.0) (2024-01-21)


### ⚠ BREAKING CHANGES

* make the plugin compatible with Gradle's configuration cache (#677)

### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.85 ([67b55be](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/67b55bee6719f6a22c4ff476dab787c49d89b3f4))
* **deps:** update node.js to 20.11 ([9baeded](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9baeded66b981647efd7a8f0f737ffa1f2bcf383))
* **deps:** update plugin gitsemver to v2.0.5 ([3eaad0d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3eaad0d3cb32d7bb6d1a784d9f598679324832de))
* **deps:** update plugin kotlin-qa to v0.57.1 ([74a6918](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/74a6918c2161fb1a9e40a95711ba9b1ccfa84506))
* **deps:** update plugin kotlin-qa to v0.58.0 ([df9108e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/df9108e2142f5d197fd3fd9f2c316393f3072740))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.17 ([30e4ca5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/30e4ca537a6248611c6136835edeae82dbd6e50e))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.18 ([94e018b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/94e018be3e435aaaf1eec5b639387f02b0d5f2f4))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2 ([47b7a2a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/47b7a2a5e39021d5b357ff49b337e00280216a4e))
* **deps:** update plugin org.gradle.toolchains.foojay-resolver-convention to v0.8.0 ([8505839](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8505839c8506bcf3abbac6c219fbdf293246e792))
* **deps:** update plugin publishoncentral to v5.0.22 ([52ac000](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/52ac00046a543091b946c4ecf3e83d8a190a8a40))


### Performance improvements

* make the plugin compatible with Gradle's configuration cache ([#677](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/677)) ([75396a7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/75396a713099fe71c36e6fde1ace065138ce2c1b))


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.13 ([38e344a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/38e344a705bc1767bd4b43b5882fa06e42e3a882))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.14 ([7c8cb9a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7c8cb9a2a73c808a338127b34d295f0a2cf7ffd4))

## [2.0.5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/2.0.4...2.0.5) (2023-12-21)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.9.22 ([a3016a1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a3016a12e7263b83b611d8c940f3b23b46082f8d))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.79 ([32727f2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/32727f242f1608a553ada6b268f7270c1fe096eb))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.80 ([190eb82](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/190eb822de86e44bb411bd0d613560460fc46d36))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.81 ([e4ed02c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e4ed02c73b352d471743c7348dc97e29abb4a069))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.82 ([25c4c21](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/25c4c2170ad760e77865bf1ddf44b4f4c686841a))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.83 ([a20ca75](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a20ca758039713d51153cacaac6b7cf3933b3262))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.84 ([18265a5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/18265a517c7d6ab5abc125567371ff3b14be3d13))
* **deps:** update plugin com.gradle.enterprise to v3.16 ([cace072](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cace0728be0e9197229acef84198bf033b74d14b))
* **deps:** update plugin com.gradle.enterprise to v3.16.1 ([6a47788](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6a47788bcafd9dbd9a3fd63d4cc5d7a58a631e08))
* **deps:** update plugin gitsemver to v2.0.4 ([c5da064](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c5da06450ecce5c1abedc13871402c8b778099d3))
* **deps:** update plugin kotlin-qa to v0.55.2 ([1249373](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/12493732a8cd808bde28858eb89cbbee1d046ec5))
* **deps:** update plugin kotlin-qa to v0.56.0 ([0846f03](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0846f0375179e9cd4d8af1d1be0602b89a447c6e))
* **deps:** update plugin kotlin-qa to v0.57.0 ([158ae4b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/158ae4b2ee747c021281b733469b3fb8e43aac76))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.16 ([5ac3f9d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5ac3f9dfc3c09071ebb500f1242afcad00a3bf74))


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.12 ([afaaa06](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/afaaa06164c571fc202cb2ad02867136dd36caa9))

## [2.0.4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/2.0.3...2.0.4) (2023-11-29)


### Dependency updates

* **core-deps:** update dependency gradle to v8.5 ([0f981df](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0f981dfdf681cf15eb5a48bede283c74cf035fcb))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.78 ([7f478a8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7f478a83e94bb0368c28ad619a5f43a09a7e83c4))
* **deps:** update plugin gitsemver to v2.0.3 ([1893002](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1893002ebedde9d92d38301a26ff2d5214caa48d))
* **deps:** update plugin kotlin-qa to v0.54.1 ([16ae786](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/16ae7866517558361b3c9e12af676de7bdd385d8))
* **deps:** update plugin kotlin-qa to v0.55.1 ([38c79f0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/38c79f0168808cdd7cc43babf35d357f3be8ac92))
* **deps:** update plugin multijvmtesting to v0.5.7 ([d2ba485](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d2ba4857c70fec640a079896625c0752e8b7fb61))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.15 ([70a1a02](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/70a1a021b3b324e2f88847f0ae581082e8b3fdda))

## [2.0.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/2.0.2...2.0.3) (2023-11-23)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.9.21 ([c871cfb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c871cfbdd0950be80be892ab69e6dec426ff18a6))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.77 ([2c6e8bb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2c6e8bbd544d505e1d2b123d8468f4318b261034))
* **deps:** update node.js to 20.10 ([14f1ec3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/14f1ec3bddc1de8815e68adbbc1df7ca7a21f64c))
* **deps:** update plugin gitsemver to v2.0.2 ([e6f3963](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e6f39637511a426c06b83e2021418e6bd616ed63))
* **deps:** update plugin publishoncentral to v5.0.20 ([322a5b1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/322a5b115addabaee75954f584da93a8f7dfb5b5))

## [2.0.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/2.0.1...2.0.2) (2023-11-16)


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.71 ([ec4879b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ec4879b33ac26a4e859d0bbf586dcc26aaf03466))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.72 ([46cdf2d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/46cdf2d00b2c612e3d90aae425bed0fe1cc1fbbb))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.73 ([6e4e314](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6e4e3146662e47b6eb04b5cfff210bce4e40348d))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.74 ([31b1149](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/31b1149e3a1156be22a1129b37c64b8aee86e15c))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.75 ([14a9908](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/14a9908c4780f71eb16f5281317fd1ee4780d5fc))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.76 ([a6aeeed](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a6aeeed3f4977d10c204542b1a96ed687159209f))
* **deps:** update kotest to v5.8.0 ([089da42](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/089da42d927d2f86a63040ebf54c95ad49ed56d9))
* **deps:** update plugin gitsemver to v2.0.1 ([48a6863](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/48a6863173709050d400b57129e6e865e6febb97))
* **deps:** update plugin kotlin-qa to v0.53.0 ([2064b61](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2064b61c8c33cab460fef47f24a29d5d02d0ad74))
* **deps:** update plugin kotlin-qa to v0.54.0 ([f0946eb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f0946eb180e7fa007c482b89a4c4d7612848143c))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.14 ([6e46746](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6e467465ee7c517def8de4674e0db2991b3b15de))
* **deps:** update plugin publishoncentral to v5.0.17 ([558e6d7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/558e6d713b4bdc401400456fa5e6ae33543b55d2))
* **deps:** update plugin publishoncentral to v5.0.18 ([428bddb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/428bddbbdf44d90a48844af0e83749a4c6ba4d90))
* **deps:** update plugin publishoncentral to v5.0.19 ([e0893e3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e0893e32b7547bc817538704f9cb3ed636f53472))


### Documentation

* **readme:** suggest library for conventional commit for commitNameBasedUpdateStrategy ([#636](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/636)) ([e387262](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e3872620851548aa71ac8032153b22d59d0c3098))


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.11 ([69c2dc2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/69c2dc2b4df7327caa0152d597b1519436ea9085))

## [2.0.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/2.0.0...2.0.1) (2023-10-31)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.9.20 ([568bc4a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/568bc4aede25c17a3a2ae58a16bdc184808ea0fc))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.69 ([301126a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/301126a0bdeb8fb18b47cb546101996b84f90af4))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.70 ([0ad0571](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0ad057127b7ecfd0cfc3e9235a2cc6fb638f6931))
* **deps:** update plugin gitsemver to v2 ([28f2a22](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/28f2a2248531b11d8f23d8fb17418289c741b973))

## [2.0.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.15...2.0.0) (2023-10-26)


### ⚠ BREAKING CHANGES

* raise the patch version by default, improving adherence to SemanticVersioning. Allow commit-based control of the version to be generated, fixing #595  (#603)

### Features

* raise the patch version by default, improving adherence to SemanticVersioning. Allow commit-based control of the version to be generated, fixing [#595](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/595)  ([#603](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/603)) ([0f26a13](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0f26a13ce1ce6a291b26ad2505ebf2cbaca2b88f))


### Dependency updates

* **deps:** update node.js to 20.9 ([efd507b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/efd507b6329188c5e1293e9877e734738f824b4f))
* **deps:** update node.js to v20 ([fd242fb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fd242fb8c081a83d238f928492f15f5854e0888e))
* **deps:** update plugin gitsemver to v1.1.15 ([84b3bf9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/84b3bf9a67f7615cc8db17af6832a7767ecdc7a4))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.13 ([028bbf3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/028bbf3a1615c3cce754c416b03a695ea88392ef))
* **deps:** update plugin publishoncentral to v5.0.16 ([e7e128c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e7e128c8ac79dbb7d71e68d601947d760f288b70))

## [1.1.15](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.14...1.1.15) (2023-10-19)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.9.10 ([ea3493e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ea3493e768945031a1e026ba803267f7070ecdcc))
* **deps:** update node.js to 18.18 ([9139389](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9139389379cad31b9613106332c2d53a655d64ee))
* **deps:** update plugin gitsemver to v1.1.14 ([6a2d4e0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6a2d4e0c3d27d67d7e6f51d2e1f20d4677d9d81e))
* **deps:** update plugin kotlin-qa to v0.52.0 ([54a2d92](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/54a2d92e9922dd696ae3cdb2acec94645ec2694b))


### Build and continuous integration

* **deps:** update actions/checkout action to v4.1.1 ([081ec5d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/081ec5dbdf8ba4832b38af62417e0502caa6dfa8))
* **deps:** update danysk/action-checkout action to v0.2.14 ([ef315e2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ef315e29dcf0311cfbba41196d54c6a1b137de93))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.10 ([1992222](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/19922220edba0d11eea089831ea710886703904b))
* **detekt:** do not enforce the project's version of Kotlin upon detekt ([3644691](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3644691ca00b127085688a341276180d81be260f))

## [1.1.14](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.13...1.1.14) (2023-10-17)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.9.10 ([f9cc8f3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f9cc8f301eb98a0868b50e04a002d35903fb5d77))
* **deps:** update plugin gitsemver to v1.1.12 ([fb76028](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fb76028197bbb5064bd2703009cdafbcb680939b))
* **deps:** update plugin gitsemver to v1.1.13 ([08613c9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/08613c97d551a955e147d1476a071d3c4c35c20e))
* **deps:** update plugin multijvmtesting to v0.5.6 ([6754e1a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6754e1a58b41e50c2aa73d8c1b389451d68b282c))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.11 ([a9b19e2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a9b19e220a07967dd7bece046b69bf9144eab614))

## [1.1.13](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.12...1.1.13) (2023-10-17)


### Dependency updates

* **core-deps:** update dependency gradle to v8.4 ([1495c64](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1495c64a229da2402a770e72e36626e07f55f6c4))
* **deps:** update plugin com.gradle.enterprise to v3.13.4 ([9aa3479](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9aa34795fb39ebe4f1f3aa1225cc396594dfc889))
* **deps:** update plugin com.gradle.enterprise to v3.15.1 ([55509c8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/55509c8aea6d7855346c837cfaafa6c97dec98df))
* **deps:** update plugin gitsemver to v1.1.11 ([566c861](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/566c861a11252367efd744a908f3e02d06eb16cd))
* **deps:** update plugin gradle-plugin-publish to v1.2.1 ([ddfd2ff](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ddfd2ff448467555b20ef3181747248f69118010))
* **deps:** update plugin org.gradle.toolchains.foojay-resolver-convention to v0.7.0 ([db246b3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/db246b369a7addf490f2cea2b1a407709f271d61))


### Build and continuous integration

* **deps:** update actions/checkout action to v4 ([c16d8d0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c16d8d0e8dda87aa4629ec1ceb20fa415a33aa3c))
* **deps:** update danysk/action-checkout action to v0.2.13 ([c5f6d6e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c5f6d6e47094d8f65fd9ec7b915605fee701b4ca))

## [1.1.12](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.11...1.1.12) (2023-10-17)


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.68 ([d5a8a30](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d5a8a30738c07db360828968da3aed64e3ec9f23))
* **deps:** update kotest to v5.7.2 ([441f95b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/441f95b65ca956a73d0d268d919f46bd649f0ff2))
* **deps:** update plugin kotlin-qa to v0.51.1 ([b3e09a2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b3e09a2c67b45fd73dc619a58fefba2aeb62c7ac))


### Revert previous changes

* **deps:** downgrade plugin kotlin-qa to v0.40.0 ([#606](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/606)) ([81a187e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/81a187ef1066dfc8295f857849c0e4bbb296bd87)), closes [#564](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/564)

## [1.1.11](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.10...1.1.11) (2023-10-16)


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.32 ([0b66609](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0b666099c6303e2c5983fb7f5087e28000bcb94d))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.33 ([17943c8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/17943c825f2d7d552b6e08873da86d0df224a041))
* **deps:** update plugin gitsemver to v1.1.10 ([603b589](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/603b5893c7603e2bd6fc556b855951c8fb2c87e0))
* **deps:** update plugin multijvmtesting to v0.5.2 ([7662c7c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7662c7cdf8fff813cf9aa5e2958383ed112f5f5e))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.8 ([b0d338c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b0d338cb7ea5e9ad017a09f670b5a9bbbf76d6f1))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.9 ([8937453](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8937453fa28c57baa2571f814f6793b95a1b33d2))
* **deps:** update plugin publishoncentral to v5.0.7 ([b0777a0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b0777a0bffe19c740bba69533eb1a82cd6098e01))


### Build and continuous integration

* **deps:** update actions/checkout action to v3.5.3 ([ca9255c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ca9255c92c41128758333de75efcd82527a115ec))
* **deps:** update danysk/action-checkout action to v0.2.10 ([a4c7d4f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a4c7d4f7a742aec2d166286fa76e79adbdcb878d))
* do not fail fast on matrix jobs ([648c790](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/648c7904791bc6f5a57dde7c0ce6bdab241b3bdc))
* **mergify:** point to the shared Mergify configuration ([fa0dabd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fa0dabdd09647edb40d7fbef2af1bbea9f49d2ed))


### Revert previous changes

* **deps:** downgrade plugin publishoncentral to v5.0.4 ([d04d9ce](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d04d9ceb578eac19e8ea23f6a23fe3f9c63bec43))

## [1.1.10](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.9...1.1.10) (2023-06-05)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.4 ([0e76826](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0e76826126e9f855d3fa4f1056f113d635f89c46))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.5 ([bb7dcca](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bb7dcca98d50eb2aea6b93edcd0aa568c44467c0))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.6 ([2e0065d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2e0065d046381e663808d3e0a902ab6bc9b8d563))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.8.20 ([dedf26c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dedf26c823c3ab35da308feb77a84c97c83090af))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.26 ([9b93dda](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9b93dda346895ebf1392186ec31ec497cc9f6508))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.27 ([126d936](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/126d93693e493923e130a232a7b28787ae83208d))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.28 ([f53e8ec](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f53e8ec00cd8da723801ac9d823cfaec7650a30e))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.29 ([5f6aa65](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5f6aa6537091221c910e59631061797deb8e5bd0))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.30 ([69f70c5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/69f70c51297644c34ae0ba2103c3f65123e7a391))
* **deps:** update kotest to v5.6.2 ([2cf6ba3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2cf6ba3965b9ad107e3123c93363f08471ab2970))
* **deps:** update plugin com.gradle.enterprise to v3.13.1 ([8bbf4eb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8bbf4ebe828dcfa15882e99e280e799286dacfe6))
* **deps:** update plugin com.gradle.enterprise to v3.13.2 ([dd515bf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dd515bf19efc51440858fad8dc3bdbfc04f1e7b7))
* **deps:** update plugin com.gradle.enterprise to v3.13.3 ([53d915a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/53d915adb3efe319b7830061acc3a7689e329b64))
* **deps:** update plugin gitsemver to v1.1.9 ([aa236b0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aa236b0ff4145042b59e8dce8dd4a2da977d72e3))
* **deps:** update plugin kotlin-qa to v0.38.2 ([aa9f97f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aa9f97fff720acd22426bb4613947c92c75da040))
* **deps:** update plugin kotlin-qa to v0.39.0 ([bebcd19](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bebcd19f364522395a83366c33c49476d2eb8df1))
* **deps:** update plugin kotlin-qa to v0.40.0 ([d00e6c8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d00e6c8caccbf21815fc4ac9e3dc997dbaf17965))
* **deps:** update plugin multijvmtesting to v0.4.23 ([f1c7719](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f1c7719ed41ab5354764b7047be97a638411f5aa))
* **deps:** update plugin multijvmtesting to v0.5.0 ([e998b13](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e998b13295b4402a3184da010043a3a12de5fca4))
* **deps:** update plugin multijvmtesting to v0.5.1 ([7ad6083](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7ad60833202426f364212331d92ab4bca5b43645))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.7 ([b916dab](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b916dabc03b5e94c4c1c3cc48cff9f81145e257f))
* **deps:** update plugin org.gradle.toolchains.foojay-resolver-convention to v0.5.0 ([6f95251](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6f95251a7ee1b303e3f8ebb291d27d78508c0725))
* **deps:** update plugin publishoncentral to v5.0.3 ([677e914](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/677e914789cf351c9ef5de82d83b3b767f69b91f))
* **deps:** update plugin publishoncentral to v5.0.4 ([2b83c2a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2b83c2a1c01e48654bc72156d9a71f63786485da))

## [1.1.9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.8...1.1.9) (2023-04-21)


### Build and continuous integration

* **editorconfig:** remove unsupported import order rule suppression ([4ef431f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4ef431fee41a659c9c98a2d34b7ba1d234fed2e4))
* use `lowercase` instead of `toLowerCase` ([f84d863](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f84d8638760986cb03d4de6c340e4e7d135cb21a))


### Style improvements

* apply the latest Detekt and Ktlint formatting rules ([b00fc19](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b00fc19ec4be15b567be96aba3057ccd7ff222dc))
* fix Detekt errors ([8990387](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/89903873310b2b56f70ec34aa04a7058e42f2bb5))


### Dependency updates

* **core-deps:** update dependency gradle to v8.1.1 ([265cc87](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/265cc876381e32d1779e01840ff74f81b669707b))
* **deps:** update plugin gitsemver to v1.1.8 ([1b4d3a1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1b4d3a1310b5619f68d0ef65141d3e2d58bbf9e8))
* **deps:** update plugin kotlin-qa to v0.38.1 ([970cd4d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/970cd4d08fea2a7c88c0643c8b4bbac98600ba88))
* **deps:** update plugin multijvmtesting to v0.4.21 ([de1098f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/de1098f47c7eb3005e5957557bb432e6a32ab8ec))
* **deps:** update plugin multijvmtesting to v0.4.22 ([b7fbe92](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b7fbe926fa5527022ee18d7a68ce671b15698cc2))
* **deps:** update plugin publishoncentral to v5.0.2 ([94b1ee5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/94b1ee5948d3ad1b4fe2ed56bce7b9ff7e017aa6))

## [1.1.8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.7...1.1.8) (2023-04-19)


### Bug Fixes

* add actual support for version prefixes, closes [#543](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/543) ([#544](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/544)) ([d8999d8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d8999d877f41c3e4311e3d59d3a9c78ca34dd338))


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.25 ([fc1e3d8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fc1e3d8cb8cc9043fa6d56605284149d7250e522))
* **deps:** update kotest to v5.6.0 ([78a3f38](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/78a3f38b876a81d2dc4463607b0fa9ed7ffea47c))
* **deps:** update kotest to v5.6.1 ([4465325](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/446532569f438a18e45379238904550087091a93))
* **deps:** update plugin gitsemver to v1.1.7 ([b593803](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b59380392cb52b2cd740f34589cc36eb00e325bd))
* **deps:** update plugin publishoncentral to v4.1.1 ([cf5003b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cf5003b20f1c30ad2e14cd8504baa4d763d54795))
* **deps:** update plugin publishoncentral to v5 ([e972fc9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e972fc9f55f49be573cef8130c6ccc1236b5618a))

## [1.1.7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.6...1.1.7) (2023-04-13)


### Build and continuous integration

* **deps:** update actions/checkout action to v3.5.1 ([057f07d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/057f07d4815079bf3bc04c524b25c4f1f3bcccb5))
* **deps:** update actions/checkout action to v3.5.2 ([c6ba4ad](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c6ba4adc3e44c96be793a34f334f57a3d2e0ed8b))
* **deps:** update danysk/action-checkout action to v0.2.8 ([6413cf1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6413cf150cd8f88c951a7d30b6d4075f50124a81))
* **deps:** update danysk/action-checkout action to v0.2.9 ([0b72137](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0b721374411985cb4df5022e3489aeee0fea06d2))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.3 ([50966e9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/50966e943f0bd9438fb5bce5493d7fe8478b7e11))


### Dependency updates

* **core-deps:** update dependency gradle to v8.1 ([ae4fbf0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ae4fbf0318854824f18c3f23121a52912c852f54))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.24 ([185d1fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/185d1fcb961a5c006520965dbf5b1cf90c4b43cb))
* **deps:** update node.js to 18.16 ([1d56fac](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1d56faca3a9632d9da41c59cb892b9b46a74e85c))
* **deps:** update plugin com.gradle.enterprise to v3.13 ([cabb16d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cabb16d47edce07e9700d63bd68d5bd4999c3df4))
* **deps:** update plugin gitsemver to v1.1.6 ([7b32d4a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7b32d4ac9235b0dea76578afc23ba6e0f7a51444))
* **deps:** update plugin gradle-plugin-publish to v1.2.0 ([4c108c1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4c108c1e22c099bb4d1aa36972572728ebeff4a4))
* **deps:** update plugin publishoncentral to v4.1.0 ([daaebc6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/daaebc6ce76f36dcb364014d4cd83aefb81190bd))

## [1.1.6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.5...1.1.6) (2023-04-07)


### Bug Fixes

* create license file ([dea2c09](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dea2c090638f784db3845b51fdb572005b0aba0a))


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.23 ([e8ab5f2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e8ab5f2ac6f76b1ffe43b7ac0d5f1412d2afd581))
* **deps:** update plugin gitsemver to v1.1.5 ([adde86a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/adde86a13a866b3bf3b6315fd8c309089f32f4c3))
* **deps:** update plugin multijvmtesting to v0.4.20 ([2502704](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/250270464439dc879038f56381e18fbcd73ce542))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.6 ([3915ed0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3915ed0d168599199bba31f31d059978ebc0428f))
* **deps:** update plugin publishoncentral to v4.0.1 ([8ecb981](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8ecb9818197978ca464433019bfb68bda05c1ed2))

## [1.1.5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.4...1.1.5) (2023-04-02)


### Build and continuous integration

* **deps:** update actions/checkout action to v3.4.0 ([5e5aa42](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5e5aa4233357044bdfad2e588f73bc6454ce722b))
* **deps:** update actions/checkout action to v3.5.0 ([99e2f55](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/99e2f5535ee18d5631b851c2b73233beb1b95470))
* **deps:** update danysk/action-checkout action to v0.2.6 ([ee13820](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ee138200b03b63476d834292a8963befed08ff00))
* **deps:** update danysk/action-checkout action to v0.2.7 ([0432ac0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0432ac0442528dadd1223904aaf929143671d83d))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.1 ([4c50972](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4c50972872f5f212dc75bfe74e24c130b9385d86))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.2 ([19c83f5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/19c83f5d39932e858f8204056ccf6fed36114d59))
* **mergify:** disable auto-rebasing due to Mergifyio/mergify[#5074](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/5074) ([efb1373](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/efb1373aa2c6efe83a1f6be2dd0c76907ea85837))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.8.20 ([ee32921](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ee329215fd781ae3db03d3f2c28b90b242f737b3))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.17 ([bf53451](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bf53451eb00c6bb770373d5fd4855f9af80ae667))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.19 ([683a7f5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/683a7f5e39e4b3c256061f4b2786e5d869b0404e))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.20 ([ea8b083](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ea8b083b5cf14dbe6f335fa1a032f733020bba30))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.21 ([a51b03e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a51b03e0de424912d93cca7acba3cad9b872d8ff))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.22 ([31011ac](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/31011ac2144fa1cd62822f9d00dedfdc30be7a55))
* **deps:** update node.js to 18.15 ([4611c89](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4611c8935c8495a5ec66aa20b2e327204cdd92bb))
* **deps:** update plugin com.gradle.enterprise to v3.12.5 ([418102f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/418102f40fc1f15550247ebbfcda4300bcbb6ec7))
* **deps:** update plugin com.gradle.enterprise to v3.12.6 ([741b552](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/741b552e215cb65b6af573ae85b704a3c209baac))
* **deps:** update plugin gitsemver to v1.1.4 ([8da027f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8da027f5a9eb017736f7882eb224dd1829c7458a))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.5 ([c56fa5f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c56fa5feb6e354ce559ae73633581b1f6c9db59e))
* **deps:** update plugin publishoncentral to v3.3.1 ([aa88237](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aa88237b69a1f6fab8ac71fb39608e30a3b9cfc8))
* **deps:** update plugin publishoncentral to v3.3.2 ([ee970d1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ee970d17d5c1adad15be2ccc7b4493b46073201e))
* **deps:** update plugin publishoncentral to v3.3.3 ([a99e3ed](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a99e3ed4576ce33a356d0aec4cddc110ed73494f))
* **deps:** update plugin publishoncentral to v3.4.0 ([febc75a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/febc75a6f01deabe2741f93964524c6d04b8f89a))
* **deps:** update plugin publishoncentral to v4 ([2558c04](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2558c0405f60177ca6ad6edb02520b45cdf5c0ba))

## [1.1.4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.3...1.1.4) (2023-03-04)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.8.10 ([2810aef](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2810aef5e14efe6d48f8e920b51fd4364531835e))
* **deps:** update plugin gitsemver to v1.1.3 ([dd79e5b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dd79e5bc180022c415ad2525052a817dc208daf4))
* **deps:** update plugin multijvmtesting to v0.4.19 ([103dff1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/103dff139d9810fbad74c0033d3485c04bc3fb14))

## [1.1.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.2...1.1.3) (2023-03-04)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.2.0 ([3749982](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3749982d857bd316509aaf6da7be0f147a8cd0a5))


### Dependency updates

* **core-deps:** update dependency gradle to v8.0.2 ([ad1fe4e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ad1fe4e58f9323439536b9a7f1962b4d952a72a3))
* **deps:** update plugin gitsemver to v1.1.2 ([0430729](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/043072967c327b08a92dd31bd61a70c376d5fb10))

## [1.1.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.1...1.1.2) (2023-03-02)


### Documentation

* **readme:** remove useless space ([6365d26](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6365d268325cf97a84e1081db5598fee35fcc167))


### Dependency updates

* **deps:** update plugin com.gradle.enterprise to v3.12.4 ([9012027](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/901202766a2779df4032e3a5c1395abf2aaa2ea3))
* **deps:** update plugin gitsemver to v1.1.1 ([5ec6326](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5ec63268721c477ac8bc5e7a81b6487b3c45d8a7))

## [1.1.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.1.0...1.1.1) (2023-02-22)


### Bug Fixes

* **build:** incapsulate the project information into a specialized object ([154a7cc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/154a7cc47586e00fbc37d4d2c52655065220dbd3))
* improve the forced version message ([5c27ff0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5c27ff08b716803ec8c53b5cfc43d88a0c622c7f))


### Dependency updates

* **deps:** update plugin publishoncentral to v3.3.0 ([85a9644](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/85a964418562a0a02357ea95ec9d72cdd23daf30))


### Build and continuous integration

* add missing deployment keys ([17690aa](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/17690aa5723649b0dc4e76c5e3ecfa94b3cc1df8))
* always try to deploy this plugin on the Gradle Portal ([c1381ae](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c1381ae224af3f1c53dc1cb35b044d7664d8d488))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.26 ([1f2f470](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1f2f4703fe90f85f2ce921edbce9b21648364921))

## [1.1.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.0.3...1.1.0) (2023-02-21)


### Features

* allow forcing the version via gradle property ([dba5b4d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dba5b4dbcc537e191a78e99c8dca334bee95281c))
* force the version with a customizable property ([86d7535](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/86d7535dfaa38bed4733f78f27870ae1f49fc667))


### Dependency updates

* **deps:** update plugin multijvmtesting to v0.4.17 ([2e22876](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2e22876a0e5c99c421cccc4a1621230e3dabdfbd))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.3 ([1db74ac](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1db74acd7b87bb9f440b9dec0f63d05dfa3f97d4))
* **deps:** update plugin publishoncentral to v3.2.4 ([3c65927](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3c65927dfda91c7c43b73673d02882efd1e28384))


### General maintenance

* remove uneeded experimental annotation ([1a9286e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1a9286ec9eaf936e5b08c0560da092b35992e055))


### Documentation

* document the force version behaviour ([69b03ce](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/69b03cec7ccf14363af84984b74d0961dbeb8bd6))
* documented force version property ([f3906cc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f3906cc73b7e60882f5d5ef6d36e013098e77898))
* minor fix to readme ([f7f833d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f7f833dac02853fa9af160a881184c9bbb7099db))

## [1.0.3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.0.2...1.0.3) (2023-02-19)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.25 ([0d13336](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0d133363387fcc61e2b2df65fcc9d010dc48b300))
* update pom.xml url refs ([#478](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/478)) ([7345332](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/73453323705fdf6c2008a7cb1514c2fbf6296540))


### Dependency updates

* **core-deps:** update dependency gradle to v8 ([ebece39](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ebece3925883d12edcaab91067704b6c75dfb7bd))
* **deps:** update plugin gitsemver to v1.0.2 ([3367d03](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3367d03ba3364e2afebf3b6aaa489c3ce1547cab))
* **deps:** update plugin multijvmtesting to v0.4.16 ([e67d477](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e67d4774c844e17f4a8ce325c96546587f6c49eb))
* **deps:** update plugin publishoncentral to v3.2.3 ([747e6d4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/747e6d46fc1e37b53384a0a58e4db1792c3504dd))

## [1.0.2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.0.1...1.0.2) (2023-02-19)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.8.10 ([fc5dbff](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fc5dbffc5b40cb8680b0d335cd66d83edbf06505))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.16 ([6566079](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6566079e04d33e5fb5bcbf87c9c7554c11e135b3))
* **deps:** update kotest to v5.5.5 ([36ada48](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/36ada48ff132f4f5d79fdfea836e99ed7afde935))
* **deps:** update node.js to 18.13 ([6d3b102](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6d3b102077afc3307ff283dbf2bfa7abd4b78776))
* **deps:** update node.js to 18.14 ([438b368](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/438b3689a06df97eddfa4cdcb743672f5f7b1f6a))
* **deps:** update plugin com.gradle.enterprise to v3.11.4 ([b6225fe](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b6225fe7c0fec45c7719d9f6eef4e1942e525cf7))
* **deps:** update plugin com.gradle.enterprise to v3.12.3 ([cdd0e61](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cdd0e61e5a8414fb9fb5a62efc83fbb55226025a))
* **deps:** update plugin gitsemver to v1.0.1 ([8070d60](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8070d6046958c6c39c899a02587666c76d7475a8))
* **deps:** update plugin gradle-plugin-publish to v1.1.0 ([8064391](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/80643910a3f0a74b321c59a235860e12aa17b7f8))
* **deps:** update plugin publishoncentral to v3 ([2ac1c39](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2ac1c395455b53d74f6bca6bfba68c26b5de17e3))
* **deps:** update plugin tasktree to v2.1.1 ([d9cf4bf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d9cf4bf8cefbf32496be16259e05c669a36175e7))


### Build and continuous integration

* **deps:** update danysk/action-checkout action to v0.2.5 ([1c1655f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1c1655f7cfc7ac61aa9f52a3dbbfce0395d68034))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.21 ([9857372](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/985737259c4df7706c9311c98f05fc02df2de0a7))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.22 ([3c7be16](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3c7be1643ea045feae425cdfad39704c57242938))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.23 ([0d57d01](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0d57d0133cb60ddc58a2b56e7404453f757facb2))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.24 ([1856cf9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1856cf9c948af65a2bc3bba924df2022bc25fd7f))
* drop outdated feature preview, catalogs are now mainlined ([b33b3a6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b33b3a6fc48819f78a307bf29016d7d2f5c9adc3))
* fix concurrency issues ([0decc13](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0decc135cb74ac6b6337762de8a352286a475e95))

## [1.0.1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/1.0.0...1.0.1) (2023-01-05)


### Bug Fixes

* **build:** drop unused "uploadGit" task ([6b33d5d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6b33d5d8e087d0a981b2b6ebba141da36890265b))
* **release:** release the plugin with both the IDs it had ([18d9664](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/18d966474003f7096f9f5dbba6fe5dcbafa2b970))

## [1.0.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.4.0...1.0.0) (2023-01-05)


### ⚠ BREAKING CHANGES

* consider both annotated and lightweight tags by default

### Features

* consider both annotated and lightweight tags by default ([34a06dd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/34a06dddfa40caa23135a6bea4f7b64cf308aaaf))


### Documentation

* update the README.md ([2fcf43e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2fcf43e5a250c0b0395d0eabdb9b0ea5f6ae0fa7))

## [0.4.0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.25...0.4.0) (2023-01-05)


### Features

* add support for lightweight tags ([#457](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/457)) ([a25b10f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a25b10fa6125216d165432d446f0cbbf3975b1e4))


### Dependency updates

* **deps:** update plugin kotlin-qa to v0.29.2 ([b7bd81f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b7bd81f07012b75a791a724a18926f1d33b3b226))
* **deps:** update plugin multijvmtesting to v0.4.15 ([6d36af1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6d36af1a3d69a87afc0fcc1bda8d7a00bbc808ba))
* **deps:** update plugin publishoncentral to v2.0.12 ([27d7537](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/27d75379277a599cd7c26f06678817dae5f0ea88))


### Build and continuous integration

* **deps:** update actions/checkout action to v3.3.0 ([f84c248](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f84c248869e833098bd1deff29778cc8b55e2072))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.20 ([1317e57](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1317e57e62a8817fb3e0bc48de9f93b850ba647d))

## [0.3.25](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.24...0.3.25) (2022-12-30)


### General maintenance

* **mergify:** rebase-update and rebase-merge working dependabot PRs ([4f5368a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4f5368abfdf9e0fec632a2443a0fa575d26d7a7d))


### Build and continuous integration

* **deps:** bump minimatch from 3.0.4 to 3.1.2 ([5c4a39f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5c4a39f4bf48a5ad3cbfcab72b07a20656025bc5))
* **deps:** update actions/checkout action to v3.2.0 ([301a400](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/301a4001ab74e3cf6ab6b7071491259d0655dbd4))
* **deps:** update danysk/action-checkout action to v0.2.4 ([55d3c48](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/55d3c486b23889a0b2fbb15a54e8e1cbf23da7cf))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.15 ([e642743](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e6427437550247fb138b053b6a42fec0afaa32cc))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.16 ([8f747f5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8f747f5d1fa3c305ca5d20eb15f61c7911977edb))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.17 ([f0df0eb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f0df0ebd6af1ceee2f3247d741e46e81d8f4a85a))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.19 ([a7447cf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a7447cf9105f5c0e30b0de1505928fda70388b8e))
* fix dependabot PR builds not starting ([c9280f8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c9280f80ae64c70a9e1c0b8705809e3d5acefc1a))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.8.0 ([79f1c40](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/79f1c40ec7ecb28bea5eff3d04a6b10630c0eff9))
* **deps:** update plugin kotlin-qa to v0.29.0 ([0046667](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/00466676badb62aba9f02860d07589ebd72be9b0))
* **deps:** update plugin kotlin-qa to v0.29.1 ([ed411c2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ed411c2de760902ee3ef26ac513b7ba0d5de1019))
* **deps:** update plugin multijvmtesting to v0.4.14 ([37284fe](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/37284feb7d3bc4239f0661c65b41bec2d12e7edb))
* **deps:** update plugin publishoncentral to v2.0.10 ([3d5a45d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3d5a45def966d37ade298771cdce8fcd237b91b9))
* **deps:** update plugin publishoncentral to v2.0.11 ([3392863](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3392863314fccd031c280a45c1d0050fca8c9c51))

## [0.3.24](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.23...0.3.24) (2022-12-01)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.7.22 ([a485d4f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a485d4fc854ed732f7653bda5846714ec6c34c78))

## [0.3.23](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.22...0.3.23) (2022-11-29)


### Performance improvements

* use configuration avoidance when creating task 'printGitSemVer' ([13d739e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/13d739ee34ffd8fa6c9c55bb882764066b3dfe63))

## [0.3.22](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.21...0.3.22) (2022-11-28)


### Dependency updates

* **core-deps:** update dependency gradle to v7.6 ([7519b11](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7519b11b4a2e6aa389c70fcb1226435e975de405))
* **deps:** update plugin kotlin-qa to v0.27.1 ([8422af7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8422af7ce0c4045b472ceb75d770656027ee9368))
* **deps:** update plugin kotlin-qa to v0.28.0 ([fe883df](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fe883dffa001cc960e5e6df665dc81a9ab957a96))
* **deps:** update plugin multijvmtesting to v0.4.13 ([b79e46a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b79e46a5889eba37ed4600ecacaeab0239fa7188))
* **deps:** update plugin publishoncentral to v2.0.9 ([2511c01](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2511c0109fd9543274afa0ed531fa3e3e9d5d675))

## [0.3.21](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.20...0.3.21) (2022-11-11)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.11 ([7a11e6c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7a11e6c2cc0b66f3ca1b84e69dec49f4c354221a))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.12 ([a4f14c0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a4f14c04ab1e6213a2bb9bb61bf7938bed3caf85))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.13 ([62315dd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/62315dde1bf9c39f3190ed0029ecc7854d841070))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.14 ([0e3e4df](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0e3e4dfd53cc1889c684f48249e03eb1d5defe58))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.7.21 ([a69eec5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a69eec5f5d468c02dd3d6821bba9b93595f57f79))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.12 ([c3316ef](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c3316ef9abb85cacc48b8c0558f4eb0f34b0b6ed))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.13 ([6dafd91](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6dafd913ede63da19afb20ca9a329e155ce257f4))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.14 ([0fc4124](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0fc41248d8d2fb83de7b138ce8bcf90d6e697dfd))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.15 ([7dcae28](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7dcae286578a9cb9935dba35cf6903ac1c58ccf6))
* **deps:** update kotest to v5.5.2 ([44f547e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/44f547ee8379c4b126237157b18179b4553b641c))
* **deps:** update kotest to v5.5.3 ([e69c7d0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e69c7d0372912d64ba38f57a45e4c9f231404113))
* **deps:** update kotest to v5.5.4 ([7cf35d1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7cf35d1c39559a06c0444fd9618e63cc50d539e5))
* **deps:** update node.js to 16.18 ([36eef42](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/36eef42b8ba1eb453bb9fe490a63dd614b4fc452))
* **deps:** update node.js to 18.12 ([6deb5f9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6deb5f9f6c9c36f3ea4c4afeb1fbca718d8eb371))
* **deps:** update node.js to v18 ([9fb7e9c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9fb7e9c67a3161d9523151220ffc2e7437445b1f))
* **deps:** update plugin kotlin-qa to v0.26.1 ([4a14725](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4a14725d12ddf703458776c990db071dc002c5fe))
* **deps:** update plugin kotlin-qa to v0.27.0 ([60ca8ea](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/60ca8ea208b756bd6c59ca4a82d30124a340d254))
* **deps:** update plugin multijvmtesting to v0.4.12 ([4e713f5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4e713f5e79d750b9edc80b93bb11a6eed019d4aa))
* **deps:** update plugin publishoncentral to v2.0.7 ([0879718](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/087971810389822e4555cf7809caa7a98de47de5))
* **deps:** update plugin publishoncentral to v2.0.8 ([695f053](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/695f0530f144963dbbf1d693b980440430e40a65))

## [0.3.20](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.19...0.3.20) (2022-10-14)


### Build and continuous integration

* **deps:** update actions/checkout action to v3.1.0 ([429e414](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/429e4143da75b9f2bbd4ead7b733b948ea5683c1))
* **deps:** update danysk/action-checkout action to v0.2.3 ([5de7e33](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5de7e33b2f7c3f17f9bae643b764f496a31bd5d2))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.10 ([799e45a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/799e45ae89d2dc578c0cf48ee654c4e5f8b6d657))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.7.20 ([4a7d854](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4a7d8547ec1b4384bcd20716b6ffe878a0832875))
* **deps:** update kotest to v5.5.0 ([1d059c2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1d059c2bab38dbf9c2c04e615ffc6aa92dbff188))
* **deps:** update kotest to v5.5.1 ([9079b5b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9079b5b7bf182a2262ad7e4e2f1e1dd55b0e76f5))
* **deps:** update plugin kotlin-qa to v0.25.1 ([83b19e5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/83b19e57674326cc01bfc0182ada4999fe1564f4))
* **deps:** update plugin kotlin-qa to v0.26.0 ([a815668](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a815668c26a92a99002b4efc5045d5f1fa74d25b))
* **deps:** update plugin multijvmtesting to v0.4.11 ([2cd4207](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2cd42075a6f3dfc2da08c8d54c36ec7534eee1c4))

## [0.3.19](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.18...0.3.19) (2022-10-01)


### Build and continuous integration

* **deps:** update danysk/action-checkout action to v0.2.2 ([f2ce099](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f2ce0992f13b9c1ed41db90a84a634e32aae6c6f))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.4 ([9e69821](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9e698215cd79c20a3cbfd4cc9c0ff2af4dca059b))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.5 ([afcd0c7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/afcd0c7ecc5c99a17bd9a2a30796e05f4e0322ab))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.6 ([579076e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/579076e8f6f47c6a604911f19978270f1e8b98d2))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.7 ([8ecd158](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8ecd15802cba50db39b7e1b5b615f3d93cf72b2a))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.8 ([2068869](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/20688695ac7e5299fa0b5033ea88295adb854cb2))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.9 ([f162a5e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f162a5e7693dfe9e93c64b2c22e9b806970d4978))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.7.20 ([35ef394](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/35ef394fb102ef39bd5ec0457c98bf54ebc1d5c6))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.10 ([d68dade](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d68dade1bec96281d7962abf345dc673ec8a3240))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.11 ([a9d205f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a9d205f333898575b24d727315cb34695cc83dde))
* **deps:** update kotest to v5.4.2 ([c743fc4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c743fc4e407f18aaa40d242b269b28f83a061e74))
* **deps:** update node.js to 16.17 ([684ba66](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/684ba6644ec16593ce28f846481e8a83f548c7cb))
* **deps:** update plugin com.gradle.enterprise to v3.11 ([3575185](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/35751853d76df585100a011c2d6a990eb78775c9))
* **deps:** update plugin com.gradle.enterprise to v3.11.1 ([ba37679](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ba376793971b58ff274d10209ba1b0ff28d93ead))
* **deps:** update plugin kotlin-qa to v0.23.2 ([b321fed](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b321fedc197e6a93d0e1583c8d705219c1895c5a))
* **deps:** update plugin kotlin-qa to v0.24.0 ([b1e3e91](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b1e3e91225310fd6262e25988b61bef0595db192))
* **deps:** update plugin kotlin-qa to v0.25.0 ([e1e33fc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e1e33fc6b6e587b06465cab4eaa38114c4d19edb))
* **deps:** update plugin multijvmtesting to v0.4.10 ([cd58025](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cd580256e3009a142084ec0ccce5e8d46dc22024))
* **deps:** update plugin publishoncentral to v2.0.6 ([f766ebe](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f766ebed409c413b16d8a71f9a9b5c385051035f))

## [0.3.18](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.17...0.3.18) (2022-08-06)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.3 ([90ef94d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/90ef94d7cec524267c6d8d04eaff8a6ee946823a))


### Dependency updates

* **core-deps:** update dependency gradle to v7.5.1 ([837dee3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/837dee37826a148c852f589144a5f183f228a482))
* **deps:** update plugin kotlin-qa to v0.22.1 ([6fd7058](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6fd7058517bf3a1e6c847d3b66627fdb531f36d6))
* **deps:** update plugin kotlin-qa to v0.22.2 ([e64c205](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e64c20576cc1a48301824abf23c9bcf9f22187b1))
* **deps:** update plugin kotlin-qa to v0.23.0 ([007d4c2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/007d4c28021050c1bdd253827187885462c4c4b1))
* **deps:** update plugin kotlin-qa to v0.23.1 ([aa66d03](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aa66d03f06b6b0fc9dac7eea4c752b026e9c33d4))
* **deps:** update plugin multijvmtesting to v0.4.9 ([0f1a3bf](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0f1a3bfb763e6424899efc8f39d1f62b7642ebe3))

## [0.3.17](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.16...0.3.17) (2022-07-28)


### Bug Fixes

* **deps:** update kotest to v5.4.1 ([6c22d99](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6c22d9933b7214b8420011f75f75920b683c259f))


### Build and continuous integration

* use the default plugin classpath ([a6226f2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a6226f241ccb9d1a255e450cc48699464e312a45))


### Dependency updates

* **deps:** update kotest to v5.3.2 ([fda97e7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fda97e7eb1e1997b7a196aaf6a87829fbc78cc15))
* **deps:** update kotest to v5.4.0 ([d8c3b1a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d8c3b1a19652115cf087ee9b0f0d5e0c6585b16c))
* **deps:** update plugin kotlin-qa to v0.20.4 ([9f6b596](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/9f6b596964d3f94c5a98372f938c49be47868e5b))
* **deps:** update plugin kotlin-qa to v0.22.0 ([ab60737](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ab60737d3150134bcf74ce3a6ecccb9274b3d183))
* **deps:** update plugin publishoncentral to v2.0.5 ([d63e0c8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d63e0c86797e36aa6a4090b3684b4693069c6d2d))

## [0.3.16](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.15...0.3.16) (2022-07-14)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.2 ([93b2360](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/93b23607dfd592dd2f94ed9489cacd4920fc579b))


### Dependency updates

* **core-deps:** update dependency gradle to v7.5 ([7050ccd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7050ccdb29dbc8918c1b3a66f2e51c15d96641a0))
* **deps:** update plugin kotlin-qa to v0.20.3 ([3cd0d28](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3cd0d28d9465b5a5f5efd22eb331d0228c36a1d6))
* **deps:** update plugin multijvmtesting to v0.4.8 ([34af01c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/34af01cc46e1f84e14f02e140cd81f0c2620e3a1))
* **deps:** update plugin publishoncentral to v2.0.4 ([cea6660](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cea6660c037831157c0eb25430b8c01ee455155b))

## [0.3.15](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.14...0.3.15) (2022-07-12)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.1 ([65e0b38](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/65e0b38ce56c5c88a4e4beba69a5931cdb947c53))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.7.10 ([777af1e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/777af1ed1b99dbcd7847d45b588548cf862c9a30))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.9 ([4c584ba](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4c584bad695a1389db162fedf3996f686c705aba))
* **deps:** update node.js to 16.16 ([68180c4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/68180c46e6b73f986cccee5d11eedd03d56c2338))
* **deps:** update plugin com.gradle.enterprise to v3.10.3 ([35e6407](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/35e64074f63cc1a92821ebc0dd2538242a8c7fb4))
* **deps:** update plugin multijvmtesting to v0.4.6 ([7c0d58f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7c0d58fe06aa7ff9063e4dce77ac70f408ee1279))
* **deps:** update plugin multijvmtesting to v0.4.7 ([05bdb8d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/05bdb8d80d9d6daec683bbcf5cc51adfcf919544))
* **deps:** update plugin publishoncentral to v2.0.3 ([60e29f7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/60e29f73bb9710d4617d28cbc2ab25177025f7da))

## [0.3.14](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.13...0.3.14) (2022-07-07)


### Build and continuous integration

* add dry-deployment test and fix the release process for publish-on-central 2.x.x ([ecf5e5c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ecf5e5ccc95293d3da134e6831de6d774552d00d))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.0.3 ([313dd6c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/313dd6cef2c1cdb605363187cb7000ea4cb4e715))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.1.0 ([bd20204](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bd20204f9a9c583bf5249a9d1bb26e6406545f42))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.7.10 ([8bbd4af](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8bbd4af6b9f4430cc94b26261c3e91046b319f3b))
* **deps:** update plugin gradle-plugin-publish to v1 ([81e56ba](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/81e56ba8173d6ddfcea873cbca6364617c9c178d))
* **deps:** update plugin multijvmtesting to v0.4.4 ([33fe046](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/33fe046aedf4ed18c896a0266f2bbb964e010bdf))
* **deps:** update plugin multijvmtesting to v0.4.5 ([f8c55c4](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f8c55c4fc20d9fcb874c8f97e01f3f7d2f7e73ab))
* **deps:** update plugin publishoncentral to v2 ([33302e0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/33302e0c7d73ff449779ff9ab661421f6b78e18c))

## [0.3.13](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.12...0.3.13) (2022-06-19)


### Build and continuous integration

* **deps:** bump semantic-release from 19.0.2 to 19.0.3 ([7bccb5a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7bccb5a6c262d6771dc945c01e2f4e8f2be21ef3))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.7.0 ([0ebee00](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0ebee0053aec30ced2c774e4eed943ba45075ef7))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.8 ([cef1a49](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cef1a491feca9c468302b1a98a8114ae9a5ecb63))
* **deps:** update plugin com.gradle.enterprise to v3.10.2 ([7e43b43](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7e43b434ae0faa065401514a61d7d5c2ca7da26e))
* **deps:** update plugin kotlin-qa to v0.19.1 ([b66091b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b66091b68c872da11f3a88657571c02694a7b205))
* **deps:** update plugin multijvmtesting to v0.4.2 ([e10b948](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e10b948dab3a84ee41cf6e513fa994c3e8529ff6))
* **deps:** update plugin multijvmtesting to v0.4.3 ([3257745](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/32577457cf548476fe315346b25f59f88085f502))
* **deps:** update plugin publishoncentral to v0.8.1 ([72463e1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/72463e1b80ae03e50ae8a2c588e7cab60bf65feb))
* **deps:** update plugin publishoncentral to v0.8.2 ([db816d5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/db816d5f859dd8f62f7bddc160e96fdfda68e41f))
* **deps:** update plugin publishoncentral to v0.8.3 ([21faae7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/21faae7a737b98fb8a5ee718f9d926b164da15bc))
* **deps:** update plugin publishoncentral to v1 ([b0e8566](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b0e8566d61cd06df56481cc777f063d129a92336))

## [0.3.12](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.11...0.3.12) (2022-06-09)


### Build and continuous integration

* **deps:** bump minimist from 1.2.5 to 1.2.6 ([1e9bbfc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/1e9bbfc348d2b33c00f3ff07f6d45f7af2b9ecf5))
* **deps:** bump node-fetch from 2.6.6 to 2.6.7 ([44f1793](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/44f1793a9ffdef41384bae4896d75e567aeae9ac))
* **deps:** bump npm from 8.3.1 to 8.12.1 ([6e50414](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6e5041456d82dca2dbb425520acd554e7c053643))
* **deps:** bump semver-regex from 3.1.3 to 3.1.4 ([#332](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/332)) ([0c9c106](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0c9c10665db367b7896173a61ee2d9731596fc11))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.14 ([db2882e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/db2882e9b953c68726dec5d758a9ec33a5c886f0))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.15 ([27c88a6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/27c88a6d5a9fef8001d5136cd525d1f459db00dd))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.16 ([ca52bdb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ca52bdb1e7476f81d0482194940f9d30f4627e8b))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2 ([5d22c8a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5d22c8a499d08c03947367dc502bbf679bd986b7))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.0.1 ([aadba54](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aadba54f3df6d5b921d2ec2ad64781f59d9deb31))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.0.2 ([73439c1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/73439c1108e53a0fa57a08a6f477d56ddc2e1f99))
* do not release from forks ([3bb0fb8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3bb0fb87b5297f398cb55c5aa78a76d248bf6920))
* ignore dependabot's branch builds ([c6cae2e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c6cae2e1c56fe171a5ee1bd739b7c218cd21e496))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.7.0 ([a2ffe25](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a2ffe25b859feb632cde4e083ad022a7c29ef63b))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.6 ([b39b399](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b39b39977f04b40ad09cd41920b6edd7548b5b73))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.7 ([230eb6d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/230eb6d9129175e4db3291739a234d602a9c25ff))
* **deps:** update io.kotest to v5.3.0 ([b13126d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b13126d38449f0dde67a707d170ce18c3a8a0dd5))
* **deps:** update node.js to 16.15 ([21ecdd3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/21ecdd31a21f307b8fd18844cd131ae0b5650533))
* **deps:** update plugin com.gradle.enterprise to v3.10.1 ([58ab316](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/58ab3160b9a5a3ac4354b2e0f9551e953ceb20a2))
* **deps:** update plugin kotlin-qa to v0.16.2 ([dbc90d7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/dbc90d785edc7296b87b78e21340f5984c45acb2))
* **deps:** update plugin kotlin-qa to v0.17.0 ([805cb6c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/805cb6c6be0107edcda63293d6409a6512df2110))
* **deps:** update plugin kotlin-qa to v0.18.0 ([7bd1b34](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7bd1b348dda9ead2339c96c3ea831682dd06147e))
* **deps:** update plugin kotlin-qa to v0.19.0 ([d1adc20](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d1adc20e757b31bf4d0090b0065e52926c2a92af))
* **deps:** update plugin multijvmtesting to v0.3.7 ([ace84dc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ace84dc7ea067c8ddba8f650b34c9491fcb21159))
* **deps:** update plugin multijvmtesting to v0.4.0 ([0871e15](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0871e1582938ae4224b8e87a9016bfbf5cbb2632))
* **deps:** update plugin multijvmtesting to v0.4.1 ([a6dc313](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a6dc3135fd8f74b953c8152811ad3f3889967025))
* **deps:** update plugin publishoncentral to v0.7.19 ([f69f1cc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f69f1cc57ad221b2369095ea32d66c1d7fa1aa21))
* **deps:** update plugin publishoncentral to v0.8.0 ([3d420ba](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3d420ba21c69c1f243aef41b322fd6e86fb9b7a7))

### [0.3.11](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.10...0.3.11) (2022-04-25)


### Build and continuous integration

* **deps:** remove mockito ([c02a58c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c02a58c8fa8cbb9e57fe683a9dc72c7f0f797ebb))
* **deps:** update actions/checkout action to v3.0.2 ([a7448b5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a7448b5c411a7e3215c0127341f8f7cbc75a8248))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.13 ([ba30da2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ba30da2c0616365cb7b2109bbce1f568bcca12bb))


### Dependency updates

* **core-deps:** update plugin dokka to v1.6.21 ([92e6111](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/92e6111599cc4adb5644db6c6eb4ac638ad284ae))
* **deps:** update dependency org.mockito:mockito-core to v4.5.0 ([cc12d1a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cc12d1ae718e72277c3fc1f4582ce5b90edb5334))
* **deps:** update plugin com.gradle.enterprise to v3.10 ([2070992](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2070992f438bc8ba8257e30829fabee6cbf2f754))
* **deps:** update plugin publishoncentral to v0.7.18 ([c36835e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/c36835ed03454e2f3f94e67c634e255d4758f5a2))

### [0.3.10](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.9...0.3.10) (2022-04-20)


### Build and continuous integration

* **deps:** update actions/checkout action to v3.0.1 ([3c48d17](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3c48d17ba239c939611a03e6b4a768dc86d402cb))


### Dependency updates

* **core-deps:** update plugin kotlin-jvm to v1.6.21 ([8421696](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/84216961dea9506fe9fd091b922e2dbd28951af0))
* **deps:** update plugin kotlin-qa to v0.15.1 ([cc9a944](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cc9a944caecacd5208246a0becf47e5b1b796bec))
* **deps:** update plugin kotlin-qa to v0.16.0 ([26b8adb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/26b8adb6d90672740b92f80bc870dcdbb2ba71f0))
* **deps:** update plugin kotlin-qa to v0.16.1 ([2478bd6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2478bd6e4c6a4d7e99b5e164036432bd2106c8ab))
* **deps:** update plugin multijvmtesting to v0.3.6 ([3cf742e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3cf742e261f635cd4a92901186cd588d4f3cc860))
* **deps:** update plugin publishoncentral to v0.7.17 ([2c6f79d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2c6f79d81cdc40b106064f9dec0961c4f837e740))

### [0.3.9](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.8...0.3.9) (2022-04-14)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.10 ([13dbbd7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/13dbbd71f976184e4ab6e1605a812998100e54be))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.11 ([2460847](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/2460847a92bf9309b5ac9c910f459219c2d3e34a))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.12 ([334bfbd](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/334bfbd3b65139eba723e443b6dad2eb7cd42456))


### Dependency updates

* **core-deps:** update plugin dokka to v1.6.20 ([ccfad0c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/ccfad0c43ddeeb78e5bfbbbca5a3e03df58a8c45))
* **deps:** update io.kotest to v5.2.3 ([be90c5c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/be90c5cdd74499bb05eef20d7224583238a34ef8))
* **deps:** update plugin kotlin-qa to v0.14.2 ([264b3bc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/264b3bc66052e461324958d42538e66d65ec3935))
* **deps:** update plugin kotlin-qa to v0.15.0 ([7c21618](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7c21618e66e37f0dfa92f792ae0eb116191861f3))
* **deps:** update plugin multijvmtesting to v0.3.5 ([e6e7783](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e6e7783f615b751e1bb1581e2e4041fb248805e4))

### [0.3.8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.7...0.3.8) (2022-04-04)


### Dependency updates

* **core-deps:** update plugin kotlin-jvm to v1.6.20 ([4a3502d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/4a3502d6bd2b0641f375a67f1e51111129994ef3))
* **deps:** update plugin publishoncentral to v0.7.15 ([772ec57](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/772ec576fd24158ac6ce9fbbc5725062c274dd23))
* **deps:** update plugin publishoncentral to v0.7.16 ([cac0eff](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/cac0eff9f91a35c624e7e1ca97e70abff3a3abf1))


### Build and continuous integration

* '-Xopt-in' is deprecated, use -opt-in instead ([621bec0](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/621bec0f226c5a04b9db0d8429c06c5ef840776d))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.8 ([7bddb69](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7bddb694d3e84c2a15114d6a24e945b0508fdb60))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.9 ([d156a50](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d156a50a6ea5e827bf6a7b8aaadeadbd2c4e006e))
* fix concurrency and use a dedicated deployment token ([53204da](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/53204daf4e0eaa39c7495bab3434c196e2df3d3f))
* split the versions of Kotlin and Dokka ([25e0173](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/25e0173b0e180b1404c8270d9ba3b1094bcc90af))

### [0.3.7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.6...0.3.7) (2022-04-01)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.7 ([983d9bb](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/983d9bb76799786cbcbf6d57cf989f8a3fcd1e91))


### Dependency updates

* **core-deps:** update dependency gradle to v7.4.2 ([81c7675](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/81c767586948ace9f87f227f880dd1c234f51664))
* **deps:** update dependency io.kotest:kotest-runner-junit5-jvm to v5.2.1 ([38005ea](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/38005ea46a417629c74eafec4650c150866e2147))
* **deps:** update io.kotest to v5 ([fc8c722](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/fc8c7221c981c62f49c41efe2ffd62eab8a7f3c0))
* **deps:** update io.kotest to v5.2.2 ([db19191](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/db191913d40e0a0babf1fe799eca1f3f5bbc8a4e))
* **deps:** update plugin com.gradle.enterprise to v3.9 ([2954886](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/29548866892f747e30243eed86376d9441d7c06d))
* **deps:** update plugin gradle-plugin-publish to v0.21.0 ([048cba2](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/048cba2ab28972bb5a4a1278b9d03bd7b427f1ea))
* **deps:** update plugin kotlin-qa to v0.12.1 ([127df75](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/127df7509624fdae8ba5b86168e87a38697d4441))
* **deps:** update plugin kotlin-qa to v0.13.0 ([6abfa2d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/6abfa2d1814e52968ad4513d0f00bb178c94f7a1))
* **deps:** update plugin kotlin-qa to v0.14.0 ([b52759a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b52759a0f01dd29c22922b2dab146aa32e2504cc))
* **deps:** update plugin kotlin-qa to v0.14.1 ([b3de2ba](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b3de2ba44206760e7272287cb025e0511c7db127))
* **deps:** update plugin publishoncentral to v0.7.14 ([0c9749d](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0c9749d88dd04c1d3080105ea5ec08dffd6ab266))

### [0.3.6](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.5...0.3.6) (2022-03-10)


### Build and continuous integration

* **deps:** update actions/checkout action to v3 ([a81c670](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a81c670e464d581ace6e4f8dce1b3350f3465a37))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.1 ([b04c788](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b04c7880b4381baab8da65df28803a981cb23138))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.4 ([27d374a](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/27d374aa0c5f6ffad827a179d48eaf5de12266ab))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.6 ([42057f3](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/42057f379b3ccd52d51afaf99edb4cea74fde302))


### Dependency updates

* **core-deps:** update dependency gradle to v7.4.1 ([e205538](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e2055384ac5ada1571bbbe86d161e7aeb3ea7c80))
* **deps:** update dependency node-fetch to 2.6.7 [security] ([a7eb96c](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a7eb96cf7918fa97091ed5b4486897b28b17ab56))
* **deps:** update dependency org.mockito:mockito-core to v4.4.0 ([8d917b7](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/8d917b7fb647e9a462df6146fe7e16167078ed36))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.5 ([a81bb34](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a81bb34694f13570b232c8b3b1a9b4a433339340))
* **deps:** update node.js to 16.14 ([96c403e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/96c403e71062575dadd71c2f7bf36e11827a2424))
* **deps:** update plugin kotlin-qa to v0.10.1 ([d919d85](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d919d85911243c528cab152c541bf794b53b6984))
* **deps:** update plugin kotlin-qa to v0.12.0 ([a2b73f1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/a2b73f11b5d11ac95860107385cc45478371e09e))
* **deps:** update plugin publishoncentral to v0.7.13 ([f81ea23](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f81ea23b28c90cc2b9788af3fb81da5b9c09eab2))

### [0.3.5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/compare/0.3.4...0.3.5) (2022-02-08)


### General maintenance

* **release:** correctly enable semantic commit conventions ([0168a10](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0168a10aab9b927d238ad1336ced3d19b6e3b849))


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.1.3 ([7c0ab46](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7c0ab46f48dddf5627bbf29e700b77848a4d86d7))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.0 ([b2e775e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b2e775e87fcafe07f3db6dd8d14336bf4af16bb2))
* **release:** enable commit-analyzer ([5e6d079](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5e6d079151dac9a4a8b9ca21f387ce1073854731))
* **release:** inherit the configuration from the shared preset ([#243](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/243)) ([f21f963](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/f21f96306d00ea515c625eaf5a956dae33b078df))


### Dependency updates

* **core-deps:** update dependency gradle to v7.4 ([3e7f181](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3e7f181e15a60e1e9c82f6672b4a25456e9fb53d))
* **deps:** update dependency org.mockito:mockito-core to v4.3.0 ([e64d77e](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/e64d77eaad47fed5a154e599ca55ade2482e4ebe))
* **deps:** update dependency org.mockito:mockito-core to v4.3.1 ([b2deca8](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/b2deca89acc517f1f03b6b030970b99b2bd66d29))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.1 ([aee87af](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/aee87af08eb24aa0748cf3809211d427d084e442))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.3 ([161e35b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/161e35b8b2d43c55957aecba31365e741200c37a))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.4 ([d89dbb1](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/d89dbb13f9fce52c1a553f594d5da05f5b1da799))
* **deps:** update plugin com.gradle.enterprise to v3.8.1 ([585fe50](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/585fe50b696314db29e11ccd780bed7d6365c987))
* **deps:** update plugin gradle-plugin-publish to v0.19.0 ([0260639](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0260639ab75ed93d2a376fde5ca6aa7b4e6bec65))
* **deps:** update plugin gradle-plugin-publish to v0.20.0 ([6146369](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/61463691d3b0714b68e08bd672ef2fa6ce43738e))
* **deps:** update plugin kotlin-qa to v0.10.0 ([150640b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/150640b4c87bf61d1316d77dc5861a1309460a21))
* **deps:** update plugin kotlin-qa to v0.9.0 ([bacccec](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/bacccec570bd30cd6cbc4daadb61504ae640302a))
* **deps:** update plugin multijvmtesting to v0.3.3 ([0ab66b5](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/0ab66b53911e430761057414f35da90c635013d7))
* **deps:** update plugin multijvmtesting to v0.3.4 ([72ce3cc](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/72ce3cc3787e5ae622fa26218715f976872c2bf0))
* **deps:** update plugin publishoncentral to v0.7.10 ([239440f](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/239440f4f50d89fefcfe2464136d3bf9417a270f))
* **deps:** update plugin publishoncentral to v0.7.11 ([5b8ef1b](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/5b8ef1b392c279dc0538566b68315988cc430eee))
* **deps:** update plugin publishoncentral to v0.7.12 ([7ed3326](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/7ed33266e049740a02ef2049106ebfce69db3ab4))
* **deps:** update plugin publishoncentral to v0.7.9 ([3fcdb93](https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/commit/3fcdb937f71777b4367a61ba3344750ffec4ae7b))

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
