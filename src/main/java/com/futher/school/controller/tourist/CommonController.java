package com.futher.school.controller.tourist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Message;
import com.futher.school.entity.Type;
@RequestMapping("/common")
@Controller
public class CommonController extends BaseController{
	/**
	 * @param model
	 * 得到链接和中招时间，用于游客页面
	 */
	public void getLinkAndTime(Model model){
		typeService.getType(model);
		List<Type> typeList = typeService.getAllTypes();
		resourceService.getLinkAndTime(typeList, model);
	}
	/**
	 * @return 转发到留言界面
	 */
	@RequestMapping("toAddMessage")
	public String toAddMessage() {
		return "manager/addmessage";
	}
	/**
	 * @param message
	 * @param file
	 * @param model
	 * @return 添加留言
	 */
	@RequestMapping("addMessage")
	public String addMessage(Message message, Model model) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		message.setMeReleasedate(dateString);
		message.setMeStatus("未回复");
		int judge = messageService.addMessage(message);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toAddMessage();
	}
	/**
	 * @param file
	 * @param truePath
	 * @return 富文本上传图片
	 */
	public String uploadMessageFile(MultipartFile file, String truePath) {
		String fileName = messageService.uploadResource(file, truePath, request);
		return fileName;
	}
}
