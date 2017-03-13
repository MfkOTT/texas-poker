package com.slt.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.slt.base.context.ErrMsgContext;

/**
 * 统一构造返回消息体
 * 
 * @author maoyl05
 *
 */
public class RspUtil {
	
	public static final String DECRYPT_ERROR = "nil";
	/**
	 * 构建返回报文结构体
	 * 
	 * @param rspCode
	 * @param info
	 * @return json对象
	 */
	public static <T extends JSON> JSONObject build(String code, String info) {
		JSONObject j = new JSONObject();
		JSONObject jb = new JSONObject();
		jb.put("code", code);
		jb.put("message", info);
		j.put("systemMsg", jb);
		return j;
	}
	/**
	 * 构建返回报文结构体
	 * 
	 * @param rspCode
	 * @param info
	 * @return json对象
	 */
	public static <T extends JSON> JSONObject build(long rspCode) {
		JSONObject j = new JSONObject();
		JSONObject jb = new JSONObject();
		jb.put("code", rspCode);
		jb.put("message", ErrMsgContext.getErrMsg("SYS_ERR_" + rspCode));
		j.put("systemMsg", jb);
		return j;
	}
}
