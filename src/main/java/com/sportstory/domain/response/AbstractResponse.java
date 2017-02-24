package com.sportstory.domain.response;

public abstract class AbstractResponse {

	protected String status = "000";
	protected String content = "成功";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
