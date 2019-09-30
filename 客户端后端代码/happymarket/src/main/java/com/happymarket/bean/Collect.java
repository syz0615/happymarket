package com.happymarket.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Collect {
	private int collectId;
	private int userId;
	private Goods goods;
	private Date collectTime;
	private BigDecimal collectPrice;
	public Collect(int collectId, int userId, Goods goods, Date collectTime, BigDecimal collectPrice) {
		super();
		this.collectId = collectId;
		this.userId = userId;
		this.goods = goods;
		this.collectTime = collectTime;
		this.collectPrice = collectPrice;
	}
	public Collect() {
		super();
	}
	public int getCollectId() {
		return collectId;
	}
	public void setCollectId(int collectId) {
		this.collectId = collectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	public BigDecimal getCollectPrice() {
		return collectPrice;
	}
	public void setCollectPrice(BigDecimal collectPrice) {
		this.collectPrice = collectPrice;
	}
	@Override
	public String toString() {
		return "Collection [collectId=" + collectId + ", userId=" + userId + ", goods=" + goods + ", collectTime="
				+ collectTime + ", collectPrice=" + collectPrice + "]";
	}
	
	
}
