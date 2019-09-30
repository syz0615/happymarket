package com.happymarket.controller;

import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.happymarket.bean.Collect;
import com.happymarket.bean.Goods;
import com.happymarket.service.CollectService;
import com.happymarket.util.CodeMsg;

@Controller
@RequestMapping("/collect")
@ResponseBody
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/add",method = {RequestMethod.POST})
	public CodeMsg addCollect(@RequestBody String json) {
		Goods goods=JSON.parseObject(json,Goods.class);
		Collect collect=JSON.parseObject(json,Collect.class);
		collect.setGoods(goods);
		boolean flag=collectService.addCollect(collect);
		return new CodeMsg(flag);
	}
	
	@RequestMapping(value = "/delete",method = {RequestMethod.GET})
	public CodeMsg deleteCollect(int collectId) {
		boolean flag=collectService.deleteCollect(collectId);
		
		return new CodeMsg(flag);
	}
	
	
	@RequestMapping(value = "/all",method = {RequestMethod.GET})
	public List<Collect> allCollect(int userId) {
		System.out.println("111111111111111111111");
		List<Collect> collects=collectService.getCollectByUserId(userId);
		return collects;
	}
}
