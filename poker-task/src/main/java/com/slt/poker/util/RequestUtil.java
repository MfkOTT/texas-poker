package com.slt.poker.util;

import com.slt.poker.util.http.HttpRequest;
import com.slt.poker.util.http.HttpsRequest;

public class RequestUtil {
	public static HttpsRequest initHttpsWithNoCert() {
		HttpsRequest httpsRequest = new HttpsRequest(null, null);
		return httpsRequest;
	}
	public static HttpsRequest initHttpsWithCert(String certPath, String certPass) {
		HttpsRequest httpsRequest = new HttpsRequest(certPath, certPass);
		return httpsRequest;
	}
	public static HttpRequest initHttp() {
		HttpRequest httpRequest = new HttpRequest();
		return httpRequest;
	}
}
