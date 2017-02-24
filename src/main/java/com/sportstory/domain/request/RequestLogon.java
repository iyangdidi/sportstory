package com.sportstory.domain.request;

import com.sportstory.domain.User;

public class RequestLogon extends AbstractRequest{

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
