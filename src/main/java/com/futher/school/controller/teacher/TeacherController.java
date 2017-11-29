package com.futher.school.controller.teacher;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;

import com.futher.school.entity.Resource;
import com.futher.school.entity.User;
import com.futher.school.util.PageBean;

@RequestMapping("/teacher")
@Controller()
public class TeacherController extends BaseController {
	// 文件上传
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request, Model model,Resource resource,
			@RequestParam(defaultValue = "1") int typeId ) throws IOException {
		String msg;
		if (file == null) {
			msg = "上传失败，上传文件为空";
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
			Date dateStr = new Date();
			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateStr);
			resource.setReTypeid(typeId);
			resource.setRePublisher(user.getUsName());
			resource.setReContent(fileName);
			resource.setReReleasedate(date);
			int boo = resourceService.uploadeEdit(resource);
			if (boo == 1) {
				msg="上传成功";
			} else {
			msg = "error , 未知错误";
			}

		}
		model.addAttribute("msg", msg);

		return "teacher/upload";
	}

	// 文件下载
	@RequestMapping("/download")
	public void down(@RequestParam(defaultValue = "1", required = true) int reId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Resource resource = resourceService.selectById(reId);
		String downFileName = resource.getReContent();
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
		bis.close();

	}

	// 获取所有上传所有资源详细
	@RequestMapping("/showUpload")
	public String showUpload(Model model, String uri, int reTypeid,
			@RequestParam(defaultValue = "1", required = false) int currentPage) {
		model.addAttribute("resourceList", resourceService.findByPage(currentPage, reTypeid));
		model.addAttribute("reTypeid", reTypeid);
		return "teacher" + "/" + uri;
	}

	// 获取单个Edit
	@RequestMapping("/showEditById")
	public String showEditById(Model model, int reId) {
		model.addAttribute("resource", resourceService.selectById(reId));
		return "teacher/previewedit";
	}

	@RequestMapping(value = "/uploadEdit", method = RequestMethod.POST)
	public String uploadEdit(Model model, @RequestParam(value = "reTypeid", required = true) int reTypeid,
			Resource resource, int typePid) {
		User user = (User) session.getAttribute("teacher");
		Date dateStr = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateStr);
		String msg = null;
		resource.setRePublisher(user.getUsEmail());
		resource.setReReleasedate(date);
		resource.setReTypepid(typePid);
		int re = resourceService.uploadeEdit(resource);
		if (re == 1) {
			msg = "提交成功,请继续操作";
		} else {
			msg = "网络错误，上传失败";
		}
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	// 留言处理
	@RequestMapping(value = "/leaveMessage")
	public String leaveMessage() {
		return null;

	}

	// 删除资源
	@RequestMapping(value = "/deleteResource")
	public String deleteResource(int reId, Model model, int reTypeid,
			@RequestParam(defaultValue = "1", required = false) int currentPage) {
		String msg;
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			msg = "对不起，你所删除的文件不存在";
		} else {
			int boo = resourceService.deletResource(reId);
			msg = "文件上传成功";
		}
		model.addAttribute("resourceList", resourceService.findByPage(currentPage, reTypeid));
		model.addAttribute("reTypeid", reTypeid);
		return "teacher/showupload";
	}

	@RequestMapping(value = "checkUser")
	public String checkUser(Model model) {
		User user = (User) session.getAttribute("teacher");
		model.addAttribute("user", user);
		return "teacher/checkuser";
	}
}
