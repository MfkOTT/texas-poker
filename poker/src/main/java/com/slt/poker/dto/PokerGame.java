package com.slt.poker.dto;

public class PokerGame {
    private String gameID;

    private String partyID;

    private Integer playerCount;

    private Integer gameIndex;

    private String endStage;

    private String showDown;

    private String createDT;

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID == null ? null : gameID.trim();
    }

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID == null ? null : partyID.trim();
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

    public String getEndStage() {
        return endStage;
    }

    public void setEndStage(String endStage) {
        this.endStage = endStage == null ? null : endStage.trim();
    }

    public String getShowDown() {
        return showDown;
    }

    public void setShowDown(String showDown) {
        this.showDown = showDown == null ? null : showDown.trim();
    }

    public String getCreateDT() {
        return createDT;
    }

    public void setCreateDT(String createDT) {
        this.createDT = createDT == null ? null : createDT.trim();
    }
}