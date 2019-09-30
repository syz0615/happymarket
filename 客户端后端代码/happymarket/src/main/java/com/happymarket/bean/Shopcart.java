package com.happymarket.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Shopcart {
	private int shopcartId;
	private Goods goods;
	private int userId;
	private int count;
	private Date addTime;
	private BigDecimal addPrice;
	private int isDefault;
	public Shopcart(int shopcartId, Goods goods, int userId, int count, Date addTime, BigDecimal addPrice,
			int isDefault) {
		super();
		this.shopcartId = shopcartId;
		this.goods = goods;
		this.userId = userId;
		this.count = count;
		this.addTime = addTime;
		this.addPrice = addPrice;
		this.isDefault = isDefault;
	}
	public Shopcart() {
		super();
	}
	public int getShopcartId() {
		return shopcartId;
	}
	public void setShopcartId(int shopcartId) {
		this.shopcartId = shopcartId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public BigDecimal getAddPrice() {
		return addPrice;
	}
	public void setAddPrice(BigDecimal addPrice) {
		this.addPrice = addPrice;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Shopcart [shopcartId=" + shopcartId + ", goods=" + goods + ", userId=" + userId + ", count=" + count
				+ ", addTime=" + addTime + ", addPrice=" + addPrice + ", isDefault=" + isDefault + "]";
	}
	
	
	
	
}