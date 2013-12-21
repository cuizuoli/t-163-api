/*
 * @(#)Display.java $version 2013年12月21日
 *
 * Copyright 2013 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.enums;

/**
 * DaLian Software t-163-api
 * com.t163.enums.Display.java
 * @author cuizuoli
 * @date 2013年12月21日
 */
public enum Display {
	DEFAULT("default"),
	MOBILE("mobile");
	private final String code;

	private Display(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
