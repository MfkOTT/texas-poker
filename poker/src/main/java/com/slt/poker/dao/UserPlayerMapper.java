package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.UserPlayer;
import com.slt.poker.dto.UserPlayerKey;

public interface UserPlayerMapper extends DaoMapper{

    List<UserPlayer> findUserPlayer(@Param("loginID")String loginID);
    UserPlayer findUserPlayerByKey(UserPlayerKey userPlayerKey);
    

}