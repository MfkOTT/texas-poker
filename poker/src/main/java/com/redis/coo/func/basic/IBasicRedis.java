package com.redis.coo.func.basic;

import java.util.List;

import com.redis.coo.func.RedisScanResult;

/**
 * redis的各种基本操作接口
 * 
 * @author maoyl05
 */
public interface IBasicRedis {

	/**
	 * 传入一个key值，删除在redis中的缓存的数据。
	 * 
	 * @param key
	 * @return 被删除 key 的数量。
	 * @throws Exception
	 */
	public Long del(String key) throws Exception;

	/**
	 * 判断指定键key是否存在
	 * 
	 * @param key
	 * @return 若 key 存在，返回 true ，否则返回 false。
	 * @throws Exception
	 */
	public Boolean exists(String key) throws Exception;
	
	/**
	 * 以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)。
	 * 
	 * @param key
	 * @return 当 key 不存在时，返回 -2 。<br>
	 * 当 key 存在但没有设置剩余生存时间时，返回 -1 。<br>
	 * 否则，以秒为单位，返回 key 的剩余生存时间。
	 * @throws Exception
	 */
	public Long ttl(String key) throws Exception;

	/**
	 * 设置一个key的过期时间(单位:秒)
	 * 
	 * @param key
	 * @param seconds
	 * @return 设置成功返回 1 。当 key 不存在或者不能为 key 设置生存时间时返回 0 。
	 * @throws Exception
	 */
	public Long expire(String key, int seconds) throws Exception;

	/**
	 * 获取key对应的string值,如果key不存在返回 nil。
	 * 
	 * @param key
	 * @return key对应的string值,如果key不存在返回 nil。
	 * @throws Exception
	 */
	public String get(String key) throws Exception;

	/**
	 * 返回所有(一个或多个)给定 key 的值<br>
	 * 如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。因此，该命令永不失败。
	 * 
	 * @param keys
	 * @return 一个包含所有给定 key 的值的列表。
	 * @throws Exception
	 */
	public List<String> mget(String... keys) throws Exception;

	/**
	 * 设置key的值，并返回 key的旧值。
	 * 
	 * @param key
	 * @param value
	 * @return 返回给定 key 的旧值。当 key 不存在时，返回 nil。
	 * @throws Exception
	 */
	public String getSet(String key, String value) throws Exception;

	/**
	 * 设置key对应的值为 string类型的value。
	 * 
	 * @param key
	 * @param value
	 * @return 设置成功时返回 OK
	 * @throws Exception
	 */
	public String set(String key, String value) throws Exception;

	/**
	 * 设置key对应的值为 string类型的value，并指定此键值对应的有效期(以秒为单位)
	 * 
	 * @param key
	 * @param seconds
	 * @param value
	 * @return 设置成功时返回 OK。当 seconds 参数不合法时，返回一个错误。
	 * @throws Exception
	 */
	public String setex(String key, int seconds, String value) throws Exception;
	
	/**
	 * 将 key 的值设为 value ，当且仅当 key 不存在。
	 * 若给定的 key 已经存在，则 SETNX 不做任何动作。
	 * 
	 * @param key
	 * @param value
	 * @return 设置成功，返回 1 。设置失败，返回 0 。
	 * @throws Exception
	 */
	public Long setnx(String key, String value) throws Exception;
	
	/**
	 * 将 key 中储存的数字值增一
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @return 执行 INCR 命令之后 key 的值
	 * @throws Exception
	 */
	public Long incr(String key) throws Exception;

	/**
	 * 将 key 所储存的值加上增量 increment 。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @param increment
	 * @return 加上 increment 之后， key 的值。
	 * @throws Exception
	 */
	public Long incrBy(String key, long increment) throws Exception;
	
	/**
	 * 将 key 中储存的数字值减一。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECR 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @return 执行 DECR 命令之后 key 的值。
	 * @throws Exception
	 */
	public Long decr(String key) throws Exception;

	/**
	 * 将 key 所储存的值减去减量 decrement 。
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作。
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @param decrement
	 * @return 减去 decrement 之后， key 的值。
	 * @throws Exception
	 */
	public Long decrBy(String key, long decrement) throws Exception;
	
	/**
	 * 对缓存中的所有key进行随机遍历，可指定模糊匹配值{match}，可指定返回个数{count}
	 * <br>
	 *  <ul>{cursor}是当前遍历开始的偏移量，第一次传0</ul>
	 * 	<ul>如果不指定{match}将对所有的key进行遍历，不推荐如此</ul>
	 *  <ul>如果不指定{count}默认将获得10个</ul>
	 * </br>
	 * 
	 * @param cursor 当前偏移量，第一次是0，之后用返回值，不可随意指定
	 * @param match 模糊匹配值，例如“test*”，“*test*”
	 * @param count 返回个数，不指定则默认10
	 * @return
	 * @throws Exception
	 *
	 * @author maoyl05
	 * @date 2016年9月5日
	 */
	public RedisScanResult<String> scan(final int cursor, final String match, final int count) throws Exception;

	/**
	 * 监听一个key
	 * 
	 * @param key
	 * @throws Exception
	 */
	public String watch(String key) throws Exception;

	String hget(String key, String field) throws Exception;
}
