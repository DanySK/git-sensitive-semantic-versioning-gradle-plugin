import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.danilopianini.git-sensitive-semantic-versioning")
    `java-gradle-plugin`
    java
    `maven-publish`
    signing
    kotlin("jvm")
    id("com.gradle.plugin-publish")
    id("org.danilopianini.publish-on-central")
    id("org.jetbrains.dokka")
    id("org.jlleitschuh.gradle.ktlint")
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
    implementation(kotlin("stdlib-jdk8"))
    implementation(gradleApi())
    testImplementation(gradleTestKit())
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:_")
    testImplementation("io.kotest:kotest-core-jvm:_")
    testImplementation("io.kotest:kotest-assertions-core-jvm:_")
    testRuntimeOnly("io.kotest:kotest-runner-junit5-jvm:_")
}

gitSemVer {
    maxVersionLength.set(20)
    version = computeGitSemVer().replace("+", "-")
}

ktlint {
    ignoreFailures.set(false)
}

tasks.javadocJar {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.get().outputDirectory)
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
        kotlinOptions {
            allWarningsAsErrors = true
            jvmTarget = "1.8"
        }
    }
}

// Add the classpath file to the test runtime classpath
dependencies {
    testRuntimeOnly(files(tasks["createClasspathManifest"]))
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
        create(projectId) {
            id = projectId
            displayName = fullName
            description = projectDetails
            implementationClass = pluginImplementationClass
        }
    }
}
