package net.refractored.eclairEconomy.api;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a currency.
 *
 * All values here are grabbed from the configuration.
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
    Component getName();

    /**
     * Returns the name of the currency in plaintext.
     *
     * This name is also used as the singular form of the currency when displaying amounts.
     *
     * @return the name of the currency in plaintext
     */
    @NotNull
    String getNamePlaintext();

    /**
     * Returns the plural name of the currency.
     *
     * This name is used as the plural form of the currency when displaying amounts.
     *
     * @return the plural name of the currency
     */
    @NotNull
    Component getPluralName();

    /**
     * Returns the plural name of the currency in plaintext.
     *
     * This name is used as the plural form of the currency when displaying amounts.
     *
     * @return the plural name of the currency in plaintext
     */
    @NotNull
    String getPluralNamePlaintext();

    /**
     * Returns the symbol of the currency.
     *
     * This symbol is used to represent the currency in a concise manner.
     *
     * @return the symbol of the currency
     */
    @NotNull
    Component getSymbol();

    /**
     * Returns the symbol of the currency in plaintext.
     *
     * This symbol is used to represent the currency in a concise manner.
     *
     * @return the symbol of the currency in plaintext
     */
    @NotNull
    String getSymbolPlaintext();

    /**
     * Returns whether this currency is the default currency for the vault.
     *
     * This will return the value set in config even if Vault or VaultUnlocked is not installed.
     *
     * @return True if this is the default currency, false otherwise.
     */
    @NotNull
    Boolean isDefaultVault();
}