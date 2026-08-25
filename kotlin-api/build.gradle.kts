plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
}

val targetJavaVersion = 25

dependencies {
    api(project(":api"))
    compileOnly(libs.kotlin)
}

kotlin {
    explicitApi()

    compilerOptions {
        allWarningsAsErrors.set(true)
    }
}
