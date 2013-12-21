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
import com.t163.model.T163User;

/**
 * nhn t-163-api
 * com.t163.api.T163Users.java
 * @author st13902
 * @date 2013年12月21日
 */
@Component
public class T163Users {

	private static final String USERS_SHOW_URL = "https://api.t.163.com/users/show.json";

	@Resource
	private T163HttpClient t163HttpClient;

	/**
	 * http://open.t.163.com/wiki/index.php?title=%E8%8E%B7%E5%8F%96%E6%8C%87%E5%AE%9A%E7%94%A8%E6%88%B7%E7%9A%84%E4%BF%A1%E6%81%AF(users/show)
	 * @param userId
	 * @param accessToken
	 * @return
	 */
	public T163User show(String userId, String accessToken) {
		String url = new StringBuffer()
			.append(USERS_SHOW_URL)
			.append("?user_id=").append(userId)
			.append("&access_token=").append(accessToken)
			.toString();
		return t163HttpClient.get(url, T163User.class);
	}

}
