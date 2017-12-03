package com.futher.school.controller.educationoffice;

import java.awt.List;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.User;

/** 
* @ClassName: EducationOfficeController 
* @Description: TODO
* @author wqjhky@gmail.com
* @date 2017年11月10日 下午2:47:17 
*  
*/

@Controller
@RequestMapping(value="/educationoffice")

public class EducationOfficeController  extends BaseController{
	@RequestMapping(value="/uploadIntegral")
	public void uploadIntegral(@RequestParam int TypeId,MultipartFile  file,Model model,Resource resource) { 
		String msg=null;
		if(file==null) {
			msg="您上传的文件为空";
		}else {
		msg="上传成功";
		Date dateStr = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateStr);
		String path = request.getSession().getServletContext().getRealPath("uploading");
		String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('\\') + 1, file.getOriginalFilename().length());
		String  boo = resourceService.uploadResource(file, path, request);
		System.out.println("打印User"+(User)session.getAttribute("educationoffice"));
		resource.setRePublisher(((User) session.getAttribute("educationoffice")).getUsName());
		resource.setReReleasedate(date);
		resource.setReContent(fileName);
		int boo2 = resourceService.addResource((com.futher.school.entity.Resource) resource);
	/*	java.util.List<Resource> resourceList = resourceService.getUploadFileName();
		model.addAttribute("resource", resourceList);*/
		}
		model.addAttribute(msg); 
	}
	@RequestMapping(value = "/showIntegral")
	public String showTeacherResearch(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int reTypeid,
			String inquiry, Model model) {
		model.addAttribute("reTypeid", reTypeid);
		model.addAttribute("messages", resourceService.findByPage(currentPage, reTypeid, inquiry));// 回显分页数据
		System.out.println("messages"+resourceService.findByPage(currentPage, reTypeid, inquiry));
		return "educationoffice/showeducationoffice";
	}

}
