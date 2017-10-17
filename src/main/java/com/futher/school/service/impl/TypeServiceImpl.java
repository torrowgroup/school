package com.futher.school.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.TypeMapper;
import com.futher.school.entity.Type;
import com.futher.school.service.TypeService;
@Service("typeService")
public class TypeServiceImpl extends BaseDao<Type,Serializable> implements TypeService{

	private static final long serialVersionUID = 1L;

	@Resource
	private TypeMapper typeMapper;

	@Override
	public Type getId(String usIdentityname) {
		return typeMapper.selectByCategoryname(usIdentityname);
	}

	@Override
	public List<Type> selectTypeName(Integer tyPid) {
		return typeMapper.selectByTypid(tyPid);
	}

}
