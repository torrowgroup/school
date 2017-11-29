package com.futher.school.controller.tourist;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;

@RequestMapping("/general")
@Controller
public class GeneralController extends CommonController {
	/**
	 * @param tyId
	 * @param model
	 * @return 转到学校官网的学校概括信息界面
	 */
	@RequestMapping("/checkGeneral")
	public String checkGeneral(int tyId, Model model) {
		getLinkAndTime(model);
		Resource generalNews = resourceService.selectByTypeid(tyId);
		if (generalNews == null) {
			model.addAttribute("generalmesssage", "暂无数据");
		} else {
			model.addAttribute("generalNews", generalNews);
		}
		return "schoolpage/general";
	}
}
