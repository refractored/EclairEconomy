import org.gradle.kotlin.dsl.`java-library`
import org.gradle.kotlin.dsl.kotlin

plugins {
    `java-library`
    alias(libs.plugins.gversion)
}

val targetJavaVersion = 25

gversion {
    srcDir = "src/main/java"
    classPackage = "$group.eclairEconomy.api"
    className = "BuildConstants"
    language = "java"
    explicitType = true
}

tasks {
    build {
        dependsOn(createVersionFile)
    }
}