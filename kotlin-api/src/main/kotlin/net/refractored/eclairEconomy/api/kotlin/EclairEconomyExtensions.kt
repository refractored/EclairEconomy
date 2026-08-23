@file:Suppress("NOTHING_TO_INLINE")

package net.refractored.eclairEconomy.api.kotlin

import net.refractored.eclairEconomy.api.Currency
import net.refractored.eclairEconomy.api.EclairEconomy
import kotlin.jvm.optionals.getOrNull

/**
 * Extension function to get a currency by its ID from the EclairEconomy instance.
 *
 * @param currencyId The ID of the currency to retrieve.
 * @return The Currency object if found, or null if not found.
 */
public inline fun EclairEconomy.getCurrencyOrNull(currencyId: String): Currency? = getCurrency(currencyId).getOrNull()