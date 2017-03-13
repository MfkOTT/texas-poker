package com.slt.poker.dao;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.PokerClub;

public interface PokerClubMapper extends DaoMapper{

    PokerClub findClub(@Param("clubID")String clubID);

}