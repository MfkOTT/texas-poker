package com.slt.poker.dto;

public class HandCardsPosition {
	private String positionID;
	private String playerID;
	private String clubID;
	private int bindType;
	private String positionName;
	private String handCardCode;
	private int poolCount;
	private String updateDT;

	public String getPositionID() {
		return positionID;
	}

	public void setPositionID(String positionID) {
		this.positionID = positionID;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getClubID() {
		return clubID;
	}

	public void setClubID(String clubID) {
		this.clubID = clubID;
	}

	public int getBindType() {
		return bindType;
	}

	public void setBindType(int bindType) {
		this.bindType = bindType;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getHandCardCode() {
		return handCardCode;
	}

	public void setHandCardCode(String handCardCode) {
		this.handCardCode = handCardCode;
	}

	public int getPoolCount() {
		return poolCount;
	}

	public void setPoolCount(int poolCount) {
		this.poolCount = poolCount;
	}

	public String getUpdateDT() {
		return updateDT;
	}

	public void setUpdateDT(String updateDT) {
		this.updateDT = updateDT;
	}

}
