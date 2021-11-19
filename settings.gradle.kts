plugins {
    id("com.gradle.enterprise") version "3.7.2"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishOnFailure()
    }
}

rootProject.name = "git-sensitive-semantic-versioning-gradle-plugin"
enableFeaturePreview("VERSION_CATALOGS")
