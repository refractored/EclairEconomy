package net.refractored.eclairEconomy

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import org.spongepowered.configurate.CommentedConfigurationNode
import org.spongepowered.configurate.yaml.YamlConfigurationLoader
import java.io.File
import java.nio.file.Files

class EclairEconomy : SuspendingJavaPlugin() {
    lateinit var config: CommentedConfigurationNode
        private set

    lateinit var messages: CommentedConfigurationNode
        private set

    init {
        instance = this
    }

    override fun onEnable() {
        reload()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun reload() {
        dataFolder.mkdirs()

        config = loadConfig("config.yml")
        messages = loadConfig("messages.yml")
    }

    private fun loadConfig(file: String): CommentedConfigurationNode {
        if (!File(dataFolder, file).exists()) {
            javaClass.getResourceAsStream("/$file")?.let {
                Files.copy(
                    it,
                    dataFolder.toPath().resolve(file),
                )
            }
        }

        val loader =
            YamlConfigurationLoader
                .builder()
                .defaultOptions { options ->
                    options.serializers { builder -> // FUTURE USE
                    }
                }.path(dataFolder.toPath().resolve(file))
                .build()

        return loader.load()
    }

    companion object {
        /**
         * The plugin's instance
         */
        @JvmStatic
        lateinit var instance: EclairEconomy
            private set
    }
}