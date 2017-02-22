package com.sportstory.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_feed")
public class Feed extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedId;				//int(11) NOT NULL AUTO_INCREMENT,
	private int userId;				//int(11) NOT NULL COMMENT '动态产生者',
	private int feedType;			//int(11) NOT NULL COMMENT '动态类型\n如果是活动类型的动态，需要填活动ID，和活动的状态\n0：活动动态',
	private String jsonContent;		//json NOT NULL COMMENT '将动态的内容存储为Json',
	private int activityId;			//int(11) NOT NULL COMMENT '如果Type为活动，则填写',
	private int feedState;			//int(11) NOT NULL DEFAULT '0' COMMENT '如果Type为活动，则填写\n0：创建\n1：取消\n2：修改',
	
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFeedType() {
		return feedType;
	}
	public void setFeedType(int feedType) {
		this.feedType = feedType;
	}
	public String getJsonContent() {
		return jsonContent;
	}
	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getFeedState() {
		return feedState;
	}
	public void setFeedState(int feedState) {
		this.feedState = feedState;
	}
}
