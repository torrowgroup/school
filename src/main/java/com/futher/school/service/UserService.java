package com.futher.school.service;

import com.futher.school.entity.User;

public interface UserService {

	//用于登录 马黎明
	public User login(String usEmail,String usPassword);
	//用于找回密码
	public User getPassword(String usEmail);
	//用于找官方账号
	public User getEmail(String identityname);
	//修改密码
	public int updatePassword(User user);
}
