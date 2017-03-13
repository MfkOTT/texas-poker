package com.slt.poker.dto;

public class UserVipKey {
    private String loginID;

    private String clubID;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID == null ? null : loginID.trim();
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID == null ? null : clubID.trim();
    }
}