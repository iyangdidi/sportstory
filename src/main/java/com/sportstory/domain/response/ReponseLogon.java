package com.sportstory.domain.response;

public class ReponseLogon extends AbstractResponse{
	String uid;
	String token;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
