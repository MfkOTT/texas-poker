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
@RequestMapping(value="/player")
public class PlayerController {
	@Autowired
	private UserService userService;
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/profit", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="手牌盈利")
	public JSONObject getCardProfit(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "007";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
		if(StringUtils.isEmpty(reqJson.getString("clubId"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(reqJson.getString("playerId"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(reqJson.getIntValue("blindType"))){
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
			return this.playerService.getCardProfit(checkJson.getString("loginId"),reqJson.getString("clubId"),reqJson.getString("playerId"),reqJson.getIntValue("blindType"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/ranking", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="盈利排行榜")
	public JSONObject getPlayerProfitList(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "006";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
		if(StringUtils.isEmpty(reqJson.getString("clubId"))){
			return RspUtil.build("fail","参数缺失");
		}
		if(StringUtils.isEmpty(reqJson.getIntValue("blindType"))){
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
			return this.playerService.getPlayerProfitList(checkJson.getString("loginId"),reqJson.getString("clubId"),reqJson.getIntValue("blindType"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/kpi", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="对局指标")
	public JSONObject getPlayerKpi(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "004";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
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
			return this.playerService.getPlayerKpi(checkJson.getString("loginId"),reqJson.getString("clubId"),reqJson.getIntValue("blindType"),reqJson.getString("playerId"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
	@RequestMapping(value = "/position", method = RequestMethod.POST)
	@ResponseBody
	@SystemControllerLog(description="起手牌入池位置统计")
	public JSONObject getCardPosition(@RequestBody JSONObject paramJson) throws Exception{
		final String operationCode = "008";
		String param = paramJson.getString("param");
		JSONObject reqJson = JSONObject.parseObject(param);
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
			return this.playerService.getCardPosition(checkJson.getString("loginId"),reqJson.getString("clubId"),reqJson.getIntValue("blindType"),reqJson.getString("playerId"),operationCode);
		} catch (Exception e) {
			throw e;
		}
	}
}
