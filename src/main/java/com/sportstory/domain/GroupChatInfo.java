package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 群聊消息
 * @author YangDi
 *
 */
@Entity
@Table(name="t_groupchat_info")
public class GroupChatInfo extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupChatId;			//int(11) NOT NULL AUTO_INCREMENT,
	private int gourpChatInfoId;		//int(11) NOT NULL COMMENT '群聊ID',
	private int senderId;				//int(11) NOT NULL COMMENT '发送者',
	private int content;				//varchar(256) NOT NULL COMMENT '内容',
	private int chatType;				//int(11) NOT NULL COMMENT '消息类型\n0：文字\n1：图片\n2：文件\n3：语音',
	private int chatState;				//int(11) NOT NULL COMMENT '消息状态\n0：正常\n1：撤销',
	
	public int getGroupChatId() {
		return groupChatId;
	}
	public void setGroupChatId(int groupChatId) {
		this.groupChatId = groupChatId;
	}
	public int getGourpChatInfoId() {
		return gourpChatInfoId;
	}
	public void setGourpChatInfoId(int gourpChatInfoId) {
		this.gourpChatInfoId = gourpChatInfoId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
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
	
}
