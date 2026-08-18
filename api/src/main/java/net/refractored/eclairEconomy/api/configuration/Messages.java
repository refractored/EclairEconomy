package net.refractored.eclairEconomy.api.configuration;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/**
 * This interface is not object-mapped like the other configurations.
 */
public interface Messages {
    /**
     * Gets a message from the configuration.
     *
     * @param args
     * @return The component, or a string of the path if the message is not found.
     */
    @NotNull Component getMessage(@NotNull String... args);

    /**
     * Gets a message from the configuration in plaintext.
     *
     * @param args
     * @return The string, or a string of the path if the message is not found.
     */
    @NotNull String getString(@NotNull String... args);
}