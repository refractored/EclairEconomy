package net.refractored.eclairEconomy.database.cache

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.RemovalCause
import com.sksamuel.aedile.core.LoadingCache
import com.sksamuel.aedile.core.asLoadingCache
import com.sksamuel.aedile.core.expireAfterAccess
import com.sksamuel.aedile.core.expireAfterWrite
import com.sksamuel.aedile.core.withRemovalListener
import kotlin.time.Duration

class InternalCache<K : Any, V : Any>(
    maxSize: Long,
    expireAfterAccess: Duration,
    expireAfterWrite: Duration,
    onRemove: suspend (key: K, value: V, cause: RemovalCause) -> Unit,
    onCompute: suspend (key: K) -> V
) : Cache<K, V> {
    val cache: LoadingCache<K, V> = Caffeine
        .newBuilder()
        .expireAfterAccess(expireAfterAccess)
        .expireAfterWrite(expireAfterWrite)
        .withRemovalListener { key, value, cause ->
            onRemove(key as K, value as V, cause)
        }
        .maximumSize(maxSize)
        .asLoadingCache<K, V> {
            onCompute(it)
        }

    override suspend fun get(key: K): V = cache.get(key)

    override suspend fun set(key: K, value: V) {
        cache.put(key, value)
    }

    override suspend fun remove(key: K) {
        cache.invalidate(key)
    }
}
