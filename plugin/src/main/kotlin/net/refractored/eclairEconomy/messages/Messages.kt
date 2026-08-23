package net.refractored.eclairEconomy.messages

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import net.refractored.eclairEconomy.EclairEconomyPlugin
import net.refractored.eclairEconomy.configurate.ComponentSerializer.component
import org.spongepowered.configurate.ConfigurationNode

object Messages {
    val EclairEconomyPlugin.prefix
        get() =
            EclairEconomyPlugin.instance.messages
                .node("prefix")
                .component

    fun Component.addPrefix(): Component = EclairEconomyPlugin.instance.prefix.append(this)

    fun String.toComponent(vararg tagResolvers: TagResolver): Component = MiniMessage.miniMessage().deserialize(this, *tagResolvers)

    fun Component.toPlainText(): String = PlainTextComponentSerializer.plainText().serialize(this)

    fun Component.toMinimessage(): String = MiniMessage.miniMessage().serialize(this)

    fun Iterable<Component>.toMinimessage(): List<String> = map { it.toMinimessage() }

    fun Iterable<String>.toComponent(vararg tagResolvers: TagResolver): List<Component> = map { it.toComponent(*tagResolvers) }

    fun join(
        names: MutableList<String>,
        seperator: JoinConfiguration = defaultJoinConfig,
        apply: TextComponent.Builder.() -> Unit = {
        }
    ): Component = Component.join(
        seperator,
        names.map { content: String ->
            Component.text { builder ->
                builder.content(content)
                builder.apply()
            }
        }
    )

    val defaultJoinConfig: JoinConfiguration =
        JoinConfiguration.separators(
            Component.text(", "),
            Component.text(", and ")
        )

    val ConfigurationNode.stringOrPath: String
        get() = string ?: pathString

    val ConfigurationNode.pathString: String
        get() = path().joinToString(".") { it.toString() }

    /**
     * Fixes italics for item lore.
     */
    fun Component.fixItalics(): Component = this.decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE)

    /**
     * Returns a new component obtained by replacing all occurrences of the [oldValue] substring in this component
     * with the specified [newValue] component.
     */
    fun Component.replace(
        oldValue: String,
        newValue: Component
    ): Component = this.replaceText(
        TextReplacementConfig
            .builder()
            .matchLiteral(oldValue)
            .replacement(newValue)
            .build()
    )

    /**
     * Returns a new component obtained by replacing all occurrences of the [oldValue] substring in this component
     * with the specified [newValue] component.
     */
    fun Component.replace(
        oldValue: String,
        newValue: String
    ): Component = this.replaceText(
        TextReplacementConfig
            .builder()
            .matchLiteral(oldValue)
            .replacement(newValue)
            .build()
    )
}
