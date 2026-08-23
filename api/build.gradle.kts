import org.gradle.kotlin.dsl.`java-library`

plugins {
    `java-library`
    checkstyle
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

checkstyle {
    toolVersion = "10.26.1"
}

tasks {
    build {
        dependsOn(createVersionFile)
    }
}