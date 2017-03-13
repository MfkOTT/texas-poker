package com.slt.poker.dao;

import com.slt.poker.dto.GameAction;

public interface GameActionMapper extends DaoMapper{
    int deleteByPrimaryKey(String actionID);

    int insert(GameAction record);

    int insertSelective(GameAction record);

    GameAction selectByPrimaryKey(String actionID);

    int updateByPrimaryKeySelective(GameAction record);

    int updateByPrimaryKey(GameAction record);
}