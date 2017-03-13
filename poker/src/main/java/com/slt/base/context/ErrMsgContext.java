package com.slt.base.context;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

/**
 * 随spring容器启动读取配置文件
 * 
 * @author maoyl05
 *
 */
@Component
public class ErrMsgContext {
	private static final Logger log = LoggerFactory.getLogger(ErrMsgContext.class);

	private static Properties props_msg;
	static {
		log.info("==初始化配置文件==");
		try {
			props_msg = PropertiesLoaderUtils.loadAllProperties("errmsg.properties");
		} catch (IOException e) {
			log.error("==PropertyUtil加载资源配置信息出错==" + e);
		}
	}
	
	/**
	 * @Title: getErrMsg
	 * @Description: 读取消息配置信息
	 *
	 * @param key 消息key
	 * @return 消息内容
	 */
	public static String getErrMsg(String key) {
		return props_msg.getProperty(key);
	}
}
