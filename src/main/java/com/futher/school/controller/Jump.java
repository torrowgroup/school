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
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "teacher/welcome";
	}

	@RequestMapping(value = "/uploadEdit")
	public String uploadEdit(Model model, int Typepid, int TypeId, String typeName) {
		msg = "请提交您的"+typeService.selectTypeById(TypeId).getTyCategoryname();
		model.addAttribute("reTypeid", TypeId);
		model.addAttribute("typeName", typeService.selectTypeById(TypeId).getTyCategoryname());
		model.addAttribute("reTypepid", Typepid);
		model.addAttribute("msg", msg);
		return "teacher/edit";
	}

	@RequestMapping(value = "/uploadFile")
	public String uploadFile(Model model, int Typepid, int TypeId, String typeName) {
		msg = "请上传您的"+typeService.selectTypeById(TypeId).getTyCategoryname();
		model.addAttribute("reTypeid", TypeId);
		model.addAttribute("reTypepid", Typepid);
		model.addAttribute("typeName", typeService.selectTypeById(TypeId).getTyCategoryname());
		return "teacher/upload";
	}
}
