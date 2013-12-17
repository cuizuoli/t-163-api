/*
 * @(#)AbstractTest.java $version 2013年12月17日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.api.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * nhn t-163-api
 * com.t163.api.test.AbstractTest.java
 * @author st13902
 * @date 2013年12月17日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context-t163.xml", "classpath:context-data.xml"})
public abstract class AbstractTest {

}
