package com.redis.coo.trans;

import java.util.List;

import redis.clients.jedis.Response;

/**
 * redis的事务操作接口
 * 
 * @author maoyl05
 *
 */
public abstract class BasicTransHandle extends ITransHandle {

	/**
	 * 传入一个key值，删除在redis中的缓存的数据。
	 * 
	 * @param key
	 * @return 被删除 key 的数量。
	 */
	public Response<Long> del(String key) {
		return tx.del(key);
	}

	/**
	 * 判断指定键key是否存在
	 * 
	 * @param key
	 * @return 若 key 存在，返回 true ，否则返回 false。
	 */
	public Response<Boolean> exists(String key) {
		return tx.exists(key);
	}

	/**
	 * 设置一个key的过期时间(单位:秒)
	 * 
	 * @param key
	 * @param seconds
	 * @return 设置成功返回 1 。当 key 不存在或者不能为 key 设置生存时间时返回 0 。
	 */
	public Response<Long> expire(String key, int seconds) {
		return tx.expire(key, seconds);
	}

	/**
	 * 获取key对应的string值,如果key不存在返回 nil。
	 * 
	 * @param key
	 * @return key对应的string值,如果key不存在返回 nil。
	 */
	public Response<String> get(String key) {
		return tx.get(key);
	}

	/**
	 * 返回所有(一个或多个)给定 key 的值<br>
	 * 如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。因此，该命令永不失败。
	 * 
	 * @param keys
	 * @return 一个包含所有给定 key 的值的列表。
	 */
	public Response<List<String>> mget(String... keys) {
		return tx.mget(keys);
	}

	/**
	 * 设置key的值，并返回 key的旧值。
	 * 
	 * @param key
	 * @param value
	 * @return 返回给定 key 的旧值。当 key 不存在时，返回 nil。
	 */
	public Response<String> getSet(String key, String value) {
		return tx.getSet(key, value);
	}

	/**
	 * 设置key对应的值为 string类型的value。
	 * 
	 * @param key
	 * @param value
	 * @return 设置成功时返回 OK
	 */
	public Response<String> set(String key, String value) {
		return tx.set(key, value);
	}

	/**
	 * 设置key对应的值为 string类型的value，并指定此键值对应的有效期(以秒为单位)
	 * 
	 * @param key
	 * @param seconds
	 * @param value
	 * @return 设置成功时返回 OK。当 seconds 参数不合法时，返回一个错误。
	 */
	public Response<String> setex(String key, int seconds, String value) {
		return tx.setex(key, seconds, value);
	}
	
	/**
	 * 将 key 中储存的数字值增一
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @return 执行 INCR 命令之后 key 的值
	 */
	public Response<Long> incr(String key) {
		return tx.incr(key);
	}
	
	/**
	 * 将 key 所储存的值加上增量 increment 。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @param increment
	 * @return 加上 increment 之后， key 的值。
	 */
	public Response<Long> incrBy(String key, long increment) {
		return tx.incrBy(key, increment);
	}
	
	/**
	 * 将 key 中储存的数字值减一。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @return 执行 DECR 命令之后 key 的值。
	 */
	public Response<Long> decr(String key) {
		return tx.decr(key);
	}
	
	/**
	 * 将 key 所储存的值减去减量 decrement 。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @param decrement
	 * @return 减去 decrement 之后， key 的值。
	 */
	public Response<Long> decrBy(String key, long decrement) {
		return tx.decrBy(key, decrement);
	}
	/**
	 * @param key
	 * @param value
	 * @return 设置成功时返回 OK
	 */
	public Response<Long> hincrBy(String key,String field, int value) {
		return tx.hincrBy(key, field, value);
	}
}
