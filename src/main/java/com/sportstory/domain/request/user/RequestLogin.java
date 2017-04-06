package com.sportstory.domain.request.user;

import com.sportstory.domain.User;
import com.sportstory.domain.request.AbstractRequest;

public class RequestLogin extends AbstractRequest{
	
	String phone;
	String password;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
