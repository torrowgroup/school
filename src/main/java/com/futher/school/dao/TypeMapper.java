package com.futher.school.dao;

import com.futher.school.entity.Type;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {

    //得到添加用户类别的id
	Type selectByCategoryname(@Param("usIdentityname") String usIdentityname);
	//根据父类ID得到所有用户类别
	List<Type> selectByTypid(@Param("tyPid")Integer tyPid);
	//分页查询所有类别
	List<Type> findByPage(HashMap<String, Object> map);
	//根据搜索内容来获取符合条件的数据条数
	List<Type> selectByInquiry(@Param("inquiry")String inquiry);

}