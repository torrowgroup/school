package com.futher.school.controller.tourist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.futher.school.entity.Type;

@RequestMapping("schoolviews")
@Controller
public class SchoolViewsController extends CommonController{

	/**
	 * @param tyId
	 * @param model
	 * @return 转到显示学校风光的信息界面
	 */
	@RequestMapping("/checkSchoolViews")
	public String checkSchoolViews(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int tyId, Model model) {
		model.addAttribute("tyId", tyId);
		Type type = typeService.selectTypeById(tyId);
		model.addAttribute("type", type);
		model.addAttribute("messages", resourceService.findByTypeId(currentPage, tyId));// 回显分页数据
		getLinkAndTime(model);
		return "schoolpage/schoolviews";
	}
}
