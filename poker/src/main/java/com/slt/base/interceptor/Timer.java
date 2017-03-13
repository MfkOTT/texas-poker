package com.slt.base.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.slt.base.utils.PropertyUtil;
import com.slt.base.utils.RspUtil;
import com.slt.base.utils.SimpleDateUtil;

/**
 * @ClassName: Timer
 * @Description: 计时器，控制活动时间
 * @author t-zhoushijie
 * @date: 2016年11月28日
 * @version V1.0
 */
public class Timer extends HandlerInterceptorAdapter{
	/** 日志对象 */
	private static final Logger log = LoggerFactory.getLogger(Timer.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		Long begin = SimpleDateUtil.parse(PropertyUtil.getConstants("beginTime"), "yyyyMMddHHmmssSSS").getTime();
		Long end = SimpleDateUtil.parse(PropertyUtil.getConstants("endTime"), "yyyyMMddHHmmssSSS").getTime();
		Long nowTime = new Date().getTime();
//		if(nowTime<begin){
//			log.error("==活动未开始==");
//			this.write(response, RspUtil.build(5000).toJSONString());
//			return false;
//		}
		if(nowTime>end){
			log.error("==活动已结束==");
			this.write(response, RspUtil.build(5001).toJSONString());
			return false;
		}
		return true;
	}
	/**
	 * @Title: write
	 * @Description: 回写数据
	 * @param out
	 * @param rspDoc 要回写的数据
	 */
	private void write(HttpServletResponse response, String rspDoc) {
		log.info("==write()运行==" + rspDoc);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			log.error("==根据response获取PrintWriter出错==" + e);
		}
		if (out != null && rspDoc != null) {
			// 记录接口日志
			out.println(rspDoc);
			out.flush();
			out.close();
		}
	}
}
