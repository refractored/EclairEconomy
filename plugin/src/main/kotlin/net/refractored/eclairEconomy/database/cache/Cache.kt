package net.refractored.eclairEconomy.database.cache

interface Cache<K, V> {
    suspend fun get(key: K): V

    suspend fun set(key: K, value: V)

    suspend fun remove(key: K)
}
