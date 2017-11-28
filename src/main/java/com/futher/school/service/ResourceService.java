package com.futher.school.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
import com.futher.school.entity.User;
import com.futher.school.util.PageBean;

public interface ResourceService {
	//添加资源
	int addResource(Resource resource);
	//上传文件
	String uploadResource(MultipartFile file, String truePath, HttpServletRequest request);
	//富文本上传
	String uploadImage(MultipartFile myFileName,HttpSession session) throws IllegalStateException, IOException;
	//分页显示资源
	PageBean<Resource> findByPage(int currentPage, int reTypeid);
	//根据ID查找资源
	Resource selectById(Integer reId);
	//根据ID删除资源
	int deletResource(int reId);
	//下载资源
	void downloadResource(Resource resource, String realPath, HttpServletResponse response, HttpServletRequest request) throws IOException;
	//删除资源
	void deletResource(String reSpare, String truePath, HttpServletRequest request);
	//修改资源
	int updateResource(Resource resource);
	//wqj用于存储用户上传文学作品
	public int uploadeEdit(Resource resource);
	//wqj 获取resource
	public List<Resource> getUploadFileName();
	//首页用
	List<Resource> selectByPid(int Pid, int number);
	//根据类型id查找
	Resource selectByTypeid(Integer reTypeid);
	//首页用，获取全部资源
	void getAllResource(List<Type> typeList, Model model);
	//学校的官方页面用，得到所有链接
	void getLinkAndTime(List<Type> typeList, Model model);
	//通过类型id查找资源
	PageBean<Resource> findByTypeId(int currentPage, int tyId);
}
