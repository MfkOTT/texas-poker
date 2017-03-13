package com.slt.poker.dto;

public class PlayerKpi {
    private String playerKpiID;

    private String playerID;

    private String clubID;

    private Integer blindType;

    private String kpiCode;

    private String kpiValue;

    private String clubKpiValue;

    private String updateDT;

    public String getPlayerKpiID() {
        return playerKpiID;
    }

    public void setPlayerKpiID(String playerKpiID) {
        this.playerKpiID = playerKpiID == null ? null : playerKpiID.trim();
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID == null ? null : playerID.trim();
    }

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

    public String getKpiCode() {
        return kpiCode;
    }

    public void setKpiCode(String kpiCode) {
        this.kpiCode = kpiCode == null ? null : kpiCode.trim();
    }

    public String getKpiValue() {
        return kpiValue;
    }

    public void setKpiValue(String kpiValue) {
        this.kpiValue = kpiValue == null ? null : kpiValue.trim();
    }

    public String getClubKpiValue() {
        return clubKpiValue;
    }

    public void setClubKpiValue(String clubKpiValue) {
        this.clubKpiValue = clubKpiValue == null ? null : clubKpiValue.trim();
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT == null ? null : updateDT.trim();
    }
}