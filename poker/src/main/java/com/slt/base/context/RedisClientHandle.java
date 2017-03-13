package com.slt.base.context;

import redis.clients.jedis.ShardedJedis;

/**
 * redis的常规操作接口
 * @author maoyl05
 *
 * @param <T> 返回值类型
 */
public interface RedisClientHandle<T> {
	/**
	 * 常规操作接口
	 * 
	 * @param shardedJedis
	 * @return 常规操作结果
	 */
	public T handle(ShardedJedis shardedJedis);
}
