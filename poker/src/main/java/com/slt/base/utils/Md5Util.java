package com.slt.base.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class Md5Util {
	/**
	 * 生成MD5签名的方法，按照ACSII排序
	 * @param map
	 * @param key
	 * @return
	 */
	public static String getSign(Map<String, String> map, String key) {
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();
			if (!StringUtils.isEmpty(v)) {
				list.add(k + "=" + v + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.append("key=" + key).toString();
		System.out.println(result);
		result = DigestUtils.md5Hex(result).toUpperCase();
		return result;
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
