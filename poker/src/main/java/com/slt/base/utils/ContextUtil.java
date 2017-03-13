package com.slt.base.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ContextUtil {
	/**容器上下文对象*/
	private static WebApplicationContext wac = null;
	/** @Title: initContext
	 * @Description: 初始化容器上下文
	 * @return
	 */
	private static WebApplicationContext initContext() {
		if (null == wac) {
			wac = ContextLoader.getCurrentWebApplicationContext();
		}
		return wac;
	}
	/**
	 * @Title: getBeanFromContainer
	 * @Description: 从web容器中获取bean
	 * @param <T>
	 * @param beanName bean名称
	 * @param requiredType 返回值类型
	 * @return
	 */
	public static <T> T getBeanFromContainer(String beanName, Class<T> requiredType) {
		return initContext().getBean(beanName, requiredType);
	}
}
