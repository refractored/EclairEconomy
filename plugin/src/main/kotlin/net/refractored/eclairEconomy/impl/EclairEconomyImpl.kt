package net.refractored.eclairEconomy.impl

import net.refractored.eclairEconomy.api.Currency
import net.refractored.eclairEconomy.api.EclairEconomy
import net.refractored.eclairEconomy.api.configuration.Messages
import net.refractored.eclairEconomy.impl.configuration.Currencies
import net.refractored.eclairEconomy.impl.configuration.MessagesImpl
import java.util.Optional

object EclairEconomyImpl : EclairEconomy {
    override fun getMessages(): Messages = MessagesImpl

    lateinit var loadedCurrencies: Currencies

    override fun getCurrencies(): Collection<Currency> {
        TODO("Not yet implemented")
    }

    override fun getCurrency(currencyId: String?): Optional<Currency?> {
        TODO("Not yet implemented")
    }

    override fun getDefaultCurrency(): Currency {
        TODO("Not yet implemented")
    }
}
