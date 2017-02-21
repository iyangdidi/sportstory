package com.sportstory.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import flexjson.JSON;

@Entity
@Table(name="t_video")
public class Video extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int videoId;			//int(11) NOT NULL AUTO_INCREMENT,
	private int authorId;			//int(11) NOT NULL COMMENT '作者ID',
	private String title;			//varchar(45) NOT NULL COMMENT '视频标题',
	private String description;		//varchar(100) NOT NULL COMMENT '描述',
	private String screenshot;		//varchar(256) NOT NULL COMMENT '截图（做封面）',
	private String stream;			//varchar(45) NOT NULL COMMENT '视频流',
	private int viewed;				//int(11) NOT NULL COMMENT '阅览数',
	private BigDecimal price;		//decimal(10,0) NOT NULL COMMENT '定价',
	private int finalScore;			//int(11) NOT NULL COMMENT '综合评分',
	private int videoState;			//int(11) NOT NULL COMMENT '状态\n0：审核中\n1：审核通过\n2：删除',
	
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	public int getVideoState() {
		return videoState;
	}
	public void setVideoState(int videoState) {
		this.videoState = videoState;
	}
}
