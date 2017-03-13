package com.slt.poker.dto;

public class UserInfo {
    private String loginID;

    private String userName;

    private String userSex;

    private String headImage;

    private String passWord;

    private String activity;

    private String protectDate;

    private String createDT;

    private String updateDT;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID == null ? null : loginID.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public String getProtectDate() {
        return protectDate;
    }

    public void setProtectDate(String protectDate) {
        this.protectDate = protectDate == null ? null : protectDate.trim();
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