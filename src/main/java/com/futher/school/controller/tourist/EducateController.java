package com.futher.school.controller.tourist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
@RequestMapping("educate")
@Controller
public class EducateController extends CommonController{
	/**
	 * @param tyId
	 * @param model
	 * @return 转到学校官网的学校教育教研的信息界面 
	 */
	@RequestMapping("/checkEducate")
	public String checkEducate (@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int tyId, Model model) {
		getLinkAndTime(model);
		model.addAttribute("messages", resourceService.findByTypeId(currentPage, tyId));// 回显分页数据
		return "schoolpage/educate";
	}
	/**
	 * @param reId
	 * @param model
	 * @return 下载学生或教师作品
	 */
	@RequestMapping("readEducate")
	public String readEducate(int reId, Model model) {
		typeService.getType(model);
		getLinkAndTime(model);
		Resource educateDetails = resourceService.selectById(reId);
		model.addAttribute("educateDetails", educateDetails);
		return "schoolpage/educatenews";
	}
}
