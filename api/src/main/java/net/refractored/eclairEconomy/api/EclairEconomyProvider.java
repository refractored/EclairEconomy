package net.refractored.eclairEconomy.api;

import java.util.Objects;

public final class EclairEconomyProvider {
    /**
     * The EclairEconomy provider instance.
     */
    private static EclairEconomy provider;

    private EclairEconomyProvider() { }

    /**
     * Sets the EclairEconomy provider instance.
     *
     * @param instance The EclairEconomy instance to set as the provider.
     * @throws NullPointerException if the instance is null.
     * @throws IllegalStateException if the provider has already been initialized.
     */
    public static synchronized void setProvider(final EclairEconomy instance) {
        Objects.requireNonNull(instance);
        if (provider != null) {
            throw new IllegalStateException("EclairEconomy provider already initialized");
        }
        provider = instance;
    }

    /**
     * Gets the EclairEconomy provider instance.
     *
     * <p>See {@link EclairEconomy#get()} for a more convenient way to access the EclairEconomy instance
     * and for more information.</p>
     *
     * @return The EclairEconomy provider instance.
     * @throws IllegalStateException if the provider has not been initialized.
     */
    public static synchronized EclairEconomy getProvider() {
        if (provider == null) {
            throw new IllegalStateException("EclairEconomy provider not initialized");
        }
        return provider;
    }

}