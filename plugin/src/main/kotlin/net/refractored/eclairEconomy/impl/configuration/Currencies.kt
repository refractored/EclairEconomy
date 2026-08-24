package net.refractored.eclairEconomy.impl.configuration

import net.refractored.eclairEconomy.api.Currency
import net.refractored.eclairEconomy.api.exceptions.IllegalConfigurationException
import net.refractored.eclairEconomy.impl.CurrencyImpl
import org.spongepowered.configurate.CommentedConfigurationNode

class Currencies(node: CommentedConfigurationNode) {

    val allCurrencies: Map<String, Currency>

    val defaultCurrency: Currency

    init {
        val currencyMapConfig: MutableMap<String, Currency> = mutableMapOf()
        var defaultCurrencyConfig: Currency? = null

        for ((key, node) in node.childrenMap()) {
            val key = key as? String ?: continue

            val currency = CurrencyImpl(key, node)

            if (currency.isDefault) {
                if (defaultCurrencyConfig != null) {
                    throw IllegalConfigurationException("Multiple default currencies defined in configuration.", "currencies.yml")
                }

                defaultCurrencyConfig = currency
            }

            currencyMapConfig[key] = currency
        }

        defaultCurrency = defaultCurrencyConfig ?: throw IllegalConfigurationException("No default currency defined in configuration.", "currencies.yml")

        allCurrencies = currencyMapConfig
    }
}
