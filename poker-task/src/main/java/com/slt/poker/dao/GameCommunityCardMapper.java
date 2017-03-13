package com.slt.poker.dao;

import com.slt.poker.dto.GameCommunityCard;

public interface GameCommunityCardMapper extends DaoMapper{
    int deleteByPrimaryKey(String communityCardID);

    int insert(GameCommunityCard record);

    int insertSelective(GameCommunityCard record);

    GameCommunityCard selectByPrimaryKey(String communityCardID);

    int updateByPrimaryKeySelective(GameCommunityCard record);

    int updateByPrimaryKey(GameCommunityCard record);
}