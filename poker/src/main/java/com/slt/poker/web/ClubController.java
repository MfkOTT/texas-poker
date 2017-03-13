package com.slt.poker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.slt.base.aop.SystemControllerLog;
import com.slt.base.utils.RspUtil;
import com.slt.poker.service.ClubService;
import com.slt.poker.service.UserService;

@Controller
@RequestMapping(value="/club")
public class ClubController {
	@Autowired
	private UserService userService;
	@Autowired
	private ClubService clubService;
	
	@RequestMapping(value = "/player/list", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="获取俱乐部人员")
	public JSONObject getClubPlayerList(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "005";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
		if(StringUtils.isEmpty(reqJson.getString("clubId"))){
			return RspUtil.build("fail","参数缺失");
		}
		JSONObject loginJson = reqJson.getJSONObject("loginInfo");
		if(null == loginJson){
			return RspUtil.build("fail","登录信息有误");
		}
		
		try {
			JSONObject checkJson = this.userService.checkLonginInfo(loginJson.getString("userToken"),loginJson.getString("deviceId"),operationCode);
			if(0 != checkJson.getIntValue("flag")){
				return 1 == checkJson.getIntValue("flag") ? RspUtil.build("fail","登录信息验证失败") : RspUtil.build("timeout","凭证失效");	
			}
			return this.clubService.ClubPlayerList(checkJson.getString("loginId"),reqJson.getString("clubId"),reqJson.getString("palyName"),operationCode);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
