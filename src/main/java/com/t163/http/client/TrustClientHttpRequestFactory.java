/*
 * @(#)TrustClientHttpRequestFactory.java $version 2013年12月17日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.http.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

/**
 * nhn t-163-api
 * com.t163.http.client.TrustClientHttpRequestFactory.java
 * @author st13902
 * @date 2013年12月17日
 */
public class TrustClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

	private SSLSocketFactory sslSocketFactory;

	private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};

	@Override
	protected HttpURLConnection openConnection(URL url, Proxy proxy) throws IOException {
		if (StringUtils.equals(url.getProtocol(), "https")) {
			HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
			HttpsURLConnection urlConnection = (HttpsURLConnection)(proxy != null ? url.openConnection(proxy)
				: url.openConnection());
			urlConnection.setHostnameVerifier(DO_NOT_VERIFY);
			return urlConnection;
		} else {
			HttpURLConnection urlConnection = (HttpURLConnection)(proxy != null ? url.openConnection(proxy)
				: url.openConnection());
			return urlConnection;
		}
	}

	public void setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
		this.sslSocketFactory = sslSocketFactory;
	}

}
