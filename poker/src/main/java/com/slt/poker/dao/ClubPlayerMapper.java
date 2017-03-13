package com.slt.poker.dao;

import com.slt.poker.dto.ClubPlayerKey;

public interface ClubPlayerMapper extends DaoMapper{
    int deleteByPrimaryKey(ClubPlayerKey key);

    int insert(ClubPlayerKey record);

    int insertSelective(ClubPlayerKey record);
}