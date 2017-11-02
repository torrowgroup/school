package com.futher.school.service;

import java.io.File;
import java.util.List;

import com.futher.school.entity.Resource;

public interface ResourceService {
	//wqj用于存储用户上传文学作品
	public int uploadeEdit(Resource resource);
	//wqj 获取resource
	public List<Resource> getUploadFileName();
}
