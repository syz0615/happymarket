package com.happymarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.happymarket.bean.Notice;
@Mapper
public interface NoticeDao {
	Notice selectNoticeById(@Param("noticeId")int noticeId);
	
	List<Notice> selectAllNotice();
}
