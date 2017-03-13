package com.slt.poker.dto;

public class HandCardsProfit {
    private String profitID;

    private String playerID;

    private String clubID;

    private Integer bindType;

    private String handCardCode;

    private Integer gameCount;

    private Integer profitCount;

    private String onceMaxWin;

    private String onceMaxLose;

    private String profit;

    private String updateDT;

    public String getProfitID() {
        return profitID;
    }

    public void setProfitID(String profitID) {
        this.profitID = profitID == null ? null : profitID.trim();
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

    public Integer getBindType() {
        return bindType;
    }

    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }

    public String getHandCardCode() {
        return handCardCode;
    }

    public void setHandCardCode(String handCardCode) {
        this.handCardCode = handCardCode == null ? null : handCardCode.trim();
    }

    public Integer getGameCount() {
        return gameCount;
    }

    public void setGameCount(Integer gameCount) {
        this.gameCount = gameCount;
    }

    public Integer getProfitCount() {
        return profitCount;
    }

    public void setProfitCount(Integer profitCount) {
        this.profitCount = profitCount;
    }

    public String getOnceMaxWin() {
        return onceMaxWin;
    }

    public void setOnceMaxWin(String onceMaxWin) {
        this.onceMaxWin = onceMaxWin == null ? null : onceMaxWin.trim();
    }

    public String getOnceMaxLose() {
        return onceMaxLose;
    }

    public void setOnceMaxLose(String onceMaxLose) {
        this.onceMaxLose = onceMaxLose == null ? null : onceMaxLose.trim();
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit == null ? null : profit.trim();
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT == null ? null : updateDT.trim();
    }
}