package com.happymarket.bean;

public class Address {

	private int addressId;
	private String receiverName;
	private String receiverAddress;
	private String receiverDetail;
	private String receiverPhone;
	private int postNo;
	private int userId;
	private int isDefault;
	public Address(int addressId, String receiverName, String receiverAddress, String receiverDetail,
			String receiverPhone, int postNo, int userId, int isDefault) {
		super();
		this.addressId = addressId;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverDetail = receiverDetail;
		this.receiverPhone = receiverPhone;
		this.postNo = postNo;
		this.userId = userId;
		this.isDefault = isDefault;
	}
	public Address() {
		super();
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverDetail() {
		return receiverDetail;
	}
	public void setReceiverDetail(String receiverDetail) {
		this.receiverDetail = receiverDetail;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", receiverName=" + receiverName + ", receiverAddress="
				+ receiverAddress + ", receiverDetail=" + receiverDetail + ", receiverPhone=" + receiverPhone
				+ ", postNo=" + postNo + ", userId=" + userId + ", isDefault=" + isDefault + "]";
	}
	
	
}
