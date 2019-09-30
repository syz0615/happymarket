package com.happymarket.service;

import java.util.List;

import com.happymarket.bean.Address;

public interface AddressService {
	List<Address> getAllAddress(int userId);
	
	boolean addAddress(Address address);
	
	boolean updateAddress(Address address);
	
	boolean deleteAddress(int addressId);
	
	Address getDefaultAddress(int userId);
}
