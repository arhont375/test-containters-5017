plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    id("org.gradle.test-retry") version "1.3.1"
    java
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.gradle.test-retry")

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.google.guava:guava:30.1.1-jre")

        testImplementation(platform("org.junit:junit-bom:5.8.2"))
        testImplementation("org.junit.jupiter:junit-jupiter")

        testImplementation("org.testcontainers:testcontainers:1.16.3")
        testImplementation("org.testcontainers:junit-jupiter:1.16.3")
    }

    tasks.named<Test>("test") {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }

        this.retry {
            this.maxRetries.set(3)
            this.maxFailures.set(5)
        }

        this.maxParallelForks = Runtime.getRuntime().availableProcessors()
        this.systemProperty("junit.jupiter.execution.parallel.enabled", true)
        this.systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
        this.systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "concurrent")
    }
}
