package com.futher.school.service.impl;

import java.io.Serializable;

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
		public int getUser(User user) {
			return userMapper.insert(user);
		}
		
}
