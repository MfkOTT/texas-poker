package com.slt.poker.dao;

import com.slt.poker.dto.GamePlayer;
import com.slt.poker.dto.GamePlayerKey;

public interface GamePlayerMapper extends DaoMapper{
    int deleteByPrimaryKey(GamePlayerKey key);

    int insert(GamePlayer record);

    int insertSelective(GamePlayer record);

    GamePlayer selectByPrimaryKey(GamePlayerKey key);

    int updateByPrimaryKeySelective(GamePlayer record);

    int updateByPrimaryKey(GamePlayer record);
}