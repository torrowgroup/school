package com.futher.school.controller.teacherresearch;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.User;
import com.futher.school.util.PageBean;

/**
 * @ClassName: TeacherResearch
 * @Description: 教研组
 * @author wqjhky@gmail.com
 * @date 2017年11月6日 下午3:47:43
 * 
 */
@RequestMapping(value = "/teacherResearch")
@Controller
public class TeacherResearch extends BaseController {
	int resourceId;
	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	@RequestMapping(value = "/saveTeacherResearch")
	public String saveTeacherResearch( Model model,@RequestParam(value = "reTypeid",required=true)int reTypeid,Resource resource) {
		User user = (User) session.getAttribute("teachergroup");
		String meg = null;
		resource.setReTypeid(reTypeid);
		resource.setRePublisher(user.getUsEmail());
		resource.setReReleasedate(new Date());
		int boo = resourceService.addResource(resource);
		if(boo==1) {
			meg="上传成功";
		}else {
			meg="未知原因上传失败";
		}
		model.addAttribute("meg", meg);
		return "teachergroup/editteacherresearch";
	
	}

	@RequestMapping(value = "/showTeacherResearch")
	public String showTeacherResearch(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int reTypeid,
			Model model) {
		System.out.println(reTypeid+"从前台获取到的reTypeId");
		model.addAttribute("reTypeid", reTypeid);
		model.addAttribute("messages", resourceService.findByPage(currentPage, reTypeid));// 回显分页数据
		System.out.println("messages"+resourceService.findByPage(currentPage, reTypeid));
		return "teachergroup/showallresource";
	}
	@RequestMapping(value = "/showResearchById")
	public String showResearchById(@RequestParam(value="reId", required = false) Integer reId,Model model) {
		Resource resource  = resourceService.selectById(reId);
		model.addAttribute("resource", resource);
		return "teachergroup/showresourcebyid";
	}
}
