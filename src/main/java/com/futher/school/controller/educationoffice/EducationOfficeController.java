package com.futher.school.controller.educationoffice;

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
@RequestMapping(value = "/educationoffice")
public class EducationOfficeController extends BaseController {
	@RequestMapping(value = "/uploadIntegral")

	public String uploadIntegral(MultipartFile file, HttpServletRequest request, Model model, Resource resource,
			@RequestParam(defaultValue = "1") int typeId) throws IOException {
		String msg;
		if (file == null) {
			msg = "上传失败，上传文件为空";
		} else {
			User user = (User) session.getAttribute("educationoffice");
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
				msg = "上传成功";
			} else {
				msg = "error , 未知错误";
			}

		}
		model.addAttribute("msg", msg);
		return "educationoffice/upload";
	}

	@RequestMapping(value = "/showIntegral")
	public String showTeacherResearch(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int reTypeid,
			String inquiry, Model model) {
		model.addAttribute("reTypeid", reTypeid);
		model.addAttribute("resourceList", resourceService.findByPage(currentPage, reTypeid, inquiry));// 回显分页数据
		return "educationoffice/showeducationoffice";
	}
	// 删除资源
	@RequestMapping(value = "/deleteResource")
	public String deleteResource(int reId, Model model, int reTypeid,
			@RequestParam(defaultValue = "1", required = false) int currentPage,String inquiry) {
		String msg;
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			msg = "对不起，你所删除的文件不存在";
		} else {
			int boo = resourceService.deletResource(reId);
			msg = "文件上传成功";
		}
		model.addAttribute("resourceList", resourceService.findByPage(currentPage, reTypeid,inquiry));
		model.addAttribute("reTypeid", reTypeid);
		return "teacher/showupload";
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

}
