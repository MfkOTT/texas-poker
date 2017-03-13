package com.slt.poker.dto;

public class HandCardsBaseInfo {
    private String handCardsCode;

    private String handCards;

    private String handCardsAlias;

    private String handSuit;

    private Integer rowIndex;

    private Integer colIndex;

    public String getHandCardsCode() {
        return handCardsCode;
    }

    public void setHandCardsCode(String handCardsCode) {
        this.handCardsCode = handCardsCode == null ? null : handCardsCode.trim();
    }

    public String getHandCards() {
        return handCards;
    }

    public void setHandCards(String handCards) {
        this.handCards = handCards == null ? null : handCards.trim();
    }

    public String getHandCardsAlias() {
        return handCardsAlias;
    }

    public void setHandCardsAlias(String handCardsAlias) {
        this.handCardsAlias = handCardsAlias == null ? null : handCardsAlias.trim();
    }

    public String getHandSuit() {
        return handSuit;
    }

    public void setHandSuit(String handSuit) {
        this.handSuit = handSuit == null ? null : handSuit.trim();
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getColIndex() {
        return colIndex;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex;
    }
}