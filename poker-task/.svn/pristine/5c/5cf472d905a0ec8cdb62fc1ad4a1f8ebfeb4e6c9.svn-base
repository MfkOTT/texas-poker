package com.slt.poker.task;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@PropertySources(value = { @PropertySource(value = { "classpath:cron.properties" }) })
@Component
public class TestTask {
	/**
	 * 每隔5秒自动执行
	 * @throws InterruptedException 
	 */
//	@Scheduled(cron = "0/5 * * * * ?")
	@Scheduled(cron = "${cron_1}")
	public void test1() throws InterruptedException {
		System.out.println("test1==start==" + System.currentTimeMillis());
		Thread.sleep(3 * 1000);
		System.out.println("test1==end==  " + System.currentTimeMillis());
	}
	
	/**
	 * @Description 每3秒自动执行
	 *
	 * @author maoyl05
	 * @throws InterruptedException 
	 * @date 2016年8月9日
	 */
//	@Scheduled(fixedRate = 3 * 1000)
	public void test2() throws InterruptedException {
		System.out.println("test2==start==" + System.currentTimeMillis());
		Thread.sleep(10 * 1000);
		System.out.println("test2==end==" + System.currentTimeMillis());
	}
	
	/**
	 * @Description 上次任务结束后2秒后再次执行
	 *
	 * @author maoyl05
	 * @throws InterruptedException 
	 * @date 2016年8月9日
	 */
//	@Scheduled(fixedDelay = 2 * 1000)
	public void test3() throws InterruptedException {
		System.out.println("test3==start==" + System.currentTimeMillis());
		Thread.sleep(3 * 1000);
		System.out.println("test3==end==" + System.currentTimeMillis());
	}
}
