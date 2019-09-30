package com.happymarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happymarket.bean.Category;
import com.happymarket.bean.Goods;
import com.happymarket.service.CategoryService;
import com.happymarket.service.GoodsService;

@Controller
@RequestMapping("/category")
@ResponseBody
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="/first",method = {RequestMethod.GET})
	public List<Category> firstCategory(){
		List<Category> firstCategory=categoryService.getFirstCategory();
		return firstCategory;
	}
	
	@RequestMapping(value="/second",method = {RequestMethod.GET})
	public List<Category> childCategory(Integer parentId){
		if(parentId==null) {
			parentId=1;
		}
		System.out.println(parentId);
		List<Category> childCategory=categoryService.getChildCategory(parentId);
		return childCategory;
	}
	
	@RequestMapping(value = "/goods",method = {RequestMethod.GET})
	public List<Goods> categoryGoods(Integer categoryId){
		if(categoryId==null) {
			categoryId=2;
		}
		List<Goods> categoryGoods=goodsService.getCategoryGoods(categoryId);
		return categoryGoods;
	}
}
