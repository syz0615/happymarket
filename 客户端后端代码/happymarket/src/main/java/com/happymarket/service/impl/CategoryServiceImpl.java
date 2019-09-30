package com.happymarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happymarket.bean.Category;
import com.happymarket.dao.CategoryDao;
import com.happymarket.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getFirstCategory() {
		
		return categoryDao.selectFirstCategory();
	}

	@Override
	public List<Category> getChildCategory(int parentId) {
		
		return categoryDao.selectChildCategory(parentId);
	}

}
