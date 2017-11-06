package com.futher.school.dao;

import com.futher.school.entity.Message;
import com.futher.school.entity.MessageExample;
import com.futher.school.entity.Resource;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer meId);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer meId);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    //取分页数据
	List<Message> findByPage(HashMap<String, Object> map);
	//根据状态来查看留言条数
	List<Message> selectByStatus(String meStatus);
	//回复留言
	int replyMessage(HashMap<String, Object> map);
	//修改留言
	int updateMessage(Message message);
}