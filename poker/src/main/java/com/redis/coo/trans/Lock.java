package com.redis.coo.trans;

import com.redis.coo.func.basic.BasicCooRedis;


/**
 * 保证事务执行的锁操作
 * 
 * @author maoyl05
 *
 */
public final class Lock {
	
	/**
	 * 事务加锁操作
	 * 
	 * @param lockKey 创建的锁key
	 * @param timeout 循环获取锁的等待超时时间（毫秒），在此时间内会一直尝试获取锁直到超时，为0表示失败后直接返回不等待
	 * @param expire 当前锁的生存时间（秒），必须大于0，如果超过生存时间锁仍未被释放，则系统会自动强制释放
	 * @param interval 获取锁失败后挂起再试的时间间隔（毫秒），必须大于0
	 * @return lockVal 加锁的值
	 * @throws Exception
	 */
	public static String lock(String lockKey, int timeout, int expire, int interval) throws Exception {
		if (0 >= expire || 0 > interval) {
			return null;
		}
		if (null == lockKey || "".equals(lockKey)) {
			return null;
		}
		long ctm = System.currentTimeMillis(); // 当前时间数
		String lockVal = String.valueOf(ctm + expire * 1000); // 锁val
		long timeoutAt = ctm + timeout; // 超时时间数
		while (true) {
			// 1-setnx一个值，值为当前时间后expire秒的毫秒数
			Long setnxRst = new BasicCooRedis().setnx(lockKey, lockVal);
			if (null != setnxRst && 1 == setnxRst) {
				// 设值成功，检查成功，可以开启事务
				// 设置lockKey的失效时间expire秒，防止死锁
				new BasicCooRedis().expire(lockKey, expire);
				return lockVal;
			}
			// 2-如果设置lockKey失败，则判断剩余生存时间：秒
			Long ttlSec = new BasicCooRedis().ttl(lockKey);
			// ttlSec小于0 表示lockKey上没有设置生存时间（lockKey是不会不存在的，因为前面setnx会自动创建）
			// 这时可以直接设置expire时间并使用当前锁（？多线程在这里是否有问题）
			if (null != ttlSec && 0 > ttlSec) {
				// 设置成功时返回 OK
				String rstEx = new BasicCooRedis().setex(lockKey, expire, lockVal);
				if (null != rstEx && "OK".equals(rstEx)) {
					return lockVal;
				}
			}
			
			// 3-如果不设置等待时间或等待时间已经超过，则退出
			if (timeout <= 0 || timeoutAt < System.currentTimeMillis()) break;
			
			// 4-设置间隔时间
			Thread.sleep(interval);
		}
		return null;
	}
	
	/**
	 * 为指定的事务解锁
	 * 
	 * @param lockKey
	 * @throws Exception
	 */
	public static void unlock(final String lockKey) throws Exception {
		Boolean existFlag = new BasicCooRedis().exists(lockKey);
		if (null != existFlag && existFlag) {
			new BasicCooRedis().del(lockKey);
		}
	}
}
