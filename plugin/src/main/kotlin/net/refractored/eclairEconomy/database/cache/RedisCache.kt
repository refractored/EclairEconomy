package net.refractored.eclairEconomy.database.cache

import com.github.benmanes.caffeine.cache.RemovalCause

class RedisCache<K : Any, V : Any>(
    val client: Nothing,
    onRemove: suspend (key: K, value: V, cause: RemovalCause) -> Unit,
    onCompute: suspend (key: K) -> V
) : Cache<K, V> {

    override suspend fun get(key: K): V {
        TODO()
    }

    override suspend fun set(key: K, value: V) {
        TODO()
    }

    override suspend fun remove(key: K) {
        TODO()
    }
}
