package com.slt.poker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.slt.base.utils.MathUtils;
import com.slt.base.utils.OperationLogUtil;
import com.slt.base.utils.RspUtil;
import com.slt.base.utils.SimpleDateUtil;
import com.slt.poker.dao.BindInfoMapper;
import com.slt.poker.dao.HandCardsPositionMapper;
import com.slt.poker.dao.HandCardsProfitMapper;
import com.slt.poker.dao.OperationLogMapper;
import com.slt.poker.dao.PlayerKpiMapper;
import com.slt.poker.dao.ProfitListMapper;
import com.slt.poker.dao.UserInfoMapper;
import com.slt.poker.dao.UserPlayerMapper;
import com.slt.poker.dao.UserVipMapper;
import com.slt.poker.dao.VipMapper;
import com.slt.poker.dto.ProfitList;
import com.slt.poker.dto.UserInfo;
import com.slt.poker.dto.UserPlayer;
import com.slt.poker.dto.UserPlayerKey;
import com.slt.poker.dto.UserVip;
import com.slt.poker.dto.UserVipKey;
import com.slt.poker.dto.Vip;

@Service
public class PlayerService {
	private static final Logger log = LoggerFactory.getLogger(PlayerService.class);
	@Autowired
	private UserVipMapper userVipMapper;
	@Autowired
	private OperationLogMapper operationLogMapper;
	@Autowired
	private VipMapper vipMapper;
	@Autowired
	private BindInfoMapper bindInfoMapper;
	@Autowired
	private UserPlayerMapper userPlayerMapper;
	@Autowired
	private HandCardsProfitMapper handCardsProfitMapper;
	@Autowired
	private HandCardsPositionMapper handCardsPositionMapper;
	@Autowired
	private ProfitListMapper profitListMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private PlayerKpiMapper playerKpiMapper;
	
	
	/**
	 * 查询手牌盈利情况
	 * @param loginId
	 * @param clubId
	 * @param playerId
	 * @param blindType
	 * @return
	 * @throws Exception 
	 */
	public JSONObject getCardProfit(String loginId, String clubId,
			String playerId, int blindType, String operationCode) throws Exception {
		// 先判断用户会员是否过期
		UserVipKey uvk = new UserVipKey();
		uvk.setClubID(clubId);
		uvk.setLoginID(loginId);
		UserVip userVip = this.userVipMapper.findUserVip(uvk);
		if (null == userVip) {
			return RspUtil.build("fail","查询失败");
		}
		if (SimpleDateUtil.parse(userVip.getExpireDate(), "yyyyMMdd").getTime() < new Date().getTime()) {
			// 记录日志
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "会员过期",loginId, null);
			return RspUtil.build("fail", "会员过期");
		}
		//查询vip等级对应盲注级别
		Vip vip = this.vipMapper.selectByPrimaryKey(userVip.getVipLevel());
		if(vip.getBlindType() > blindType){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "您无权限查看本级别的数据",loginId, null);
			return RspUtil.build("fail", "您无权限查看本级别的数据");
		}
		//查询关联牌手正确性
		UserPlayerKey upk = new UserPlayerKey();
		upk.setLoginID(loginId);
		upk.setPlayerID(playerId);
		UserPlayer userPlayer = this.userPlayerMapper.findUserPlayerByKey(upk);
		if(null == userPlayer){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "未查询到绑定牌手",loginId, null);
			return RspUtil.build("fail", "未查询到绑定牌手");
		}
		//获取起手牌盈利情况
		List<Map<String,Object>> profitList = this.handCardsProfitMapper.findCardList(playerId, clubId, blindType);
		if(null == profitList){
			log.error("**findCardList fail!!**loginId:{}",loginId);
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "查询手牌失败",loginId, null);
			return RspUtil.build("fail", "查询手牌失败");
		}
		//获取盈利数据，用于计算盈利类型
		List<Integer> simpleProfitList = new ArrayList<Integer>();
		for (Map<String, Object> map : profitList) {
			simpleProfitList.add(Integer.parseInt(map.get("Profit").toString()));
		}
		JSONArray cardList = new JSONArray();
		for (Map<String, Object> map : profitList) {
			JSONObject cardJson = new JSONObject();
			cardJson.put("handCardCode", map.get("HandCardCode").toString());
			cardJson.put("handCars", map.get("HandSuit").toString());
			cardJson.put("rowIndex", map.get("RowIndex").toString());
			cardJson.put("colIndex", map.get("ColIndex").toString());
			cardJson.put("gameCount", map.get("GameCount").toString());
			cardJson.put("profitCout", map.get("ProfitCount").toString());
			cardJson.put("profitType", String.valueOf(MathUtils.getSimpleProfit(simpleProfitList, Integer.parseInt(map.get("Profit").toString()))));
			cardList.add(cardJson);
		}
		JSONObject rspJson = RspUtil.build("ok","查询成功");
		rspJson.put("cardList", cardList);
		return rspJson;
	}

	/**
	 * 俱乐部同一盲注级别下牌手排行榜
	 * @param loginId
	 * @param clubId
	 * @param blindType
	 * @return
	 * @throws Exception 
	 */
	public JSONObject getPlayerProfitList(String loginId, String clubId,
			int blindType, String operationCode) throws Exception {
		final String statisticStage_week="001";
		final String statisticStage_month="002";
		// 先判断用户会员是否过期
		UserVipKey uvk = new UserVipKey();
		uvk.setClubID(clubId);
		uvk.setLoginID(loginId);
		UserVip userVip = this.userVipMapper.findUserVip(uvk);
		if (null == userVip) {
			return RspUtil.build("fail", "查询失败");
		}
		if (SimpleDateUtil.parse(userVip.getExpireDate(), "yyyyMMdd").getTime() < new Date().getTime()) {
			// 记录日志
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "会员过期",loginId, null);
			return RspUtil.build("fail", "会员过期");
		}
		// 查询vip等级对应盲注级别
		Vip vip = this.vipMapper.selectByPrimaryKey(userVip.getVipLevel());
		if (vip.getBlindType() > blindType) {
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "您无权限查看本级别的数据",loginId, null);
			return RspUtil.build("fail", "您无权限查看本级别的数据");
		}
		//获取7天排行
		List<HashMap<String,Object>> profitListWeek = this.profitListMapper.findProfitList(clubId, blindType, statisticStage_week,SimpleDateUtil.format(new Date(), "yyyyMMdd"));
		if(profitListWeek.isEmpty()){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "查询7天数据失败",loginId, null);
			return RspUtil.build("fail", "查询7天数据失败");
		}
		log.debug("=="+profitListWeek.toString());
		JSONArray profitWeekList = new JSONArray();
		JSONObject weekPlayerCount = new JSONObject();
		for (HashMap<String,Object> profit : profitListWeek) {
			JSONObject profitRankingJson = new JSONObject();
			if(StringUtils.isEmpty(profit.get("LoginID").toString())){
				profitRankingJson.put("playerName", profit.get("PlayerName").toString());
				profitRankingJson.put("myself", "1");
			}else if(profit.get("LoginID").toString().equals(loginId)){
				profitRankingJson.put("playerName", profit.get("PlayerName").toString());
				profitRankingJson.put("myself", "0");
			}else{
				profitRankingJson.put("playerName", "VIP");
				profitRankingJson.put("myself", "1");
			}
			profitRankingJson.put("profit", profit.get("Profit").toString());
			profitRankingJson.put("profitIndex", profit.get("ProfitIndex").toString());
			
			profitWeekList.add(profitRankingJson);
		}
		weekPlayerCount.put("playerCount", profitListWeek.size());
		weekPlayerCount.put("playerList", profitWeekList);
		log.debug("==week ranking==weekPlayerCount:{}",weekPlayerCount);
		//获取30天排行
		List<HashMap<String,Object>> profitListMonth = this.profitListMapper.findProfitList(clubId, blindType, statisticStage_month,SimpleDateUtil.format(new Date(), "yyyyMMdd"));
		if(profitListWeek.isEmpty()){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "查询30天数据失败",loginId, null);
			return RspUtil.build("fail", "查询30天数据失败");
		}
		JSONArray profitMonthList = new JSONArray();
		JSONObject monthPlayerCount = new JSONObject();
		for (HashMap<String,Object> profit : profitListMonth) {
			JSONObject profitRankingJson = new JSONObject();
			if(StringUtils.isEmpty(profit.get("LoginID").toString())){
				profitRankingJson.put("playerName", profit.get("PlayerName").toString());
				profitRankingJson.put("myself", "1");
			}else if(profit.get("LoginID").toString().equals(loginId)){
				profitRankingJson.put("playerName", profit.get("PlayerName").toString());
				profitRankingJson.put("myself", "0");
			}else{
				profitRankingJson.put("playerName", "VIP");
				profitRankingJson.put("myself", "1");
			}
			profitRankingJson.put("profit", profit.get("Profit").toString());
			profitRankingJson.put("profitIndex", profit.get("ProfitIndex").toString());
			
			profitMonthList.add(profitRankingJson);
		}
		monthPlayerCount.put("playerCount", profitMonthList.size());
		monthPlayerCount.put("playerList", profitMonthList);
		log.debug("==week ranking==PlayerCount:{}",weekPlayerCount);
		JSONObject rspJson = RspUtil.build("ok","查询成功");
		rspJson.put("week", weekPlayerCount);
		rspJson.put("month", monthPlayerCount);
		return rspJson;
	}

	/**
	 * 查询牌手对局指标
	 * @param loginId
	 * @param clubId
	 * @param blindType
	 * @param playerId
	 * @return
	 * @throws Exception 
	 */
	public JSONObject getPlayerKpi(String loginId, String clubId,
			int blindType, String playerId, String operationCode) throws Exception {
		// 先判断用户会员是否过期
		UserVipKey uvk = new UserVipKey();
		uvk.setClubID(clubId);
		uvk.setLoginID(loginId);
		UserVip userVip = this.userVipMapper.findUserVip(uvk);
		if (null == userVip) {
			return RspUtil.build("fail", "查询失败");
		}
		if (SimpleDateUtil.parse(userVip.getExpireDate(), "yyyyMMdd").getTime() < new Date().getTime()) {
			// 记录日志
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "会员过期",
					loginId, null);
			return RspUtil.build("fail", "会员过期");
		}
		// 查询vip等级对应盲注级别
		Vip vip = this.vipMapper.selectByPrimaryKey(userVip.getVipLevel());
		if (vip.getBlindType() < blindType) {
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "您无权限查看本级别的数据",loginId, null);
			return RspUtil.build("fail", "您无权限查看本级别的数据");
		}
		JSONObject rspJson = RspUtil.build("ok","查询成功");
		//判断数据保护期
		if(this.isProtect(playerId,loginId)){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "目标数据处于保护期间",loginId, null);
			rspJson.put("vipProtect", String.valueOf(0));
			return rspJson;
		}
		//查询目标用户对局kpi
		List<HashMap<String,Object>> playerKpiList = this.playerKpiMapper.findPlayerKpiList(clubId,blindType,playerId);
		if(playerKpiList.isEmpty()){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "查询kpi失败",loginId, null);
			return RspUtil.build("fail", "查询kpi失败");
		}
		JSONArray kpiListAll = new JSONArray();
		JSONArray kpiListPreflop = new JSONArray();
		JSONArray kpiListFlop = new JSONArray();
		JSONArray kpiListTurn = new JSONArray();
		JSONArray kpiListRiver = new JSONArray();
		for (HashMap<String,Object> playerKpi : playerKpiList) {
			JSONObject kpiJson = new JSONObject();
			kpiJson.put("kpiCode", null == playerKpi.get("KpiCode") ? "0" : playerKpi.get("KpiCode").toString());
			kpiJson.put("kpiName", null == playerKpi.get("KpiName") ? "0" : playerKpi.get("KpiName").toString());
			kpiJson.put("kpiValue", null == playerKpi.get("KpiValue") ? "0" : playerKpi.get("KpiValue").toString());
			kpiJson.put("clubValue",null == playerKpi.get("ClubKpiValue") ? "0" : playerKpi.get("ClubKpiValue").toString());
			String stage = playerKpi.get("GameStage").toString();//阶段
			switch (stage) {
			case "all":
				kpiListAll.add(kpiJson);
				break;
			case "preflop":
				kpiListPreflop.add(kpiJson);
				break;
			case "flop":
				kpiListFlop.add(kpiJson);
				break;
			case "turn":
				kpiListTurn.add(kpiJson);
				break;
			case "river":
				kpiListRiver.add(kpiJson);
				break;
			default:
				break;
			}
		}
		rspJson.put("vipProtect", String.valueOf(1));
		rspJson.put("all", kpiListAll);
		rspJson.put("preflop", kpiListPreflop);
		rspJson.put("flop", kpiListFlop);
		rspJson.put("turn", kpiListTurn);
		rspJson.put("river", kpiListRiver);
		return rspJson;
	}

	/**
	 * 判断用户数据是否处于保护器,作用域不包括自己
	 * @param playerId
	 * @param loginId
	 * @return
	 * @throws Exception 
	 */
	private boolean isProtect(String playerId, String loginId) throws Exception {
		UserInfo userInfo = this.userInfoMapper.findUserByPartyId(playerId);
		if(null == userInfo){
			return false;
		}
		log.debug("loginId:{}==userInfo{}",loginId,userInfo.getLoginID());
		if(loginId.equals(userInfo.getLoginID())){
			return false;
		}
		if(SimpleDateUtil.parse(userInfo.getProtectDate(), "yyyyMMdd").getTime() < new Date().getTime()){
			return false;
		}	
		return true;
	}

	/**
	 * 查询用户自己kpi
	 * @param loginId
	 * @param clubId
	 * @param blindType
	 * @param playerId
	 * @param operationCode
	 * @return
	 * @throws Exception
	 */
	public JSONObject getMyselfKpi(String loginId, String clubId,
			int blindType, String playerId, String operationCode) throws Exception {
		// 先判断用户会员是否过期
		UserVipKey uvk = new UserVipKey();
		uvk.setClubID(clubId);
		uvk.setLoginID(loginId);
		UserVip userVip = this.userVipMapper.findUserVip(uvk);
		if (null == userVip) {
			return RspUtil.build("fail", "查询失败");
		}
		if (SimpleDateUtil.parse(userVip.getExpireDate(), "yyyyMMdd").getTime() < new Date().getTime()) {
			// 记录日志
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "会员过期",
					loginId, null);
			return RspUtil.build("fail", "会员过期");
		}
		// 查询vip等级对应盲注级别
		Vip vip = this.vipMapper.selectByPrimaryKey(userVip.getVipLevel());
		if (vip.getBlindType() > blindType) {
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "您无权限查看本级别的数据",loginId, null);
			return RspUtil.build("fail", "您无权限查看本级别的数据");
		}
		//查询目标用户对局kpi
		List<HashMap<String,Object>> playerKpiList = this.playerKpiMapper.findSelfKpiList(clubId,blindType,playerId);
		if(playerKpiList.isEmpty()){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "查询kpi失败",loginId, null);
			return RspUtil.build("fail", "查询kpi失败");
		}
		JSONArray kpiList = new JSONArray();
		for (HashMap<String,Object> playerKpi : playerKpiList) {
			JSONObject kpiJson = new JSONObject();
			kpiJson.put("kpiCode", playerKpi.get("KpiCode").toString());
			kpiJson.put("kpiName", playerKpi.get("KpiName").toString());
			kpiJson.put("kpiValue", playerKpi.get("KpiValue").toString());
			kpiJson.put("clubValue", playerKpi.get("ClubKpiValue").toString());
			kpiJson.put("stage", playerKpi.get("GameStage").toString());
			kpiList.add(kpiJson);
		}
		JSONObject rspJson = RspUtil.build("ok","查询成功");
		rspJson.put("kpiScoreList", kpiList);
		return rspJson;
	}

	public JSONObject getCardPosition(String loginId, String clubId,
			int blindType, String playerId, String operationCode) throws Exception {
		final String[] position = new String[]{"SB","BB","MP","EP","CO","BTN"};
		// 先判断用户会员是否过期
		UserVipKey uvk = new UserVipKey();
		uvk.setClubID(clubId);
		uvk.setLoginID(loginId);
		UserVip userVip = this.userVipMapper.findUserVip(uvk);
		if (null == userVip) {
			return RspUtil.build("fail","查询失败");
		}
		if (SimpleDateUtil.parse(userVip.getExpireDate(), "yyyyMMdd").getTime() < new Date().getTime()) {
			// 记录日志
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "会员过期",loginId, null);
			return RspUtil.build("fail", "会员过期");
		}
		//查询vip等级对应盲注级别
		Vip vip = this.vipMapper.selectByPrimaryKey(userVip.getVipLevel());
		if(vip.getBlindType() > blindType){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "您无权限查看本级别的数据",loginId, null);
			return RspUtil.build("fail", "您无权限查看本级别的数据");
		}
		//查询关联牌手正确性
		UserPlayerKey upk = new UserPlayerKey();
		upk.setLoginID(loginId);
		upk.setPlayerID(playerId);
		UserPlayer userPlayer = this.userPlayerMapper.findUserPlayerByKey(upk);
		if(null == userPlayer){
			OperationLogUtil.saveLog(operationLogMapper, operationCode, "未查询到绑定牌手",loginId, null);
			return RspUtil.build("fail", "未查询到绑定牌手");
		}
		//统计起手牌入池位置
		JSONObject rspJson = RspUtil.build("ok","查询成功");
		for (String string : position) {
			List<HashMap<String,Object>> positionList = this.handCardsPositionMapper.
					findCardPositionListByName(playerId,clubId,blindType,string);
			if(positionList.isEmpty()){
				OperationLogUtil.saveLog(operationLogMapper, operationCode, "查询起手位置信息失败",loginId, null);
				return RspUtil.build("fail", "查询起手位置信息失败");
			}
			JSONArray array = new JSONArray(); 
			for (HashMap<String, Object> hashMap : positionList) {
				JSONObject positionJson = new JSONObject();
				positionJson.put("handCardCode", hashMap.get("HandCardCode").toString());
				positionJson.put("handCars", hashMap.get("HandSuit").toString());
				positionJson.put("rowIndex", hashMap.get("RowIndex").toString());
				positionJson.put("colIndex", hashMap.get("ColIndex").toString());
				positionJson.put("poolCount", hashMap.get("PoolCount").toString());
				positionJson.put("poolIndex", hashMap.get("PoolIndex").toString());
				array.add(positionJson);
			}
			rspJson.put(string, array);
		}
		return rspJson;
	}
}
