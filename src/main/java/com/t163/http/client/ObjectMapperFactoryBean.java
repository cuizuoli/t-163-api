/*
 * @(#)ObjectMapperFactoryBean.java $version 2013年12月17日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.http.client;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.FactoryBean;

import com.t163.http.client.handler.SimpleDeserializationProblemHandler;

/**
 * nhn t-163-api
 * com.t163.http.client.ObjectMapperFactoryBean.java
 * @author st13902
 * @date 2013年12月17日
 */
public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {

	@Override
	public ObjectMapper getObject() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.getDeserializationConfig().addHandler(new SimpleDeserializationProblemHandler());
		return objectMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
