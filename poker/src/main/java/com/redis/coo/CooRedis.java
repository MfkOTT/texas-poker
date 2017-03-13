package com.redis.coo;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import com.redis.coo.func.ICooHandle;
import com.redis.coo.trans.ITransHandle;
import com.redis.coo.trans.Lock;

/**
 * redis的操作支配类
 * 
 * @author maoyl05
 *
 */
public class CooRedis {
	private static JedisPool jedisPool;

	// 单例构造函数
	private CooRedis() {
		jedisPool = JedisPoolManager.getInstance();
	}

    // 使用单实例模式
    private static class LazyHolder {
        private static final CooRedis INSTANCE = new CooRedis();
    }
	
    /**
     * 获取当前实例
     * 
     * @return 当前实例
     */
    public static CooRedis getInstance() {
        return LazyHolder.INSTANCE;
    }
    
    // 构造加锁键
    private String linkLockKey(String[] keys) {
		StringBuilder sb = new StringBuilder();
		for (String k : keys) {
			sb.append(k).append("#");
		}
		sb.deleteCharAt(sb.length() - 1);
		return "Lock:" + sb.toString();
    }
    
	/**
	 * 事务执行操作
	 * 
	 * @param keys 事务关联keys
	 * @param timeout 循环获取锁的等待超时时间（毫秒），在此时间内会一直尝试获取锁直到超时，为0表示失败后直接返回不等待
	 * @param expire 当前锁的生存时间（秒），必须大于0，如果超过生存时间锁仍未被释放，则系统会自动强制释放
	 * @param interval 获取锁失败后挂起再试的时间间隔（毫秒），必须大于0
	 * @param th 事务操作
	 * @return 事务操作的执行结果集合，或者null
	 * @throws Exception
	 */
	public List<Object> execTrans(String[] keys, int timeout, int expire, int interval, ITransHandle th) throws Exception {
		if (null == keys || 0 == keys.length || 0 > timeout || 0 >= expire || 0 > interval || null == th) {
			return null;
		}
		List<Object> rst = null;
		Jedis jedis = null;
		try {
			// 从池中获取一个Jedis对象
			jedis = jedisPool.getResource();
			// 获取事务锁
			String lockKey = linkLockKey(keys);
			// 第1关：加锁，机制可以过滤掉90%的冲突
			String lockVal = Lock.lock(lockKey, timeout, expire, interval);
			if (null != lockVal) {
				// 第2关：防止锁被盗，90%
				jedis.watch(lockKey);
				jedis.watch(keys);
				// 第3关：安全检查，事务打开前的必要检查，90%
				// 第4关：再次校验锁是否被盗，90%
				if (null != jedis.get(lockKey) && lockVal.equals(jedis.get(lockKey)) && th.check(jedis)) {
					Transaction tx = jedis.multi();
					th.handle(tx);
					rst = tx.exec();
				} else {
					jedis.unwatch();
				}
				// 事务完成后要解锁
				Lock.unlock(lockKey);
			}
		} catch (Exception e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			throw new Exception("transaction exec exception >> " + e.getMessage() + " >> " + trace.toString());
		} finally {
			if (null != jedis) {
				// 释放对象池
				jedisPool.returnResource(jedis);
			}
		}
		return rst;
	}
	
	/**
	 * redis执行普通操作
	 * 
	 * @param ch
	 * @return 普通操作执行结果
	 * @throws Exception
	 */
	public Object execFunc(ICooHandle ch) throws Exception {
		Object rst = null;
		Jedis jedis = null;
		try {
			// 从池中获取一个Jedis对象
			jedis = jedisPool.getResource();
			rst = ch.handle(jedis);
		} catch (Exception e) {
			throw new Exception("func exec exception >> " + e.getMessage());
		} finally {
			if (null != jedis) {
				// 释放对象池
				jedisPool.returnResource(jedis);
			}
		}
		return rst;
	}
}
