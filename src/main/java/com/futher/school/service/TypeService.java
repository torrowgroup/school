package com.futher.school.service;

import java.util.List;

import org.springframework.ui.Model;

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
	//根据ID删除类别
	int deletType(int tyId);
	//根据修改类别
	int updateType(Type type);
	//根据ID获得类别
	Type selectTypeById(int tyId);
//	//根据父ID得到同一类的类别
//	Type selectTypeByPid(int tyPid);
	//得到所有的类型
	void getType(Model model);
	
	
//	Type getTypeById(Integer reTypeid);

}
