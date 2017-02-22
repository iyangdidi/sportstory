package com.sportstory.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import flexjson.JSON;

@Entity
@Table(name="t_trade")
public class Trade extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tradeId;		//int(11) NOT NULL AUTO_INCREMENT,
	private int userId;			//int(11) NOT NULL COMMENT '交易用户ID',
	private BigDecimal price;	//decimal(10,0) DEFAULT NULL COMMENT '交易金额',
	private int tradeType;		//int(11) DEFAULT NULL COMMENT '交易类型\n0：买视频\n1：参加活动',
	private String content;		//json DEFAULT NULL COMMENT '根据type的不同，json内容类型不同',
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getTradeType() {
		return tradeType;
	}
	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
