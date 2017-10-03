package com.futher.school.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.entity.Type;
import com.futher.school.service.TypeService;
@Service("typeService")
public class TypeServiceImpl extends BaseDao<Type,Serializable> implements TypeService{

	private static final long serialVersionUID = 1L;

}
