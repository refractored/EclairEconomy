plugins {
    alias(libs.plugins.kotlin.jvm) apply false
}

allprojects {
    group = "net.refractored"
    version = "0.2"
}

val targetJavaVersion = 25