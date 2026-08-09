plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.plugin.yaml.creator.paper)
    alias(libs.plugins.gversion)
    alias(libs.plugins.buildconfig)
    alias(libs.plugins.paper.run)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper.api)
    implementation(libs.kotlin.stdlib)
}

paperPluginYaml {
    main = "net.refractored.eclairEconomy.EclairEconomy"
    loader = "net.refractored.eclairEconomy.EclairEconomyLoader"
    apiVersion = "26.2"

    authors = listOf("refractored")
    website = "net.refractored"
}

kotlin {
    jvmToolchain(25)
}

tasks {
    runServer {
        minecraftVersion(libs.versions.minecraft.get())
        jvmArgs("-Xms2G", "-Xmx2G", "-Dcom.mojang.eula.agree=true")
    }
}