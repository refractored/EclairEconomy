package net.refractored.eclairEconomy.api.configuration;

import net.kyori.adventure.text.Component;

/**
 * This interface is not object-mapped like the other configurations.
 */
public interface Messages {
    Component getMessage(String... args);

    String getString(String key, Object... args);
}