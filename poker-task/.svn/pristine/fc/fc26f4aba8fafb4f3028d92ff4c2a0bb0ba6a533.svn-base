package com.slt.poker.util.http;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpRequest extends HttpConfig implements IRequest {

	@Override
	public String doPost(String url, String content, String ctype, String charset) throws Exception {
		String useCharset = (null == charset || "".equals(charset)) ? DEFAULT_CHARSET : charset;
		byte[] reqContent = {};
		if (content != null) {
			reqContent = content.getBytes(useCharset);
		}
		return doPost(url, ctype + ";charset=" + useCharset, reqContent);
	}
	
	@Override
	public String doPostFile(String url, String fileName, byte[] content, String charset) throws Exception {
		HttpURLConnection conn = null;
		OutputStream out = null;
		String rsp = null;
		String useCharset = (null == charset || "".equals(charset)) ? DEFAULT_CHARSET : charset;
		String boundary = "--------httppostfile";
		try {
			conn = getConnection(new URL(url), METHOD_POST, "multipart/form-data; boundary=" + boundary);
			out = conn.getOutputStream();
			
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("\r\n");
			strBuf.append("--").append(boundary).append("\r\n");
			strBuf.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"\r\n");
			strBuf.append("Content-Type: application/octet-stream \r\n");
			strBuf.append("\r\n");
			out.write(strBuf.toString().getBytes(useCharset));
			out.write(content);
			
			strBuf.setLength(0);
			strBuf.append("\r\n");
			strBuf.append("--" + boundary + "--" + "\r\n");
			strBuf.append("\r\n");
			out.write(strBuf.toString().getBytes());
			
			out.flush();
			
			rsp = getResponseAsString(conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != out) {
				out.close();
			}
			if (null != conn) {
				conn.disconnect();
			}
		}
		return rsp;
	}
	
	private String doPost(String url, String ctype, byte[] content) throws Exception {
		HttpURLConnection conn = null;
		OutputStream out = null;
		String rsp = null;
		try {
			conn = getConnection(new URL(url), METHOD_POST, ctype);
			out = conn.getOutputStream();
			out.write(content);
			out.flush();
			
			rsp = getResponseAsString(conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != out) {
				out.close();
			}
			if (null != conn) {
				conn.disconnect();
			}
		}
		return rsp;
	}
	
	@Override
	public String doGet(String url) throws Exception {
		HttpURLConnection conn = null;
		String rsp = null;
		try {
			conn = getConnection(new URL(url), METHOD_GET, null);
			rsp = getResponseAsString(conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != conn) {
				conn.disconnect();
			}
		}
		return rsp;
	}
	
	@Override
	public Map<String, Object> doGetFile(String url) throws Exception {
		HttpURLConnection conn = null;
		Map<String, Object> rsp = null;
		try {
			conn = getConnection(new URL(url), METHOD_GET, null);
			rsp = getResponseAsByteArray(conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (null != conn) {
				conn.disconnect();
			}
		}
		return rsp;
	}
}
