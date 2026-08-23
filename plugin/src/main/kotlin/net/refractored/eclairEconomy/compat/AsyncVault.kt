package net.refractored.eclairEconomy.compat

import net.milkbowl.vault2.economy.AccountPermission
import net.milkbowl.vault2.economy.AsyncEconomy
import net.milkbowl.vault2.economy.EconomyResponse
import net.milkbowl.vault2.economy.MultiEconomyResponse
import java.math.BigDecimal
import java.util.Optional
import java.util.UUID
import java.util.concurrent.CompletableFuture

object AsyncVault : AsyncEconomy {
    override fun createAccount(
        accountID: UUID,
        name: String,
        player: Boolean,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun createAccount(
        accountID: UUID,
        name: String,
        worldName: String,
        player: Boolean,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun getUUIDNameMap(): CompletableFuture<Map<UUID?, String?>?> {
        TODO("Not yet implemented")
    }

    override fun getAccountName(accountID: UUID): CompletableFuture<Optional<String?>?> {
        TODO("Not yet implemented")
    }

    override fun hasAccount(accountID: UUID): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun hasAccount(
        accountID: UUID,
        worldName: String,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun renameAccount(
        pluginName: String,
        accountID: UUID,
        name: String,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun deleteAccount(
        pluginName: String,
        accountID: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun accountSupportsCurrency(
        pluginName: String,
        accountID: UUID,
        currency: String,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun accountSupportsCurrency(
        pluginName: String,
        accountID: UUID,
        currency: String,
        world: String,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun balance(
        pluginName: String,
        accountID: UUID,
    ): CompletableFuture<BigDecimal?> {
        TODO("Not yet implemented")
    }

    override fun balance(
        pluginName: String,
        accountID: UUID,
        world: String,
    ): CompletableFuture<BigDecimal?> {
        TODO("Not yet implemented")
    }

    override fun balance(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
    ): CompletableFuture<BigDecimal?> {
        TODO("Not yet implemented")
    }

    override fun has(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun has(
        pluginName: String,
        accountID: UUID,
        world: String,
        amount: BigDecimal,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun has(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun set(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun set(
        pluginName: String,
        accountID: UUID,
        world: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun set(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun transfer(
        pluginName: String,
        from: UUID,
        to: UUID,
        amount: BigDecimal,
    ): CompletableFuture<MultiEconomyResponse?>? {
        TODO("Not yet implemented")
    }

    override fun transfer(
        pluginName: String,
        from: UUID,
        to: UUID,
        worldName: String,
        amount: BigDecimal,
    ): CompletableFuture<MultiEconomyResponse?>? {
        TODO("Not yet implemented")
    }

    override fun transfer(
        pluginName: String,
        from: UUID,
        to: UUID,
        worldName: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<MultiEconomyResponse?>? {
        TODO("Not yet implemented")
    }

    override fun canWithdraw(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun canWithdraw(
        pluginName: String,
        accountID: UUID,
        world: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun canWithdraw(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun withdraw(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun withdraw(
        pluginName: String,
        accountID: UUID,
        world: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun withdraw(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun canDeposit(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun canDeposit(
        pluginName: String,
        accountID: UUID,
        world: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun canDeposit(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun deposit(
        pluginName: String,
        accountID: UUID,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun deposit(
        pluginName: String,
        accountID: UUID,
        world: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun deposit(
        pluginName: String,
        accountID: UUID,
        world: String,
        currency: String,
        amount: BigDecimal,
    ): CompletableFuture<EconomyResponse?> {
        TODO("Not yet implemented")
    }

    override fun createSharedAccount(
        pluginName: String,
        accountID: UUID,
        name: String,
        owner: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun accountsWithOwnerOf(
        pluginName: String,
        accountID: UUID,
    ): CompletableFuture<List<UUID?>?> {
        TODO("Not yet implemented")
    }

    override fun accountsWithMembershipTo(
        pluginName: String,
        accountID: UUID,
    ): CompletableFuture<List<UUID?>?> {
        TODO("Not yet implemented")
    }

    override fun accountsWithAccessTo(
        pluginName: String,
        accountID: UUID,
        vararg permissions: AccountPermission,
    ): CompletableFuture<List<UUID?>?> {
        TODO("Not yet implemented")
    }

    override fun isAccountOwner(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun setOwner(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun isAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun addAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun addAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
        vararg initialPermissions: AccountPermission,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun removeAccountMember(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun hasAccountPermission(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
        permission: AccountPermission,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }

    override fun updateAccountPermission(
        pluginName: String,
        accountID: UUID,
        uuid: UUID,
        permission: AccountPermission,
        value: Boolean,
    ): CompletableFuture<Boolean?> {
        TODO("Not yet implemented")
    }
}