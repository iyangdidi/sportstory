package com.sportstory.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDomain implements Serializable {
	
	private Timestamp createTime;		//datetime NOT NULL,
	private Timestamp updateTime;		//datetime NOT NULL,
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}



	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}
