/*
 * @(#)T163Users.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.t163.http.client.T163HttpClient;

/**
 * nhn t-163-api
 * com.t163.api.T163Users.java
 * @author st13902
 * @date 2013年12月21日
 */
@Component
public class T163Users {

	private static final String USERS_SHOW_URL = "https://api.weibo.com/2/users/show.json";

	@Resource
	private T163HttpClient t163HttpClient;

}
