package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_groupchat")
public class GroupChat extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupChatInfoId;		//int(11) NOT NULL AUTO_INCREMENT,
	private int leaderId;			//int(11) NOT NULL COMMENT '群主ID',
	private int chatType;			//int(11) NOT NULL COMMENT '群类型\n0：活动群\n1：用户群',
	private int chatState;			//int(11) NOT NULL DEFAULT '0' COMMENT '群生存状态\n0：正常\n1：过期\n2：删除',
	private int activityId;			//int(11) NOT NULL COMMENT '如果type=0,为活动群,则需要添加activityID',
	
	public int getGroupChatInfoId() {
		return groupChatInfoId;
	}
	public void setGroupChatInfoId(int groupChatInfoId) {
		this.groupChatInfoId = groupChatInfoId;
	}
	public int getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}
	public int getChatType() {
		return chatType;
	}
	public void setChatType(int chatType) {
		this.chatType = chatType;
	}
	public int getChatState() {
		return chatState;
	}
	public void setChatState(int chatState) {
		this.chatState = chatState;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
}
