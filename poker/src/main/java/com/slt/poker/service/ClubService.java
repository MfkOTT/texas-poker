package com.slt.poker.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.slt.base.utils.OperationLogUtil;
import com.slt.base.utils.RspUtil;
import com.slt.base.utils.SimpleDateUtil;
import com.slt.poker.dao.OperationLogMapper;
import com.slt.poker.dao.PokerPlayerMapper;
import com.slt.poker.dao.UserVipMapper;
import com.slt.poker.dto.PokerPlayer;
import com.slt.poker.dto.UserVip;
import com.slt.poker.dto.UserVipKey;

@Service
public class ClubService {
	private static final Logger log = LoggerFactory.getLogger(ClubService.class);
	@Autowired
	private UserVipMapper userVipMapper;
	@Autowired
	private OperationLogMapper operationLogMapper;
	@Autowired
	private PokerPlayerMapper pokerPlayerMapper;
	
	/**
	 * 获取俱乐部会员列表
	 * @param loginId
	 * @param clubId
	 * @param palyName
	 * @return
	 * @throws Exception 
	 */
	public JSONObject ClubPlayerList(String loginId, String clubId,
			String playerName, String operationCode) throws Exception {
		//先判断用户会员是否过期
		log.debug("==ClubPlayerList==loginId:{}",loginId);
		UserVipKey uvk = new UserVipKey();
		uvk.setClubID(clubId);
		uvk.setLoginID(loginId);
		UserVip userVip = this.userVipMapper.findUserVip(uvk);
		if(null != userVip){
			if(SimpleDateUtil.parse(userVip.getExpireDate(), "yyyyMMdd").getTime() < new Date().getTime()){
				//记录日志
				OperationLogUtil.saveLog(operationLogMapper,"005","会员过期",loginId,null);
				return RspUtil.build("fail","会员过期");
			}
			//抓取牌手列表
			List<PokerPlayer> pPlayerList = this.pokerPlayerMapper.findPlayerList(clubId, playerName);
			JSONArray jarray = new JSONArray();
			for (PokerPlayer pokerPlayer : pPlayerList) {
				JSONObject json = new JSONObject();
				json.put("playerId", pokerPlayer.getPlayerID());
				json.put("playerName", pokerPlayer.getPlayerName());
				jarray.add(json);
			}
			JSONObject rspJson = RspUtil.build("ok","查询成功");
			rspJson.put("playerList", jarray);
			return rspJson;
		}
		
		return RspUtil.build("fail","查询失败");
	}
	
	
	
	
}
