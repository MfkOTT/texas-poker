package com.slt.poker.dto;

public class PlayerKpi {
    private String playerKpiID;

    private String playerID;

    private String clubID;

    private Integer blindType;

    private String kpiCode;

    private String kpiValue;

    private String clubKpiValue;

    private String updateDT;
    
    private String poolCount;
    
    private String gameCount;
    
    private String winCount;
    
    private String winRate;
    
    private String riverCount;
    
    private String foldCount;
    
    private String showdowRate;
    
    private String profit;
    
    private String lose;
    
    private int count;
    
    
    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the profit
	 */
	public String getProfit() {
		return profit;
	}

	/**
	 * @param profit the profit to set
	 */
	public void setProfit(String profit) {
		this.profit = profit;
	}

	/**
	 * @return the lose
	 */
	public String getLose() {
		return lose;
	}

	/**
	 * @param lose the lose to set
	 */
	public void setLose(String lose) {
		this.lose = lose;
	}

	/**
	 * @return the riverCount
	 */
	public String getRiverCount() {
		return riverCount;
	}

	/**
	 * @param riverCount the riverCount to set
	 */
	public void setRiverCount(String riverCount) {
		this.riverCount = riverCount;
	}

	/**
	 * @return the foldCount
	 */
	public String getFoldCount() {
		return foldCount;
	}

	/**
	 * @param foldCount the foldCount to set
	 */
	public void setFoldCount(String foldCount) {
		this.foldCount = foldCount;
	}

	/**
	 * @return the showdowRate
	 */
	public String getShowdowRate() {
		return showdowRate;
	}

	/**
	 * @param showdowRate the showdowRate to set
	 */
	public void setShowdowRate(String showdowRate) {
		this.showdowRate = showdowRate;
	}

	/**
	 * @return the winCount
	 */
	public String getWinCount() {
		return winCount;
	}

	/**
	 * @param winCount the winCount to set
	 */
	public void setWinCount(String winCount) {
		this.winCount = winCount;
	}

	/**
	 * @return the winRate
	 */
	public String getWinRate() {
		return winRate;
	}

	/**
	 * @param winRate the winRate to set
	 */
	public void setWinRate(String winRate) {
		this.winRate = winRate;
	}

	/**
	 * @return the poolCount
	 */
	public String getPoolCount() {
		return poolCount;
	}

	/**
	 * @param poolCount the poolCount to set
	 */
	public void setPoolCount(String poolCount) {
		this.poolCount = poolCount;
	}


	/**
	 * @return the gameCount
	 */
	public String getGameCount() {
		return gameCount;
	}

	/**
	 * @param gameCount the gameCount to set
	 */
	public void setGameCount(String gameCount) {
		this.gameCount = gameCount;
	}

	public String getPlayerKpiID() {
        return playerKpiID;
    }

    public void setPlayerKpiID(String playerKpiID) {
        this.playerKpiID = playerKpiID == null ? null : playerKpiID.trim();
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID == null ? null : playerID.trim();
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID == null ? null : clubID.trim();
    }

  




	/**
	 * @return the blindType
	 */
	public Integer getBlindType() {
		return blindType;
	}

	/**
	 * @param blindType the blindType to set
	 */
	public void setBlindType(Integer blindType) {
		this.blindType = blindType;
	}

	public String getKpiCode() {
        return kpiCode;
    }

    public void setKpiCode(String kpiCode) {
        this.kpiCode = kpiCode == null ? null : kpiCode.trim();
    }

    public String getKpiValue() {
        return kpiValue;
    }

    public void setKpiValue(String kpiValue) {
        this.kpiValue = kpiValue == null ? null : kpiValue.trim();
    }

    public String getClubKpiValue() {
        return clubKpiValue;
    }

    public void setClubKpiValue(String clubKpiValue) {
        this.clubKpiValue = clubKpiValue == null ? null : clubKpiValue.trim();
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT == null ? null : updateDT.trim();
    }
}