package net.refractored.eclairEconomy.compat

import net.milkbowl.vault2.economy.AccountPermission
import net.milkbowl.vault2.economy.Economy
import net.milkbowl.vault2.economy.EconomyResponse
import java.math.BigDecimal
import java.util.Optional
import java.util.UUID

object VaultUnlocked : Economy {
    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun hasSharedAccountSupport(): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasMultiCurrencySupport(): Boolean {
        TODO("Not yet implemented")
    }

    override fun fractionalDigits(pluginName: String): Int {
        TODO("Not yet implemented")
    }

    override fun format(amount: BigDecimal): String {
        TODO("Not yet implemented")
    }

    override fun format(
        pluginName: String,
        amount: BigDecimal,
    ): String {
        TODO("Not yet implemented")
    }

    override fun format(
        amount: BigDecimal,
        currency: String,
    ): String {
        TODO("Not yet implemented")
    }

    override fun format(
        pluginName: String,
        amount: BigDecimal,
        currency: String,
    ): String {
        TODO("Not yet implemented")
    }

    override fun hasCurrency(currency: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getDefaultCurrency(pluginName: String): String {
        TODO("Not yet implemented")
    }

    override fun defaultCurrencyNamePlural(pluginName: String): String {
        TODO("Not yet implemented")
    }

    override fun defaultCurrencyNameSingular(pluginName: String): String {
        TODO("Not yet implemented")
    }

    override fun currencies(): Collection<String?> {
        TODO("Not yet implemented")
    }

    override fun createAccount(
        accountID: UUID,
        name: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun createAccount(
        accountID: UUID,
        name: String,
        player: Boolean,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun createAccount(
        accountID: UUID,
        name: String,
        worldName: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun createAccount(
        accountID: UUID,
        name: String,
        worldName: String,
        player: Boolean,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUUIDNameMap(): Map<UUID?, String?> {
        TODO("Not yet implemented")
    }

    override fun getAccountName(accountID: UUID): Optional<String?>? {
        TODO("Not yet implemented")
    }

    override fun hasAccount(accountID: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasAccount(
        accountID: UUID,
        worldName: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun renameAccount(
        accountID: UUID,
        name: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun renameAccount(
        pluginName: String,
        accountID: UUID,
        name: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteAccount(
        pluginName: String,
        accountID: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun accountSupportsCurrency(
        pluginName: String,
        accountID: UUID,
        currency: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun accountSupportsCurrency(
        pluginName: String,
        accountID: UUID,
        currency: String,
        world: String,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBalance(
        pluginName: String,
        accountID: UUID,
    ): BigDecimal {
        TODO("Not yet implemented")
    }

    override fun getBalance(
        pluginName: String,
        accountID: UUID,
        world: String,
    ): BigDecimal {
        TODO("Not yet implemented")
    }

    override fun getBalance(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
    ): BigDecimal {
        TODO("Not yet implemented")
    }

    override fun has(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun has(
        pluginName: String,
        accountID: UUID,
        worldName: String,
        amount: BigDecimal,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun has(
        pluginName: String,
        accountID: UUID,
        worldName: String,
        currency: String,
        amount: BigDecimal,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun withdraw(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): EconomyResponse {
        TODO("Not yet implemented")
    }

    override fun withdraw(
        pluginName: String,
        accountID: UUID,
        worldName: String,
        amount: BigDecimal,
    ): EconomyResponse {
        TODO("Not yet implemented")
    }

    override fun withdraw(
        pluginName: String,
        accountID: UUID,
        worldName: String,
        currency: String,
        amount: BigDecimal,
    ): EconomyResponse {
        TODO("Not yet implemented")
    }

    override fun deposit(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): EconomyResponse {
        TODO("Not yet implemented")
    }

    override fun deposit(
        pluginName: String,
        accountID: UUID,
        worldName: String,
        amount: BigDecimal,
    ): EconomyResponse {
        TODO("Not yet implemented")
    }

    override fun deposit(
        pluginName: String,
        accountID: UUID,
        worldName: String,
        currency: String,
        amount: BigDecimal,
    ): EconomyResponse {
        TODO("Not yet implemented")
    }

    override fun createSharedAccount(
        pluginName: String,
        accountID: UUID,
        name: String,
        owner: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountOwner(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun setOwner(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
        vararg initialPermissions: AccountPermission,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasAccountPermission(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
        permission: AccountPermission,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateAccountPermission(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
        permission: AccountPermission,
        value: Boolean,
    ): Boolean {
        TODO("Not yet implemented")
    }
}