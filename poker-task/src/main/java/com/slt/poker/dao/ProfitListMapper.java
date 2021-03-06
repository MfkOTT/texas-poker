package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.ProfitList;

public interface ProfitListMapper extends DaoMapper{

	List<ProfitList> findProfitList(@Param("dateStr")String dateStr);

	void batchInsertProfit(List<ProfitList> profitList);

	void deleteProfitByStage(@Param("statisticStage")String statisticStage_week);
	
	List<ProfitList> findSevenDayProfit(@Param("statisticStage")String statisticStage);
}