package com.slt.poker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slt.poker.dao.TurnPlayerKpiMapper;
import com.slt.poker.dto.FlopPlayerKpi;
import com.slt.poker.dto.TurnPlayerKpi;
import com.slt.poker.util.CalcUtil;
import com.slt.poker.util.NonceUtil;
import com.slt.poker.util.SimpleDateUtil;

@Service
public class TurnPlayerKpiService {
	@Autowired
	private TurnPlayerKpiMapper turnPlayerKpiMapper;
	/**
	 * 4001
	 * turn胜率
	 * Turn上收pot的次数/见到Turn的次数
	 * @throws Exception
	 */
	public void saveTurnWinRate() throws Exception{
		final String kpiCode = "4001";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnWinRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 计算俱乐部平均值并入库
	 * 
	 * @param playerKpitList
	 *            待计算数据
	 * @param kpiCode
	 *            指标
	 */
	private void doClubKpiValue(List<TurnPlayerKpi> playerKpitList,
			String kpiCode) {
		TurnPlayerKpi dataItem; // 数据库中查询到的每条记录
		Map<String, List<TurnPlayerKpi>> resultMap = new HashMap<String, List<TurnPlayerKpi>>(); // 最终要的结果
		Map<String, Map<String, String>> countMap = new HashMap<String, Map<String, String>>();// 统计俱乐部概率
		for (int i = 0; i < playerKpitList.size(); i++) {
			dataItem = playerKpitList.get(i);
			String str = dataItem.getClubID() + "_" + dataItem.getBlindType();
			if (resultMap.containsKey(str)) {
				resultMap.get(str).add(dataItem);
			} else {
				List<TurnPlayerKpi> list = new ArrayList<TurnPlayerKpi>();
				list.add(dataItem);
				resultMap.put(str, list);
			}

			// 统计相同俱乐部同类型的值
			if (countMap.containsKey(str)) {
				countMap.get(str).put("sumPoolCount",CalcUtil.getNumInfo(countMap.get(str).get("sumPoolCount"),dataItem.getNumerator()));
				countMap.get(str).put("sumGameCount",CalcUtil.getNumInfo(countMap.get(str).get("sumGameCount"),dataItem.getDenominator()));
			} else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("sumPoolCount", dataItem.getNumerator());
				map.put("sumGameCount", dataItem.getDenominator());
				countMap.put(str, map);
			}
		}
		// 循环统一俱乐部和统一盲注类型入库
		String dateStr = SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss");
		Iterator it = countMap.entrySet().iterator();
		List<TurnPlayerKpi> kpiList = new ArrayList<TurnPlayerKpi>();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			Map<String, String> value = (Map<String, String>) entry.getValue();
			String divide = CalcUtil.getDivide(value.get("sumPoolCount"),
					value.get("sumGameCount"), 2);
			List<TurnPlayerKpi> pList = resultMap.get(key);
			if (!pList.isEmpty()) {
				for (TurnPlayerKpi playerKpi : pList) {
					playerKpi.setPlayerKpiID(NonceUtil.getUuid());
					playerKpi.setUpdateDT(dateStr);
					playerKpi.setClubKpiValue(divide);
					playerKpi.setKpiCode(kpiCode);
					kpiList.add(playerKpi);
				}
			}
			value.clear();
		}
		this.turnPlayerKpiMapper.deleteKpiByKpiCode(kpiCode);
		this.turnPlayerKpiMapper.insertKpiBatch(kpiList);
	}
	/**
	 * 4002
	 * turn总Cbet率
	 * @throws Exception
	 */
	public void saveTurnTotalCbetRate() throws Exception{
		final String kpiCode = "4002";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}	
	}
	/**
	 * 4003
	 * turn有位置的CBet率
	 * turn上有位置的Cbet次数/turn上总Cbet次数
	 * @throws Exception
	 */
	public void saveTurnPositionCbetRate() throws Exception{
		final String kpiCode = "4003";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnPositionCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4004
	 * turn无位置的CBet
	 * turn上无位置的Cbet次数/turn上总Cbet次数
	 * @throws Exception
	 */
	public void saveTurnNoPositionCbetRate() throws Exception{
		final String kpiCode = "4004";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnNoPositionCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4005
	 * turn Cbet面对raise的跟注率
	 * @throws Exception
	 */
	public void saveTurnCbetRaiseRate() throws Exception{
		final String kpiCode = "4005";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnCbetRaiseRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4006
	 * turn Cbet面对raise的Reraise率
	 * @throws Exception
	 */
	public void saveTurnCbetReRaiseRate() throws Exception{
		final String kpiCode = "4006";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnCbetReRaiseRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4007
	 * turn Cbet面对raise的弃牌率
	 * @throws Exception
	 */
	public void saveTurnCbetFoldRate() throws Exception{
		final String kpiCode = "4007";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnCbetFoldRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4008
	 * 总延迟Cbet率
	 * @throws Exception
	 */
	public void saveTurnTotalCbetDelayRate() throws Exception{
		final String kpiCode = "4008";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalCbetDelayRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4009
	 * 有位置延迟Cbet率
	 * @throws Exception
	 */
	public void saveTurnPositionCbetDelayRate() throws Exception{
		final String kpiCode = "4009";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnPositionCbetDelayRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4010
	 * 无位置延迟Cbet率
	 * @throws Exception
	 */
	public void saveTurnNoPositionCbetDelayRate() throws Exception{
		final String kpiCode = "4010";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnNoPositionCbetDelayRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4011
	 * turn总Fold给Cbet率
	 * @throws Exception
	 */
	public void saveTurnTotalFoldCbetRate() throws Exception{
		final String kpiCode = "4011";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalFoldCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4012
	 * turn有位置Fold给Cbet率
	 * @throws Exception
	 */
	public void saveTurnPositionFoldCbetRate() throws Exception{
		final String kpiCode = "4012";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnPositionFoldCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4013
	 * turn无位置Fold给Cbet率
	 * @throws Exception
	 */
	public void saveTurnNoPositionFoldCbetRate() throws Exception{
		final String kpiCode = "4013";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnNoPositionFoldCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4014
	 * turn总Call Cbet率
	 * @throws Exception
	 */
	public void saveTurnTotalCallCbetRate() throws Exception{
		final String kpiCode = "4014";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalCallCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4015
	 * turn有位置Call Cbet率
	 * @throws Exception
	 */
	public void saveTurnPositionCallCbetRate() throws Exception{
		final String kpiCode = "4015";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnPositionCallCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4016
	 * turn无位置Call Cbet率
	 * @throws Exception
	 */
	public void saveTurnNoPositionCallCbetRate() throws Exception{
		final String kpiCode = "4016";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnNoPositionCallCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4017
	 * turn总Raise Cbet率
	 * @throws Exception
	 */
	public void saveTurnTotalRaiseCbetRate() throws Exception{
		final String kpiCode = "4017";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalRaiseCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4018
	 * turn有位置Raise Cbet率
	 * @throws Exception
	 */
	public void saveTurnPositionRaiseCbetRate() throws Exception{
		final String kpiCode = "4018";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnPositionRaiseCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4019
	 * turn无位置Raise Cbet率
	 * @throws Exception
	 */
	public void saveTurnNoPositionRaiseCbetRate() throws Exception{
		final String kpiCode = "4019";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnNoPositionRaiseCbetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4020
	 * turn面对Donk下注Fold
	 * @throws Exception
	 */
	public void saveTurnWithDonkFoldRate() throws Exception{
		final String kpiCode = "4020";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnWithDonkFoldRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4021
	 * turn面对Donk下注Call
	 * @throws Exception
	 */
	public void saveTurnWithDonkCallRate() throws Exception{
		final String kpiCode = "4021";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnWithDonkCallRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4022
	 * turn总溜入底池首先下注率
	 * @throws Exception
	 */
	public void saveTurnWithDonkRaiseRate() throws Exception{
		final String kpiCode = "4022";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnWithDonkRaiseRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}		
	}
	/**
	 * 4023
	 * turn总溜入底池首先下注率
	 * @throws Exception
	 */
	public void saveTurnTotalLimpInPotBetRate() throws Exception{
		final String kpiCode = "4023";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalLimpInPotBetRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}
	/**
	 * 4024-4029
	 * 各位置溜入底池首先下注率
	 * @throws Exception
	 */
	public void saveTurnLimpInPotBetRate() throws Exception{
		final String[] position = new String[]{"EP","MP","CO","BTN","SB"};
		//kpiCode从4024开始
		for (int i = 0 ; i< position.length ; i++) {
			List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnLimpInPotBetRate(position[i]);
			if(playerKpitList.isEmpty()){
				continue;
			}
			String kpiCode = String.valueOf(i+4024);
			this.doClubKpiValue(playerKpitList, kpiCode);
		}			
	}

	/**
	 * 4030
	 * turn总溜入底池平跟率
	 * @throws Exception
	 */
	public void saveTurnTotalLimpInPotCallRate() throws Exception{
		final String kpiCode = "4030";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalLimpInPotCallRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}

	/**
	 * 4031-4035
	 * 各位置总溜入底池平跟率
	 * @throws Exception
	 */
	public void saveTurnLimpInPotCallRate() throws Exception{
		final String[] position = new String[]{"EP","MP","CO","BTN"};
		//kpiCode从4031开始
		for (int i = 0 ; i< position.length ; i++) {
			List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnLimpInPotCallRate(position[i]);
			if(playerKpitList.isEmpty()){
				continue;
			}
			String kpiCode = String.valueOf(i+4031);
			this.doClubKpiValue(playerKpitList, kpiCode);
		}			
	}
	/**
	 * 4036
	 * turn总溜入底池后位再加注率
	 * @throws Exception
	 */

	public void saveTurnTotalLimpInPotRaiseRate() throws Exception{
		final String kpiCode = "4036";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalLimpInPotRaiseRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}
	/**
	 * 4037-4041
	 * 各位置溜入底池后位再加注率
	 * @throws Exception
	 */
	public void saveTurnLimpInPotRaiseRate() throws Exception{
		final String[] position = new String[]{"EP","MP","CO","BTN"};
		//kpiCode从4037开始
		for (int i = 0 ; i< position.length ; i++) {
			List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnLimpInPotRaiseRate(position[i]);
			if(playerKpitList.isEmpty()){
				continue;
			}
			String kpiCode = String.valueOf(i+4037);
			this.doClubKpiValue(playerKpitList, kpiCode);
		}			
	}
	/**
	 * 4042
	 * turn总溜入底池check-call率
	 * @throws Exception
	 */
	public void saveTurnTotalLimpInPotCheckCallRate() throws Exception{
		final String kpiCode = "4042";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalLimpInPotCheckCallRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}
	/**
	 * 4043-4047
	 * 各位置溜入底池check-call率
	 * @throws Exception
	 */

	public void saveTurnLimpInPotCheckCallRate() throws Exception{
		final String[] position = new String[]{"EP","MP","CO","SB"};
		//kpiCode从4043开始
		for (int i = 0 ; i< position.length ; i++) {
			List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnLimpInPotCheckCallRate(position[i]);
			if(playerKpitList.isEmpty()){
				continue;
			}
			String kpiCode = String.valueOf(i+4043);
			this.doClubKpiValue(playerKpitList, kpiCode);
		}			
	}
	/**
	 * 4048
	 * turn总溜入底池check-raise率
	 * @throws Exception
	 */
	public void saveTurnTotalLimpInPotCheckRaiseRate() throws Exception{
		final String kpiCode = "4048";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalLimpInPotCheckRaiseRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}
	/**
	 * 4049-4053
	 * 各位置溜入底池check-raise率
	 * @throws Exception
	 */
	public void saveTurnLimpInPotCheckRaiseRate() throws Exception{
		final String[] position = new String[]{"EP","MP","CO","BTN","SB"};
		//kpiCode从4049开始
		for (int i = 0 ; i< position.length ; i++) {
			List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnLimpInPotCheckRaiseRate(position[i]);
			if(playerKpitList.isEmpty()){
				continue;
			}
			String kpiCode = String.valueOf(i+4049);
			this.doClubKpiValue(playerKpitList, kpiCode);
		}			
	}
	/**
	 * 4054
	 * turn总溜入底池弃牌率
	 * @throws Exception
	 */
	public void saveTurnTotalLimpInPotFoldRate() throws Exception{
		final String kpiCode = "4054";
		List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnTotalLimpInPotFoldRate();
		if(!playerKpitList.isEmpty()){
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}
	/**
	 * 4055-4060
	 * turn面对Donk下注raise
	 * @throws Exception
	 */
	public void saveTurnLimpInPotCheckFoldRate() throws Exception{
		final String[] position = new String[]{"EP","MP","CO","BTN","SB"};
		//kpiCode从4055开始
		for (int i = 0 ; i< position.length ; i++) {
			List<TurnPlayerKpi> playerKpitList = this.turnPlayerKpiMapper.findTurnLimpInPotCheckFoldRate(position[i]);
			if(playerKpitList.isEmpty()){
				continue;
			}
			String kpiCode = String.valueOf(i+4055);
			this.doClubKpiValue(playerKpitList, kpiCode);
		}				
	}
}
