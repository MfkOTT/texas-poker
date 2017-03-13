package com.slt.poker.dto;

public class TurnPlayerKpi {
    private String playerKpiID;

    private String playerID;

    private String clubID;

    private Integer blindType;

    private String kpiCode;

    private String kpiValue;

    private String clubKpiValue;

    private String updateDT;
	private String numerator;
    
    private String denominator;
    
    public String getPlayerKpiID() {
		return playerKpiID;
	}

	public void setPlayerKpiID(String playerKpiID) {
		this.playerKpiID = playerKpiID;
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

	public Integer getBlindType() {
		return blindType;
	}

	public void setBlindType(Integer blindType) {
		this.blindType = blindType;
	}

	public String getKpiCode() {
		return kpiCode;
	}

	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}

	public String getKpiValue() {
		return kpiValue;
	}

	public void setKpiValue(String kpiValue) {
		this.kpiValue = kpiValue;
	}

	public String getClubKpiValue() {
		return clubKpiValue;
	}

	public void setClubKpiValue(String clubKpiValue) {
		this.clubKpiValue = clubKpiValue;
	}

	public String getUpdateDT() {
		return updateDT;
	}

	public void setUpdateDT(String updateDT) {
		this.updateDT = updateDT;
	}

	public String getNumerator() {
		return numerator;
	}

	public void setNumerator(String numerator) {
		this.numerator = numerator;
	}

	public String getDenominator() {
		return denominator;
	}

	public void setDenominator(String denominator) {
		this.denominator = denominator;
	}


}
