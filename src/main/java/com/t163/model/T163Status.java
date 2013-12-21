/*
 * @(#)T163Status.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn t-163-api
 * com.t163.model.T163Status.java
 * @author st13902
 * @date 2013年12月21日
 */
@Data
public class T163Status {
	private String id;
	private String source;
	private String text;
	@JsonProperty("create_at")
	private String createAt;
	private String videoInfos;
	private String musicInfos;
	private String songInfos;
	private boolean truncated;
	@JsonProperty("in_reply_to_screen_name")
	private String inReplyToScreenName;
	@JsonProperty("in_reply_to_status_id")
	private String inReplyToStatusId;
	@JsonProperty("in_reply_to_user_id")
	private String inReplyToUserId;
	@JsonProperty("in_reply_to_user_name")
	private String inReplyToUserName;
	private String previewLinkInfos;

}
