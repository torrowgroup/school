package com.futher.school.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.service.ResourceService;
@Service("resourceService")
public class ResourceServiceImpl extends BaseDao<ResourceService,Serializable> implements ResourceService{

	private static final long serialVersionUID = 1L;

}
