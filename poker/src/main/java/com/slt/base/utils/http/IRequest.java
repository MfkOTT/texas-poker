package com.slt.base.utils.http;

import java.util.Map;

public interface IRequest {
	public String doPost(String url, String content, String ctype, String charset,Map<String,String> headMap) throws Exception;
	public String doPostFile(String url, String fileName, byte[] content, String charset,Map<String,String> headMap) throws Exception;
	public String doGet(String url) throws Exception;
	public Map<String, Object> doGetFile(String url) throws Exception;
}
