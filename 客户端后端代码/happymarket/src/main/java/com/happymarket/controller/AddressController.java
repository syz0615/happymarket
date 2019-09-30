package com.happymarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happymarket.bean.Address;
import com.happymarket.service.AddressService;
import com.happymarket.util.CodeMsg;


@Controller
@RequestMapping("/address")
@ResponseBody
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/all",method = {RequestMethod.GET})
	public List<Address> allAddress(int userId){
		List<Address> addresses=addressService.getAllAddress(userId);
		return addresses;
	}
	
	@RequestMapping(value = "/add",method = {RequestMethod.POST})
	public CodeMsg addAddress(@RequestBody Address address) {
		boolean flag=addressService.addAddress(address);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	@RequestMapping(value = "/change",method = {RequestMethod.POST})
	public CodeMsg changeAddress(@RequestBody Address address) {
		boolean flag=addressService.updateAddress(address);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	
	@RequestMapping(value = "/delete",method = {RequestMethod.GET})
	public CodeMsg deleteAddress(int addressId) {
		boolean flag=addressService.deleteAddress(addressId);
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	@RequestMapping(value = "/default",method = {RequestMethod.GET})
	public Address getDefaultAddress(int userId) {
		Address address=addressService.getDefaultAddress(userId);
		return address;
	}
}
