 # <p align="center"> <img width="696" height="88" alt="minecraft-text(5)" src="https://github.com/user-attachments/assets/7c9324e0-8f0d-45ed-bebd-29b8ea03b25f" /> <p align="center">A Paper plugin that adds several useful economy features.</p>
 </p>

The plugin currently is incomplete. The plugin will be sold on [BuiltByBit](https://builtbybit.com/) and [voxel.shop](https://voxel.shop/) once completed.

Several features are inspired from [Qking12's](https://github.com/qKing12) [RoyaleEconomy](https://voxel.shop/product/113/royaleeconomy-open-sourced), and [DrDonut's DonutSMP](https://store.donutsmp.net/)

# Requirements
- A supported external database
  - MySQL
  - MariaDB (Preferred over mysql)
- A supported database cache
  - In-Memory (Fastest for vault-compat, unfortunately does not support more than one server)
  - Redis (Requires a external Redis server)
  - PluginMessaging (Requires BungeeCord or Velocity proxy, with the companion plugin installed)

# Supported Plugins
- [Vault](https://www.spigotmc.org/resources/vault.34315/) 
- [VaultUnlocked](https://modrinth.com/plugin/vaultunlocked) (Recommended over Vault & Provides backwards compatibility)
<small>[See more here](https://github.com/TheNewEconomy/VaultUnlockedAPI#why-vaultunlocked)</small>


# Feature list
Checked boxes are features that have been implemented!
- [ ] Banking System
- [ ] Shops
- [ ] Sellall command & menu
- [ ] Killcoins
- [ ] Boosters
- [ ] Blackmarket
- [ ] Bounties
- [ ] Playtime Rewards
- [ ] Multi-Server Support
- [ ] Multi-Currency Support
- [ ] Transactions not handled by the main thread
- [ ] Dropping or losing currency on death
- [ ] AFK reward zone (With worldguard)
- [ ] Custom items, including sellall wands, talismen
- [ ] Vault Support for existing compatibility
- [ ] Customizable GUIs
- [ ] [Minimessage](https://docs.papermc.io/adventure/minimessage/format/) Support