package com.futher.school.dao;

import com.futher.school.entity.User;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //用于登录，马黎明
	User selectByUserValue(@Param("usEmail")String usEmail,@Param("usPassword") String usPassword);
	//用于找回密码 马黎明
	User selectByEmail(@Param("usEmail")String usEmail);
	//用于找官方邮箱 马黎明
	User selectByIdentity(@Param("identityname")String identityname);
	//分页查询
	List<User> findByPage(HashMap<String, Object> map);
	//根据pid查找教师
	List<User> selectByPid(@Param("number")int number, @Param("name")String name, @Param("identity")String identity);
	//用户分页查询，和模糊查询，得到总条数
	List<User> selectByInquiry(@Param("inquiry")String inquiry);
	//根据类型ID查找老师和教研组的条数
	List<User> selectByTypeId(int tyId);
	//根据类型ID查找老师和教研组数据进行分页
	List<User> findByTypeId(HashMap<String, Object> map);
}