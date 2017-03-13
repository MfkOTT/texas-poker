package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.TurnPlayerKpi;

public interface TurnPlayerKpiMapper extends DaoMapper {
	/** 根据kpicode删除数据 **/
	void deleteKpiByKpiCode(@Param("kpiCode")String kpiCode);
	/** 批量插入数据 **/
	void insertKpiBatch(List<TurnPlayerKpi> KpiList);
	
	/** 4001 **/
	List<TurnPlayerKpi> findTurnWinRate();
	
	/** 4002 **/
	List<TurnPlayerKpi> findTurnTotalCbetRate();
	
	/** 4003 **/
	List<TurnPlayerKpi> findTurnPositionCbetRate();
	
	/** 4004 **/
	List<TurnPlayerKpi> findTurnNoPositionCbetRate();
	
	/** 4005 **/
	List<TurnPlayerKpi> findTurnCbetRaiseRate();
	
	/** 4006 **/
	List<TurnPlayerKpi> findTurnCbetReRaiseRate();
	
	/** 4007 **/
	List<TurnPlayerKpi> findTurnCbetFoldRate();
	
	/** 4008 **/
	List<TurnPlayerKpi> findTurnTotalCbetDelayRate();
	
	/** 4009 **/
	List<TurnPlayerKpi> findTurnPositionCbetDelayRate();
	
	/** 4010 **/
	List<TurnPlayerKpi> findTurnNoPositionCbetDelayRate();
	
	/** 4011 **/
	List<TurnPlayerKpi> findTurnTotalFoldCbetRate();
	
	/** 4012 **/
	List<TurnPlayerKpi> findTurnPositionFoldCbetRate();
	
	/** 4013 **/
	List<TurnPlayerKpi> findTurnNoPositionFoldCbetRate();
	
	/** 4014 **/
	List<TurnPlayerKpi> findTurnTotalCallCbetRate();
	
	/** 4015 **/
	List<TurnPlayerKpi> findTurnPositionCallCbetRate();
	
	/** 4016 **/
	List<TurnPlayerKpi> findTurnNoPositionCallCbetRate();
	
	/** 4017 **/
	List<TurnPlayerKpi> findTurnTotalRaiseCbetRate();
	
	/** 4018 **/
	List<TurnPlayerKpi> findTurnPositionRaiseCbetRate();
	
	/** 4019 **/
	List<TurnPlayerKpi> findTurnNoPositionRaiseCbetRate();
	
	/** 4020 **/
	List<TurnPlayerKpi> findTurnWithDonkFoldRate();
	
	/** 4021 **/
	List<TurnPlayerKpi> findTurnWithDonkCallRate();
	
	/** 4022 **/
	List<TurnPlayerKpi> findTurnWithDonkRaiseRate();
	
	/** 4023 **/
	List<TurnPlayerKpi> findTurnTotalLimpInPotBetRate();
	
	/** 4024-4029 **/
	List<TurnPlayerKpi> findTurnLimpInPotBetRate(@Param("position")String position);
	
	/** 4030 **/
	List<TurnPlayerKpi> findTurnTotalLimpInPotCallRate();
	
	/** 4031-4035 **/
	List<TurnPlayerKpi> findTurnLimpInPotCallRate(@Param("position")String position);
	
	/** 4036 **/
	List<TurnPlayerKpi> findTurnTotalLimpInPotRaiseRate();
	
	/** 4037-4041 **/
	List<TurnPlayerKpi> findTurnLimpInPotRaiseRate(@Param("position")String position);
	
	/** 4042 **/
	List<TurnPlayerKpi> findTurnTotalLimpInPotCheckCallRate();
	
	/** 4043-4047 **/
	List<TurnPlayerKpi> findTurnLimpInPotCheckCallRate(@Param("position")String position);
	
	/** 4048 **/
	List<TurnPlayerKpi> findTurnTotalLimpInPotCheckRaiseRate();
	
	/** 4049-4053 **/
	List<TurnPlayerKpi> findTurnLimpInPotCheckRaiseRate(@Param("position")String position);
	
	/** 4054 **/
	List<TurnPlayerKpi> findTurnTotalLimpInPotFoldRate();
	
	/** 4055-4060 **/
	List<TurnPlayerKpi> findTurnLimpInPotCheckFoldRate(@Param("position")String position);
}
