plugins {
    `java-library`
//    checkstyle
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

// checkstyle {
//    toolVersion = "14.0.0"
// }

tasks {
    build {
        dependsOn(createVersionFile)
    }
}
