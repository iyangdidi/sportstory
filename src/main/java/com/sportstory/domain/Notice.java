package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import flexjson.JSON;

@Entity
@Table(name="t_notice")
public class Notice extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int noticeId;		//int(11) NOT NULL AUTO_INCREMENT,
	private int senderId;		//int(11) NOT NULL COMMENT '发送通知的用户\n0：系统\n其他值：为用户产生的消息，接收方从t_follow表中得到\n此表信息一般用作Push\n由于系统的引入，不用senderId做外键',
	private int noticeType;		//int(11) NOT NULL COMMENT '通知类型\n0：系统通知\n',
	private JSON jsonContent;	//json NOT NULL COMMENT '有些通知涉及到具体的数据信息，封装成Json',
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(int noticeType) {
		this.noticeType = noticeType;
	}
	public JSON getJsonContent() {
		return jsonContent;
	}
	public void setJsonContent(JSON jsonContent) {
		this.jsonContent = jsonContent;
	}

}
