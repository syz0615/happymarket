package com.happymarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happymarket.bean.Notice;
import com.happymarket.dao.NoticeDao;
import com.happymarket.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> getAllNotice() {
		List<Notice> list=noticeDao.selectAllNotice();
		return list;
	}

	@Override
	public Notice getNoticeDetail(int noticeId) {
		Notice notice=noticeDao.selectNoticeById(noticeId);
		return notice;
	}

}
