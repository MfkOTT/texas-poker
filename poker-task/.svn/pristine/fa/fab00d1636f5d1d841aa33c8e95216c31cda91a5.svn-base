package com.slt.poker.context;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.ShardedJedis;

/**
 * redis集成的各种操作
 * 
 * @author maoyl05
 *
 */
@Component
public class RedisClientTemplate {
	
	@Autowired
	private RedisDataSource redisDataSource;
	
	/**
	 * 设置单个值
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String set(final String key, final String value) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<String>() {
			@Override
			public String handle(ShardedJedis shardedJedis) {
				return shardedJedis.set(key, value);
			}
		});
	}

	/**
	 * 获取单个值
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String get(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<String>() {
			@Override
			public String handle(ShardedJedis shardedJedis) {
				return shardedJedis.get(key);
			}
		});
	}

	/**
	 * 判断key是否存在
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Boolean exists(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Boolean>() {
			@Override
			public Boolean handle(ShardedJedis shardedJedis) {
				return shardedJedis.exists(key);
			}
		});
	}

	/**
	 * 在${seconds}秒后失效
	 * 
	 * @param key
	 * @param seconds 秒
	 * @return
	 * @throws Exception
	 */
	public Long expire(final String key, final int seconds) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.expire(key, seconds);
			}
		});
	}

	/**
	 * 在指定的${unixTime}秒时间点失效
	 * 
	 * @param key
	 * @param unixTime
	 * @return
	 * @throws Exception
	 */
	public Long expireAt(final String key, final long unixTime) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.expireAt(key, unixTime);
			}
		});
	}
	
	/**
	 * 在${milliseconds}毫秒后失效
	 * 
	 * @param key
	 * @param milliseconds
	 * @return
	 * @throws Exception
	 */
	public Long pexpire(final String key, final int milliseconds) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.pexpire(key, milliseconds);
			}
		});
	}
	
	/**
	 * 在指定的${millisecondsTimestamp}毫秒时间点失效
	 * 
	 * @param key
	 * @param millisecondsTimestamp
	 * @return
	 * @throws Exception
	 */
	public Long pexpireAt(final String key, final long millisecondsTimestamp) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.pexpireAt(key, millisecondsTimestamp);
			}
		});
	}

	/**
	 * 为key对应的值减去${integer}
	 * @param key
	 * @param integer
	 * @return
	 * @throws Exception
	 */
	public Long decrBy(final String key, final long integer) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.decrBy(key, integer);
			}
		});
	}

	/**
	 * 对数值型键减1
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long decr(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.decr(key);
			}
		});
	}

	/**
	 * 对数值类型键增加${integer}
	 * 
	 * @param key
	 * @param integer
	 * @return
	 * @throws Exception
	 */
	public Long incrBy(final String key, final long integer) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.incrBy(key, integer);
			}
		});
	}

	/**
	 * 对数值类型键加1
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long incr(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.incr(key);
			}
		});
	}

	/**
	 * hash单键set操作
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public Long hset(final String key, final String field, final String value) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.hset(key, field, value);
			}
		});
	}

	/**
	 * hash单键get操作
	 * @param key
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public String hget(final String key, final String field) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<String>() {
			@Override
			public String handle(ShardedJedis shardedJedis) {
				return shardedJedis.hget(key, field);
			}
		});
	}

	/**
	 * hash多键set操作
	 * @param key
	 * @param hash
	 * @return
	 * @throws Exception
	 */
	public String hmset(final String key, final Map<String, String> hash) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<String>() {
			@Override
			public String handle(ShardedJedis shardedJedis) {
				return shardedJedis.hmset(key, hash);
			}
		});
	}

	/**
	 * hash多键get操作
	 * @param key
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public List<String> hmget(final String key, final String... fields) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<List<String>>() {
			@Override
			public List<String> handle(ShardedJedis shardedJedis) {
				return shardedJedis.hmget(key, fields);
			}
		});
	}

	/**
	 * hash中对某个field进行增减操作
	 * <p>仅数值型的域</p>
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public Long hincrBy(final String key, final String field, final long value) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.hincrBy(key, field, value);
			}
		});
	}

	/**
	 * 删除键
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long del(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.del(key);
			}
		});
	}

	/**
	 * 删除hash中的field
	 * @param key
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public Long hdel(final String key, final String field) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.hdel(key, field);
			}
		});
	}

	/**
	 * 获取hash结构中所有的key及val
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> hgetAll(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Map<String, String>>() {
			@Override
			public Map<String, String> handle(ShardedJedis shardedJedis) {
				return shardedJedis.hgetAll(key);
			}
		});
	}

	/**
	 * set集合多值加入操作
	 * 
	 * @param key
	 * @param members
	 * @return
	 * @throws Exception
	 */
	public Long sadd(final String key, final String... members) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.sadd(key, members);
			}
		});
	}

	/**
	 * set集合取出所有值操作
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Set<String> smembers(final String key) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Set<String>>() {
			@Override
			public Set<String> handle(ShardedJedis shardedJedis) {
				return shardedJedis.smembers(key);
			}
		});
	}

	/**
	 * set集合移除多个元素
	 * 
	 * @param key
	 * @param members
	 * @return
	 * @throws Exception
	 */
	public Long srem(final String key, final String... members) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Long>() {
			@Override
			public Long handle(ShardedJedis shardedJedis) {
				return shardedJedis.srem(key, members);
			}
		});
	}

	/**
	 * set集合验证是否已存入
	 * 
	 * @param key
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public Boolean sismember(final String key, final String member) throws Exception {
		return redisDataSource.exec(new RedisClientHandle<Boolean>() {
			@Override
			public Boolean handle(ShardedJedis shardedJedis) {
				return shardedJedis.sismember(key, member);
			}
		});
	}
	
	/**
	 * set集合的scan操作
	 * 
	 * @param key
	 * @param cursor
	 * @param match
	 * @return
	 * @throws Exception
	 */
	public RedisScanResult<String> sscan(final String key, final int cursor, final String match, final int count) throws Exception {
		if (count <= 0) return null;
		ScanResult<String> sr = redisDataSource.exec(new RedisClientHandle<ScanResult<String>>() {
			@Override
			public ScanResult<String> handle(ShardedJedis shardedJedis) {
				ScanParams scanParams = new ScanParams();
				int curs = cursor > 0 ? cursor : 0;
				if (null != match) {
					scanParams.match(match);
				}
				scanParams.count(count);
				return shardedJedis.sscan(key, String.valueOf(curs), scanParams);
			}
		});
		RedisScanResult<String> rsr = new RedisScanResult<>();
		rsr.setResults(sr.getResult());
		rsr.setCursor(Integer.parseInt(sr.getStringCursor()));
		return rsr;
	}
}
