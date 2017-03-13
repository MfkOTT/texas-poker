package com.slt.poker.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.slt.poker.dto.FlopPlayerKpi;

/**
 * 翻牌阶段kpi统计
 * @author Administrator
 *
 */
public interface FlopPlayerKpiMapper extends DaoMapper {

	/** 根据kpicode删除数据 **/
	void deleteKpiByKpiCode(@Param("kpiCode")String kpiCode);
	/** 批量插入数据 **/
	void insertKpiBatch(List<FlopPlayerKpi> KpiList);
	
	/**3001 flop胜率 在flop上收pot次数/见到flop的次数**/
	List<FlopPlayerKpi> findFlopPlayerWinRate();
	
	/**3002 总Cbet率 在preflop中最后一个加注的在flop上第一下注的次数/最后一个在preflop上加注的次数**/
	List<FlopPlayerKpi> findFlopPlayerCbetRate();
	
	/**3003 有位置的CBet率 在最后位的cbet次数/总cbet次数**/
	List<FlopPlayerKpi> findFlopPlayerPositionCbetRate();
	
	/**3004 无位置的CBet 在最前位的cbet次数/总cbet次数**/
	List<FlopPlayerKpi> findFlopPlayerNoPositionCbetRate();

	/**3005 Cbet面对raise的跟注率 Cbet面对raise的跟注次数/Cbet面对raise的总次数**/
	List<FlopPlayerKpi> findFlopPlayerCbetRaiseRate();

	/**3006 Cbet面对raise的Reraise率Cbet面对raise的加注次数/Cbet面对raise的总次数**/
	List<FlopPlayerKpi> findFlopPlayerCbetReraiseRate();
	
	/**3007 Cbet面对raise的弃牌率 Cbet面对raise的弃牌次数/Cbet面对raise的总次数**/
	List<FlopPlayerKpi> findFlopCbetRaiseBackOutRate();
	
	/**3008 未Cbet的Check-Call率**/
	List<FlopPlayerKpi> findFlopNoCBetCheckCallRate();
	
	/**3009**/
	List<FlopPlayerKpi> findFlopNoCBetCheckRaiseRate();
	
	/**3010**/
	List<FlopPlayerKpi> findFlopNoCBetCheckFoldRate();
	
	/**3011**/
	List<FlopPlayerKpi> findFlopTotalFoldCBetRate();
	
	/**3012**/
	List<FlopPlayerKpi> findFlopTotalPositionFoldCBetRate();
	
	/**3013**/
	List<FlopPlayerKpi> findFlopTotalNoPositionFolddCBetRate();
	
	/**3014**/
	List<FlopPlayerKpi> findFlopTotalCallCBetRate();
	
	/**3015**/
	List<FlopPlayerKpi> findFlopTotalPositionCallCBetRate();
	
	/**3016**/
	List<FlopPlayerKpi> findFlopTotalNoPositionCallCBetRate();
	
	/**3017**/
	List<FlopPlayerKpi> findFlopTotalRaiseCBetRate();
	
	/**3018**/
	List<FlopPlayerKpi> findFlopTotalPositionRaiseCBetRate();
	
	/**3019**/
	List<FlopPlayerKpi> findFlopTotalNoPositionRaiseCBetRate();
	
	/**3020**/
	List<FlopPlayerKpi> findFlopFoldWithDonkRate();
	
	/**3021**/
	List<FlopPlayerKpi> findFlopCallWithDonkRate();
	
	/**3022**/
	List<FlopPlayerKpi> findFlopRaiseWithDonkRate();
	
	/**3023**/
	List<FlopPlayerKpi> findTotalLimpInPotBetRate();
	
	/**3024-3029**/
	List<FlopPlayerKpi> findLimpInPotBetRate(@Param("position")String position);
	
	/**3030**/
	List<FlopPlayerKpi> findTotalLimpInPotCallRate();
	
	/**3031-3035**/
	List<FlopPlayerKpi> findLimpInPotCallRate(@Param("position")String position);
	
	/**3036**/
	List<FlopPlayerKpi> findTotalLimpInPotRaiseRate();
	
	/**3037-3041**/
	List<FlopPlayerKpi> findLimpInPotRaiseRate(@Param("position")String position);
	
	/**3042**/
	List<FlopPlayerKpi> findTotalLimpInPotCheckCallRate();
	
	/**3043-3047**/
	List<FlopPlayerKpi> findLimpInPotCheckCallRate(@Param("position")String position);
	
	/**3048**/
	List<FlopPlayerKpi> findTotalLimpInPotCheckRaiseRate();
	
	/**3049-3053**/
	List<FlopPlayerKpi> findLimpInPotCheckRaiseRate(@Param("position")String position);
	
	/**3054**/
	List<FlopPlayerKpi> findTotalLimpInPotFoldRate();
	
	/**3055-3060**/
	List<FlopPlayerKpi> findLimpInPotFoldRate(@Param("position")String position);
	
	/**3061**/
	List<FlopPlayerKpi> findFinallyCbetRate();
	

}
