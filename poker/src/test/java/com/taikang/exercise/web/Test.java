package com.taikang.exercise.web;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class Test {
	@RequestMapping(value="/json", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getJSON() {
		JSONObject jb = new JSONObject();
		jb.put("key", "value");
		return jb;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
//		User u = new User();
//		u.setBirthYear(1990);
//		u.setBmi(0.00);
//		u.setCreateTime("20160824141801");
//		u.setHeadImg("http://wx.qlogo.cn/mmopen/ajNVdqHZLLAIaUAILpeJyrg2VdggOn07C9D1pwrJE0Ma6YgP8adMmicibxq1Uc8EPMfib0JlyCVicGAeGCngHNUMsQ/0");
//		u.setHeight(187);
//		u.setNickName("大易");
//		u.setOpenId("oYsgvuNB1PYFytAdZy4vrF3B7MpI");
//		u.setSex(1);
//		u.setUnionId("fjdjdjdjdj");
//		u.setUpdateTime("20160824141801");
//		u.setWeight(70);
//		System.out.println((JSONObject) JSON.toJSON(u));
//		String unionId ="P6phwbZDfb9wa7uhRuLRukjwbHyQvxGpN3jmdfbX/8clz5x2bM9vgyVfHk/XI/480OCqsPZFU0htprRqZ3s239R4f5rzlAwabaVyky514mtINBFrqElx9Ztu218tmz17+FEWnVHrJkkbztDZqoFm3Ucf9Lm6TjgYvHFPTM1b1W4=";
//		JSONObject jb = new JSONObject();
//		jb.put("unionId", unionId);
//		System.out.println(jb);
//		unionId = "fjdjdjdjdj";
//		
//		jb.put("unionId", unionId);
//		System.out.println(jb);
//		
//		System.out.println("B001_NE7iSVnC_SlDn".substring(0,13));
//		
//		JSONObject params=JSON.parseObject("{\"subitem\": [{\"score\": 5,\"subitemId\": \"C001_L6SZWMlx_ItRT\"},{\"score\": 0,\"subitemId\": \"C001_L6SZWMlx_c74k\"}],\"info\": \"CkTcBfLtjpwn4oFrcdQDUepEIwaYnJy0jHUdTFDAdGE0401JtemavzpBNePtifkKg6cIez0K2Q/TyCvD13d/OW1Rs+RR/95KRp7r8BlT5ABJFl/8sWDUZNNZavnOvoOmpnBNYp5RhNWGaTtPW5jbQgBCL0HbyOBf3WJK60nA2tU=\"}");
//		JSONArray subitems = params
//				.getJSONArray("subitem");
//		List<Object> scores =  JSON.parseArray(subitems, Type);
//				
//		System.out.println(scores.get(1));
//		System.out.println(URLDecoder.decode("%E9%B2%81%E7%91%9E","utf-8"));
//		List li = null;
//		URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs(); 
//	        for (URL urL : urls) {
//	            System.out.println(urL.toExternalForm());
//	        }
//		for (int i = 0; i < 100000; i++) {
//			int ii=(int)(Math.random()*2000+10000);
//			System.out.println(ii);
//			if(ii<10000 || ii>12000){
//				System.out.println("outline");
//			}
//		}
//		int i=0;
//		for (; i < 834794; i+=1000) {
//			int j=i+1000;
//			System.out.println(i+"=="+j);
//			if(i==834000){
//				for(;i<834794;i++){
//					System.out.println("==="+i);
//				}
//			}
//		}
//		if(834794%1000!=0){
//			for(;i<834794;i++){
//				System.out.println("==="+i);
//			}
//		}
//		System.out.println(834794%1000!=0);
		JSONObject j = new JSONObject();
		j.put("main", "aaa");
		j.put("slave", "aaa");
		
		String main = j.getString("main");
		String slave = j.getString("slave");
		String ij="asdas";
		String ii=new String("asdas");
	System.out.println(main==slave);	
	System.out.println(main.equals(slave));
	}
}
