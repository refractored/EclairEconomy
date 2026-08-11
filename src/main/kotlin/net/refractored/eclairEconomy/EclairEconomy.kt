package net.refractored.eclairEconomy

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import io.r2dbc.spi.IsolationLevel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.refractored.eclairEconomy.messages.Messages.stringOrPath
import org.bukkit.configuration.file.FileConfiguration
import org.jetbrains.exposed.v1.core.SqlLogger
import org.jetbrains.exposed.v1.core.Transaction
import org.jetbrains.exposed.v1.core.statements.StatementContext
import org.jetbrains.exposed.v1.core.statements.expandArgs
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabase
import org.jetbrains.exposed.v1.r2dbc.SchemaUtils
import org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction
import org.jetbrains.exposed.v1.r2dbc.transactions.transactionManager
import org.spongepowered.configurate.CommentedConfigurationNode
import org.spongepowered.configurate.yaml.YamlConfigurationLoader
import revxrsal.commands.Lamp
import revxrsal.commands.bukkit.BukkitLamp
import revxrsal.commands.bukkit.actor.BukkitCommandActor
import rocks.balls.shuffled.serializers.configurate.ComponentSerializer
import java.io.File
import java.nio.file.Files
import kotlin.time.TimeSource

class EclairEconomy : SuspendingJavaPlugin() {
    lateinit var config: CommentedConfigurationNode
        private set

    private lateinit var lamp: Lamp<BukkitCommandActor>

    lateinit var messages: CommentedConfigurationNode
        private set

    init {
        instance = this
    }

    override suspend fun onEnableAsync() {
        val startupTime = TimeSource.Monotonic.markNow()

        reload()

        lamp =
            BukkitLamp
                .builder(this)
                .build()

//         lamp.register(TODO())

        logger.info("Commands registered.")

        componentLogger.info(
            Component.text("Enabled in ${startupTime.elapsedNow().inWholeMilliseconds}ms", NamedTextColor.GREEN),
        )
    }

    override suspend fun onDisableAsync() {
        if (this::lamp.isInitialized) {
            lamp.unregisterAllCommands()
        }
    }

    suspend fun reload() {
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
                    options.serializers { builder ->
                        builder.register(Component::class.java, ComponentSerializer)
                    }
                }.path(dataFolder.toPath().resolve(file))
                .build()

        return loader.load()
    }

    override fun getConfig(): FileConfiguration = throw UnsupportedOperationException("Config is not a FileConfiguration.")

    companion object {
        /**
         * The plugin's instance
         */
        @JvmStatic
        lateinit var instance: EclairEconomy
            private set
    }
}