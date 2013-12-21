/*
 * @(#)T163UsersTest.java $version 2013年12月21日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.api;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.t163.api.test.AbstractTest;

/**
 * DaLian Software t-163-api
 * com.t163.api.T163UsersTest.java
 * @author cuizuoli
 * @date 2013年12月21日
 */
public class T163UsersTest extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private T163Users t163Users;

	@Test
	public void show() {
		t163Users.show(dataMap.get("userId"), dataMap.get("accessToken"));
	}

	@Test
	public void showByName() {
		t163Users.showByName(dataMap.get("screenName"), dataMap.get("accessToken"));
	}

}
