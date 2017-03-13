package com.slt.poker.dao;

import com.slt.poker.dto.PlayerHand;
import com.slt.poker.dto.PlayerHandKey;

public interface PlayerHandMapper extends DaoMapper{
    int deleteByPrimaryKey(PlayerHandKey key);

    int insert(PlayerHand record);

    int insertSelective(PlayerHand record);

    PlayerHand selectByPrimaryKey(PlayerHandKey key);

    int updateByPrimaryKeySelective(PlayerHand record);

    int updateByPrimaryKey(PlayerHand record);
}