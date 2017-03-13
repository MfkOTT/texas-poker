package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.BindInfo;

public interface BindInfoMapper extends DaoMapper{
  
    BindInfo selectByPrimaryKey(@Param("blindType")Integer blindType);

    List<BindInfo> findBlindLowerBlindTypeList(@Param("clubID")String clubID,@Param("blindType")Integer blindType);
}