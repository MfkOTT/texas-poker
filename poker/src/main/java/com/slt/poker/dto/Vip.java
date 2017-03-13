package com.slt.poker.dto;

public class Vip {
    private Integer vipLevel;

    private Integer blindType;

    private String vipDecription;

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    public Integer getBlindType() {
        return blindType;
    }

    public void setBlindType(Integer blindType) {
        this.blindType = blindType;
    }

    public String getVipDecription() {
        return vipDecription;
    }

    public void setVipDecription(String vipDecription) {
        this.vipDecription = vipDecription == null ? null : vipDecription.trim();
    }
}