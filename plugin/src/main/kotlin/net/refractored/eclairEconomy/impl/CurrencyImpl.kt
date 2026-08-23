package net.refractored.eclairEconomy.impl

import net.kyori.adventure.text.Component
import net.refractored.eclairEconomy.EclairEconomyPlugin
import net.refractored.eclairEconomy.api.Currency
import net.refractored.eclairEconomy.configurate.ComponentSerializer.component
import net.refractored.eclairEconomy.messages.Messages.toPlainText
import org.spongepowered.configurate.ConfigurationNode

class CurrencyImpl(
    // Private to prevent JVM clash
    private val id: String,
    val node: ConfigurationNode = EclairEconomyPlugin.instance.currencies.node(id),
) : Currency {
    override fun getId(): String = id

    override fun getName(): Component = node.node("name").component

    override fun getNamePlaintext(): String = name.toPlainText()

    override fun getPluralName(): Component = node.node("plural-name").component

    override fun getPluralNamePlaintext(): String = pluralName.toPlainText()

    override fun getSymbol(): Component = node.node("symbol").component

    override fun isDefault(): Boolean = node.node("default-vault-currency").boolean

    override fun getSymbolPlaintext(): String = symbol.toPlainText()
}