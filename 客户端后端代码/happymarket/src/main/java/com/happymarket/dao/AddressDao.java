package com.happymarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.happymarket.bean.Address;


@Mapper
public interface AddressDao {
	
	int updateAddress(Address address);
	
	List<Address> selectAddressByUserId(@Param("userId")int userId);
	
	int insertAddress(Address address);
	
	Address selectAddressById(int addressId);
	
	int deleteAddress(int addressId);
	
	Address selectDefaultAddress(int userId);
}
