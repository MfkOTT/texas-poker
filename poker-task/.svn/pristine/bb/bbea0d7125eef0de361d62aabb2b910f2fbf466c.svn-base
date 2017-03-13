package com.slt.poker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SimpleDateUtil {
	
	/**
	 * 获取指定时间的格式化串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
		return sdf.format(date);
	}
	
	/**
	 * 获取指定格式时间串的date值
	 * 
	 * @param date
	 * @param pattern 指定格式
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String date, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
		return sdf.parse(date);
	}
	
	/**
	 * @Description 获取指定时间${date}的前/后${dayNum}天的值
	 * @param date 指定时间
	 * @param dayNum 天数
	 * @return
	 *
	 * @author maoyl05
	 * @date 2016年8月15日
	 * 
	 * @deprecated
	 */
	public static Date getDateAlter(Date date, int dayNum) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		cal.add(Calendar.DATE, dayNum);
		return cal.getTime();
	}
	

	
	/**
	 * 计算指定时间的天数之前的时间（年月日时分秒）
	 * @param date 指定时间
	 * <br><i>正：向后；负：向前</i></br>
	 * @param yearNum 年数
	 * @param monthNum 月数
	 * @param dayNum 天数
	 * @param hourNum 时数
	 * @param minuteNum 分数
	 * @param secondNum 秒数
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDateAlter(Date date, int yearNum,
			int monthNum, int dayNum, int hourNum, int minuteNum, int secondNum) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		cal.add(Calendar.YEAR, yearNum);
		cal.add(Calendar.MONTH, monthNum);
		cal.add(Calendar.DATE, dayNum);
		cal.add(Calendar.HOUR_OF_DAY, hourNum);
		cal.add(Calendar.MINUTE, minuteNum);
		cal.add(Calendar.SECOND, secondNum);
		return cal.getTime();
	}
}
