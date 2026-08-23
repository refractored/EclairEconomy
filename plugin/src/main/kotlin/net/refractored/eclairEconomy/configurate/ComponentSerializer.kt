package net.refractored.eclairEconomy.configurate

import net.kyori.adventure.text.Component
import net.refractored.eclairEconomy.messages.Messages.addPrefix
import net.refractored.eclairEconomy.messages.Messages.fixItalics
import net.refractored.eclairEconomy.messages.Messages.pathString
import net.refractored.eclairEconomy.messages.Messages.toComponent
import net.refractored.eclairEconomy.messages.Messages.toMinimessage
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

// I know configurate or kyori provides one already, but it does not use minimessage iirc.
object ComponentSerializer : TypeSerializer<Component> {
    override fun deserialize(
        type: Type,
        node: ConfigurationNode
    ): Component = (node.string ?: node.pathString).toComponent().fixItalics()

    override fun serialize(
        type: Type,
        obj: Component?,
        node: ConfigurationNode
    ) {
        node.set(obj?.toMinimessage())
    }

    val ConfigurationNode.component
        get() = get(Component::class.java)!! // Shouldn't ever be null

    val ConfigurationNode.prefixedComponent
        get() = component.addPrefix()
}
