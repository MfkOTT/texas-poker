package com.slt.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.slt.base.aop.SystemControllerLog;
import com.slt.base.utils.RspUtil;

/**
 * 处理公共请求
 * 
 * @author maoyl05
 *
 */
@Controller
public class CommonController {
	private static final long ACCESS_ERR_CODE = 400;
	private static final long SYS_EXCEPTION_CODE = 500;
	
	/**
	 * 响应业务级异常处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/error/sysException", method = {RequestMethod.GET,
			RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@ResponseBody
	public JSONObject sysExceptionShow() {
		return RspUtil.build(SYS_EXCEPTION_CODE);
	}
	
	/**
	 * 响应系统默认异常处理
	 * 
	 * @param errCode
	 * @return
	 */
	@RequestMapping(value = "/error/{errCode:[\\d]+}", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject errShow(@PathVariable long errCode) {
		return RspUtil.build(errCode);
	}
	
	/**
	 * 响应默认请求
	 * 
	 * @return
	 */
	@RequestMapping(value = "/")
	@ResponseBody
	public JSONObject access() {
		return RspUtil.build(ACCESS_ERR_CODE);
	}
	
	@RequestMapping(value = "/toPage/{toPage}", method = RequestMethod.GET)
	@SystemControllerLog(description = "注册抽奖账户")
	public String toHtml(@PathVariable String toPage) throws Exception{
		return toPage;
	}
}
