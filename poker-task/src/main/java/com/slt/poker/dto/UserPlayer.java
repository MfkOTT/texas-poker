package com.slt.poker.dto;

public class UserPlayer extends UserPlayerKey {
    private String createDT;

    public String getCreateDT() {
        return createDT;
    }

    public void setCreateDT(String createDT) {
        this.createDT = createDT == null ? null : createDT.trim();
    }
}