package com.slt.poker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slt.poker.dao.ClubBlindMapper;
import com.slt.poker.dao.ProfitListMapper;
import com.slt.poker.dto.ClubBlindKey;
import com.slt.poker.dto.ProfitList;
import com.slt.poker.util.NonceUtil;
import com.slt.poker.util.SimpleDateUtil;

@Service
public class RankingService {

	@Autowired
	private ClubBlindMapper clubBlindMapper;
	@Autowired
	private ProfitListMapper profitListMapper;
	
	/**
	 * 周排行榜
	 * @param clubBlindList
	 * @throws Exception
	 */
	public void saveCalcWeek() throws Exception {
		final String statisticStage_week = "001";
		//String dateStr = SimpleDateUtil.format(SimpleDateUtil.getDateAlter(new Date(), 0, -1, 0, 0, 0, 0), "yyyyMMddHHmmss");
		String dateStr = SimpleDateUtil.format(SimpleDateUtil.parse("20150202121212", "yyyyMMddHHmmss"), "yyyyMMddHHmmss");
		List<ProfitList> profitList = this.profitListMapper.findProfitList(dateStr);
		if(!profitList.isEmpty()){
			for (ProfitList profit : profitList) {
				profit.setListID(NonceUtil.getUuid());
				profit.setStatisticStage(statisticStage_week);
				profit.setUpdateDT(SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss"));
			}
			this.profitListMapper.deleteProfitByStage(statisticStage_week);
			this.profitListMapper.batchInsertProfit(profitList);
		}
	}



	/**
	 * 月排行榜
	 * @param clubBlindList
	 */
	public void saveCalcMonth() throws Exception{
		final String statisticStage_week = "002";
//		String dateStr = SimpleDateUtil.format(SimpleDateUtil.getDateAlter(new Date(), 0, 0, -7, 0, 0, 0), "yyyyMMddHHmmss");
		String dateStr = SimpleDateUtil.format(SimpleDateUtil.parse("20150202121212", "yyyyMMddHHmmss"), "yyyyMMddHHmmss");
		List<ProfitList> profitList = this.profitListMapper.findProfitList(dateStr);
		for (ProfitList profit : profitList) {
			profit.setListID(NonceUtil.getUuid());
			profit.setStatisticStage(statisticStage_week);
			profit.setUpdateDT(SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss"));
		}
		this.profitListMapper.deleteProfitByStage(statisticStage_week);
		this.profitListMapper.batchInsertProfit(profitList);
		
	}
	public List<ClubBlindKey> findClubBlindList() throws Exception{
		return this.clubBlindMapper.findClubBlindList();
	}
}
