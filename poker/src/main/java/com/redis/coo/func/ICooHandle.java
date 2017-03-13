package com.redis.coo.func;

import redis.clients.jedis.Jedis;

/**
 * redis的常规操作接口
 * 
 * @author maoyl05
 */
public interface ICooHandle {
	/**
	 * 常规操作接口
	 * 
	 * @param jedis
	 * @return 常规操作结果
	 */
	public Object handle(Jedis jedis);
}
