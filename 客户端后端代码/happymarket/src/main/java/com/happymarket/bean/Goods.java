package com.happymarket.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
	
	private int goodsId;
	private String goodsName;
	private String goodsTitle;
	private BigDecimal goodsPrice;
	private String goodsImg;
	private String goodsDesc;
	private String goodsDescImg;
	private int goodsStock;
	private int categoryId;
	private Date addTime;
	private Date sellTime;
	public Goods(int goodsId, String goodsName, String goodsTitle, BigDecimal goodsPrice, String goodsImg, String goodsDesc,
			String goodsDescImg, int goodsStock, int categoryId, Date addTime, Date sellTime) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsTitle = goodsTitle;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
		this.goodsDesc = goodsDesc;
		this.goodsDescImg = goodsDescImg;
		this.goodsStock = goodsStock;
		this.categoryId = categoryId;
		this.addTime = addTime;
		this.sellTime = sellTime;
	}
	public Goods() {
		super();
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public String getGoodsDescImg() {
		return goodsDescImg;
	}
	public void setGoodsDescImg(String goodsDescImg) {
		this.goodsDescImg = goodsDescImg;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getSellTime() {
		return sellTime;
	}
	public void setSellTime(Date sellTime) {
		this.sellTime = sellTime;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsTitle=" + goodsTitle + ", goodsPrice="
				+ goodsPrice + ", goodsImg=" + goodsImg + ", goodsDesc=" + goodsDesc + ", goodsDescImg=" + goodsDescImg
				+ ", goodsStock=" + goodsStock + ", categoryId=" + categoryId + ", addTime=" + addTime + ", sellTime="
				+ sellTime + "]";
	}
	
}
