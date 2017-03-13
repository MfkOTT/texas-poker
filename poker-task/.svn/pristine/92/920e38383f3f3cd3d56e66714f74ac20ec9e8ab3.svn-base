package com.slt.poker.dao;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.UserToken;

public interface UserTokenMapper extends DaoMapper{
    int insertToken(UserToken record);

    UserToken findToken(@Param("loginID")String loginID);
    
    UserToken findByTokenAndDeviceId(@Param("userToken")String userToken,@Param("deviceID")String deviceID);
    
    int updateToken(UserToken record);
}