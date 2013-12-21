/*
 * @(#)T163AccessToken.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn t-163-api
 * com.t163.model.T163AccessToken.java
 * @author st13902
 * @date 2013年12月21日
 */
@Data
public class T163AccessToken {
	private String uid;
	@JsonProperty("expires_in")
	private String expiresIn;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("access_token")
	private String accessToken;
}
