package net.refractored.eclairEconomy

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.milkbowl.vault2.economy.Economy
import net.refractored.eclairEconomy.api.EclairEconomyProvider
import net.refractored.eclairEconomy.api.exceptions.IllegalConfigurationException
import net.refractored.eclairEconomy.compat.Vault
import net.refractored.eclairEconomy.compat.VaultUnlocked
import net.refractored.eclairEconomy.configurate.ComponentSerializer
import net.refractored.eclairEconomy.impl.EclairEconomyImpl
import net.refractored.eclairEconomy.impl.configuration.Currencies
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.ServicePriority
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabase
import org.spongepowered.configurate.CommentedConfigurationNode
import org.spongepowered.configurate.ConfigurateException
import org.spongepowered.configurate.yaml.YamlConfigurationLoader
import revxrsal.commands.Lamp
import revxrsal.commands.bukkit.BukkitLamp
import revxrsal.commands.bukkit.actor.BukkitCommandActor
import java.io.File
import java.nio.file.Files
import kotlin.time.TimeSource

class EclairEconomyPlugin : SuspendingJavaPlugin() {
    lateinit var config: CommentedConfigurationNode
        private set

    private lateinit var lamp: Lamp<BukkitCommandActor>

    lateinit var messages: CommentedConfigurationNode
        private set

    lateinit var currenciesConfig: CommentedConfigurationNode
        private set

    lateinit var database: R2dbcDatabase
        private set

    init {
        instance = this
    }

    override suspend fun onEnableAsync() {
        val startupTime = TimeSource.Monotonic.markNow()

        try {
            reload()
        } catch (exception: IllegalConfigurationException) {
            logger.severe("${exception.configName} failed to load: ${exception.message}")
            throw exception
        }

        EclairEconomyProvider.setProvider(EclairEconomyImpl)

        if (server.pluginManager.getPlugin("Vault") != null) {
            try {
                Class.forName("net.milkbowl.vault2.economy.Economy")
                // TODO: Look more into how the new vault API handles old compat
                server.servicesManager.register(
                    Economy::class.java,
                    VaultUnlocked,
                    this,
                    ServicePriority.High
                )
            } catch (_: ClassNotFoundException) {
                server.servicesManager.register(
                    @Suppress("DEPRECATION")
                    net.milkbowl.vault.economy.Economy::class.java,
                    Vault,
                    this,
                    ServicePriority.High
                )
            }
        }

        lamp =
            BukkitLamp
                .builder(this)
                .build()

//         lamp.register(TODO())

        logger.info("Commands registered.")

        componentLogger.info(
            Component.text("Enabled in ${startupTime.elapsedNow().inWholeMilliseconds}ms", NamedTextColor.GREEN)
        )
    }

    override suspend fun onDisableAsync() {
        if (this::lamp.isInitialized) {
            lamp.unregisterAllCommands()
        }
    }

    /**
     * Reloads the plugin's configuration files and database connection.
     *
     * If any exception is thrown during the reload, the plugin will fallback to the last known good configuration.
     *
     * @throws IllegalConfigurationException If any configuration file is invalid.
     */
    suspend fun reload() {
        dataFolder.mkdirs()

        val loadedConfig = loadConfig("config.yml")
        val loadedMessages = loadConfig("messages.yml")
        val loadedCurrencies = loadConfig("currencies.yml")

        val currenciesInstance = Currencies(loadedCurrencies)

        withContext(Dispatchers.IO) {
//            database =
//                R2dbcDatabase.connect(
//                    config
//                        .node("database", "url")
//                        .stringOrPath,
//                    user =
//                        config
//                            .node("database", "user")
//                            .stringOrPath,
//                    password =
//                        config
//                            .node("database", "password")
//                            .stringOrPath,
//                )
//
//            loggedTransaction {
// //                SchemaUtils.create(TODO())
//            }
//            logger.info("Database connected.")
        }

        config = loadedConfig
        messages = loadedMessages
        currenciesConfig = loadedCurrencies

        EclairEconomyImpl.loadedCurrencies = currenciesInstance

        // TODO: Fire a reload event.

        logger.info("Configuration loaded.")
    }

    private fun loadConfig(file: String): CommentedConfigurationNode {
        if (!File(dataFolder, file).exists()) {
            javaClass.getResourceAsStream("/$file")?.let {
                Files.copy(
                    it,
                    dataFolder.toPath().resolve(file)
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

        try {
            return loader.load()
        } catch (exception: ConfigurateException) {
            throw IllegalConfigurationException(exception.message ?: "An unknown error occurred.", file)
        }
    }

    @Deprecated("", ReplaceWith("config"))
    override fun getConfig(): FileConfiguration = throw UnsupportedOperationException("Config is not a FileConfiguration.")

    companion object {
        /**
         * The plugin's instance. The exposed API should be used instead of this when possible.
         */
        @JvmStatic
        lateinit var instance: EclairEconomyPlugin
            private set
    }
}
