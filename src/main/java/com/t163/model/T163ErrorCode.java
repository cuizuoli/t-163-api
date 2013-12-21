/*
 * @(#)T163ErrorCode.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn t-163-api
 * com.t163.model.T163ErrorCode.java
 * @author st13902
 * @date 2013年12月21日
 */
@Data
public class T163ErrorCode {
	private String request;
	private String error;
	@JsonProperty("error_code")
	private String errorCode;
	@JsonProperty("message_code")
	private String messageCode;
}
