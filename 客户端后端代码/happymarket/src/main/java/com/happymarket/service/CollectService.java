package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Collect;

public interface CollectService {
	boolean addCollect(Collect collect);
	
	boolean deleteCollect(int collectId);
	
	List<Collect> getCollectByUserId(int userId);
}
