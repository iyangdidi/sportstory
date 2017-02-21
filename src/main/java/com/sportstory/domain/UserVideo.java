package com.sportstory.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//用户与别人视频的关系
@Entity
@Table(name="r_user_video")
public class UserVideo extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userVideoId;		//int(11) NOT NULL AUTO_INCREMENT,
	private int userId;				//int(11) NOT NULL COMMENT '用户ID',
	private int videoId;			//int(11) NOT NULL COMMENT '视频ID',
	private int tradeId;			//int(11) NOT NULL COMMENprivate int ID',
	private int state;				//int(11) NOT NULL COMMENT '用户对视频的状态\n0：没有支付\n1：支付中\n2：支付完成',
	private int score;				//int(11) NOT NULL COMMENT '阅览后，评分',
	private String comment;			//varchar(100) NOT NULL COMMENT '阅览后，评价',
	private int viewTimes;			//int(11) NOT NULL COMMENT '阅览次数',
	
	public int getUserVideoId() {
		return userVideoId;
	}
	public void setUserVideoId(int userVideoId) {
		this.userVideoId = userVideoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getViewTimes() {
		return viewTimes;
	}
	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}

}
