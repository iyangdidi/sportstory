package com.sportstory.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user_state")
public class UserState extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	String id;
	@Column(nullable=false, columnDefinition="varchar(50)")
	String userId;
	@Column(nullable=false, columnDefinition="varchar(50)")
	String token;
	@Column(nullable=false, columnDefinition="datetime")
	Timestamp updateTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
