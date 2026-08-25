import org.gradle.accessors.dm.LibrariesForLibs
import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml.Load

plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.plugin.yaml.creator.paper)
    alias(libs.plugins.gversion)
    alias(libs.plugins.buildconfig)
    alias(libs.plugins.paper.run)
    alias(libs.plugins.ktlint)
}

val targetJavaVersion = 25

val externalDepends = mutableListOf<String>()

repositories {
    mavenCentral()
    maven("https://repo.codemc.io/repository/creatorfromhell/")
}

dependencies {
    implementation(project(":api"))
    implementation(project(":kotlin-api"))

    compileOnly(libs.vault.unlocked)

    // External dependencies downloaded at runtime
    libLoader(libs.kotlin)
    libLoader(libs.kotlin.coroutines)
    libLoader(libs.bundles.mccoroutine)

    libLoader(libs.bundles.configurate)
    libLoader(libs.bundles.lamp.bukkit)
    libLoader(libs.bundles.exposed)
    libLoader(libs.bundles.r2dbc.drivers)
}

paperPluginYaml {
    main = "$group.eclairEconomy.EclairEconomy"
    loader = "$group.eclairEconomy.EclairEconomyLoader"
    foliaSupported = true // Probably would need more testing.
    apiVersion = libs.versions.minecraft.get()
    version = version.get()

    authors = listOf("refractored")
    contributors = listOf()

    website = "https://github.com/refractored/EclairEconomy"

    dependencies {
        server("Vault", Load.BEFORE, false) // VaultUnlocked is under the same name for old compat.
    }
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
    packageName("$group.eclairEconomy")

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

    compileKotlin {
        dependsOn(createVersionFile)
    }

    jar {
        archiveBaseName.set("EclairEconomy")
        archiveVersion.set(version.toString())

        from(project(":api").sourceSets["main"].output)
        from(project(":kotlin-api").sourceSets["main"].output)
    }
}

/**
 * Adds a dependency as [compileOnly] and sets up for paper's library loader to download the dependency at runtime.
 * Providers that resolve to either [MinimalExternalModuleDependency] or [ExternalModuleDependencyBundle] are supported, as well as Strings and the Kotlin library accessors.
 *
 * @return The dependency.
 *
 * @throws IllegalArgumentException If the dependency is unsupported.
 */
fun DependencyHandler.libLoader(dep: Any?): Dependency? = when (dep) {
    is String -> {
        externalDepends.add(dep)
        compileOnly(dep)
    }

    is LibrariesForLibs.KotlinLibraryAccessors -> {
        externalDepends.add(dep.asProvider().get().toString())
        compileOnly(dep)
    }

    is Provider<*> -> {
        when (val resolved = dep.get()) {
            is MinimalExternalModuleDependency -> {
                externalDepends.add(resolved.toString())
                compileOnly(dep)
            }

            is ExternalModuleDependencyBundle -> {
                resolved.forEach { bundledDep ->
                    externalDepends.add(bundledDep.toString())
                }
                compileOnly(dep)
            }

            else -> {
                throw IllegalArgumentException("Unsupported Provider: ${resolved::class.java.name}")
            }
        }
    }

    else -> {
        throw IllegalArgumentException("Unsupported dependency: $dep")
    }
}
