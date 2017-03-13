package com.redis.coo.func.list;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

import com.redis.coo.CooRedis;
import com.redis.coo.func.ICooHandle;

public class ListCooRedis implements IListRedis {

	/* (non-Javadoc)
	 * @see com.redis.coo.func.list.IListRedis#llen(java.lang.String)
	 */
	@Override
	public Long llen(final String key) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.llen(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.list.IListRedis#lpop(java.lang.String)
	 */
	@Override
	public String lpop(final String key) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.lpop(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.list.IListRedis#lpush(java.lang.String, java.lang.String[])
	 */
	@Override
	public Long lpush(final String key, final String... values) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.lpush(key, values);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.list.IListRedis#rpop(java.lang.String)
	 */
	@Override
	public String rpop(final String key) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.rpop(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.list.IListRedis#rpush(java.lang.String, java.lang.String[])
	 */
	@Override
	public Long rpush(final String key, final String... values) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.rpush(key, values);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.redis.coo.func.list.IListRedis#lrange(java.lang.String, long, long)
	 */
	@Override
	public List<String> lrange(final String key, final long start, final long stop) throws Exception {
		final List<String> vs = new ArrayList<String>();
		CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				List<String> lr = jedis.lrange(key, start, stop);
				vs.addAll(lr);
				return lr;
			}
		});
		return vs;
	}

}
