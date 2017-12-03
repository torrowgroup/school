package com.futher.school.dao;

import com.futher.school.entity.User;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

//    int deleteByPrimaryKey(Integer usId);
//
//    int insert(User record);
//
//    User selectByPrimaryKey(Integer usId);
//
//    int updateByPrimaryKey(User record);
    //用于登录，马黎明
	User selectByUserValue(@Param("usEmail")String usEmail,@Param("usPassword") String usPassword);
	//用于找回密码 马黎明
	User selectByEmail(@Param("usEmail")String usEmail);
	//用于找官方邮箱 马黎明
	User selectByIdentity(@Param("identityname")String identityname);
//	//查询所有用户
//	List<User> selectAll();
	//分页查询
	List<User> findByPage(HashMap<String, Object> map);
	//根据pid查找教师
	List<User> selectByPid(@Param("number")int number, @Param("name")String name);
	//修改密码
	int updatePassword(@Param("usId") int usId,@Param("usPassword") String usPassword);

	
	//用户分页查询，和模糊查询，得到总条数
	List<User> selectByInquiry(@Param("inquiry")String inquiry);
}