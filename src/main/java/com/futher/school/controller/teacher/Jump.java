package com.futher.school.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;

@RequestMapping("/jump")
@Controller()
public class Jump extends BaseController {
	String msg;
	// 上传书法作品
	@RequestMapping("/uploadCalligraphy")
	public String uploadCalligraphy(Model model) {
		msg="请上传您的书法作品";
		model.addAttribute("msg", msg);
		return "teacher/upload"; 
	}
	// 上传优秀教案
	@RequestMapping("/uploadGrammar")

	public String uploadGrammar(Model model) {
		msg="请上传您的教案";
		model.addAttribute("msg", msg);
		return "teacher/upload"; 
	}

	// 上传优秀试卷
	@RequestMapping("/uploadExamination")
	public String uploadExamination(Model model) {
		msg="请上传优秀试卷";
		model.addAttribute("msg", msg);
		return "teacher/upload"; 
	}
	// 上传优秀课件
	@RequestMapping("/uploadCourseware")
	public String uploadCourseware(Model model) {
		msg="请上传您的优秀课件";
		model.addAttribute("msg", msg);
		return "teacher/upload"; 
	}
	// 提交教研活动
	@RequestMapping("/uploadaAchievements")
	public String uploadaAchievements(Model model) {
		msg="请提交您的教研活动";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}
	@RequestMapping("/uploadActivationRecord")
	public String uploadActivationRecord(Model model) {
		msg="请提交您的活动记录";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}
	@RequestMapping("/uploadEducationNews")
	public String uploadEducationNews(Model model) {
		msg="请更新您的教育动态";
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}
}