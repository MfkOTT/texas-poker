package com.slt.poker.dto;

public class Device {
    private String deviceID;

    private String loginID;

    private String activity;

    private String createDT;

    private String updateDT;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID == null ? null : deviceID.trim();
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID == null ? null : loginID.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public String getCreateDT() {
        return createDT;
    }

    public void setCreateDT(String createDT) {
        this.createDT = createDT == null ? null : createDT.trim();
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT == null ? null : updateDT.trim();
    }
}