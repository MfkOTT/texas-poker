package com.slt.poker.dto;

public class ClubBlindKey {
    private String clubID;

    private Integer blindType;

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID == null ? null : clubID.trim();
    }

    public Integer getBlindType() {
        return blindType;
    }

    public void setBlindType(Integer blindType) {
        this.blindType = blindType;
    }
}