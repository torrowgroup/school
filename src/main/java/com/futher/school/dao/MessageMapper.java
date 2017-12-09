package com.futher.school.dao;

import com.futher.school.entity.Message;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {

//    int deleteByPrimaryKey(Integer meId);
//
//    int insert(Message record);

//    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer meId);

//    int updateByPrimaryKeySelective(Message record);

//    int updateByPrimaryKey(Message record);
    //取分页数据
	List<Message> findByPage(HashMap<String, Object> map);
	//根据状态来查看留言条数
	List<Message> selectByStatus(@Param("meStatus")String meStatus, @Param("inquiry")String inquiry);
	//回复留言
	int replyMessage(HashMap<String, Object> map);
	//修改留言
	int updateMessage(Message message);
}