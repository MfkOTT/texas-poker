package com.redis.coo.func.list;

import java.util.List;

/**
 * redis集合操作
 * 
 * @author maoyl05
 * 
 */
public interface IListRedis {
	/**
	 * 返回列表 key 的长度<br>
	 * 如果 key 不存在，则 key 被解释为一个空列表，返回 0<br>
	 * 如果 key 不是列表类型，返回一个错误
	 * 
	 * @param key
	 * @return 列表 key 的长度
	 * @throws Exception
	 */
	public Long llen(String key) throws Exception;

	/**
	 * 移除并返回列表 key 的头元素<br>
	 * 左出栈，并返回出栈的值
	 * 
	 * @param key
	 * @return 列表的头元素。当 key 不存在时，返回 nil。
	 * @throws Exception
	 */
	public String lpop(String key) throws Exception;

	/**
	 * 将一个或多个值 value 插入到列表 key 的表头<br>
	 * 如果有多个 value 值，那么各个 value 值按从左到右的顺序依次插入到表头：左入栈。 <br>
	 * 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误。
	 * 
	 * @param key
	 * @param values
	 * @return 执行 LPUSH 操作后，列表 key 长度
	 * @throws Exception
	 */
	public Long lpush(String key, String... values) throws Exception;
	
	/**
	 * 移除并返回列表 key 的尾元素<br>
	 * 右出栈，并返回出栈的值
	 * 
	 * @param key
	 * @return 列表的尾元素。当 key 不存在时，返回 nil。
	 * @throws Exception
	 */
	public String rpop(String key) throws Exception;

	/**
	 * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。<br>
	 * 如果有多个 value 值，那么各个 value 值按从左到右的顺序依次插入到表尾
	 * 
	 * @param key
	 * @param values
	 * @return 执行 RPUSH 操作后，列表的长度。
	 * @throws Exception
	 */
	public Long rpush(String key, String... values) throws Exception;
	
	/**
	 * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。<br>
	 * 下标(index)参数 start 和 stop 都以 0 为底。<br>
	 * 可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。<br>
	 * 超出范围的下标值不会引起错误。<br>
	 * 如果 start 下标比列表的最大下标 end ( LLEN list 减去 1 )还要大，那么 LRANGE 返回一个空列表。<br>
	 * 如果 stop 下标比 end 下标还要大，Redis将 stop 的值设置为 end 。
	 * 
	 * @param key
	 * @param start
	 * @param stop
	 * @return 一个列表，包含指定区间内的元素。
	 * @throws Exception
	 */
	public List<String> lrange(String key, long start, long stop) throws Exception;
}
