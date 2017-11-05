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

@RequestMapping("/type")
@Controller()
public class TypeController extends BaseController{
	@RequestMapping("/toAddType")
	public String toAddType(){
		
		return "/manager/addtype";
	}
	@RequestMapping("/verifyTypeName")
	@ResponseBody
	public void verifyTypeName(String tyCategoryname) throws IOException{
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
	public String addType(Type type,Model model){
		int judge = typeService.addType(type);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return "manager/addtype";
	}
	@RequestMapping("/selectType")
	public String selectType(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			Model model){
		model.addAttribute("messages", typeService.findByPage(currentPage));// 回显分页数据
		return "manager/selecttype";
	}
	@RequestMapping("/deletType")
	public String deletType(int tyId,Model model){
		int judge = typeService.deletType(tyId);
		if (judge == 1) {
			model.addAttribute("news", "删除成功");
		} else {
			model.addAttribute("news", "删除失败");
		}
		return selectType(1,model);
	}
	@RequestMapping("/toUpdateType")
	public String toUpdateType(int tyId,Model model){
		Type type = typeService.selectTypeById(tyId);
		model.addAttribute("typenews", type);
		return "manager/updatetype";
		
	}
	@RequestMapping("/updateType")
	public String updateType(Type type,Model model){
		int judge = typeService.updateType(type);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectType(1,model);
	}
	@RequestMapping("/verifyType")
	@ResponseBody
	public void verifyType(int tyId,String tyCategoryname) throws IOException{
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "true";
		Type type = typeService.selectTypeById(tyId);
		if (tyCategoryname.equals(type.getTyCategoryname())){
			result = "true";
		} else {
			List<Type> typelist = typeService.getAllTypes();
			for (int i = 0; i < typelist.size(); i++) {
				if (tyCategoryname.equals(typelist.get(i).getTyCategoryname())) {
					result = "false";
				}
			}
		}
		out.print(result);
		out.close();
	}
}
