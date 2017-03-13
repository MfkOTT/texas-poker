package com.slt.poker.dto;

public class PlayerHand extends PlayerHandKey {
    private String handCards;

    private String handColors;

    private String createDT;

    private String handSuit;

    public String getHandCards() {
        return handCards;
    }

    public void setHandCards(String handCards) {
        this.handCards = handCards == null ? null : handCards.trim();
    }

    public String getHandColors() {
        return handColors;
    }

    public void setHandColors(String handColors) {
        this.handColors = handColors == null ? null : handColors.trim();
    }

    public String getCreateDT() {
        return createDT;
    }

    public void setCreateDT(String createDT) {
        this.createDT = createDT == null ? null : createDT.trim();
    }

    public String getHandSuit() {
        return handSuit;
    }

    public void setHandSuit(String handSuit) {
        this.handSuit = handSuit == null ? null : handSuit.trim();
    }
}