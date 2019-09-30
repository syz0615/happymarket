package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Goods;

public interface GoodsService {
	List<Goods> getCarouselGoods();
	
	List<Goods> getNewGoods();
	
	List<Goods> getHotGoods();
	
	List<Goods> searchGoods(String key);
	
	List<Goods> getCategoryGoods(int categoryId);
	
	Goods getGoods(int goodsId);
	
	boolean changeGoodsStock(int goodsId,int goodsStock);
}
