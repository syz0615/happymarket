package com.happymarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happymarket.bean.Goods;
import com.happymarket.service.GoodsService;

@Controller
@RequestMapping("/goods")
@ResponseBody
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/carousel", method = { RequestMethod.GET })
	public List<Goods> carouselGoods() {
		List<Goods> carousel = goodsService.getCarouselGoods();
		return carousel;
	}

	@RequestMapping(value = "/newgoods", method = { RequestMethod.GET })
	public List<Goods> newGoods() {
		List<Goods> newGoods = goodsService.getHotGoods();
		return newGoods;
	}

	@RequestMapping(value = "/hotgoods", method = { RequestMethod.GET })
	public List<Goods> hotGoods() {
		List<Goods> hotGoods = goodsService.getHotGoods();
		return hotGoods;
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public List<Goods> search(String key) {
		List<Goods> search = goodsService.searchGoods(key);
		return search;
	}

	@RequestMapping(value = "/detail", method = { RequestMethod.GET })
	public Goods goodsDetail(int goodsId) {
		Goods goods = goodsService.getGoods(goodsId);
		return goods;
	}

	
}
