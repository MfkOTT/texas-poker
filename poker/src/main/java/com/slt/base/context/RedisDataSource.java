package com.slt.base.context;

import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Component
public class RedisDataSource {
	private static final Logger log = LoggerFactory.getLogger(RedisDataSource.class);
	
	@Autowired
	private ShardedJedisPool shardedJedisPool;

	private ShardedJedis getRedisClient() {
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			log.error("getRedisClent error", e);
		}
		return null;
	}
	
	/**
	 * redis执行普通操作
	 * @param <T> 返回值类型预设
	 * 
	 * @param rc RedisClientHandle对象
	 * @return 普通操作执行结果
	 * @throws Exception
	 */
	public <T> T exec(RedisClientHandle<T> rc) throws Exception {
		T result = null;
		ShardedJedis shardedJedis = getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			// 从池中获取一个shardedJedis对象
			result = rc.handle(shardedJedis);
		} catch (Exception e) {
			StringWriter trace = new StringWriter();
			throw new Exception("func exec exception >> " + e.getMessage() + " >> " + trace.toString());
		} finally {
			shardedJedis.close();
		}
		return result;
	}
}
