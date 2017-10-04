package com.futher.school.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.entity.Message;
import com.futher.school.service.MessageService;
@Service("messageService")
public class MessageServiceImpl extends BaseDao<Message,Serializable> implements MessageService{

	private static final long serialVersionUID = 1L;

}
