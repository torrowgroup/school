package com.futher.school.service;

import java.util.List;

import com.futher.school.entity.Type;
import com.futher.school.util.PageBean;

public interface TypeService {
	//根据类别名称得到id
	Type getId(String usIdentityname);
	//根据父ID得到同一类的类别名称
	List<Type> selectTypeName(Integer tyPid);
	//添加类别
	int addType(Type type);
	//查询所有类别
	List<Type> getAllTypes();
	//分页查看所有类别
	PageBean<Type> findByPage(int currentPage);

}
