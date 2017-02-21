package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import flexjson.JSON;

@Entity
@Table(name="t_ability")
public class Ability extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int abilityId;			//int(11) NOT NULL AUTO_INCREMENT,
	private int commentUserId;		//int(11) NOT NULL COMMENT '评价者',
	private int commentedUserId;	//int(11) NOT NULL COMMENT '被评价人',
	private int activityId;			//int(11) NOT NULL COMMENT '活动ID',
	private JSON scoreInDetail;		//json NOT NULL COMMENT '根据不同的sportType,评分细则不同',
	private int sportTypeId;
	private String sportTypeName;	//varchar(45) NOT NULL COMMENT '运动类型',
	private String comment;			//varchar(100) NOT NULL COMMENT '评论',
	
	public int getAbilityId() {
		return abilityId;
	}
	public void setAbilityId(int abilityId) {
		this.abilityId = abilityId;
	}
	public int getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	public int getCommentedUserId() {
		return commentedUserId;
	}
	public void setCommentedUserId(int commentedUserId) {
		this.commentedUserId = commentedUserId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public JSON getScoreInDetail() {
		return scoreInDetail;
	}
	public void setScoreInDetail(JSON scoreInDetail) {
		this.scoreInDetail = scoreInDetail;
	}
	public int getSportTypeId() {
		return sportTypeId;
	}
	public void setSportTypeId(int sportTypeId) {
		this.sportTypeId = sportTypeId;
	}
	public String getSportTypeName() {
		return sportTypeName;
	}
	public void setSportTypeName(String sportTypeName) {
		this.sportTypeName = sportTypeName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
