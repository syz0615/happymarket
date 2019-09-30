package com.happymarket.bean;

public class Notice {
	private int noticeId;
	private  String noticeTitle;
	private String noticeDesc;
	private int level;
	public Notice(int noticeId, String noticeTitle, String noticeDesc, int level) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeDesc = noticeDesc;
		this.level = level;
	}
	public Notice() {
		super();
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeDesc() {
		return noticeDesc;
	}
	public void setNoticeDesc(String noticeDesc) {
		this.noticeDesc = noticeDesc;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeDesc=" + noticeDesc
				+ ", level=" + level + "]";
	}
	
	
	
}
