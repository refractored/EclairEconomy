package net.refractored.eclairEconomy.messages

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver
import net.refractored.eclairEconomy.EclairEconomyPlugin
import net.refractored.eclairEconomy.messages.Messages.pathString
import net.refractored.eclairEconomy.messages.Messages.prefix
import net.refractored.eclairEconomy.messages.Messages.toComponent
import org.spongepowered.configurate.CommentedConfigurationNode

class MinimessageBuilder private constructor(
    var minimessage: String,
) : Cloneable {
    val tags = mutableListOf<TagResolver>()

    /**
     * If the prefix should be added to the component.
     */
    var prefixed = false

    /**
     * This replacement is auto-closing, so its style will not influence the style of following components.
     */
    fun replace(
        key: String,
        newValue: Component,
    ) {
        tags.add(
            Placeholder.component(key, newValue),
        )
    }

    /**
     *
     * @param parsed If false, a literal string will be inserted, without attempting to parse any contained tags. Otherwise, the string will be parsed with the entire.
     *
     * @throws IllegalArgumentException Whenever the % char is used.
     */
    fun replace(
        key: String,
        newValue: String,
        parsed: Boolean = false,
    ) {
        if (key.contains('%')) throw IllegalArgumentException("Placeholder keys cannot contain '%' characters")
        if (parsed) {
            tags.add(
                Placeholder.parsed(key, newValue),
            )
        } else {
            tags.add(
                Placeholder.unparsed(key, newValue),
            )
        }
    }

    /**
     * Adds a custom tag resolver to the builder.
     *
     * You can use this to add custom tags but there are also utility functions that may already cover your use case, such as [replace].
     */
    fun addTagResolver(tagResolver: TagResolver) {
        tags.add(tagResolver)
    }

    companion object {
        /**
         * Builds a component from a Minimessage string, using the provided builder to replace placeholders.
         *
         * @return The built component.
         */
        fun builder(
            minimessage: String,
            init: MinimessageBuilder.() -> Unit,
        ): Component {
            val builder = MinimessageBuilder(minimessage)
            builder.init()
            val component = builder.minimessage.toComponent(*builder.tags.toTypedArray())
            return if (builder.prefixed) {
                EclairEconomyPlugin.instance.prefix.append(component)
            } else {
                component
            }
        }

        fun String.component(init: MinimessageBuilder.() -> Unit): Component = builder(this, init)

        /**
         * Builds a component from a string from [CommentedConfigurationNode.getString] using Minimessage.
         *
         * @see [builder]
         *
         * @return The built component.
         */
        fun CommentedConfigurationNode.component(init: MinimessageBuilder.() -> Unit): Component = builder(string ?: pathString, init)

        /**
         * Builds a list of components from a list of strings string from [CommentedConfigurationNode.getString] using Minimessage.
         *
         * @see [builder]
         *
         * @return A list of built components.
         */
        fun CommentedConfigurationNode.components(init: MinimessageBuilder.() -> Unit): List<Component> {
            val components = mutableListOf<Component>()

            for (string in getList(String::class.java)!!) {
                components.add(builder(string, init))
            }

            return components
        }
    }
}