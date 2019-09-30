package com.happymarket.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private int orderId;
	private String orderNo;
	private User user;
	private Goods goods;
	private Address address;
	private int buyCount;
	private int orderStatus;
	private Date createTime;
	private BigDecimal payPrice;
	private Date payTime;
	private String alipayNo;
	
	public Order(int orderId, String orderNo, User user, Goods goods, Address address, int buyCount, int orderStatus,
			Date createTime, BigDecimal payPrice, Date payTime, String alipayNo) {
		super();
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.user = user;
		this.goods = goods;
		this.address = address;
		this.buyCount = buyCount;
		this.orderStatus = orderStatus;
		this.createTime = createTime;
		this.payPrice = payPrice;
		this.payTime = payTime;
		this.alipayNo = alipayNo;
	}
	
	
	public Order() {
		super();
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getBuyCount() {
		return buyCount;
	}


	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}


	public int getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public BigDecimal getPayPrice() {
		return payPrice;
	}


	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}


	public Date getPayTime() {
		return payTime;
	}


	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}


	public String getAlipayNo() {
		return alipayNo;
	}


	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNo=" + orderNo + ", user=" + user + ", goods=" + goods
				+ ", address=" + address + ", buyCount=" + buyCount + ", orderStatus=" + orderStatus + ", createTime="
				+ createTime + ", payPrice=" + payPrice + ", payTime=" + payTime + ", alipayNo=" + alipayNo + "]";
	}

	
}
