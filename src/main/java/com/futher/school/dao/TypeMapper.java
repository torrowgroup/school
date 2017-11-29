package com.futher.school.dao;

import com.futher.school.entity.Type;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {

    int deleteByPrimaryKey(Integer tyId);

    int insert(Type record);

//    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer tyId);

//    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
    //得到添加用户类别的id
	Type selectByCategoryname(@Param("usIdentityname") String usIdentityname);
	//根据父类ID得到所有用户类别
	List<Type> selectByTypid(@Param("tyPid")Integer tyPid);
	//得到所有用户的类别
	List<Type> selectAll();
	//分页查询所有类别
	List<Type> findByPage(HashMap<String, Object> map);

}