package com.happymarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.happymarket.bean.Collect;
@Mapper
public interface CollectDao {
	List<Collect> selectCollectByUserId(int userId);
	
	int insertCollect(Collect collect);
	
	int deleteCollect(int collectId);
}
