package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.UserVip;
import com.slt.poker.dto.UserVipKey;

public interface UserVipMapper extends DaoMapper{
    UserVip findUserVip(UserVipKey key);

	List<UserVip> findEeffectiveVipClubList(@Param("loginID")String loginId, @Param("timeStr")String timeStr);

}