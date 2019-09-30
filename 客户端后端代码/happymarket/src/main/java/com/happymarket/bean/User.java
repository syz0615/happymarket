package com.happymarket.bean;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String userPhone;
	private String userPicture;
	private Date lastLoginTime;
	private Date registTime;
	private int level;
	public User(int userId, String userName, String userPwd, String userEmail, String userPhone, String userPicture,
			Date lastLoginTime, Date registTime, int level) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPicture = userPicture;
		this.lastLoginTime = lastLoginTime;
		this.registTime = registTime;
		this.level = level;
	}
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPicture() {
		return userPicture;
	}
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userPicture=" + userPicture + ", lastLoginTime=" + lastLoginTime
				+ ", registTime=" + registTime + ", level=" + level + "]";
	}
	
	
}
