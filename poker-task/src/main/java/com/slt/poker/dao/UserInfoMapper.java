package com.slt.poker.dao;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.UserInfo;

public interface UserInfoMapper extends DaoMapper{
	UserInfo findUser(@Param("loginID")String loginID,@Param("passWord")String passWord);

	void updatePwd(UserInfo newUser);

	UserInfo findUserByLoginId(@Param("loginID")String loginId);
	
	UserInfo findAlias(@Param("playerID")String playerID,@Param("dateStr") String dateStr,@Param("loginID") String loginID);

	UserInfo findUserByPartyId(@Param("playerID")String playerID);
}