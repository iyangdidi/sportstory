package com.sportstory.domain.request.user;

import com.sportstory.domain.request.AbstractRequest;

public class RequestNeigborList extends AbstractRequest{
	//地理位置
	double longitude;//经度
	double latitude;//纬度
	
	//筛选条件
	int gender;//0=男，1=女
	int ageFrom;
	int ageTo;
	int sportType;//运动类型
	int sportLevel;//运动水平
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAgeFrom() {
		return ageFrom;
	}
	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}
	public int getAgeTo() {
		return ageTo;
	}
	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	public int getSportType() {
		return sportType;
	}
	public void setSportType(int sportType) {
		this.sportType = sportType;
	}
	public int getSportLevel() {
		return sportLevel;
	}
	public void setSportLevel(int sportLevel) {
		this.sportLevel = sportLevel;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
