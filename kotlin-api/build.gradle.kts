import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.`java-library`

plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
}

val targetJavaVersion = 25

dependencies {
    implementation(project(":api"))
    compileOnly(libs.kotlin)
}