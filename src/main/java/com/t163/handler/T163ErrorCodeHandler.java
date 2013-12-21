/*
 * @(#)T163ErrorCodeHandler.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.handler;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

import com.t163.model.T163ErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * nhn t-163-api
 * com.t163.handler.T163ErrorCodeHandler.java
 * @author st13902
 * @date 2013年12月21日
 */
@Slf4j
@Component
public class T163ErrorCodeHandler {
	public T163ErrorCode handle(HttpStatusCodeException error) {
		ObjectMapper objectMapper = new ObjectMapper();
		T163ErrorCode errorCode = new T163ErrorCode();
		errorCode.setRequest(StringUtils.EMPTY);
		errorCode.setErrorCode(error.getStatusCode().toString());
		errorCode.setError(error.getStatusText());
		try {
			errorCode = objectMapper.readValue(error.getResponseBodyAsByteArray(), T163ErrorCode.class);
		} catch (JsonParseException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (JsonMappingException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		}
		return errorCode;
	}
}
