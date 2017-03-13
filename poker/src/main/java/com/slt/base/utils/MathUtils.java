package com.slt.base.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 算法工具类
 * 
 * @author Administrator
 * 
 */
public class MathUtils {

	/**
	 * 盈利为正的前30%手牌为盈利最高(2),盈利为正的中间50%为盈利较高(1)，盈利为正的最后20%和盈利为0的与盈利为负的前20%为水平手牌(0)
	 * ,盈利为负的中间50%为亏损手牌(-1)，盈利为负的最后30%为严重亏损(-2)。
	 * 
	 * @param list
	 *            盈利明细
	 * @param args
	 *            待确定盈利类型的数
	 * @return
	 */
	public static int getSimpleProfit(List<Integer> list, int args) {
		final double radio_3 = 0.3;
		final double radio_7 = 0.7;
		final double radio_8 = 0.8;
		if (args == 0) {
			return 0;
		}
		if (args < 0) {
			List<Integer> nagetive = new ArrayList<Integer>();
			for (Integer integer : list) {
				if (integer < 0) {
					nagetive.add(integer);
				}
			}
			Collections.sort(nagetive);
			int firstIndex = nagetive.indexOf(args);
			int type2 = (int) Math.floor(nagetive.size() * radio_3);
			int type1 = (int) Math.floor(nagetive.size() * radio_8);
			if (firstIndex <= type2) {
				return -2;
			}
			if (firstIndex > type2 && firstIndex <= type1) {
				return -1;
			}
			return 0;
		}
		if (args > 0) {
			List<Integer> postive = new ArrayList<Integer>();
			for (Integer integer : list) {
				if (integer > 0) {
					postive.add(integer);
				}
			}
			Collections.sort(postive);
			int firstIndex = postive.indexOf(args);
			int type2 = (int) Math.floor(postive.size() * radio_3);
			int type1 = (int) Math.floor(postive.size() * radio_7);
			if (firstIndex <= type2) {
				return 0;
			}
			if (firstIndex > type2 && firstIndex <= type1) {
				return 1;
			}
			return 2;
		}
		return 500;
	}
}
