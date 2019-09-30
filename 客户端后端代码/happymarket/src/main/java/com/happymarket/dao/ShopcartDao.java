package com.happymarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.happymarket.bean.Shopcart;


@Mapper
public interface ShopcartDao {
	List<Shopcart> selectShopcartByUserId(int userId);
	
	Shopcart selectShopcartByUserIdAndGoodsId(@Param("userId")int userId,@Param("goodsId")int goodsId);
	
	int insertShopcart(Shopcart shopcart);
	
	int updateShopcartById(@Param("shopcartId")int shopcartId,@Param("count")int count);

	int deleteShopcartById(@Param("shopcartId")int shopcartId);
}
