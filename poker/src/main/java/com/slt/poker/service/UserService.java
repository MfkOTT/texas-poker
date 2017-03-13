package com.slt.poker.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.slt.base.utils.Md5Util;
import com.slt.base.utils.OperationLogUtil;
import com.slt.base.utils.RspUtil;
import com.slt.base.utils.SimpleDateUtil;
import com.slt.poker.dao.BindInfoMapper;
import com.slt.poker.dao.DeviceMapper;
import com.slt.poker.dao.OperationLogMapper;
import com.slt.poker.dao.PokerClubMapper;
import com.slt.poker.dao.PokerPlayerMapper;
import com.slt.poker.dao.UserInfoMapper;
import com.slt.poker.dao.UserPlayerMapper;
import com.slt.poker.dao.UserTokenMapper;
import com.slt.poker.dao.UserVipMapper;
import com.slt.poker.dao.VipMapper;
import com.slt.poker.dto.BindInfo;
import com.slt.poker.dto.Device;
import com.slt.poker.dto.PokerClub;
import com.slt.poker.dto.UserInfo;
import com.slt.poker.dto.UserPlayer;
import com.slt.poker.dto.UserToken;
import com.slt.poker.dto.UserVip;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	/**token有效时间 7天*/
	private static final Long EXPIRE_TIME = 604800000L;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private DeviceMapper deviceMapper;
	@Autowired
	private UserTokenMapper userTokenMapper;
	@Autowired
	private OperationLogMapper operationLogMapper;
	@Autowired
	private UserVipMapper userVipMapper;
	@Autowired
	private VipMapper vipMapper;
	@Autowired
	private BindInfoMapper bindInfoMapper;
	@Autowired
	private PokerClubMapper pokerClubMapper;
	@Autowired
	private UserPlayerMapper userPlayerMapper;
	@Autowired
	private PokerPlayerMapper pokerPlayerMapper;
	/**
	 * @param deviceId
	 * @param loginId
	 * @param passWord
	 * @return
	 * 用户登录
	 */
	public JSONObject login(String deviceId, String loginId, String passWord, String operationCode) throws Exception{
		JSONObject dataJson = new JSONObject();
		JSONObject rspJson = new JSONObject();
		UserInfo user = userInfoMapper.findUser(loginId, passWord);
		if(user != null){
			Device device = this.deviceMapper.findDevice(deviceId);
			if(null != device && !StringUtils.isEmpty(device.getLoginID())){
				//修改或新增token
				String newToken = this.saveUserToken(loginId,deviceId);
				
				dataJson.put("code", "ok");
				dataJson.put("message", "登录成功");
				rspJson.put("systemMsg", dataJson);
				rspJson.put("userToken", newToken);
				return rspJson;
			}
			log.error("**findDevice fail**");
		}
		log.error("**findUser fail**");
		//记录日志
		OperationLogUtil.saveLog(operationLogMapper,operationCode,"登录失败",loginId,deviceId);
		
		dataJson.put("code", "fail");
		dataJson.put("message", "登录失败");
		rspJson.put("systemMsg", dataJson);
		return rspJson;
	}
	/**
	 * 修改或新增token
	 * @param loginId
	 * @param deviceId
	 * @return
	 * @throws Exception
	 */
	private String saveUserToken(String loginId,String deviceId) throws Exception{
		UserToken userToken = this.userTokenMapper.findToken(loginId);
		String newToken = Md5Util.getUuid();
		UserToken newUserToken = new UserToken();
		String time = SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss");
		String expireDt = SimpleDateUtil.format(new Date(new Date().getTime() + EXPIRE_TIME), "yyyyMMddHHmmss");
		if(null == userToken){
			newUserToken.setCreateDT(time);
			newUserToken.setDeviceID(deviceId);
			newUserToken.setExpireDT(expireDt);
			newUserToken.setLoginID(loginId);
			newUserToken.setUpdateDT(time);
			newUserToken.setUserToken(newToken);
			this.userTokenMapper.insertToken(newUserToken);
		}else{
			newUserToken.setDeviceID(deviceId);
			newUserToken.setExpireDT(expireDt);
			newUserToken.setLoginID(loginId);
			newUserToken.setUpdateDT(time);
			newUserToken.setUserToken(newToken);
			this.userTokenMapper.updateToken(newUserToken);
		}
		return newToken;
	}

	/**
	 * 验证登录信息
	 * @param userToken
	 * @param deviceId
	 * @return
	 * @throws Exception 
	 */
	public JSONObject checkLonginInfo(String userToken, String deviceId,String operationCode) throws Exception {
		UserToken token = this.userTokenMapper.findByTokenAndDeviceId(userToken, deviceId);
		JSONObject rspJson = new JSONObject();
		if(null != token){
			if(SimpleDateUtil.parse(token.getExpireDT(), "yyyyMMddHHmmss").getTime() > new Date().getTime()){
				rspJson.put("flag", 0);
				rspJson.put("loginId", token.getLoginID());
				return rspJson;
			}else{
				//记录日志
				OperationLogUtil.saveLog(operationLogMapper,operationCode,"token is invalid",token.getLoginID(),deviceId);
				rspJson.put("flag", 2);
			}
		}
		OperationLogUtil.saveLog(operationLogMapper,operationCode,"token is null",null,deviceId);
		rspJson.put("flag", 1);
		return rspJson;
	}

	/**
	 * 修改密码
	 * @param userToken
	 * @param deviceId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public JSONObject saveUpdatePwd(String loginId,String oldPwd, String newPwd) {
		UserInfo user = this.userInfoMapper.findUser(loginId, oldPwd);
		if(null == user){
			return RspUtil.build("fail", "原密码错误");
		}
		UserInfo newUser = new UserInfo();
		newUser.setLoginID(loginId);
		newUser.setPassWord(newPwd);
		newUser.setUpdateDT(SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss"));
		this.userInfoMapper.updatePwd(newUser);
		return RspUtil.build("ok", "修改成功");
	}

	/**
	 * 初始化用户信息 
	 * 2，用户信息：在用户信息表(SLT_USERINFO)中查找用户信息
	 * 3,关联俱乐部：在人员Vip等级表(SLT_USER_VIP)
	 * 中查找Vip未过期的关联关联俱乐部，并根据Vip等级确定在本俱乐部中盲注大小关联Vip等级表
	 * （SLT_VIP）和盲注级别表(SLT_BINDINFO)。 如果没有Vip未过期的俱乐部则该用户无权限初始化数据，设置错误信息进入步骤6。
	 * 4，俱乐部盲注信息
	 * ：因为用户有权限查看比自己Vip等级对应的盲注级别和比对应盲注级别小的数据，因此要根据在用户在各个有效俱乐部中的vip等级，找到关联Vip等级表
	 * （SLT_VIP
	 * ）确定用户在本俱乐部中的盲注类别，再在俱乐部盲注表(SLT_CLUB_BLIND)中找到小于等于本盲注级别的盲注类别，并关联盲注级别表
	 * (SLT_BINDINFO)获取 5,关联牌手：在用户牌手关联表(SLT_USER_PLAYER)中获取关联牌手信息。 6,
	 * 在操作日志表(SLT_OPERATION_LOG)中记录日志,功能编号:999
	 * 
	 * @param string
	 * @return
	 */
	public JSONObject findUserInfo(String loginId, String operationCode) {
		//获取用户信息
		UserInfo user = userInfoMapper.findUserByLoginId(loginId);
		JSONObject userJson = new JSONObject();
		userJson.put("loginId", loginId);
		userJson.put("dataProtectDate", user.getProtectDate());
		//先查出用户vip未过期的俱乐部
		List<UserVip> uvList = this.userVipMapper.findEeffectiveVipClubList(loginId,SimpleDateUtil.format(new Date(), "yyyyMMdd"));
		if(null == uvList || uvList.isEmpty()){
			OperationLogUtil.saveLog(operationLogMapper,operationCode,"会员过期",loginId,null);
			return RspUtil.build("fail","会员过期");
		}
		JSONArray clubList = new JSONArray();
		JSONArray blindList = new JSONArray();
		JSONArray playerList = new JSONArray();
		//关联俱乐部信息
		for (UserVip userVip : uvList) {
			JSONObject clubJson = new JSONObject();
			clubJson.put("clubId", userVip.getClubID());
			clubJson.put("vipExpireDate", userVip.getExpireDate());
			BindInfo bi = this.bindInfoMapper.selectByPrimaryKey(this.vipMapper.selectByPrimaryKey(userVip.getVipLevel()).getBlindType());
			clubJson.put("blind", bi.getSBind()+"/"+bi.getBBind());
			PokerClub club = this.pokerClubMapper.findClub(userVip.getClubID());
			if(null == club){
				return RspUtil.build("fail","获取俱乐部信息失败");
			}
			clubJson.put("clubName", club.getClubName());
			
			clubList.add(clubJson);
			
			//小于用户vip等级的俱乐部盲注信息
			JSONObject blindJson = new JSONObject();
			JSONArray blindArray = new JSONArray();
			blindJson.put("clubId", userVip.getClubID());
			blindJson.put("clubName", club.getClubName());
			List<BindInfo> biList = this.bindInfoMapper.findBlindLowerBlindTypeList(userVip.getClubID(), bi.getBlindType());
			if(biList.isEmpty()){
				OperationLogUtil.saveLog(operationLogMapper,operationCode,"获取俱乐部盲注信息失败",loginId,null);
				return RspUtil.build("fail","获取俱乐部盲注信息失败");
			}
			for (BindInfo bindInfo : biList) {
				JSONObject j = new JSONObject();
				j.put("blindType", bindInfo.getBlindType());
				j.put("blind", bindInfo.getSBind()+"/"+bindInfo.getBBind());
				blindArray.add(j);
			}
			blindJson.put("blindList", blindArray);
			blindList.add(blindJson);
		}
		//关联牌手信息
		List<UserPlayer> userPlayerList  = this.userPlayerMapper.findUserPlayer(loginId);
		if(userPlayerList.isEmpty()){
			OperationLogUtil.saveLog(operationLogMapper,operationCode,"获取关联牌手失败",loginId,null);
			return RspUtil.build("fail","获取关联牌手失败");
		}
		for (UserPlayer userPlayer2 : userPlayerList) {
			JSONObject playerJson = new JSONObject();
			playerJson.put("playerId", userPlayer2.getPlayerID());
			playerJson.put("playerName", this.pokerPlayerMapper.findPokerPlayer(userPlayer2.getPlayerID()).getPlayerName());
			playerList.add(playerJson);
		}
		JSONObject rspJson = RspUtil.build("ok","初始化成功");
		rspJson.put("userInfo", userJson);
		rspJson.put("clubList", clubList);
		rspJson.put("playerList", playerList);
		rspJson.put("blindInfo", blindList);
		return rspJson;
	}

}
