/*
 * @(#)T163User.java $version 2013年12月21日
 *
 * Copyright 2013 NHN ST. All rights Reserved.
 * NHN ST PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.t163.model;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * nhn t-163-api
 * com.t163.model.T163User.java
 * @author st13902
 * @date 2013年12月21日
 */
@Data
public class T163User {
	private T163Status status;
	private boolean following;
	private boolean blocking;
	@JsonProperty("followed_by")
	private boolean followedBy;
	private String name;
	private String location;
	private String id;
	private String description;
	private String email;
	private String gender;
	private boolean verified;
	private String url;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("screen_name")
	private String screenName;
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	private String columnIdNameWithCounts;
	private String darenRec;
	@JsonProperty("favourites_count")
	private String favouritesCount;
	@JsonProperty("followers_count")
	private String followersCount;
	@JsonProperty("friends_count")
	private String friendsCount;
	@JsonProperty("geo_enable")
	private boolean geoEnable;
	private String icorp;
	private String realName;
	@JsonProperty("statuses_count")
	private String statusesCount;
	private String sysTag;
	private String userTag;
	@JsonProperty("in_groups")
	private String[] inGroups;
}
