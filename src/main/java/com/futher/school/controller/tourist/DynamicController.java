package com.futher.school.controller.tourist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
@RequestMapping("dynamic")
@Controller
public class DynamicController extends CommonController{
	/**
	 * @param tyId
	 * @param model
	 * @return 转到学校官网的学校动态的信息界面
	 */
	@RequestMapping("/checkDynamic")
	public String checkDynamic(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int tyId, Model model) {
		model.addAttribute("tyId", tyId);
		model.addAttribute("messages", resourceService.findByTypeId(currentPage, tyId));// 回显分页数据
		getLinkAndTime(model);
		return "schoolpage/dynamic";
	}
	
	@RequestMapping("readDynamic")
	public String readDynamic(int reId, Model model) {
		typeService.getType(model);
		getLinkAndTime(model);
		Resource dynamicDetails = resourceService.selectById(reId);
		model.addAttribute("dynamicDetails", dynamicDetails);
		return "schoolpage/dynamicnews";
	}
}
