package com.slt.poker.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ProfitListMapper extends DaoMapper{

	List<HashMap<String, Object>> findProfitList(@Param("clubID")String clubID,@Param("bindType")int bindType,@Param("statisticStage")String statisticStage
			,@Param("protectDate")String protectDate);
}