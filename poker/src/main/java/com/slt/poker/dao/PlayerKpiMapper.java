package com.slt.poker.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface PlayerKpiMapper extends DaoMapper{
	List<HashMap<String,Object>> findPlayerKpiList(@Param("clubID")String clubId, @Param("blindType")int blindType,
			@Param("playerID")String playerId);

	List<HashMap<String, Object>> findSelfKpiList(@Param("clubID")String clubId, @Param("blindType")int blindType,
			@Param("playerID")String playerId);
}