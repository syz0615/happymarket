package com.happymarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happymarket.bean.Notice;
import com.happymarket.service.NoticeService;

@Controller
@RequestMapping("/notice")
@ResponseBody
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/all",method = {RequestMethod.GET})
	public List<Notice> allNotice(){
		List<Notice> notice=noticeService.getAllNotice();
		return notice;
	}
	
	@RequestMapping(value="/detail",method = {RequestMethod.GET})
	public Notice noticeDetail(int noticeId) {
		Notice noticeDetail=noticeService.getNoticeDetail(noticeId);
		return noticeDetail;
	}
	
	
}
