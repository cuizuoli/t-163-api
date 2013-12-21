/*
 * @(#)OAuth2.java $version 2013年12月21日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.api;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.t163.enums.Display;
import com.t163.http.client.T163HttpClient;
import com.t163.model.AccessToken;
import com.t163.model.TokenInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * DaLian Software t-163-api
 * com.t163.api.OAuth2.java
 * @author cuizuoli
 * @date 2013年12月21日
 */
@Slf4j
@Component("t163OAuth2")
public class OAuth2 {

	private static final String OAUTH2_AUTHORIZE = "https://api.t.163.com/oauth2/authorize";
	private static final String OAUTH2_ACCESS_TOKEN = "https://api.t.163.com/oauth2/access_token";
	private static final String OAUTH2_GET_TOKEN_INFO = "https://api.t.163.com/oauth2/get_oauth2_token.json";

	@Value("#{t163Properties['t163.appKey']}")
	private String appKey;

	@Value("#{t163Properties['t163.appSecret']}")
	private String appSecret;

	@Value("#{t163Properties['t163.redirectUri']}")
	private String redirectUri;

	@Resource
	private T163HttpClient t163HttpClient;

	/**
	 * http://open.t.163.com/wiki/index.php?title=Oauth2/authorize
	 * @param state
	 * @param display
	 * @return
	 */
	public String authorize(String state, Display display) {
		String authorizeUrl = new StringBuffer()
			.append(OAUTH2_AUTHORIZE)
			.append("?client_id=").append(appKey)
			.append("&redirect_uri=").append(redirectUri)
			.append("&state=").append(state)
			.append("&display=").append(display.getCode())
			.toString();
		log.info(authorizeUrl);
		return authorizeUrl;
	}

	/**
	 * accessToken
	 * @param code
	 * @return
	 */
	public AccessToken accessToken(String code) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", appKey);
		map.add("client_secret", appSecret);
		map.add("grant_type", "authorization_code");
		map.add("code", code);
		map.add("redirect_uri", redirectUri);
		String result = t163HttpClient.postForm(OAUTH2_ACCESS_TOKEN, map, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			AccessToken accessToken = objectMapper.readValue(result, AccessToken.class);
			return accessToken;
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public TokenInfo getTokenInfo(String accessToken) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("access_token", accessToken);
		String result = t163HttpClient.postForm(OAUTH2_GET_TOKEN_INFO, map, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			TokenInfo tokenInfo = objectMapper.readValue(result, TokenInfo.class);
			return tokenInfo;
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

}
