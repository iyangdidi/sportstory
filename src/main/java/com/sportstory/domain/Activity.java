package com.sportstory.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 活动信息
 * @author YangDi
 *
 */
@Entity
@Table(name="t_activity")
public class Activity extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int activityId;			//int(11) NOT NULL AUTO_INCREMENT,
	private int createrId;			//int(11) NOT NULL COMMENT '创建者ID',
	private String sportTypeName;	//varchar(45) NOT NULL COMMENT '运动类型',
	private int sportTypeId;		//int(11) NOT NULL,
	private int activityDate;		//date NOT NULL COMMENT '活动日期',
	private Timestamp startTime;	//datetime NOT NULL COMMENT '开始时间',
	private Timestamp endTime;		//datetime NOT NULL COMMENT '结束时间',
	private String address;			//varchar(45) NOT NULL COMMENT '活动地点',
	private int memberNum;			//int(11) NOT NULL COMMENT '活动人数',
	private int activityState;		//int(11) NOT NULL COMMENT '活动状态\n0：未开始\n1：已开始\n2：结束\n3：取消',
	private int sportLevel;			//int(11) NOT NULL COMMENT '活动等级',
	private int chargeType;			//int(11) NOT NULL COMMENT '收费类型\n0：女生免费\n1：自费',
	private int teamNature;			//int(11) NOT NULL COMMENT '组队类型\n0：随便玩玩\n1：专业级别',
	private int activityNature;		//int(11) NOT NULL COMMENT '活动性质',
	private int joinedNum;			//int(11) NOT NULL DEFAULT '0' COMMENT '报名人数',
	private BigDecimal price;		//decimal(10,0) NOT NULL COMMENT '活动单人价格',
	private int groupChatId;		//int(11) NOT NULL COMMENT '群聊ID',
	
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getCreaterId() {
		return createrId;
	}
	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}
	public String getSportTypeName() {
		return sportTypeName;
	}
	public void setSportTypeName(String sportTypeName) {
		this.sportTypeName = sportTypeName;
	}
	public int getSportTypeId() {
		return sportTypeId;
	}
	public void setSportTypeId(int sportTypeId) {
		this.sportTypeId = sportTypeId;
	}
	public int getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(int activityDate) {
		this.activityDate = activityDate;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getActivityState() {
		return activityState;
	}
	public void setActivityState(int activityState) {
		this.activityState = activityState;
	}
	public int getSportLevel() {
		return sportLevel;
	}
	public void setSportLevel(int sportLevel) {
		this.sportLevel = sportLevel;
	}
	public int getChargeType() {
		return chargeType;
	}
	public void setChargeType(int chargeType) {
		this.chargeType = chargeType;
	}
	public int getTeamNature() {
		return teamNature;
	}
	public void setTeamNature(int teamNature) {
		this.teamNature = teamNature;
	}
	public int getActivityNature() {
		return activityNature;
	}
	public void setActivityNature(int activityNature) {
		this.activityNature = activityNature;
	}
	public int getJoinedNum() {
		return joinedNum;
	}
	public void setJoinedNum(int joinedNum) {
		this.joinedNum = joinedNum;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getGroupChatId() {
		return groupChatId;
	}
	public void setGroupChatId(int groupChatId) {
		this.groupChatId = groupChatId;
	}

}
