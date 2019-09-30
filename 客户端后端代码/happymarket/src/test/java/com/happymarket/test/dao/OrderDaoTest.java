package com.happymarket.test.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.happymarket.dao.OrderDao;
import com.happymarket.test.test;

public class OrderDaoTest extends test {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void test1() throws Exception {
		System.out.println(orderDao.selectHotGoods());
		
	}
}
