package com.slt.poker.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface HandCardsPositionMapper extends DaoMapper{

	List<HashMap<String, Object>> findCardPositionListByName(@Param("playerID")String playerID,@Param("clubID")String clubID,@Param("bindType")Integer bindType, @Param("positionName")String positionName);
  
}