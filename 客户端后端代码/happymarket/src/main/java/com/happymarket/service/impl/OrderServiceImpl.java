package com.happymarket.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happymarket.bean.Goods;
import com.happymarket.bean.Order;
import com.happymarket.dao.GoodsDao;
import com.happymarket.dao.OrderDao;
import com.happymarket.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	@Transactional
	public Order addOrder(Order order) {
		int orderResult=0,goodsResult=0;
		Goods goods=goodsDao.selectGoodsById(order.getGoods().getGoodsId());
		int temp=goods.getGoodsStock()-order.getBuyCount();
		if(temp>=0) {
			goodsResult=goodsDao.updateGoodsStock(goods.getGoodsId(), temp);
			order.setPayPrice(goods.getGoodsPrice().multiply(new BigDecimal(order.getBuyCount())));
			orderResult=orderDao.insertOrder(order);
		}else{
			return null;
		}
		if(goodsResult==0||orderResult==0) {
			return null;
		}
		Order orderAft=orderDao.selectOrderById(order.getOrderId());
		return orderAft;
	}

	@Override
	@Transactional
	public boolean payOrder(int orderId) {
		boolean flag=true;
		int result=orderDao.updateOrderById(orderId);
		if(result==0) {
			flag=false;
		}
		return flag;
	}

	@Override
	public List<Order> getAllOrder(int userId) {
		
		return orderDao.selectOrderByUserId(userId);
	}

	@Override
	@Transactional
	public int deleteOrder(int orderId) {
		
		return orderDao.deleteOrder(orderId);
	}
	
	@Override
	public Order getOrderById(int orderId) {
		Order order=orderDao.selectOrderById(orderId);
		return order;
	}

}
