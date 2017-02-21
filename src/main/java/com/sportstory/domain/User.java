package com.sportstory.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 用户信息
 * @author YangDi
 *
 */
@Entity
@Table(name="t_user")
public class User extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer uid;	
	private String phone;				//varchar(45) NOT NULL COMMENT '手机号',
	private String password;			//varchar(45) NOT NULL,
	private String name;				//varchar(45) NOT NULL COMMENT '用户名',
	private String nickname;			//varchar(45) NOT NULL COMMENT '昵称',
	private String email;				//varchar(45) NOT NULL COMMENT '绑定的邮箱',
	private String headImageUrl;		//varchar(256) NOT NULL DEFAULT 'http://7u2ouq.com2.z0.glb.qiniucdn.com/headimage.png' COMMENT '头像URL',
	private String backgourdUrl;		//varchar(256) NOT NULL DEFAULT 'http://7u2r5d.com2.z0.glb.qiniucdn.com/background1.jpg' COMMENT '背景图片URL',
	private int pubgender;				//int(11) NOT NULL DEFAULT '0' COMMENT '性别\n0：男\n1：女',
	private Date birthday;				//date NOT NULL COMMENT '出生日期',
	private int stature;				//int(11) NOT NULL COMMENT '身高（厘米，整数）',
	private int weight;					//int(11) NOT NULL COMMENT '体重（斤，整数）',
	private String province;			//varchar(45) NOT NULL COMMENT '省',
	private String city;				//varchar(45) NOT NULL COMMENT '市',
	private String district;			//varchar(45) NOT NULL COMMENT '区',
	private String address;				//varchar(45) NOT NULL COMMENT '详细地址',
	private String assignment;			//varchar(45) NOT NULL COMMENT '用户签名',
	private String userGroup;			//varchar(45) NOT NULL DEFAULT '0' COMMENT '用户分组（方便用户管理，用户分级等等）\n0：初级用户',
	private BigDecimal wallet;			//decimal(10,0) NOT NULL DEFAULT '0' COMMENT '钱包余额',
	private int isForbiden;				//int(11) NOT NULL DEFAULT '0' COMMENT '是否被禁止（用户可能被举报，核实后，可以禁止用户）\n0：没有被禁止\n1：禁止',
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadImageUrl() {
		return headImageUrl;
	}
	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	public String getBackgourdUrl() {
		return backgourdUrl;
	}
	public void setBackgourdUrl(String backgourdUrl) {
		this.backgourdUrl = backgourdUrl;
	}
	public int getPubgender() {
		return pubgender;
	}
	public void setPubgender(int pubgender) {
		this.pubgender = pubgender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getStature() {
		return stature;
	}
	public void setStature(int stature) {
		this.stature = stature;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public BigDecimal getWallet() {
		return wallet;
	}
	public void setWallet(BigDecimal wallet) {
		this.wallet = wallet;
	}
	public int getIsForbiden() {
		return isForbiden;
	}
	public void setIsForbiden(int isForbiden) {
		this.isForbiden = isForbiden;
	}	
}
