package net.refractored.eclairEconomy.impl.configuration

import net.kyori.adventure.text.Component
import net.refractored.eclairEconomy.EclairEconomyPlugin
import net.refractored.eclairEconomy.api.configuration.Messages
import net.refractored.eclairEconomy.configurate.ComponentSerializer.component
import net.refractored.eclairEconomy.messages.Messages.stringOrPath

object MessagesImpl : Messages {
    override fun getMessage(vararg args: String): Component =
        EclairEconomyPlugin.instance.messages
            .node(*args)
            .component

    override fun getString(vararg args: String): String =
        EclairEconomyPlugin.instance.messages
            .node(*args)
            .stringOrPath
}