package com.futher.school.controller.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
import com.futher.school.entity.User;

@RequestMapping("/resource")
@Controller
public class ResourceController extends BaseController {

	@RequestMapping("toAddResource")
	public String toAddResource(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		model.addAttribute("typelist", typelist);
		session.setAttribute("tyPid", tyPid);
		return "/manager/addresource";
	}

	@RequestMapping("/addResource")
	public String addResource(Resource resource, MultipartFile file, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		setAddResource(resource);
		if (resource.getReTypename().equals("校园新闻")) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传新闻图片");
				return toAddResource(tyPid, model);
			} else {
				String truePath = "static/uploadImg/uploadnew";
				String fileName = uploadOpus(file, truePath);
				resource.setReSpare(fileName);
			}
		}
		if (tyPid == 5) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传作品");
				return toAddResource(tyPid, model);
			} else {
				String truePath = "static/uploadImg/schoolopus";
				String fileName = uploadOpus(file, truePath);
				resource.setReContent(fileName);
			}
		} else if (tyPid == 6) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传资源下载文件");
				return toAddResource(tyPid, model);
			} else {
				String truePath = "static/uploadImg/schoolresource";
				String fileName = uploadOpus(file, truePath);
				resource.setReContent(fileName);
			}
		} else if (tyPid == 9) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传校园风景照片");
				return toAddResource(tyPid, model);
			} else {
				String truePath = "static/uploadImg/schoolview";
				String fileName = uploadOpus(file, truePath);
				resource.setReSpare(fileName);
			}
		}
		int judge = resourceService.addResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toAddResource(tyPid, model);
	}

	@RequestMapping("/selectResource")
	public String selectResource(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int reTypeid,
			Model model) {
		model.addAttribute("reTypeid", reTypeid);
		model.addAttribute("messages", resourceService.findByPage(currentPage, reTypeid));// 回显分页数据
		return "manager/selectresource";
	}

	@RequestMapping("deletResource")
	public String deletResource(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		int judge = resourceService.deletResource(reId);
		if (judge == 1) {
			model.addAttribute("news", "删除成功");
		} else {
			model.addAttribute("news", "删除失败");
		}
		return selectResource(1, resource.getReTypeid(), model);

	}
	@RequestMapping("toUpdateResource")
	public String toUpdateResource(int reId,Model model){
		Resource resource = resourceService.selectById(reId);
		List<Type> typelist = typeService.selectTypeName(resource.getReTypeid());
		model.addAttribute("typelist", typelist);
		session.setAttribute("tyPid", resource.getReTypeid());
		model.addAttribute("resource", resource);
		return "/manager/updateresource";
	}
	@RequestMapping("updateResource")
	public String updateResource(Resource resource, MultipartFile file, Model model){
		int tyPid = (int) session.getAttribute("tyPid");
		Resource oldResource = resourceService.selectById(resource.getReId());
		setAddResource(resource);
		if (resource.getReTypename().equals("校园新闻")) {
			if (file.isEmpty()) {
				resource.setReSpare(oldResource.getReSpare());
			} else {
				String truePath = "static/uploadImg/uploadnew";
				String fileName = uploadOpus(file, truePath);
				resourceService.deletResource(oldResource.getReSpare(), truePath, request);
				resource.setReSpare(fileName);
			}
		}
		if (tyPid == 5) {
			if (file.isEmpty()) {
				resource.setReContent(oldResource.getReContent());
			} else {
				String truePath = "static/uploadImg/schoolopus";
				String fileName = uploadOpus(file, truePath);
				resourceService.deletResource(oldResource.getReContent(), truePath, request);
				resource.setReContent(fileName);
			}
		} else if (tyPid == 6) {
			if (file.isEmpty()) {
				resource.setReContent(oldResource.getReContent());
			} else {
				String truePath = "static/uploadImg/schoolresource";
				String fileName = uploadOpus(file, truePath);
				resourceService.deletResource(oldResource.getReContent(), truePath, request);
				resource.setReContent(fileName);
			}
		} else if (tyPid == 9) {
			if (file.isEmpty()) {
				resource.setReSpare(oldResource.getReSpare());
			} else {
				String truePath = "static/uploadImg/schoolview";
				String fileName = uploadOpus(file, truePath);
				resourceService.deletResource(oldResource.getReSpare(), truePath, request);
				resource.setReSpare(fileName);
			}
		}
		int judge = resourceService.updateResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectResource(1, resource.getReTypeid(), model);
	}
	
	@RequestMapping("downloadResource")
	@ResponseBody
	public void downloadResource(int reId) throws IOException {
		response.setCharacterEncoding("UTF-8");
		Resource resource = resourceService.selectById(reId);
		String realPath = "";
		if (resource.getReTypeid() == 5) {
			 realPath = "static/uploadImg/schoolopus";
			 resourceService.downloadResource(resource, realPath, response, request);
		} else if (resource.getReTypeid() == 6) {
			 realPath = "static/uploadImg/schoolresource";
			 resourceService.downloadResource(resource, realPath, response, request);
		}
//		if (realPath =="") {
//			response.getWriter().write("文件不存在");
//		} else {
//			//获得下载的文件名字
//			String fileName = resource.getReContent();
//			realPath = request.getSession().getServletContext().getRealPath(realPath);
//			File file = new File(realPath,fileName);
//			if(!file.exists()){
//				response.getWriter().write("文件不存在");
//				return;
//			}
//			response.addHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
//			IOUtils.copy(new FileInputStream(file),response.getOutputStream());
//		}
	}

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public void upload(MultipartFile myFileName) throws IOException {
		String realName = resourceService.uploadImage(myFileName, session);
		response.getWriter().write(request.getContextPath() + "/static/uploadImg/source/" + realName);
	}

	@RequestMapping("previewContent")
	public String previewContent(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		model.addAttribute("resource", resource);
		return "manager/previewcontent";
	}

	public String uploadOpus(MultipartFile file, String truePath) {
		String fileName = resourceService.uploadResource(file, truePath, request);
		return fileName;
	}

	public void setAddResource(Resource resource) {
		String typename = resource.getReTypename();
		Type type = typeService.getId(typename);
		resource.setReTypeid(type.getTyPid());
		User user = (User) session.getAttribute("manager");
		resource.setRePublisher(user.getUsName());
		resource.setReReleasedate(new Date());
	}
}
