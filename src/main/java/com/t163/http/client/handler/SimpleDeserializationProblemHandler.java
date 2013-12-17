/*
 * @(#)SimpleDeserializationProblemHandler.java $version 2013年12月17日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.http.client.handler;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.JsonDeserializer;

import lombok.extern.slf4j.Slf4j;

/**
 * nhn t-163-api
 * com.t163.http.client.handler.SimpleDeserializationProblemHandler.java
 * @author st13902
 * @date 2013年12月17日
 */
@Slf4j
public class SimpleDeserializationProblemHandler extends DeserializationProblemHandler {

	@Override
	public boolean handleUnknownProperty(DeserializationContext ctxt, JsonDeserializer<?> deserializer,
			Object beanOrClass, String propertyName) throws IOException, JsonProcessingException {
		log.error("Can't deserialize " + beanOrClass.getClass().getPackage().getName() + "."
			+ beanOrClass.getClass().getSimpleName() + " [" + propertyName + "]");
		return true;
	}

}
