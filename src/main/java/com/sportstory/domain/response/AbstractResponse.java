package com.sportstory.domain.response;

public abstract class AbstractResponse {

	protected int status = 0;
	protected String content = "成功";

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
