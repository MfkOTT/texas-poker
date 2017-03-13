package com.slt.poker.dao;

import com.slt.poker.dto.GameInsure;

public interface GameInsureMapper extends DaoMapper{
    int deleteByPrimaryKey(String inuserID);

    int insert(GameInsure record);

    int insertSelective(GameInsure record);

    GameInsure selectByPrimaryKey(String inuserID);

    int updateByPrimaryKeySelective(GameInsure record);

    int updateByPrimaryKey(GameInsure record);
}