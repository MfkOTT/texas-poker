package com.slt.poker.dto;

public class UserPlayerKey {
    private String loginID;

    private String playerID;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID == null ? null : loginID.trim();
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID == null ? null : playerID.trim();
    }
}