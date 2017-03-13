package com.slt.poker.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.slt.poker.service.ProperReader1;
import com.slt.poker.service.ProperReader2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-base.xml" })
public class PropertyTest {
//	@Value("${jdbc.url}")
//	@Value("#{constSetting.url_" + 3 + "}")
//	private String url;
//	
	@Value("${templete.msg_url}")
	private String username;
	
//	@Autowired
//	private ProperReader1 reader1;
//	@Autowired
//	private ProperReader2 reader2;

	@Test
	public void test1() {
//		System.out.println(this.url);
		System.out.println(this.username);
//		this.reader1.say();
//		this.reader2.say();
	}
}
