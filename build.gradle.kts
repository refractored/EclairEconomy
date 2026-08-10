import org.gradle.kotlin.dsl.buildConfigField

plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.plugin.yaml.creator.paper)
    alias(libs.plugins.gversion)
    alias(libs.plugins.buildconfig)
    alias(libs.plugins.paper.run)
}

group = "net.refractored"
version = "0.1"
val targetJavaVersion = 25

val externalDepends = mutableListOf<String>()

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper.api)

    implementation(libs.kotlin)
    implementation(libs.kotlin.coroutines)
    implementation(libs.bundles.mccoroutine)
    implementation(libs.bundles.configurate)
}

paperPluginYaml {
    main = "$group.eclairEconomy.EclairEconomy"
    loader = "$group.eclairEconomy.EclairEconomyLoader"
    foliaSupported = true // Probably would need more testing.
    apiVersion = "26.2"
    version = "$version"

    authors = listOf("refractored")
    contributors = listOf()

    website = "https://github.com/refractored/EclairEconomy"
}

gversion {
    srcDir = "src/main/kotlin"
    classPackage = "$group.eclairEconomy"
    className = "BuildConstants"
    language = "kotlin"
    explicitType = true
}

buildConfig {
    className("Libraries")
    useJavaOutput()

    buildConfigField("DEPENDS", externalDepends)
}

kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks {
    runServer {
        minecraftVersion(libs.versions.minecraft.get())
        jvmArgs("-Xms2G", "-Xmx2G", "-Dcom.mojang.eula.agree=true")
    }
}