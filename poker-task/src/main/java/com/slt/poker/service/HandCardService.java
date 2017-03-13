package com.slt.poker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slt.poker.dao.HandCardsPositionMapper;
import com.slt.poker.dao.HandCardsProfitMapper;
import com.slt.poker.dto.HandCardsPosition;
import com.slt.poker.dto.HandCardsProfit;
import com.slt.poker.util.NonceUtil;
import com.slt.poker.util.SimpleDateUtil;

@Service
public class HandCardService {

	@Autowired
	private HandCardsProfitMapper handCardsProfitMapper;
	@Autowired
	private HandCardsPositionMapper handCardsPositionMapper;

	/**
	 * 计算起手牌盈利
	 */
	public void saveHandCardProfit() throws Exception{
		List<HandCardsProfit> list = this.handCardsProfitMapper.findCardsProfitList();
		if(!list.isEmpty()){
			String dateStr = SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss");
			for (HandCardsProfit handCardsProfit : list) {
				handCardsProfit.setProfitID(NonceUtil.getUuid());
				handCardsProfit.setUpdateDT(dateStr);
			}
			this.handCardsProfitMapper.deleteHandCardsProfit();
			this.handCardsProfitMapper.insertCardsProfitList(list);	
			}
	}
	/**
	 * 起手牌位置统计
	 */
	public void saveHandCardPostion() {
		List<HandCardsPosition> list = this.handCardsPositionMapper.findCardsPositionList();
		if(!list.isEmpty()){
			String dateStr = SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss");
			for (HandCardsPosition handCardsPosition : list) {
				handCardsPosition.setPositionID(NonceUtil.getUuid());
				handCardsPosition.setUpdateDT(dateStr);
			}
			this.handCardsPositionMapper.deleteHandCardsPosition();;
			this.handCardsPositionMapper.insertCardsPositionList(list);;	
			}
	}
}
