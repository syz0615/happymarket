package com.happymarket.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.happymarket.bean.User;
import com.happymarket.service.UserService;
import com.happymarket.util.CodeMsg;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/regist",method={RequestMethod.POST})
	public CodeMsg regist(@RequestBody User user) {
		//TODO 这里需要添加密码加盐代码
		user.setLevel(0);
		boolean flag=userService.checkPhone(user.getUserPhone());
		if(flag) {
			flag=userService.regist(user);
			System.out.println("user");
		}
		CodeMsg msg=new CodeMsg(flag);
		return msg;
	}
	
	
	@RequestMapping(value="/checkphone",method = {RequestMethod.GET})
	public CodeMsg checkPhone(String userPhone) {
		boolean check=userService.checkPhone(userPhone);
		CodeMsg msg=new CodeMsg(check);
		return msg;
	}
	
	
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public User login(@RequestBody User user) {
		//TODO 这里需要对密码进行一次加盐
		User loginuser=userService.login(user.getUserPhone(),user.getUserPwd());
		return loginuser;
	}
	
	
	@RequestMapping(value = "/userpicture", method = { RequestMethod.POST })
	public CodeMsg goodsImg(MultipartFile file,int userId) {
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		if (!suffix.equals(".jpg") && !suffix.equals(".png")) {
			return new CodeMsg(false);
		}
		String newName=String.valueOf(new Date().getTime())+suffix;
		try {
			String serverpath = ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ").replace('/','\\');
			String folderPath = serverpath.substring(1)+"/image/";// 从路径字符串中取出工程路径
			file.transferTo(new File(folderPath+newName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new CodeMsg(false);
		} catch (IllegalStateException e) {
			System.out.println("文件转储时出错");
			e.printStackTrace();
			return new CodeMsg(false);
		} catch (IOException e) {
			e.printStackTrace();
			return new CodeMsg(false);
		}
		boolean flag=userService.updateUserPicture(userId, newName);
		return new CodeMsg(flag);
	}
	
	@RequestMapping(value = "/getuser" ,method = {RequestMethod.GET})
	public User getUser(int userId) {
		User user=userService.getUserById(userId);
		return user;
	}
	
	@RequestMapping(value = "/changeinfo",method = {RequestMethod.POST})
	public CodeMsg changeUserInfo(@RequestBody User user) {
		boolean flag=userService.changeUserInfo(user);
		return new CodeMsg(flag);
	}
	
	@RequestMapping(value = "/password",method = {RequestMethod.POST})
	public CodeMsg changeUserPwd(@RequestBody Map<String,Object> map) {
		int userId=(int) map.get("userId");
		String oldPwd=(String) map.get("oldPwd");
		String newPwd=(String) map.get("newPwd");
		boolean flag=userService.changePwd(userId, oldPwd, newPwd);
		return new CodeMsg(flag);
	}
	
}
