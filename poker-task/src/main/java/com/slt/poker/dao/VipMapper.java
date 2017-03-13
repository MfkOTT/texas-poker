package com.slt.poker.dao;

import com.slt.poker.dto.Vip;

public interface VipMapper extends DaoMapper{
    int deleteByPrimaryKey(Integer vipLevel);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Integer vipLevel);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);
}