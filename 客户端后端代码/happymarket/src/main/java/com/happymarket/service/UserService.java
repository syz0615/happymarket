package com.happymarket.service;

import com.happymarket.bean.User;

public interface UserService {
	
	boolean regist(User user);
	
	boolean checkPhone(String userPhone);
	
	User login(String userPhone,String password);
	
	boolean updateUserPicture(int userId,String userPicture);
	
	User getUserById(int userId);
	
	boolean changePwd(int userId,String oldPwd,String newPwd);
	
	boolean changeUserInfo(User user);
}
