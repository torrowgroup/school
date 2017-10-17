package com.futher.school.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.selectAll();
	}

	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public User loginTest(String usEmail) {
		return userMapper.selectByEmail(usEmail);
	}

	@Override
	public PageBean<User> findByPage(int currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<User> pageBean = new PageBean<User>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userMapper.selectAll().size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		// 封装每页显示的数据
		List<User> lists = userMapper.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}

	@Override
	public int deletByUserId(int usId) {
		return userMapper.deleteByPrimaryKey(usId);
	}

	@Override
	public User selectByUserId(int usId) {
		return userMapper.selectByPrimaryKey(usId);
	}

}
