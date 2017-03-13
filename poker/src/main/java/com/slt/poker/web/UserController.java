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
import com.slt.poker.service.PlayerService;
import com.slt.poker.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PlayerService playerService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="用户登录")
	public JSONObject login(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "001";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
		if(StringUtils.isEmpty(reqJson.getString("deviceId"))){
			return RspUtil.build("fail","设备号为空");
		}
		JSONObject userJson = reqJson.getJSONObject("userInfo");
		if(StringUtils.isEmpty(userJson.getString("loginId"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(userJson.getString("passWord"))){
			return RspUtil.build("fail","参数缺失");
		}
		try {
			return userService.login(reqJson.getString("deviceId"),userJson.getString("loginId"),userJson.getString("passWord"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="修改密码")
	public JSONObject modifyPwd(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "002";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
		if(StringUtils.isEmpty(reqJson.getString("oldPwd"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(reqJson.getString("newPwd"))){
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
			return this.userService.saveUpdatePwd(checkJson.getString("loginId"),reqJson.getString("oldPwd")
					,reqJson.getString("newPwd"));
		} catch (Exception e) {
			throw e;
		}
	}
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="初始化用户信息")
	public JSONObject getUserInfo(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "999";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
		JSONObject loginJson = reqJson.getJSONObject("loginInfo");
		if(null == loginJson){
			return RspUtil.build("fail","登录信息有误");
		}
		try {
			JSONObject checkJson = this.userService.checkLonginInfo(loginJson.getString("userToken"),loginJson.getString("deviceId"),operationCode);
			if(0 != checkJson.getIntValue("flag")){
				return 1 == checkJson.getIntValue("flag") ? RspUtil.build("fail","登录信息验证失败") : RspUtil.build("timeout","凭证失效");	
			}
			return this.userService.findUserInfo(checkJson.getString("loginId"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
	@RequestMapping(value = "/kpi", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="数据报表")
	public JSONObject getMyselfKpi(@RequestBody JSONObject reqJson) throws Exception{
		final String operationCode = "004";
		if(StringUtils.isEmpty(reqJson.getString("clubId"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(reqJson.getIntValue("blindType"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(reqJson.getIntValue("playerId"))){
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
			return this.playerService.getMyselfKpi(checkJson.getString("loginId"),reqJson.getString("clubId"),reqJson.getIntValue("blindType"),reqJson.getString("playerId"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
}
