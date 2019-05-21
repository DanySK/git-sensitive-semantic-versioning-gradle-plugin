import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("de.fayard.buildSrcVersions") version
            Versions.de_fayard_buildsrcversions_gradle_plugin
    id("org.danilopianini.git-sensitive-semantic-versioning") version
            Versions.org_danilopianini_git_sensitive_semantic_versioning_gradle_plugin
    `java-gradle-plugin`
    java
    `maven-publish`
    signing
    kotlin("jvm") version Versions.org_jetbrains_kotlin
    id("com.gradle.plugin-publish") version Versions.com_gradle_plugin_publish_gradle_plugin
    id("org.danilopianini.publish-on-central") version Versions.org_danilopianini_publish_on_central_gradle_plugin
    id("org.jetbrains.dokka") version Versions.org_jetbrains_dokka_gradle_plugin
    id("org.jlleitschuh.gradle.ktlint") version Versions.org_jlleitschuh_gradle_ktlint_gradle_plugin
}

group = "org.danilopianini"
val projectId = "$group.$name"
val fullName = "Gradle Git-Sensitive Semantic Versioning Plugin"
val projectDetails = "A Gradle plugin that forces semantic versioning and relies on git to detect the project state"
val pluginImplementationClass = "org.danilopianini.gradle.gitsemver.GitSemVer"
val websiteUrl = "https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(Libs.kotlin_stdlib)
    implementation(gradleApi())
    testImplementation(gradleTestKit())
    testImplementation(Libs.kotlintest_runner_junit5)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_6
}

gitSemVer {
    maxVersionLength.set(20)
    version = computeGitSemVer()
}

ktlint {
    ignoreFailures.set(false)
}

tasks.withType<DokkaTask> {
    outputDirectory = "$buildDir/javadoc"
    jdkVersion = 8
    reportUndocumented = false
    outputFormat = "javadoc"
}

publishOnCentral {
    projectDescription.set(projectDetails)
    projectLongName.set(fullName)
    projectUrl.set(websiteUrl)
    scmConnection.set("git:git@github.com:DanySK/git-sensitive-semantic-versioning-gradle-plugin")
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
        testLogging {
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
            events(*TestLogEvent.values())
        }
    }
    register("createClasspathManifest") {
        val outputDir = file("$buildDir/$name")
        inputs.files(sourceSets.main.get().runtimeClasspath)
        outputs.dir(outputDir)
        doLast {
            outputDir.mkdirs()
            file("$outputDir/plugin-classpath.txt").writeText(sourceSets.main.get().runtimeClasspath.joinToString("\n"))
        }
    }
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.6"
    }
}

// Add the classpath file to the test runtime classpath
dependencies {
    testRuntimeOnly(files(tasks["createClasspathManifest"]))
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
        create(projectId) {
            id = projectId
            displayName = fullName
            description = projectDetails
            implementationClass = pluginImplementationClass
        }
    }
}
