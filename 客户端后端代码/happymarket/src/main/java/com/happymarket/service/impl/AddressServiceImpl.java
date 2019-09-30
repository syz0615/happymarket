package com.happymarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happymarket.bean.Address;
import com.happymarket.dao.AddressDao;
import com.happymarket.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	@Override
	public List<Address> getAllAddress(int userId) {
		List<Address> allAddress = addressDao.selectAddressByUserId(userId);
		return allAddress;
	}

	@Override
	@Transactional
	public boolean addAddress(Address address) {
		boolean flag = true;
		int result = addressDao.insertAddress(address);
		if (result == 0) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean updateAddress(Address address) {
		boolean flag = true;
		int result = addressDao.updateAddress(address);
		if (result == 0) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean deleteAddress(int addressId) {
		boolean flag = true;
		int result = addressDao.deleteAddress(addressId);
		if (result == 0) {
			flag = false;
		}
		return flag;
	}

	@Override
	public Address getDefaultAddress(int userId) {
		Address address=addressDao.selectDefaultAddress(userId);
		return address;
	}

}
