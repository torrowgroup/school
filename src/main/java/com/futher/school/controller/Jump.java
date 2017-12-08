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

	String msg;

	// 上传教学反思
	@RequestMapping("/uploadIntrospection")
	public String uploadIntrospection(Model model) {
		msg = "请上传您的教学反思";
		model.addAttribute("reTypeid", 15);
		model.addAttribute("reTypepid", 3);
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传优秀教案
	@RequestMapping("/uploadRecord")
	public String uploadRecord(Model model) {
		msg = "请上传您的听课记录";
		model.addAttribute("reTypeid", 16);
		model.addAttribute("reTypepid", 3);
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传试卷
	@RequestMapping("/uploadPaper")
	public String uploadPaper(Model model) {
		msg = "请提交优秀试卷";
		model.addAttribute("reTypeid", 11);
		model.addAttribute("reTypepid", 3);
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传作业记录
	@RequestMapping("/uploadHomeWork")
	public String uploadHomeWork(Model model) {
		msg = "请提交您的作业记录";
		model.addAttribute("reTypeid", 12);
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传教案
	@RequestMapping("/uploadPlan")
	public String uploadPlan(Model model) {
		msg = "请上传您的教案";
		model.addAttribute("reTypeid", 13);
		model.addAttribute("reTypepid", 3);
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传基本功
	@RequestMapping("/uploadBasicSkill")
	public String uploadBasicSkill(Model model, int reTypepid) {
		msg = "请上传您的基本功";
		/* model.addAttribute("reTypeid", reTypepid); */
		model.addAttribute("reTypepid", reTypepid);
		model.addAttribute("msg", msg);
		return "teacher/upload";
	}

	// 上传教学成果
	@RequestMapping("/uploadaAchievements")
	public String uploadaAchievements(Model model) {
		msg = "请上传您的教学成果";
		model.addAttribute("reTypeid", 14);
		model.addAttribute("reTypepid", 4);
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	// 上传教学动态
	@RequestMapping("/uploadEducationNews")
	public String uploadEducationNews(Model model) {
		msg = "请上传您的教学动态";
		model.addAttribute("reTypeid", 15);
		model.addAttribute("reTypepid", 3);
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	// 上传文学作品
	@RequestMapping("/uploadLiterature")
	public String uploadLiterature(Model model) {
		msg = "请上传您的文学作品";
		model.addAttribute("reTypeid", 16);
		model.addAttribute("reTypepid", 5);
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	@RequestMapping(value = "/showTeacherResearch")
	public String showTeacherResourch(String resourceId, Model model) {
		model.addAttribute("resourceId", resourceId);
		return "redirect:/teacgerResearch/showTeacherResearch";
	}

	@RequestMapping(value = "/saveTeacherResearch")
	public String SaveTeacherResourch() {
		return "teachergroup/editteacherresearch";
	}

	@RequestMapping(value = "/uploadIntegral")
	public String uploadIntegral(Model model) {
		msg = "请提交您的量化积分";
		model.addAttribute("reTypeid", 1);
		model.addAttribute("reTypepid", 3);
		model.addAttribute("msg", msg);
		return "educationoffice/upload";
	}

	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "teacher/welcome";
	}

	@RequestMapping(value = "/uploadEdit")
	public String uploadEdit(Model model, int Typepid, int TypeId, String typeName) {
		model.addAttribute("reTypeid", TypeId);
		model.addAttribute("reTypepid", Typepid);
		model.addAttribute("typeName", typeName);
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	@RequestMapping(value = "/uploadFile")
	public String uploadFile(Model model, int Typepid, int TypeId, String typeName) {
		model.addAttribute("reTypeid", TypeId);
		model.addAttribute("reTypepid", Typepid);
		model.addAttribute("typeName", typeName);
		return "teacher/upload";
	}
}
