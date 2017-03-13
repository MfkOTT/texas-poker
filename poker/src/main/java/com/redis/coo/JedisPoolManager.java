package com.redis.coo;

import java.util.ResourceBundle;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 连接池访问redis
 * 
 * @author maoyl05
 *
 */
public class JedisPoolManager {
	
	/**
	 * 获取连接池实例
	 * 
	 * @return JedisPool对象
	 */
	public static JedisPool getInstance() {
		return initJedisPool();
	}
	
	/**
	 * 初始化连接池
	 * 
	 * @return 初始化JedisPool对象
	 */
	private static JedisPool initJedisPool() {
		ResourceBundle bundle = ResourceBundle.getBundle("redis");
		if (null == bundle) {
			throw new IllegalArgumentException("[rediscfg.properties] is not found!");
		}
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(Integer.valueOf(bundle.getString("redis.maxTotal")));
		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.maxIdle")));
		config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.maxWaitMillis")));
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.testOnBorrow")));
		// config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
		return new JedisPool(config, bundle.getString("redis.host"), Integer.valueOf(bundle.getString("redis.port")));
	}
}
