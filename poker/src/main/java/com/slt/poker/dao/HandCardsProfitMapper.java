package com.slt.poker.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface HandCardsProfitMapper extends DaoMapper{

    List<Map<String,Object>> findCardList(@Param("playerID")String playerID,@Param("clubID")String clubID,@Param("bindType")Integer bindType);
}