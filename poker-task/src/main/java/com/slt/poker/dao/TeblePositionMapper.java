package com.slt.poker.dao;

import com.slt.poker.dto.TeblePosition;

public interface TeblePositionMapper extends DaoMapper{
    int deleteByPrimaryKey(String positionCode);

    int insert(TeblePosition record);

    int insertSelective(TeblePosition record);

    TeblePosition selectByPrimaryKey(String positionCode);

    int updateByPrimaryKeySelective(TeblePosition record);

    int updateByPrimaryKey(TeblePosition record);
}