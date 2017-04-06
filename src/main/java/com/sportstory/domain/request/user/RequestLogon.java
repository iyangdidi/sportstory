package com.sportstory.domain.request.user;

import com.sportstory.domain.User;
import com.sportstory.domain.request.AbstractRequest;

public class RequestLogon extends AbstractRequest{

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
