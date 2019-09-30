package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Order;

public interface OrderService {
	Order addOrder(Order order);
	
	boolean payOrder(int orderId);
	
	int deleteOrder(int orderId);
	
	List<Order> getAllOrder(int userId);
	
	Order getOrderById(int orderId);
}
