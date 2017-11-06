package com.futher.school.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.futher.school.entity.Message;
import com.futher.school.entity.Resource;
import com.futher.school.util.PageBean;

public interface MessageService {
	//添加留言
	int addMessage(Message message);
	//上传留言附加文件
	String uploadResource(MultipartFile file, String truePath, HttpServletRequest request);
	//用于留言分页
	PageBean<Message> findByPage(int currentPage, String meStatus);
	//删除留言
	int deletMessage(int meId);
	//根据id查找留言
	Message selectById(int meId);
	//回复留言
	int replyMessage(int meId, String meReplycontent, String meStatus);
	//修改留言
	int updateMessage(Message message);

}
