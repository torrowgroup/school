package com.futher.school.controller.teacher;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.futher.school.base.BaseController;
import com.futher.school.dao.ResourceMapper;
import com.futher.school.entity.Resource;
import com.futher.school.entity.User;

@RequestMapping("/teacher")
@Controller()
public class TeacherController extends BaseController {
	//文件上传
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request, Model model) throws IOException {
		User user = (User) session.getAttribute("teacher");
		String path = request.getSession().getServletContext().getRealPath("uploading");
		String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('\\') + 1, file.getOriginalFilename().length());
		String msg;
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// MultipartFile自带的解析方法
		file.transferTo(dir);
		msg = "文件上传成功";
		Resource resource  = new Resource();
		Date date = new Date();
		resource.setRePublisher(user.getUsName());
		resource.setReTypename(fileName);
		resource.setReReleasedate(date);
		int boo = resourceService.uploadeEdit(resource);
		if(boo == 1) {
			System.out.println("上传成功");
		}else {
			System.out.println("error , 未知错误");
		}
		model.addAttribute("msg", msg);
		
		return "teacher/upload";
	}

	@RequestMapping(value = "/uploadEdit", method = RequestMethod.POST)
	public String uploadEdit(Model model, HttpServletRequest request) {
		System.out.println("asdrganjkasb;helgaslbghjkasbd;lasndfjkbnjlk");
		String edit = (String) request.getSession().getServletContext().getAttribute("edit");
		System.out.println("agfuiweakuilfjbiwasujebhyu");
		System.out.println(edit);
		return null;
	}
	//文件下载
	@RequestMapping("/down")
	public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = request.getSession().getServletContext().getRealPath("uploading")+"/1.txt";
		// 获取输入流
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
		// 假如以中文名下载的话
		String filename = "下载文件.txt";
		// 转码，免得文件名中文乱码
		filename = URLEncoder.encode(filename, "UTF-8");
		// 设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while ((len = bis.read()) != -1) {
			out.write(len);
			out.flush();
		}
		out.close();
	}
	//获取所有上传所有资源详细
	@RequestMapping("/showUpload")
	public String  showUpload(Model model) {
		List<Resource> resourceList  = resourceService.getUploadFileName();
		System.out.println(resourceList);
		model.addAttribute("resource", resourceList);
		return "teacher/showupload";
	}
}
