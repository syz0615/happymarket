package com.happymarket.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.happymarket.bean.Address;
import com.happymarket.bean.Goods;
import com.happymarket.bean.Order;
import com.happymarket.bean.User;
import com.happymarket.service.OrderService;
import com.happymarket.util.CodeMsg;

@Controller
@RequestMapping("/order")
@ResponseBody
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value = "/add",method = {RequestMethod.POST})
	public Order addOrder(@RequestBody String json) {
		Order order=JSON.parseObject(json,Order.class);
		User user=JSON.parseObject(json,User.class);
		Goods goods=JSON.parseObject(json,Goods.class);
		Address address=JSON.parseObject(json,Address.class);
		order.setGoods(goods);
		order.setAddress(address);
		order.setUser(user);
		order.setOrderNo(String.valueOf(new Date().getTime()) + user.getUserId());
		order=orderService.addOrder(order);
		return order;
	}
	
	@RequestMapping(value = "/pay",method = {RequestMethod.GET})
	public CodeMsg payOrder(int orderId) {
		boolean flag=true;
		flag=orderService.payOrder(orderId);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	@RequestMapping(value = "/all",method = {RequestMethod.GET})
	public List<Order> allOrder(int userId){
		List<Order> orders=orderService.getAllOrder(userId);
		return orders;
	}
	
	@RequestMapping(value = "/getorder",method = {RequestMethod.GET})
	public Order getOrder(int orderId) {
		Order order=orderService.getOrderById(orderId);
		return order;
	}
}
