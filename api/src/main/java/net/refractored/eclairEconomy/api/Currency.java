package net.refractored.eclairEconomy.api;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a currency.
 */
public interface Currency {

    /**
     * The unique identifier of the currency.
     *
     * This is typically used for getting the currency from a registry, database storage and configuration.
     *
     * @return The unique identifier of the currency.
     */
    @NotNull
    String getId();

    /**
     * Returns the name of the currency.
     *
     * This name is also used as the singular form of the currency when displaying amounts.
     *
     * @return the name of the currency
     */
    @NotNull
    String getName();

    /**
     * Returns the plural name of the currency.
     *
     * This name is used as the plural form of the currency when displaying amounts.
     *
     * @return the plural name of the currency
     */
    @NotNull
    String getPluralName();

    /**
     * Returns the symbol of the currency.
     *
     * This symbol is used to represent the currency in a concise manner.
     *
     * @return the symbol of the currency
     */
    @NotNull
    String getSymbol();
}