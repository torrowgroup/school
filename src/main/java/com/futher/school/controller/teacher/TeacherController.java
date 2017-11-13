package com.futher.school.controller.teacher;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
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
	
	String uri;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	
	// 文件上传
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request, Model model) throws IOException {
		String msg;
		if (file == null) {
			msg = "上传失败，上传文件为";
		} else {
			User user = (User) session.getAttribute("teacher");
			String path = request.getSession().getServletContext().getRealPath("uploading");
			String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('\\') + 1,
					file.getOriginalFilename().length());

			File dir = new File(path, fileName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// MultipartFile自带的解析方法
			file.transferTo(dir);
			msg = "文件上传成功";
			Resource resource = new Resource();
			Date date = new Date();
			resource.setRePublisher(user.getUsName());
			resource.setReTypename(fileName);
			resource.setReReleasedate(date);
			int boo = resourceService.uploadeEdit(resource);
			if (boo == 1) {
				System.out.println("上传成功");
			} else {
				System.out.println("error , 未知错误");
			}
		}
		model.addAttribute("msg", msg);

		return "teacher/upload";
	}

	/*
	 * @RequestMapping(value = "/uploadEdit", method = RequestMethod.POST) public
	 * String uploadEdit(Model model, HttpServletRequest request) {
	 * System.out.println("asdrganjkasb;helgaslbghjkasbd;lasndfjkbnjlk"); String
	 * edit = (String)
	 * request.getSession().getServletContext().getAttribute("edit");
	 * System.out.println("agfuiweakuilfjbiwasujebhyu"); System.out.println(edit);
	 * return null; }
	 */
	@SuppressWarnings("deprecation")
	// 文件下载
	@RequestMapping("/download")
	public void down(@RequestParam(defaultValue="1",required=true) int reId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Resource resource = resourceService.selectById(reId);
		String downFileName = resource.getReTypename();
		String fileName = request.getSession().getServletContext().getRealPath("uploading") + "/" + downFileName;
		// 获取输入流d
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
		// 转码，免得文件名中文乱码
		String filename = URLEncoder.encode(downFileName, "UTF-8");
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

	// 获取所有上传所有资源详细
	@RequestMapping("/showUpload")
	public String showUpload(Model model, String uri) {
		List<Resource> resourceList = resourceService.getUploadFileName();
		model.addAttribute("resourceList", resourceList);
		System.out.println(resourceList);
		System.out.println("获取到的uri" + uri);
		return "teacher" + "/" + uri;
	}

	@RequestMapping(value = "/uploadEdit", method = RequestMethod.POST)
	public String  uploadEdit(Resource resource,Model model) {
		User user = (User) session.getAttribute("teacher");
		String msg = null;
		resource.setRePublisher(user.getUsEmail());
		resource.setReReleasedate(new Date());
		int re = resourceService.uploadeEdit(resource);
		if (re == 1) {
			msg = "提交成功";
		} else {
			msg = "未知原因，上传失败";
		}
		model.addAttribute("msg");
		return "teacher/edit";
	}

	// 留言处理
	@RequestMapping(value = "/leaveMessage")
	public String leaveMessage() {
		return null;

	}
}
