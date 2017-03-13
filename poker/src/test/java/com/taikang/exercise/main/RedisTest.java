//package com.taikang.exercise.main;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.taikang.lottery.context.RedisClientTemplate;
//import com.taikang.lottery.context.RedisScanResult;
//
///**
// * 多数据源测试服务接口测试
// * 
// * @author maoyl05
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:context-base.xml","classpath:context-db.xml","classpath:context-nosql.xml" })
//public class RedisTest {
//	
//	@Autowired
//	private RedisClientTemplate redisClientTemplate;
//	
////	@Test
//	public void testSadd() {
//		try {
//			this.redisClientTemplate.sadd("mao:set", "a", "b", "c", "d", "e", "f", "g");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
////	@Test
//	public void testSdel() {
//		try {
//			this.redisClientTemplate.srem("mao:set", "a", "b", "c");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
////	@Test
////	public void testScan() {
////		try {
////			int cursor = 0;
////			do {
////				RedisScanResult<String> result = redisClientTemplate.sscan("mao:set", cursor, null, 10);
////				for (String e : result.getResults()) {
////					System.out.print(e);
////				}
////				System.out.println("====");
////				cursor = result.getCursor();
////			} while (cursor > 0);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////	}
//}
