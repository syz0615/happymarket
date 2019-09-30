package com.happymarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happymarket.bean.Collect;
import com.happymarket.dao.CollectDao;
import com.happymarket.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectDao collectDao;
	
	
	@Override
	@Transactional
	public boolean addCollect(Collect collect) {
		boolean flag=true;
		int result=collectDao.insertCollect(collect);
		if(result==0) {
			flag=false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean deleteCollect(int collectId) {
		boolean flag=true;
		int result=collectDao.deleteCollect(collectId);
		if(result==0) {
			flag=false;
		}
		return flag;
	}

	@Override
	public List<Collect> getCollectByUserId(int userId) {
		List<Collect> collects=collectDao.selectCollectByUserId(userId);
		return collects;
	}
	
}
