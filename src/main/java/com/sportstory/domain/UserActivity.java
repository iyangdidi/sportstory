package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_user_activity")
public class UserActivity extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userActivityId;	//int(11) NOT NULL AUTO_INCREMENT,
	private int activityId;		//int(11) NOT NULL COMMENT '活动ID',
	private int userId;			//int(11) NOT NULL COMMENT '用户ID',
	private int tradeId;		//int(11) NOT NULL COMMENT '交易ID',
	
	public int getUserActivityId() {
		return userActivityId;
	}
	public void setUserActivityId(int userActivityId) {
		this.userActivityId = userActivityId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	
}
