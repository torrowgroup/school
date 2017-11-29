package com.futher.school.controller.tourist;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
@RequestMapping("/download")
@Controller
public class DownloadController extends CommonController{
	/**\
	 * @param currentPage
	 * @param tyId
	 * @param model
	 * @return 转发到资源下载界面
	 */
	@RequestMapping("/checkDownload")
	public String checkDownload (@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int tyId, Model model) {
		getLinkAndTime(model);
		model.addAttribute("messages", resourceService.findByTypeId(currentPage, tyId));// 回显分页数据
		return "schoolpage/download";
	}
	/**
	 * @param reId
	 * @throws IOException
	 * 下载资源下载的文件
	 */
	@RequestMapping("/downloadResouece")
	@ResponseBody
	public void downloadResouece(int reId) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			response.getWriter().write("文件不存在");
		} else {
			String realPath = "static/uploadImg/schoolresource";
				resourceService.downloadResource(resource, realPath, response, request);
		}
	}
	/**
	 * @param model
	 * 得到链接和中招时间，用于游客页面
	 */
//	public void getLinkAndTime(Model model){
//		typeService.getType(model);
//		List<Type> typeList = typeService.getAllTypes();
//		resourceService.getLinkAndTime(typeList, model);
//	}
	
}
