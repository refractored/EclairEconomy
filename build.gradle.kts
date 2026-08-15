plugins {
    java
    alias(libs.plugins.kotlin.jvm) apply false
}

val targetJavaVersion = 25

allprojects {
    // TODO: Use newer syntax for allprojects eventually...
    apply(plugin = "java")

    group = "net.refractored"
    version = "0.1"

    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
    }

    dependencies {
        compileOnly(rootProject.libs.paper.api)
    }
}