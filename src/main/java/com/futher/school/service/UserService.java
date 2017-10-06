package com.futher.school.service;

import java.util.List;

import com.futher.school.entity.User;

public interface UserService {

	//用于登录 马黎明
	public User login(String usEmail,String usPassword);
	//用于找回密码
	public User getPassword(String usEmail);
	//用于找官方发邮件账号
	public User getEmail(String identityname);
	//修改密码 修改个人资料
	public int updatePassword(User user);
	//用于得到所有用户
	public List<User> getAllUsers();
}
