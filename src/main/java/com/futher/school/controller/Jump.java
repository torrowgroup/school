package com.futher.school.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jca.context.ResourceAdapterApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.User;

@RequestMapping("/jump")
@Controller()
public class Jump extends BaseController {
	private Resource resource;

	public Resource getResource() {
		return resource;
	}

	String msg;

	// 上传书法作品
	@RequestMapping("/uploadCalligraphy")
	public String uploadCalligraphy(Model model) {
		msg = "请上传您的书法作品";
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传优秀教案
	@RequestMapping("/uploadGrammar")

	public String uploadGrammar(Model model) {
		msg = "请上传您的教案";
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传优秀试卷
	@RequestMapping("/uploadExamination")
	public String uploadExamination(Model model) {
		msg = "请上传优秀试卷";
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传优秀课件
	@RequestMapping("/uploadCourseware")
	public String uploadCourseware(Model model) {
		msg = "请上传您的优秀课件";
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 提交教研活动
	@RequestMapping("/uploadaAchievements")
	public String uploadaAchievements(Model model) {
		msg = "请提交您的教研活动";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	@RequestMapping("/uploadActivationRecord")
	public String uploadActivationRecord(Model model) {
		msg = "请提交您的活动记录";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	@RequestMapping("/uploadEducationNews")
	public String uploadEducationNews(Model model) {
		msg = "请更新您的教育动态";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	@RequestMapping("/uploadLiterature")
	public String uploadLiterature(Model model) {
		msg = "请上传您的文学作品";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	/*@RequestMapping(value = "/uploadEdit", method = RequestMethod.POST)
	public void uploadEdit(Model model, HttpServletRequest request, Resource resource) {
		System.out.println(resource + "获取到的resource");
		User user = (User) session.getAttribute("teacher");

		Date date  = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);

		String msg = null;
		resource.setReTitle(request.getParameter("resource.reTitle"));
		resource.setReTypename(request.getParameter("resource.reTypeName"));
		resource.setReContent((String) request.getParameter("resource.reContent"));
<<<<<<< HEAD:src/main/java/com/futher/school/controller/Jump.java
		resource.setRePublisher(user.getUsEmail());
		resource.setReReleasedate(date);
=======
		resource.setRePublisher(user.getUsEmail()); 
		resource.setReReleasedate(dateString);
>>>>>>> 81c741df4ad48eaae3a6d332d6c1a8e0badc9e0e:src/main/java/com/futher/school/controller/teacher/Jump.java
		int re = resourceService.uploadeEdit(resource);
		System.out.println(resource);
		if (re == 1) {
			msg = "提交成功";
		} else {
			msg = "未知原因，上传失败";
		}
		model.addAttribute("msg");
	}
*/
	@RequestMapping(value = "/showTeacherResearch")
	public String showTeacherResourch(String resourceId,Model model) {
		model.addAttribute("resourceId", resourceId);
		 return "redirect:/teacgerResearch/showTeacherResearch"; 
	}
	@RequestMapping(value="/saveTeacherResearch")
	public String SaveTeacherResourch() {
		return "teachergroup/editteacherresearch";
	}
	@RequestMapping(value="/uploadIntegral")
	public String uploadIntegral() {
		return "educationoffice/upload";
	}
}
