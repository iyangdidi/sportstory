package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 聊天内容表
 * @author YangDi
 *
 */
@Entity
@Table(name="t_chat")
public class Chat extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int chatId;			//int(11) NOT NULL AUTO_INCREMENT,
	private int senderId;		//int(11) NOT NULL COMMENTprivate int 
	private int receiverId;		//int(11) NOT NULL COMMENT '接受者ID',
	private int chatType;		//int(11) NOT NULL COMMENT '消息类型\n0：文字\n1：图片\n2：文件\n3：语音',
	private String content;		//varchar(45) NOT NULL COMMENT '内容',
	private int chatState;		//int(11) NOT NULL DEFAULT '0' COMMENT '消息状态\n0：正常\n1：撤销',
	
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getChatType() {
		return chatType;
	}
	public void setChatType(int chatType) {
		this.chatType = chatType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getChatState() {
		return chatState;
	}
	public void setChatState(int chatState) {
		this.chatState = chatState;
	}
	
}
