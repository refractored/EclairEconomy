package net.refractored.eclairEconomy.api;

import net.refractored.eclairEconomy.api.configuration.Messages;
import org.jetbrains.annotations.NotNull;

public final class EclairEconomy {

    private static Messages messages;

    private EclairEconomy() {}

    public static @NotNull Messages messages() {
        if (messages == null) {
            throw new IllegalStateException("EclairEconomy has not been initialized yet.");
        }
        return messages;
    }

    public static void setMessages(@NotNull Messages messages) {
        EclairEconomy.messages = messages;
    }
}