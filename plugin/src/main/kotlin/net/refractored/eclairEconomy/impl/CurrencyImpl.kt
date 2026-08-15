package net.refractored.eclairEconomy.impl

import net.refractored.eclairEconomy.api.Currency
import org.spongepowered.configurate.ConfigurationNode

class CurrencyImpl(
    val id: String,
) : Currency {
    val node: ConfigurationNode = TODO()

    override fun getId(): String {
        TODO("Not yet implemented")
    }

    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun getPluralName(): String {
        TODO("Not yet implemented")
    }

    override fun getSymbol(): String {
        TODO("Not yet implemented")
    }
}