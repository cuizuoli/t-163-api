/*
 * @(#)T163OAuth2Test.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.api;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.t163.api.test.AbstractTest;
import com.t163.enums.Display;

/**
 * nhn t-163-api
 * com.t163.api.T163OAuth2Test.java
 * @author st13902
 * @date 2013年12月21日
 */
public class T163OAuth2Test extends AbstractTest {

	@Resource
	private Map<String, String> dataMap;

	@Resource
	private T163OAuth2 t163OAuth2;

	@Test
	public void authorize() {
		t163OAuth2.authorize("Test", Display.MOBILE);
	}

	@Test
	public void accessToken() {
		String code = "39bcb38ca2bfe3a1aaa652e9d21d8621";
		t163OAuth2.accessToken(code);
	}

	@Test
	public void getTokenInfo() {
		t163OAuth2.getTokenInfo(dataMap.get("accessToken"));
	}

}
