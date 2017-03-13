package com.slt.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
	 * 获取指定时间${date}的前/后${dayNum}天的零点毫秒值
	 * 
	 * @param date 指定时间
	 * @param dayNum 天数
	 */
	public static long getDateAlter(Date date, int dayNum) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		cal.add(Calendar.DATE, dayNum);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	public static void main(String[] args) throws ParseException {
		
		long time = new Date().getTime();
		System.out.println(time);
		long ss = 7*24*60*60*1000;
		System.out.println(ss);
		System.out.println(time +ss);
		System.out.println(format(new Date(time +ss), "yyyyMMddHHmmss"));
		
		System.out.println(parse("20161222235959000", "yyyyMMddHHmmssSSS").getTime());
//		System.out.println(getDateAlter(parse("20161108000000000", "yyyyMMddHHmmssSSS"),0));
//		System.out.println(format(new Date(1478534400000L), "yyyyMMddHHmmssSSS"));
//		
//		System.out.println(String.format(PropertyUtil.getConstants("redirectUrl"),"asd","asdasdas"));
		Map<String,String> headMap = new HashMap<String,String>();
		headMap.put("appid", "wx2f763d09aa9ca523");
		headMap.put("channel", "rs");
		headMap.put("paymode", "wr");
		
		String headSign = Md5Util.getSign(headMap, PropertyUtil.getConstants("md5Key"));
		System.out.println(headSign);
	}
}
