package com.sportstory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//字典表
@Entity
@Table(name="d_dictionary")
public class Dictionary extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dictionaryId;	//int(11) NOT NULL AUTO_INCREMENT,
	private int dicType;		//int(11) NOT NULL COMMENT '字典类型\n0：运动类型字典',
	private String name;		//varchar(45) NOT NULL COMMENT '某类型下，字典对应的中文表示',
	
	public int getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(int dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public int getDicType() {
		return dicType;
	}
	public void setDicType(int dicType) {
		this.dicType = dicType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
