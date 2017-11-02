package com.futher.school.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.ResourceMapper;
import com.futher.school.service.ResourceService;
@Service("resourceService")
public class ResourceServiceImpl extends BaseDao<ResourceService,Serializable> implements ResourceService{

	private static final long serialVersionUID = 1L;
	@Resource 
	private ResourceMapper resourceMapper ;
	/* (non-Javadoc)
	 * @see com.futher.school.service.ResourceService#uploadeEdit(com.futher.school.entity.Resource)
	 */
	@Override
	public int   uploadeEdit(com.futher.school.entity.Resource resource) {
		return resourceMapper.insert(resource);
		//上传文档
		
	}
	/* (non-Javadoc)
	 * @see com.futher.school.service.ResourceService#getUpload()
	 */
	@Override
	public List<com.futher.school.entity.Resource> getUploadFileName() {
		
		return  resourceMapper.getUploadFileName();
	}

}
