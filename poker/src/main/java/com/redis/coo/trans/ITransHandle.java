package com.redis.coo.trans;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * redis的事务操作接口
 * 
 * @author maoyl05
 */
public abstract class ITransHandle {
	
	/** 事务对象 */
	protected Transaction tx = null;
	
	/** jedis对象 */
	protected Jedis jedis = null;

	/**
	 * 事务操作执行
	 * 
	 * @param tx
	 * @throws Exception
	 */
	public final void handle(Transaction tx) {
		this.tx = tx;
		handle();
	}
	
	/**
	 * 事务操作执行前的检查
	 * 
	 * @param jedis
	 * @return true：可执行事务/false：不执行事务
	 */
	public final boolean check(Jedis jedis) {
		this.jedis = jedis;
		return check();
	}

	/**
	 * 事务操作执行
	 */
	protected abstract void handle();

	/**
	 * 事务操作执行前的检查
	 * 
	 * @return true：可执行事务/false：不执行事务
	 */
	protected abstract boolean check();
}
