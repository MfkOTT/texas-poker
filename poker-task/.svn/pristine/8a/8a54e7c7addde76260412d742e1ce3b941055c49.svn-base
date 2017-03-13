package com.slt.poker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySources(value = { @PropertySource("classpath:const.properties") })
public class ProperReader1 {
	@Value("${templete_msg_url}")
	private String mongodbUrl;

	//To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public void say() {
		System.out.println(this.mongodbUrl);
	}
}
