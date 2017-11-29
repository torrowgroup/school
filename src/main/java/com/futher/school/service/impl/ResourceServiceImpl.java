package com.futher.school.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.ResourceMapper;
import com.futher.school.service.ResourceService;
import com.futher.school.util.PageBean;

@Service("resourceService")
public class ResourceServiceImpl extends BaseDao<com.futher.school.entity.Resource, Serializable>
		implements ResourceService {

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

	@Override
	public int addResource(com.futher.school.entity.Resource resource) {
		return resourceMapper.insert(resource);
	}

	@Override
	public String uploadResource(MultipartFile file, String truePath, HttpServletRequest request) {
		return this.uploadFile(file, truePath, request);
	}

	@Override
	public String uploadImage(MultipartFile myFileName, HttpSession session) throws IllegalStateException, IOException {
		return this.upload(myFileName, session);
	}

	@Override
	public PageBean<com.futher.school.entity.Resource> findByPage(int currentPage, int reTypeid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<com.futher.school.entity.Resource> pageBean = new PageBean<com.futher.school.entity.Resource>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = resourceMapper.selectByTypeId(reTypeid).size();
		System.out.println(totalCount+"sssssssssssssssssssssssssssssssssssssssssssssssssssfffffffffffffffffffffffffffffffffffffffffffff");
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("reTypeid", reTypeid);
		// 封装每页显示的数据
		List<com.futher.school.entity.Resource> lists = resourceMapper.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}

	@Override
	public com.futher.school.entity.Resource selectById(Integer reId) {
		return (com.futher.school.entity.Resource) this.selectOneEntity(reId);
	}

	@Override
	public int deletResource(int reId) {
		return this.deleteEntity(reId);
	}

	@Override
	public void downloadResource(com.futher.school.entity.Resource resource, String realPath,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		String filename = resource.getReContent();
		this.downloadFile(filename, realPath, response, request);
	}

	@Override
	public void deletResource(String reSpare, String truePath, HttpServletRequest request) {
		this.deletFile(reSpare, truePath, request);
	}

	@Override
	public int updateResource(com.futher.school.entity.Resource resource) {
		return this.updateEntity(resource);
	}
	@Override
	public List<com.futher.school.entity.Resource> selectByPid(int Pid, int number) {
		return resourceMapper.selectByPid(Pid, number);
	}

}
