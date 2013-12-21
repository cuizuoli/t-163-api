/*
 * @(#)AccessToken.java $version 2013年12月21日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * DaLian Software t-163-api
 * com.t163.model.AccessToken.java
 * @author cuizuoli
 * @date 2013年12月21日
 */
@Data
public class AccessToken {
	@JsonProperty("oauth_token")
	private String oauthToken;
	@JsonProperty("oauth_token_secreate")
	private int oauthTokenSecreate;
}