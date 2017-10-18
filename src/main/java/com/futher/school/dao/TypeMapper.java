package com.futher.school.dao;

import com.futher.school.entity.Type;
import com.futher.school.entity.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    long countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer tyId);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer tyId);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
    //得到添加用户类别的id
	Type selectByCategoryname(@Param("usIdentityname") String usIdentityname);
	//得到所有用户类别
	List<Type> selectByTypid(@Param("tyPid")Integer tyPid);
}