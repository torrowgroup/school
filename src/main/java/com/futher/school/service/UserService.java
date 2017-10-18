package com.futher.school.service;

import java.util.List;

import com.futher.school.entity.User;
import com.futher.school.util.PageBean;

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
	//添加用户
	public int addUser(User user);
	//用于登录验证
	public User loginTest(String usEmail);
	//查询所有用户，并分页
	public PageBean<User> findByPage(int currentPage);
	//删除用户
	public int deletByUserId(int usId);
	//得到修改的用户信息
	public User selectByUserId(int usId);
}
