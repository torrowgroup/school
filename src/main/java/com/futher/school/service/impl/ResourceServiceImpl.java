package com.futher.school.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseDao;
import com.futher.school.dao.ResourceMapper;
import com.futher.school.entity.Type;
import com.futher.school.service.ResourceService;
import com.futher.school.util.PageBean;

@Service("resourceService")
public class ResourceServiceImpl extends BaseDao<com.futher.school.entity.Resource, Serializable>
		implements ResourceService {

	private static final long serialVersionUID = 1L;
	@Resource
	private ResourceMapper resourceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.futher.school.service.ResourceService#uploadeEdit(com.futher.school.
	 * entity.Resource)
	 */
	@Override
	public int uploadeEdit(com.futher.school.entity.Resource resource) {
		return this.insertEntity(resource);
		// 上传文档

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.futher.school.service.ResourceService#getUpload()
	 */
	@Override
	public List<com.futher.school.entity.Resource> getUploadFileName() {

		return resourceMapper.getUploadFileName();
	}

	@Override
	public int addResource(com.futher.school.entity.Resource resource) {
		return this.insertEntity(resource);
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
	public PageBean<com.futher.school.entity.Resource> findByPage(int currentPage, int reTypeid, String inquiry) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<com.futher.school.entity.Resource> pageBean = new PageBean<com.futher.school.entity.Resource>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		// 封装总记录数

		int totalCount = resourceMapper.selectByTypePid(reTypeid, inquiry).size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("reTypeid", reTypeid);
		map.put("inquiry", inquiry);
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

	@Override
	public com.futher.school.entity.Resource selectByTypeid(Integer reTypeid) {
		return resourceMapper.selectByid(reTypeid);
	}

	@Override
	public void getAllResource(List<Type> typeList, Model model) {
		List<com.futher.school.entity.Resource> educateList = new ArrayList<com.futher.school.entity.Resource>();
		List<com.futher.school.entity.Resource> linkList = new ArrayList<com.futher.school.entity.Resource>();
		List<com.futher.school.entity.Resource> informList = new ArrayList<com.futher.school.entity.Resource>();
		List<com.futher.school.entity.Resource> schoolviewList = new ArrayList<com.futher.school.entity.Resource>();
		List<com.futher.school.entity.Resource> newsList = new ArrayList<com.futher.school.entity.Resource>();
		for (int i = 0; i < typeList.size(); i++) {
			if (typeList.get(i).getTyPid() == 4) {
				educateList = this.selectByPid(4, 10);
			} else if (typeList.get(i).getTyPid() == 7) {
				linkList = this.selectByPid(7, 4);
			} else if (typeList.get(i).getTyPid() == 8) {
				informList = this.selectImmediateNews(8, 6);
			} else if (typeList.get(i).getTyPid() == 9) {
				schoolviewList = this.selectByPid(9, 4);
			} else if (typeList.get(i).getTyPid() == 12) {
				newsList = this.selectImmediateNews(12, 4);
			} else if (typeList.get(i).getTyPid() == 11) {
				com.futher.school.entity.Resource examTime = this.selectByTypeid(typeList.get(i).getTyId());
				model.addAttribute("examTime", examTime);
			} else if (typeList.get(i).getTyPid() == 13) {
				com.futher.school.entity.Resource schoolNews = this.selectByTypeid(typeList.get(i).getTyId());
				model.addAttribute("schoolNews", schoolNews);
			}
		}
//		List<com.futher.school.entity.Resource> newsAndInformList = new ArrayList<com.futher.school.entity.Resource>();
//		newsAndInformList.addAll(informList);
//		newsAndInformList.addAll(newsList);
		model.addAttribute("schoolviewlist", schoolviewList);
		model.addAttribute("informlist", informList);
		model.addAttribute("newslist", newsList);
		model.addAttribute("educatelist", educateList);
		model.addAttribute("linkList", linkList);
//		model.addAttribute("newsandinformlist", newsAndInformList);
	}

	private List<com.futher.school.entity.Resource> selectImmediateNews(int Pid, int number) {
		return resourceMapper.selectImmediateNews(Pid, number);
	}

	@Override
	public void getLinkAndTime(List<Type> typeList, Model model) {
		List<com.futher.school.entity.Resource> linkList = new ArrayList<com.futher.school.entity.Resource>();
		if (typeList.isEmpty()) {
			model.addAttribute("news", "暂无该类型数据");
		} else {
			for (int i = 0; i < typeList.size(); i++) {
				if (typeList.get(i).getTyPid() == 7) {
					linkList = this.selectByPid(7, 4);
				} else if (typeList.get(i).getTyPid() == 11) {
					com.futher.school.entity.Resource examTime = this.selectByTypeid(typeList.get(i).getTyId());
					if (examTime == null) {
						model.addAttribute("", "暂无时间");
					} else {
						model.addAttribute("examTime", examTime);
					}
				} else if (typeList.get(i).getTyPid() == 13) {
					com.futher.school.entity.Resource schoolNews = this.selectByTypeid(typeList.get(i).getTyId());
					if (schoolNews == null) {
						model.addAttribute("", "暂无学校信息");
					} else {
						model.addAttribute("schoolNews", schoolNews);
					}
				}
			}
		}
//		linkList = this.selectByPid(7, 4);
		model.addAttribute("linkList", linkList);
	}

	@Override
	public PageBean<com.futher.school.entity.Resource> findByTypeId(int currentPage, int reTypeid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<com.futher.school.entity.Resource> pageBean = new PageBean<com.futher.school.entity.Resource>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 8;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = resourceMapper.selectByTypeId(reTypeid).size();
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("reTypeid", reTypeid);
		// 封装每页显示的数据
		List<com.futher.school.entity.Resource> lists = resourceMapper.findByTypeId(map);
		pageBean.setLists(lists);
		
		return pageBean;
	}
}
