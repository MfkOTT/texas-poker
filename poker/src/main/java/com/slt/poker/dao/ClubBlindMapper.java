package com.slt.poker.dao;

import com.slt.poker.dto.ClubBlindKey;

public interface ClubBlindMapper extends DaoMapper{
    int deleteByPrimaryKey(ClubBlindKey key);

    int insert(ClubBlindKey record);

    int insertSelective(ClubBlindKey record);
}