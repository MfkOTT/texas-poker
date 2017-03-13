package com.slt.poker.dao;

import com.slt.poker.dto.PokerGame;

public interface PokerGameMapper extends DaoMapper{
    int deleteByPrimaryKey(String gameID);

    int insert(PokerGame record);

    int insertSelective(PokerGame record);

    PokerGame selectByPrimaryKey(String gameID);

    int updateByPrimaryKeySelective(PokerGame record);

    int updateByPrimaryKey(PokerGame record);
}