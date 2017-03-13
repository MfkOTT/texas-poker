package com.slt.poker.dto;

public class ClubPlayerKey {
    private String clubID;

    private String PLAYERID;

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID == null ? null : clubID.trim();
    }

    public String getPLAYERID() {
        return PLAYERID;
    }

    public void setPLAYERID(String PLAYERID) {
        this.PLAYERID = PLAYERID == null ? null : PLAYERID.trim();
    }
}