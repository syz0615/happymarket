package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Category;

public interface CategoryService {
	List<Category> getFirstCategory();
	
	List<Category> getChildCategory(int parentId);
}
