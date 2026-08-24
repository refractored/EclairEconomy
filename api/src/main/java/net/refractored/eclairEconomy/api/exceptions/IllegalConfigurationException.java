package net.refractored.eclairEconomy.api.exceptions;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.io.IOException;


public class IllegalConfigurationException extends IOException {
    private @NotNull String configName;

    /**
     * Exception thrown when the configuration is invalid or is in an illegal state.
     *
     * Examples of this are if something is not defined, yet is required, or if a value is invalid.
     *
     * @param fileName The name of the configuration that is invalid.
     * @param message The message that will be communicated to the user when this exception is thrown.
     */
    public IllegalConfigurationException(@NonNull String message, @NotNull String fileName) {
        configName = fileName;
        super(message);
    }

    public @NotNull String getConfigName() {
        return configName;
    }
}