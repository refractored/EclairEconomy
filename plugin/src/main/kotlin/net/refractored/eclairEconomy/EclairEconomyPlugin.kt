package net.refractored.eclairEconomy

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import io.r2dbc.spi.IsolationLevel
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.milkbowl.vault2.economy.Economy
import net.refractored.eclairEconomy.api.EclairEconomy
import net.refractored.eclairEconomy.api.EclairEconomyProvider
import net.refractored.eclairEconomy.api.kotlin.getCurrency
import net.refractored.eclairEconomy.compat.Vault
import net.refractored.eclairEconomy.compat.VaultUnlocked
import net.refractored.eclairEconomy.configurate.ComponentSerializer
import net.refractored.eclairEconomy.impl.EclairEconomyImpl
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.ServicePriority
import org.jetbrains.exposed.v1.core.SqlLogger
import org.jetbrains.exposed.v1.core.Transaction
import org.jetbrains.exposed.v1.core.statements.StatementContext
import org.jetbrains.exposed.v1.core.statements.expandArgs
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabase
import org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction
import org.jetbrains.exposed.v1.r2dbc.transactions.transactionManager
import org.spongepowered.configurate.CommentedConfigurationNode
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

    lateinit var currencies: CommentedConfigurationNode
        private set

    lateinit var database: R2dbcDatabase
        private set

    init {
        instance = this
    }

    override suspend fun onEnableAsync() {
        val startupTime = TimeSource.Monotonic.markNow()

        reload()

        EclairEconomyProvider.setProvider(EclairEconomyImpl)

        if (server.pluginManager.getPlugin("Vault") != null) {
            try {
                Class.forName("net.milkbowl.vault2.economy.Economy")
                // TODO: Look more into how the new vault API handles old compat
                server.servicesManager.register(
                    Economy::class.java,
                    VaultUnlocked,
                    this,
                    ServicePriority.High,
                )
            } catch (_: ClassNotFoundException) {
                server.servicesManager.register(
                    @Suppress("DEPRECATION")
                    net.milkbowl.vault.economy.Economy::class.java,
                    Vault,
                    this,
                    ServicePriority.High,
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
        currencies = loadConfig("currencies.yml")

        logger.info("Configuration loaded.")

//        withContext(Dispatchers.IO) {
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
//        }
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
        suspend fun <T> loggedTransaction(
            db: R2dbcDatabase? = null,
            transactionIsolation: IsolationLevel? = db?.transactionManager?.defaultIsolationLevel,
            readOnly: Boolean? = db?.transactionManager?.defaultReadOnly,
            statement: suspend Transaction.() -> T,
        ): T =
            suspendTransaction(db, transactionIsolation, readOnly) {
                if (instance.config.node("database", "verbose").boolean) {
                    addLogger(
                        object : SqlLogger {
                            override fun log(
                                context: StatementContext,
                                transaction: Transaction,
                            ) {
                                instance.logger.info("SQL: ${context.expandArgs(transaction)}")
                            }
                        },
                    )
                }
                statement()
            }

        /**
         * The plugin's instance. The exposed API should be used instead of this when possible.
         */
        @JvmStatic
        lateinit var instance: EclairEconomyPlugin
            private set
    }
}