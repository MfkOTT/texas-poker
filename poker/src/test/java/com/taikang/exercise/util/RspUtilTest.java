package com.taikang.exercise.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.slt.base.utils.RspUtil;

public class RspUtilTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = URLEncoder.encode("dt78439X8mE+j+T743aR07kEjfofl+y03rPyAt4mqvtD47ZABzSMVbCOA6Lvw9YArbLcjMxhhGoVmdhW8vrxgLPtOqcreO5quUkcI7OVj+titnQu43UPwRxLHyPNtxzGPobGh0bZ41+wkb0fyzNCi/bYB82r/EvsbiP+k/UE3l4=", "utf-8");
	System.out.println(s);
	}
}
