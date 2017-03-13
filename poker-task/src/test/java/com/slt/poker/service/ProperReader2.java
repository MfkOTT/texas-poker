package com.slt.poker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySources(value = { @PropertySource("classpath:const.properties") })
public class ProperReader2 {
	@Autowired
	private Environment env;

	public void say() {
		System.out.println(env.getProperty("mongodb.url"));
	}
}
