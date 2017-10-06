package com.futher.school.dao;

import com.futher.school.entity.User;
import com.futher.school.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer usId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer usId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //用于登录，马黎明
	User selectByUserValue(@Param("usEmail")String usEmail,@Param("usPassword") String usPassword);
	//用于找回密码 马黎明
	User selectByEmail(@Param("usEmail")String usEmail);
	//用于找官方邮箱 马黎明
	User selectByIdentity(@Param("identityname")String identityname);
}