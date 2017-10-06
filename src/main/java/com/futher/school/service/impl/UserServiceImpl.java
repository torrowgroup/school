package com.futher.school.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.UserMapper;
import com.futher.school.entity.User;
import com.futher.school.service.UserService;
@Service
public class UserServiceImpl extends BaseDao<User,Serializable> implements UserService{

	private static final long serialVersionUID = 1L;
		// 注入Service依赖
		@Resource
		private UserMapper userMapper;

		@Override
		public User login(String usEmail, String usPassword) {
			return userMapper.selectByUserValue(usEmail,usPassword);
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
		
}
