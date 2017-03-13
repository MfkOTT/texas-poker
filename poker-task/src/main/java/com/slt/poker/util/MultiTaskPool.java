package com.slt.poker.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 构造多线程执行队列对象
 *
 * @date 2016年8月11日
 */
public class MultiTaskPool {
	// 执行任务的线程池
	private static ExecutorService executor = null;

	// 使用单实例模式
	private static class LazyHolder {
		private static final MultiTaskPool INSTANCE = new MultiTaskPool();
	}

	// 获取当前实例
	public static final MultiTaskPool getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * @Description: 构造函数
	 * 
	 */
	private MultiTaskPool() {
		// 线程池
		executor = Executors.newFixedThreadPool(500);
	}
	
	/**
	 * 线程池执行任务方法
	 * 
	 * @param job 可被执行的任务信息
	 */
	public void executeJob(Runnable job) {
		executor.execute(job);
	}
}
