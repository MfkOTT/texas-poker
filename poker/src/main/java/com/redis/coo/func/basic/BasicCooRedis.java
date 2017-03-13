package com.redis.coo.func.basic;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import com.redis.coo.CooRedis;
import com.redis.coo.func.ICooHandle;
import com.redis.coo.func.RedisScanResult;

/**
 * redis的各种基本操作接口
 * 
 * @author maoyl05
 *
 */
public class BasicCooRedis implements IBasicRedis {
	
	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#del(java.lang.String)
	 */
	@Override
	public Long del(final String key) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.del(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#exists(java.lang.String)
	 */
	@Override
	public Boolean exists(final String key) throws Exception {
		return (Boolean) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.exists(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#expire(java.lang.String, int)
	 */
	@Override
	public Long expire(final String key, final int seconds) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.expire(key, seconds);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#get(java.lang.String)
	 */
	@Override
	public String get(final String key) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.get(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#mget(java.lang.String[])
	 */
	@Override
	public List<String> mget(final String... keys) throws Exception {
		final List<String> vs = new ArrayList<String>();
		CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				for (String key : keys) {
					vs.add(jedis.get(key));
				}
				return vs;
			}
		});
		return vs;
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#getSet(java.lang.String, java.lang.String)
	 */
	@Override
	public String getSet(final String key, final String value) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.getSet(key, value);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#set(java.lang.String, java.lang.String)
	 */
	@Override
	public String set(final String key, final String value) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.set(key, value);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#setex(java.lang.String, int, java.lang.String)
	 */
	@Override
	public String setex(final String key, final int seconds, final String value) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.setex(key, seconds, value);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#incr(java.lang.String)
	 */
	@Override
	public Long incr(final String key) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.incr(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#incrBy(java.lang.String, long)
	 */
	@Override
	public Long incrBy(final String key, final long increment) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.incrBy(key, increment);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#decr(java.lang.String)
	 */
	@Override
	public Long decr(final String key) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.decr(key);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#decrBy(java.lang.String, long)
	 */
	@Override
	public Long decrBy(final String key, final long decrement) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.decrBy(key, decrement);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#setnx(java.lang.String, java.lang.String)
	 */
	@Override
	public Long setnx(final String key, final String value) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.setnx(key, value);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.redis.coo.func.basic.IBasicRedis#ttl(java.lang.String)
	 */
	@Override
	public Long ttl(final String key) throws Exception {
		return (Long) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.ttl(key);
			}
		});
	}

	@Override
	public RedisScanResult<String> scan(final int cursor, final String match, final int count) throws Exception {
		if (count <= 0) return null;
		ScanResult<String> sr = (ScanResult<String>) CooRedis.getInstance().execFunc(new ICooHandle() {			
			@Override
			public ScanResult<String> handle(Jedis jedis) {
				ScanParams scanParams = new ScanParams();
				int curs = cursor > 0 ? cursor : 0;
				if (null != match) {
					scanParams.match(match);
				}
				scanParams.count(count);
				return jedis.scan(String.valueOf(curs), scanParams);
			}
		});
		RedisScanResult<String> rsr = new RedisScanResult<String>();
		rsr.setResults(sr.getResult());
		rsr.setCursor(Integer.parseInt(sr.getStringCursor()));
		return rsr;
	}

	@Override
	public String watch(final String key) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.watch(key);
			}
		});
	}
	
	@Override
	public String hget(final String key, final String field) throws Exception {
		return (String) CooRedis.getInstance().execFunc(new ICooHandle() {
			@Override
			public Object handle(Jedis jedis) {
				return jedis.hget(key,field);
			}
		});
	}

	
}
