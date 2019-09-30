package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Notice;

public interface NoticeService {
	 
	List<Notice> getAllNotice();
	
	Notice getNoticeDetail(int noticeId);
	 
}
