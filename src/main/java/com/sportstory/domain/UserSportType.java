package com.sportstory.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//用户和运动类型字典关系表
@Entity
@Table(name="r_user_sporttype")
public class UserSportType extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userSportTypeId;		//int(11) NOT NULL AUTO_INCREMENT,
	private int userId;					//int(11) NOT NULL COMMENT '用户ID',
	private int dictionaryId;			//int(11) NOT NULL COMMENT '字典表中对应Id',
	private String name;				//varchar(45) NOT NULL COMMENT '字典表中对应名称',
	private int sportLevel;				//int(11) NOT NULL COMMENT '运动等级\n1：一级\n2：二级\n3：三级',
	
	public int getUserSportTypeId() {
		return userSportTypeId;
	}
	public void setUserSportTypeId(int userSportTypeId) {
		this.userSportTypeId = userSportTypeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(int dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSportLevel() {
		return sportLevel;
	}
	public void setSportLevel(int sportLevel) {
		this.sportLevel = sportLevel;
	}	
}
