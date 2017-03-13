package com.slt.poker.dto;

public class GameCommunityCard {
    private String communityCardID;

    private String gameID;

    private String gameStage;

    private String communityCards;

    private String communityColor;

    public String getCommunityCardID() {
        return communityCardID;
    }

    public void setCommunityCardID(String communityCardID) {
        this.communityCardID = communityCardID == null ? null : communityCardID.trim();
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID == null ? null : gameID.trim();
    }

    public String getGameStage() {
        return gameStage;
    }

    public void setGameStage(String gameStage) {
        this.gameStage = gameStage == null ? null : gameStage.trim();
    }

    public String getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(String communityCards) {
        this.communityCards = communityCards == null ? null : communityCards.trim();
    }

    public String getCommunityColor() {
        return communityColor;
    }

    public void setCommunityColor(String communityColor) {
        this.communityColor = communityColor == null ? null : communityColor.trim();
    }
}