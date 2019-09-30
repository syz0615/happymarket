package com.happymarket.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.happymarket.bean.Goods;
@Mapper
public interface GoodsDao {
	Goods selectGoodsById(@Param("goodsId")int goodsId);
	
	Goods selectSimpleGoodsById(int goodsId);
	
	List<Goods> selectAllGoods();
	
	List<Goods> searchGoods(@Param("key")String key);
	
	List<Goods> selectGoodsByCategoryId(@Param("categoryId")int categoryId );
	
	int updateGoodsStock(@Param("goodsId")int goodsId,@Param("goodsStock")int goodsStock);
}
