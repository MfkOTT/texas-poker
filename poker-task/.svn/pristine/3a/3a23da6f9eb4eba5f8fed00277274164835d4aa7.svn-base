package com.slt.poker.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slt.poker.dao.PlayerKpiMapper;
import com.slt.poker.dto.PlayerKpi;
import com.slt.poker.util.CalcUtil;
import com.slt.poker.util.NonceUtil;
import com.slt.poker.util.SimpleDateUtil;

/**
 * 主要是计算几种典型的起手牌型相对不同位置的比例及次数
 * @author Administrator
 *
 */
@Service
public class PokerPatternsScaleService {
	@Autowired
	private PlayerKpiMapper playerKpiMapper;
	/**
	 *  2050-2051加注或跟注3Bet时的AA比例,次数 
	 * @throws Exception
	 */
	public void saveCallOrRaiseBetThree_PatternAA() throws Exception{

		final String kpiCode = "2050";
		final String kpiCode1 = "2051";
		List<PlayerKpi> list = this.playerKpiMapper.findCallOrRaiseBetThree_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2052-2053相对后位加3Bet的AA比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Mp_PatternAA() throws Exception{
		final String kpiCode = "2052";
		final String kpiCode1 = "2053";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Mp_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2054-2055相对后位跟3Bet的AA比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Mp_PatternAA() throws Exception{
		final String kpiCode = "2054";
		final String kpiCode1 = "2055";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Mp_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2056-2057相对前位加3Bet的AA比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Ep_PatternAA() throws Exception{
		final String kpiCode = "2056";
		final String kpiCode1 = "2057";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Ep_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2058-2059相对前位跟3Bet的AA比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Ep_PatternAA() throws Exception{
		final String kpiCode = "2058";
		final String kpiCode1 = "2059";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Ep_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2060-2061相对前位加4Bet+的AA比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetFour_Ep_PatternAA() throws Exception{
		final String kpiCode = "2060";
		final String kpiCode1 = "2061";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetFour_Ep_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2062-2063相对前位跟4Bet+的AA比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetFour_Ep_PatternAA() throws Exception{
		final String kpiCode = "2062";
		final String kpiCode1 = "2063";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetFour_Ep_PatternAA();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2064-2065加注或跟注3Bet时的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveCallOrRaiseBetThree_PatternStrong() throws Exception{
		final String kpiCode = "2064";
		final String kpiCode1 = "2065";
		List<PlayerKpi> list = this.playerKpiMapper.findCallOrRaiseBetThree_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}

	
	/**
	 *  2066-2067相对后位加3Bet的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Mp_PatternStrong() throws Exception{
		final String kpiCode = "2066";
		final String kpiCode1 = "2067";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Mp_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2068-2069相对后位跟3Bet的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Mp_PatternStrong() throws Exception{
		final String kpiCode = "2068";
		final String kpiCode1 = "2069";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Mp_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2070-2071相对前位加3Bet的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Ep_PatternStrong() throws Exception{
		final String kpiCode = "2070";
		final String kpiCode1 = "2071";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Ep_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2072-2073相对前位跟3Bet的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Ep_PatternStrong() throws Exception{
		final String kpiCode = "2072";
		final String kpiCode1 = "2073";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Ep_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2074-2075相对前位加4Bet+的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetFour_Ep_PatternStrong() throws Exception{
		final String kpiCode = "2074";
		final String kpiCode1 = "2075";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetFour_Ep_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2076-2077相对前位跟4Bet+的AA/KK/QQ/AK比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetFour_Ep_PatternStrong() throws Exception{
		final String kpiCode = "2076";
		final String kpiCode1 = "2077";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetFour_Ep_PatternStrong();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}
	}
	/**
	 *  2078-2079加注或跟注3Bet时的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveCallOrRaiseBetThree_PatternPoket() throws Exception{
		final String kpiCode = "2078";
		final String kpiCode1 = "2079";
		List<PlayerKpi> list = this.playerKpiMapper.findCallOrRaiseBetThree_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2080-2081相对后位加3Bet的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Mp_PatternPoket() throws Exception{
		final String kpiCode = "2080";
		final String kpiCode1 = "2081";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Mp_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2082-2083相对后位跟3Bet的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Mp_PatternPoket() throws Exception{
		final String kpiCode = "2082";
		final String kpiCode1 = "2083";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Mp_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2084-2085相对前位加3Bet的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Ep_PatternPoket() throws Exception{
		final String kpiCode = "2084";
		final String kpiCode1 = "2085";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Ep_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2086-2087相对前位跟3Bet的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Ep_PatternPoket() throws Exception{
		final String kpiCode = "2086";
		final String kpiCode1 = "2087";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Ep_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2088-2089相对前位加4Bet+的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetFour_Ep_PatternPoket() throws Exception{
		final String kpiCode = "2088";
		final String kpiCode1 = "2089";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetFour_Ep_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2090-2091相对前位跟4Bet+的口袋对比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetFour_Ep_PatternPoket() throws Exception{
		final String kpiCode = "2090";
		final String kpiCode1 = "2091";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetFour_Ep_PatternPoket();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2092-2093加注或跟注3Bet时的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveCallOrRaiseBetThree_PatternOther() throws Exception{
		final String kpiCode = "2092";
		final String kpiCode1 = "2093";
		List<PlayerKpi> list = this.playerKpiMapper.findCallOrRaiseBetThree_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2094-2095相对后位加3Bet的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Mp_PatternOther() throws Exception{
		final String kpiCode = "2094";
		final String kpiCode1 = "2095";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Mp_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2096-2097相对后位跟3Bet的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Mp_PatternOther() throws Exception{
		final String kpiCode = "2096";
		final String kpiCode1 = "2097";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Mp_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2098-2099相对前位加3Bet的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetThree_Ep_PatternOther() throws Exception{
		final String kpiCode = "2098";
		final String kpiCode1 = "2099";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetThree_Ep_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2100-2101相对前位跟3Bet的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetThree_Ep_PatternOther() throws Exception{
		final String kpiCode = "2100";
		final String kpiCode1 = "2101";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetThree_Ep_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2102-2103相对前位加4Bet+的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveRaiseBetFour_Ep_PatternOther() throws Exception{
		final String kpiCode = "2102";
		final String kpiCode1 = "2103";
		List<PlayerKpi> list = this.playerKpiMapper.findRaiseBetFour_Ep_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 *  2104-2105相对前位跟4Bet+的其他手牌比例,次数 
	 * @throws Exception
	 */
	public void saveCallBetFour_Ep_PatternOther() throws Exception{
		final String kpiCode = "2104";
		final String kpiCode1 = "2105";
		List<PlayerKpi> list = this.playerKpiMapper.findCallBetFour_Ep_PatternOther();
		if(!list.isEmpty()){
			this.doData(list,kpiCode,kpiCode1);
		}		
	}
	/**
	 * 2106位置技术
	 * @throws Exception
	 */
	public void savePostionSkill() throws Exception{
		final String kpiCode = "2106";
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		List<PlayerKpi> playerKpitList = this.playerKpiMapper.findPostionSkill();
		
		PlayerKpi dataItem; // 数据库中查询到的每条记录
		Map<String, List<PlayerKpi>> resultMap= new HashMap<String, List<PlayerKpi>>(); // 最终要的结果
		Map<String,Map<String,String>> countMap = new HashMap<String,Map<String,String>>();//统计俱乐部概率
		for(int i=0;i<playerKpitList.size();i++){
		    dataItem = playerKpitList.get(i);
		    String str = dataItem.getClubID()+"_"+dataItem.getBlindType();
		    if(resultMap.containsKey(str)){
		        resultMap.get(str).add(dataItem);
		    }else{
		        List<PlayerKpi> list = new ArrayList<PlayerKpi>();
		        list.add(dataItem);
		        resultMap.put(str,list);
		    }
		    
		    //统计相同俱乐部同类型的值
	        if(countMap.containsKey(str)){
	        	countMap.get(str).put("sumPoolCount",CalcUtil.getNumInfo(countMap.get(str).get("sumPoolCount"),dataItem.getPoolCount()));
	        	countMap.get(str).put("sumGameCount",CalcUtil.getNumInfo(countMap.get(str).get("sumGameCount"),dataItem.getGameCount()));
	        }else{
	        	Map<String,String> map = new HashMap<String,String>();
	        	map.put("sumPoolCount", dataItem.getPoolCount());
	        	map.put("sumGameCount", dataItem.getGameCount());
	        	countMap.put(str, map);
	        }
		}
		 //循环统一俱乐部和统一盲注类型入库
		   Iterator it = countMap.entrySet().iterator();
		   List<PlayerKpi> kpiList = new ArrayList<PlayerKpi>();
		   while (it.hasNext()) {
			    Map.Entry entry = (Map.Entry) it.next();
			    String key = (String)entry.getKey();
			    Map<String,String> value = (Map<String,String>)entry.getValue();
			    String divide = CalcUtil.getDivide(value.get("sumPoolCount"),value.get("sumGameCount"),2);
			    List<PlayerKpi> pList = resultMap.get(key);
				if(!pList.isEmpty()){
					for (PlayerKpi playerKpi : pList) {
						 playerKpi.setPlayerKpiID(NonceUtil.getUuid());
						 playerKpi.setUpdateDT(dateString);
						 playerKpi.setClubKpiValue(divide);
						 playerKpi.setKpiCode(kpiCode);
						 kpiList.add(playerKpi);
					}
				}
				value.clear();
		   }
			this.playerKpiMapper.deleteKpiByKpiCode(kpiCode);
			this.playerKpiMapper.insertKpiBatch(kpiList);
			
	}
	/**
	 * 统一数据处理
	 * @param list 待处理列表
	 * @param kpiCode 指标编号，比例
	 * @param kpiCode1 指标编号，次数
	 */
	private void doData(List<PlayerKpi> list, String kpiCode, String kpiCode1) throws Exception{
		//比例
		List<PlayerKpi> scaleList = new ArrayList<PlayerKpi>();
		//次数
		List<PlayerKpi> timesList = new ArrayList<PlayerKpi>();

		String dateStr = SimpleDateUtil.format(new Date(), "yyyyMMddHHmmss");
		for (PlayerKpi playerKpi : list) {
			playerKpi.setUpdateDT(dateStr);
			playerKpi.setPlayerKpiID(NonceUtil.getUuid());
			playerKpi.setKpiCode(kpiCode);
			scaleList.add(playerKpi);
		}
		this.playerKpiMapper.deleteKpiByKpiCode(kpiCode);
		this.playerKpiMapper.insertKpiBatch(scaleList);

		for (PlayerKpi playerKpi : list) {
			playerKpi.setUpdateDT(dateStr);
			playerKpi.setPlayerKpiID(NonceUtil.getUuid());
			playerKpi.setKpiValue(String.valueOf(playerKpi.getCount()));
			playerKpi.setKpiCode(kpiCode1);
			timesList.add(playerKpi);
		}
		this.playerKpiMapper.deleteKpiByKpiCode(kpiCode1);
		this.playerKpiMapper.insertKpiBatch(timesList);

	}
}
