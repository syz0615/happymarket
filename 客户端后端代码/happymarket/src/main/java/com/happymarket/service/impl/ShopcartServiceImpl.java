package com.happymarket.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happymarket.bean.Shopcart;
import com.happymarket.dao.GoodsDao;
import com.happymarket.dao.ShopcartDao;
import com.happymarket.service.ShopcartService;
@Service
public class ShopcartServiceImpl implements ShopcartService {
	
	@Autowired
	private ShopcartDao shopcartDao;
	@Autowired
	private GoodsDao goodsDao;
	
	
	@Override
	public List<Shopcart> getShopcartGoods(int userId) {
		List<Shopcart> shopcarts=shopcartDao.selectShopcartByUserId(userId);
		return shopcarts;
	}


	@Override
	@Transactional
	public boolean insertShopcart(Shopcart shopcart) {
		boolean flag=true;
		int result=1;
		Shopcart existShopcart=shopcartDao.selectShopcartByUserIdAndGoodsId(shopcart.getUserId(), shopcart.getGoods().getGoodsId());
		if(existShopcart==null) {
			BigDecimal goodsPrice=goodsDao.selectSimpleGoodsById(shopcart.getGoods().getGoodsId()).getGoodsPrice();
			shopcart.setAddPrice(goodsPrice);
			result=shopcartDao.insertShopcart(shopcart);
		}else {
			result=shopcartDao.updateShopcartById(existShopcart.getShopcartId(), shopcart.getCount());
		}
		if(result==0) {
			flag=false;
		}
		return flag;
	}


	@Override
	@Transactional
	public boolean changeShopcart(int shopcartId, int count) {
		boolean flag=true;
		int result=shopcartDao.updateShopcartById(shopcartId, count);
		if(result==0) {
			flag=false;
		}
		return flag;
	}


	@Override
	@Transactional
	public boolean deleteShopcart(int shopcartId) {
		boolean flag=true;
		int result=shopcartDao.deleteShopcartById(shopcartId);
		if(result==0) {
			flag=false;
		}
		return flag;
	}

}
