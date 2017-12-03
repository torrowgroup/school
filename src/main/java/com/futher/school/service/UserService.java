package com.futher.school.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

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
	//上传文件
	public String uploadResource(MultipartFile file, String path, HttpServletRequest request);
	//富文本上传图片
	public String uploadimage(MultipartFile myFileName, HttpSession session) throws IllegalStateException, IOException;
	//根据类型父id查找教师
	public List<User> selectByPid(int number);
	/**
	 * @param password
	 * @return
	 */

	/**
	 * @param usId
	 * @param password
	 * @return
	 */
	public int updatePassword(int usId, String password);
}
