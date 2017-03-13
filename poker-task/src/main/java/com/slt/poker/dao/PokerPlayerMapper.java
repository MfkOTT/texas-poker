package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.PokerPlayer;

public interface PokerPlayerMapper extends DaoMapper{

    List<PokerPlayer> findPlayerList(@Param("clubID")String clubId,@Param("playerName")String playerName);
    
    PokerPlayer findPokerPlayer(@Param("playerID")String playerID);
}