package com.happymarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.happymarket.bean.Order;
@Mapper
public interface OrderDao {
	Order selectOrderById(int orderId);
	
	List<Integer> selectHotGoods();
	
	List<Order> selectOrderByUserId(@Param("userId")int userId);
	
	int insertOrder(Order order);
	
	int deleteOrder(int orderId);
	//订单付款后的接口
	int updateOrderById(int orderId);
}
