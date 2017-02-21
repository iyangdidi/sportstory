package com.sportstory.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name="t_follow")
public class Follow extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int followId;	//int(11) NOT NULL AUTO_INCREMENT,
	private int userFromId;	//int(11) NOT NULL COMMENT '发起关注的用户',
	private int userToId;	//int(11) NOT NULL COMMENT '被关注的用户',
	private int state;		//int(11) NOT NULL DEFAULT '0' COMMENT '关注状态\n0：关注\n1：取消关注',
	
	public int getFollowId() {
		return followId;
	}
	public void setFollowId(int followId) {
		this.followId = followId;
	}
	public int getUserFromId() {
		return userFromId;
	}
	public void setUserFromId(int userFromId) {
		this.userFromId = userFromId;
	}
	public int getUserToId() {
		return userToId;
	}
	public void setUserToId(int userToId) {
		this.userToId = userToId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
