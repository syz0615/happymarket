package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Shopcart;

public interface ShopcartService {
	
	List<Shopcart> getShopcartGoods(int userId);
	
	boolean insertShopcart(Shopcart shopcart);
	
	boolean changeShopcart(int shopcartId,int count);
	
	boolean deleteShopcart(int shopcartId);
}
