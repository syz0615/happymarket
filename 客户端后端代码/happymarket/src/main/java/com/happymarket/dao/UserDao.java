package com.happymarket.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.happymarket.bean.User;

@Mapper
public interface UserDao {
	User selectUserByPhonePwd(@Param("userPhone")String userPhone,@Param("password")String password);
	
	User seclectUserByUserPhone(@Param("userPhone")String userPhone);
	
	User selectUserByUserId(@Param("userId")int userId);
	
	int insertUser(User user);
	
	int updateUserPicture(@Param("userId")int userId,@Param("userPicture")String userPicture);
	
	int updateUserInfo(User user);
	
	int updateUserPwd(@Param("userId")int userId,@Param("oldPwd")String oldPwd,@Param("newPwd")String newPwd);
	
}
