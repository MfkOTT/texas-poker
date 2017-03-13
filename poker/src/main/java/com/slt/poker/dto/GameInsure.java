package com.slt.poker.dto;

public class GameInsure {
    private String inuserID;

    private String gameID;

    private String playerID;

    private String gameStage;

    private String pot;

    private String investment;

    private String insureBuy;

    private String insureClaim;

    private String insureProfit;

    public String getInuserID() {
        return inuserID;
    }

    public void setInuserID(String inuserID) {
        this.inuserID = inuserID == null ? null : inuserID.trim();
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID == null ? null : gameID.trim();
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID == null ? null : playerID.trim();
    }

    public String getGameStage() {
        return gameStage;
    }

    public void setGameStage(String gameStage) {
        this.gameStage = gameStage == null ? null : gameStage.trim();
    }

    public String getPot() {
        return pot;
    }

    public void setPot(String pot) {
        this.pot = pot == null ? null : pot.trim();
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment == null ? null : investment.trim();
    }

    public String getInsureBuy() {
        return insureBuy;
    }

    public void setInsureBuy(String insureBuy) {
        this.insureBuy = insureBuy == null ? null : insureBuy.trim();
    }

    public String getInsureClaim() {
        return insureClaim;
    }

    public void setInsureClaim(String insureClaim) {
        this.insureClaim = insureClaim == null ? null : insureClaim.trim();
    }

    public String getInsureProfit() {
        return insureProfit;
    }

    public void setInsureProfit(String insureProfit) {
        this.insureProfit = insureProfit == null ? null : insureProfit.trim();
    }
}