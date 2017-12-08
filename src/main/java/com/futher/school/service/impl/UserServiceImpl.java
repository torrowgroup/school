package com.futher.school.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.UserMapper;
import com.futher.school.entity.User;
import com.futher.school.service.UserService;
import com.futher.school.util.PageBean;

@Service
public class UserServiceImpl extends BaseDao<User, Serializable> implements UserService {

	private static final long serialVersionUID = 1L;
	// 注入Service依赖
	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String usEmail, String usPassword) {
		return userMapper.selectByUserValue(usEmail, usPassword);
	}

	@Override
	public User getPassword(String usEmail) {
		return userMapper.selectByEmail(usEmail);
	}

	@Override
	public User getEmail(String identityname) {
		return userMapper.selectByIdentity(identityname);
	}

	@Override
	public int updatePassword(User user) {
		return this.updateEntity(user);
//		return userMapper.updateByPrimaryKey(user);
	}
	@Override
	public int updatePassword(int usId, String password) {
		return userMapper.updatePassword(usId, password);
	}

	@Override
	public List<User> getAllUsers() {
		return this.selectAllEntity();
//		return userMapper.selectAll();
	}

	@Override
	public int addUser(User user) {
		return this.insertEntity(user);
//		return userMapper.insert(user);
	}

	@Override
	public User loginTest(String usEmail) {
		return userMapper.selectByEmail(usEmail);
	}

	@Override
	public PageBean<User> findByPage(int currentPage, String inquiry) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<User> pageBean = new PageBean<User>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userMapper.selectByInquiry(inquiry).size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("inquiry", inquiry);
		// 封装每页显示的数据
		List<User> lists = userMapper.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}

	@Override
	public int deletByUserId(int usId) {
		return this.deleteEntity(usId);
//		return userMapper.deleteByPrimaryKey(usId);
	}

	@Override
	public User selectByUserId(int usId) {
		return this.selectOneEntity(usId);
//		return userMapper.selectByPrimaryKey(usId);
	}

	@Override
	public String uploadResource(MultipartFile file, String path,HttpServletRequest request) {
		return this.uploadFile(file, path, request);
	}

	@Override
	public String uploadimage(MultipartFile myFileName,HttpSession session) throws IllegalStateException, IOException {
		return this.upload(myFileName, session);
	}

	@Override
	public List<User> selectByPid(int number, String identity) {
		String name = "teacher";
		return userMapper.selectByPid(number, name, identity);
	}

	@Override
	public Object findByTypeId(int currentPage, int tyId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<User> pageBean = new PageBean<User>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userMapper.selectByTypeId(tyId).size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("tyId", tyId);
		// 封装每页显示的数据
		List<User> lists = userMapper.findByTypeId(map);
//		for (int i = 0; i < lists.size(); i++) {
//			System.out.println(lists.get(i));
//		}
		pageBean.setLists(lists);

		return pageBean;
	}

}
