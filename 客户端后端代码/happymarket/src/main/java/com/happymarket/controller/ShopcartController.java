package com.happymarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.happymarket.bean.Goods;
import com.happymarket.bean.Shopcart;
import com.happymarket.service.ShopcartService;
import com.happymarket.util.CodeMsg;

@Controller
@RequestMapping("/shopcart")
@ResponseBody
public class ShopcartController {
	@Autowired
	private ShopcartService shopcartService;
	
	@RequestMapping(value = "/all",method = {RequestMethod.GET})
	public List<Shopcart> allShopcart(int userId) {
		List<Shopcart> shopcart=shopcartService.getShopcartGoods(userId);
		return shopcart;
	}
	
	@RequestMapping(value = "/add",method = {RequestMethod.POST})
	public CodeMsg addShopcart(@RequestBody String json) {
		Goods goods=JSON.parseObject(json,Goods.class);
		Shopcart shopcart=JSON.parseObject(json,Shopcart.class);
		shopcart.setGoods(goods);
		shopcart.setIsDefault(1);
		boolean flag=shopcartService.insertShopcart(shopcart);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	
	@RequestMapping(value = "/count",method = {RequestMethod.GET})
	public CodeMsg changeShopcartCount(int shopcartId,int count) {
		boolean flag=shopcartService.changeShopcart(shopcartId, count);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	@RequestMapping(value = "/delete",method = {RequestMethod.GET})
	public CodeMsg deleteShopcart(int shopcartId) {
		boolean flag=shopcartService.deleteShopcart(shopcartId);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
}
