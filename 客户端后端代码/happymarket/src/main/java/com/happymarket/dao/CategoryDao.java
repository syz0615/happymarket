package com.happymarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.happymarket.bean.Category;
@Mapper
public interface CategoryDao {
	List<Category> selectFirstCategory();
	
	List<Category> selectChildCategory(int parentId);
}
