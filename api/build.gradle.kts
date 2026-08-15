import org.gradle.kotlin.dsl.`java-library`
import org.gradle.kotlin.dsl.kotlin

plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
}

val targetJavaVersion = 25

kotlin {
    jvmToolchain(targetJavaVersion)
}

dependencies {
}