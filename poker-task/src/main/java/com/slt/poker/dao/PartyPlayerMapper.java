package com.slt.poker.dao;

import com.slt.poker.dto.PartyPlayer;
import com.slt.poker.dto.PartyPlayerKey;

public interface PartyPlayerMapper extends DaoMapper{
    int deleteByPrimaryKey(PartyPlayerKey key);

    int insert(PartyPlayer record);

    int insertSelective(PartyPlayer record);

    PartyPlayer selectByPrimaryKey(PartyPlayerKey key);

    int updateByPrimaryKeySelective(PartyPlayer record);

    int updateByPrimaryKey(PartyPlayer record);
}