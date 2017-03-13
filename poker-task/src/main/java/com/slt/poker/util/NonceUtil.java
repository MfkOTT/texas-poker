package com.slt.poker.util;

import java.util.Random;
import java.util.UUID;

public class NonceUtil {

	/**
	 * @Title: createNonceStr
	 * @Description: 取得指定位数的不重复的随机串<br>
	 * <u>由大小写字母及数字组成</u>
	 *
	 * @param length 生成随机串位数
	 * @return 随机串
	 */
	public static String createNonceStr(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		return createNonceStr(chars, length);
	}
	
	/**
	 * @Title: createNonceStr
	 * @Description: 从字符串的涵盖范围字符中获取指定长度的随机串
	 *
	 * @param scope 指定字符串
	 * @param length 随机串长度
	 * @return 随机串
	 */
	public static String createNonceStr(String scope, int length) {
		Random rd = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < length; i++) {
			res.append(scope.charAt(rd.nextInt(scope.length())));
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(createNonceStr(4));
		}
		
	}
	/**
	 * UUID
	 * */
	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 指定位数UUID
	 * */
	public static String getUuid(int num) {
		return UUID.randomUUID().toString().replace("-", "").substring(0,num);
	}
}
