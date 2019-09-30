package com.happymarket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happymarket.bean.Goods;
import com.happymarket.dao.GoodsDao;
import com.happymarket.dao.OrderDao;
import com.happymarket.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Goods> getCarouselGoods() {
		List<Goods> list=goodsDao.selectAllGoods();
		List<Goods> carousel=new ArrayList<>();
		int length=list.size();
		for(int i=length-1;i>=0&&i>=length-6;i--) {
			carousel.add(list.get(i));
		}
		return carousel;
	}


	@Override
	public List<Goods> getNewGoods() {
		List<Goods> list=goodsDao.selectAllGoods();
		List<Goods> newGoods=new ArrayList<>();
		int length=list.size();
		for(int i=length-1;i>=0&&i>=length-11;i--) {
			newGoods.add(list.get(i));
		}
		return newGoods;
	}


	@Override
	public List<Goods> getHotGoods() {
		List<Integer> hotGoodsId=orderDao.selectHotGoods();
		List<Goods> hotGoods=new ArrayList<>();
		Goods goods=new Goods();
		for(int i=0;i<10&&i<hotGoodsId.size();i++) {
			goods=goodsDao.selectSimpleGoodsById(hotGoodsId.get(i));
			hotGoods.add(goods);
		}
		return hotGoods;
	}


	@Override
	public List<Goods> searchGoods(String key) {
		List<Goods> search=goodsDao.searchGoods(key);
		return search;
	}


	@Override
	public List<Goods> getCategoryGoods(int categoryId) {
		List<Goods> list=goodsDao.selectGoodsByCategoryId(categoryId);
		return list;
	}


	@Override
	public Goods getGoods(int goodsId) {
		
		return goodsDao.selectGoodsById(goodsId);
	}


	@Override
	public boolean changeGoodsStock(int goodsId, int goodsStock) {
		boolean flag=true;
		int result=goodsDao.updateGoodsStock(goodsId, goodsStock);
		if(result==0) {
			flag=false;
		}
		return flag;
	}

}
