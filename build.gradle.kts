@file:Suppress("SuspiciousCollectionReassignment")

import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION as KOTLIN_VERSION

plugins {
    `java-gradle-plugin`
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.gradle.plugin.publish)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.multiJvmTesting)
    alias(libs.plugins.taskTree)
}

group = "org.danilopianini"
val projectId = "$group.$name"
val fullName = "Gradle Git-Sensitive Semantic Versioning Plugin"
val projectDetails = "A Gradle plugin that forces semantic versioning and relies on git to detect the project state"
val pluginImplementationClass = "org.danilopianini.gradle.gitsemver.GitSemVer"
val websiteUrl = "https://github.com/DanySK/$name"

gitSemVer {
    maxVersionLength.set(20)
    buildMetadataSeparator.set("-")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

multiJvm {
    maximumSupportedJvmVersion.set(latestJavaSupportedByGradle)
}

dependencies {
    api(gradleApi())
    api(gradleKotlinDsl())
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.kotlin.testing)
}

// Enforce Kotlin version coherence
configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin" && requested.name.startsWith("kotlin")) {
            useVersion(KOTLIN_VERSION)
            because("All Kotlin modules should use the same version, and compiler uses $KOTLIN_VERSION")
        }
    }
}

publishOnCentral {
    projectDescription.set(projectDetails)
    projectLongName.set(fullName)
    projectUrl.set(websiteUrl)
    scmConnection.set("git:git@github.com:DanySK/$name.git")
    repository("https://maven.pkg.github.com/DanySK/${rootProject.name}".toLowerCase(), name = "github") {
        user.set("danysk")
        password.set(System.getenv("GITHUB_TOKEN"))
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
            events(*TestLogEvent.values())
        }
    }
    withType<KotlinCompile> {
        kotlinOptions {
            allWarningsAsErrors = true
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn", "-Xinline-classes")
        }
    }
}

if ("true" == System.getenv("CI")) {
    signing {
        val signingKey: String? by project
        val signingPassword: String? by project
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                developers {
                    developer {
                        name.set("Danilo Pianini")
                        email.set("danilo.pianini@gmail.com")
                        url.set("http://www.danilopianini.org/")
                    }
                }
            }
        }
    }
}

pluginBundle {
    website = websiteUrl
    vcsUrl = websiteUrl
    tags = listOf("git", "semver", "semantic versioning", "vcs", "tag")
}

gradlePlugin {
    plugins {
        create(project.name) {
            id = projectId
            displayName = fullName
            description = projectDetails
            implementationClass = pluginImplementationClass
        }
    }
}
