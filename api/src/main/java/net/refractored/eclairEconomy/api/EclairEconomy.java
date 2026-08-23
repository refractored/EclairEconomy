package net.refractored.eclairEconomy.api;

import net.refractored.eclairEconomy.api.configuration.Messages;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;

public interface EclairEconomy {

    /**
     * Gets the EclairEconomy instance.
     *
     * @throws IllegalStateException if the provider has not been initialized
     * @return The EclairEconomy instance.
     */
    static @NotNull EclairEconomy get() {
        return EclairEconomyProvider.getProvider();
    }

    /**
     * Gets the messages configuration.
     *
     * @return The messages configuration instance.
     */
    @NotNull Messages getMessages();

    /**
     * Gets all currencies defined in the configuration.
     *
     * @return A collection of all currencies.
     */
    @NotNull Collection<Currency> getCurrencies();

    /**
     * Gets a currency by its unique identifier.
     *
     * @param currencyId The unique identifier of the currency.
     * @return The currency's instance if found, otherwise an empty Optional.
     */
    @NotNull Optional<Currency> getCurrency(String currencyId);

    /**
     * Gets the default currency as defined in the configuration.
     *
     * @return The default currency's instance.
     */
    @NotNull Currency getDefaultCurrency();
}