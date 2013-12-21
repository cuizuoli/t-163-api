/*
 * @(#)OAuth2Test.java $version 2013年12月21日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.api;

import javax.annotation.Resource;

import org.junit.Test;

import com.t163.api.test.AbstractTest;
import com.t163.enums.Display;

/**
 * DaLian Software t-163-api
 * com.t163.api.OAuth2Test.java
 * @author cuizuoli
 * @date 2013年12月21日
 */
public class OAuth2Test extends AbstractTest {

	@Resource
	private OAuth2 oAuth2;

	@Test
	public void authorize() {
		oAuth2.authorize("Test", Display.MOBILE);
	}

	@Test
	public void accessToken() {
		String code = "d18d17dcf4d2830137052791ee5a4d73";
		oAuth2.accessToken(code);
	}

}
