package com.futher.school.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseDao;
import com.futher.school.entity.Message;
import com.futher.school.dao.MessageMapper;
import com.futher.school.service.MessageService;
import com.futher.school.util.PageBean;
@Service("messageService")
public class MessageServiceImpl extends BaseDao<Message,Serializable> implements MessageService{

	private static final long serialVersionUID = 1L;

	@Resource
	private MessageMapper MessageMapper;
	
	@Override
	public int addMessage(Message message) {
		return this.insertEntity(message);
	}

	@Override
	public String uploadResource(MultipartFile file, String truePath, HttpServletRequest request) {
		return this.uploadFile(file, truePath, request);
	}

	@Override
	public PageBean<Message> findByPage(int currentPage,String meStatus, String inquiry) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<Message> pageBean = new PageBean<Message>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = MessageMapper.selectByStatus(meStatus, inquiry).size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("meStatus", meStatus);
		map.put("inquiry", inquiry);
		// 封装每页显示的数据
		List<Message> lists = MessageMapper.findByPage(map);
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override
	public int deletMessage(int meId) {
		return this.deleteEntity(meId);
	}

	@Override
	public Message selectById(int meId) {
		return this.selectOneEntity(meId);
	}

	@Override
	public int replyMessage(int meId, String meReplycontent,String meStatus) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("meId", meId);
		map.put("meReplycontent", meReplycontent);
		map.put("meStatus", meStatus);
		return MessageMapper.replyMessage(map);
	}

	@Override
	public int updateMessage(Message message) {
		return this.updateEntity(message);
	}

}
