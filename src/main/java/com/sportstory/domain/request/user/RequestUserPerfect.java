package com.sportstory.domain.request.user;

import com.sportstory.domain.User;
import com.sportstory.domain.UserSportType;
import com.sportstory.domain.request.AbstractRequest;

public class RequestUserPerfect extends AbstractRequest{
	User user;//用户信息，所有条目不能为空
	UserSportType userSportType;//用户运动类型，包含运动名称与运动等级

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserSportType getUserSportType() {
		return userSportType;
	}

	public void setUserSportType(UserSportType userSportType) {
		this.userSportType = userSportType;
	}
	
}
