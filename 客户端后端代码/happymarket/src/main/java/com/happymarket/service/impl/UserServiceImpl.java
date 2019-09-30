package com.happymarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happymarket.bean.User;
import com.happymarket.dao.UserDao;
import com.happymarket.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	
	@Override
	@Transactional
	public boolean regist(User user) {
		boolean regist=true;
		user.setUserPhone(user.getUserPhone());
		user.setUserPwd(user.getUserPwd());
		int result=userDao.insertUser(user);
		if(result==0) {
			regist=false;
		}
		return regist;
	}


	@Override
	public boolean checkPhone(String userPhone) {
		boolean check=true;
		User result=userDao.seclectUserByUserPhone(userPhone);
		if(result!=null) {
			check=false;
		}
		return check;
	}


	@Override
	public User login(String userPhone, String password) {
		User user=userDao.selectUserByPhonePwd(userPhone, password);
		
		return user;
	}


	@Override
	public boolean updateUserPicture(int userId, String userPicture) {
		boolean flag=true;
		int result=userDao.updateUserPicture(userId, userPicture);
		if(result==0) {
			flag=false;
		}
		return flag;
	}


	@Override
	public User getUserById(int userId) {
		User user=userDao.selectUserByUserId(userId);
		return user;
	}


	@Override
	public boolean changePwd(int userId, String oldPwd, String newPwd) {
		boolean flag=true;
		int result=userDao.updateUserPwd(userId, oldPwd, newPwd);
		if(result==0) {
			flag=false;
		}
		return flag;
	}


	@Override
	public boolean changeUserInfo(User user) {
		boolean flag=true;
		int result=userDao.updateUserInfo(user);
		if(result==0) {
			flag=false;
		}
		return flag;
	}
	

}
