package com.futher.school.controller.tourist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
@RequestMapping("/literature")
@Controller
public class LiteratureController extends CommonController{
	/**
	 * @param tyId
	 * @param model
	 * @return 转到学校管网的学校动态的信息界面
	 */
	@RequestMapping("/checkLiterature")
	public String checkLiterature(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int tyId, Model model) {
		getLinkAndTime(model);
		model.addAttribute("messages", resourceService.findByTypeId(currentPage, tyId));// 回显分页数据
		return "schoolpage/literature";
	}
	@RequestMapping("downloadLiterature")
	@ResponseBody
	public void downloadLiterature(int reId) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			PrintWriter out = response.getWriter();
			out.print("文件不存在");
//			response.getWriter().write("文件不存在");
		} else {
			String realPath = "static/uploadImg/schoolopus";
			resourceService.downloadResource(resource, realPath, response, request);	
		}
	}
}
