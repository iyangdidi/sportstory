package com.sportstory.domain.bean;

import com.sportstory.domain.UserSportType;

public class NeigborInfo {
	String uid;
	String headImageUrl;//头像
	String nickname;//昵称
	UserSportType userSportType;//用户运动类型，包含运动名称与运动等级
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getHeadImageUrl() {
		return headImageUrl;
	}
	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	public UserSportType getUserSportType() {
		return userSportType;
	}
	public void setUserSportType(UserSportType userSportType) {
		this.userSportType = userSportType;
	}
	
}
