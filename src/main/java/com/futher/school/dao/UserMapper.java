package com.futher.school.dao;

import com.futher.school.entity.User;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int deleteByPrimaryKey(Integer usId);

    int insert(User record);

//    int insertSelective(User record);

    User selectByPrimaryKey(Integer usId);

//    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //用于登录，马黎明
	User selectByUserValue(@Param("usEmail")String usEmail,@Param("usPassword") String usPassword);
	//用于找回密码 马黎明
	User selectByEmail(@Param("usEmail")String usEmail);
	//用于找官方邮箱 马黎明
	User selectByIdentity(@Param("identityname")String identityname);
	//查询所有用户
	List<User> selectAll();
	//分页查询
	List<User> findByPage(HashMap<String, Object> map);
	//根据pid查找教师
	List<User> selectByPid(@Param("number")int number, @Param("name")String name);
}