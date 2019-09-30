package com.happymarket.test.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.happymarket.dao.ShopcartDao;
import com.happymarket.test.test;

public class ShopcartDaoTest extends test {
	
	@Autowired
	private ShopcartDao shopcartDao;
	
	@Override
	public void test1() throws Exception {
		System.out.println(shopcartDao.selectShopcartByUserId(1));
	}
	
}
