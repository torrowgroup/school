package com.futher.school.controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Type;

import net.sf.json.JSONArray;

@RequestMapping("/type")
@Controller()
public class TypeController extends BaseController {
	@RequestMapping("/toAddType")
	public String toAddType() {

		return "/manager/addtype";
	}

	@RequestMapping("/verifyTypeName")
	@ResponseBody
	public void verifyTypeName(String tyCategoryname) throws IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "true";
		List<Type> typelist = typeService.getAllTypes();
		for (int i = 0; i < typelist.size(); i++) {
			if (tyCategoryname.equals(typelist.get(i).getTyCategoryname())) {
				result = "false";
			}
		}
		out.print(result);
		out.close();
	}

	@RequestMapping("/addType")
	public String addType(Type type, Model model) {
		if (type.getTyPid() == 7 || type.getTyPid() == 9 || type.getTyPid() == 12|| type.getTyPid() == 13) {
			int count = typeService.selectTypeName(type.getTyPid()).size();
			if (count >= 1) {
				model.addAttribute("news", "已添加过了，不可在添加");
			} else {
				int judge = typeService.addType(type);
				if (judge == 1) {
					model.addAttribute("news", "添加成功");
				} else {
					model.addAttribute("news", "添加失败");
				}
			}
		} else {
			int judge = typeService.addType(type);
			if (judge == 1) {
				model.addAttribute("news", "添加成功");
			} else {
				model.addAttribute("news", "添加失败");
			}
		}
		return "manager/addtype";
	}

	@RequestMapping("/selectType")
	public String selectType(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			String inquiry,	Model model) {
		model.addAttribute("inquiry", inquiry);
		session.setAttribute("inquiry", inquiry);
		model.addAttribute("messages", typeService.findByPage(currentPage, inquiry));// 回显分页数据
		return "manager/selecttype";
	}

	@RequestMapping("/deletType")
	public String deletType(int tyId, Model model) {
		Type type = typeService.selectTypeById(tyId);
		if (type == null) {
			model.addAttribute("news", "该数据已删除");
		} else {
			int judge = typeService.deletType(tyId);
			if (judge == 1) {
				model.addAttribute("news", "删除成功");
			} else {
				model.addAttribute("news", "删除失败");
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectType(1, inquiry, model);
	}

	@RequestMapping("/toUpdateType")
	public String toUpdateType(int tyId, Model model) {
		Type type = typeService.selectTypeById(tyId);
		if (type == null) {
			model.addAttribute("news", "该类型已删除");
		}
		model.addAttribute("typenews", type);
		return "manager/updatetype";
	}

	@RequestMapping("/updateType")
	public String updateType(Type type, Model model) {
		int judge = 0;
		Type oldType = typeService.selectTypeById(type.getTyId());
		if (oldType == null) {
			model.addAttribute("news", "该修改类型已删除");
		} else {
			if (oldType.getTyCategoryname().equals(type.getTyCategoryname()) && oldType.getTyPid() == type.getTyPid()) {
				judge = typeService.updateType(type);
			} else {
				Type otherType = typeService.getId(type.getTyCategoryname());
				if (otherType == null) {
					judge = typeService.updateType(type);
				}
			} 
			if (judge == 1) {
				model.addAttribute("news", "修改成功");
			} else {
				model.addAttribute("news", "修改失败,已有此类型");
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectType(1, inquiry, model);
	}

	@RequestMapping("/verifyType")
	@ResponseBody
	public void verifyType(int tyId, String tyCategoryname) throws IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "true";
		Type type = typeService.selectTypeById(tyId);
		if (!(type == null)) {
			if (tyCategoryname.equals(type.getTyCategoryname())) {
				result = "true";
			} else {
				List<Type> typelist = typeService.getAllTypes();
				for (int i = 0; i < typelist.size(); i++) {
					if (tyCategoryname.equals(typelist.get(i).getTyCategoryname())) {
						result = "false";
					}
				}
			}
		} else {
			result = "false";
		}
		out.print(result);
		out.close();
	}
}
