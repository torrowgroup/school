package com.futher.school.controller.tourist;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String toAddMessage(Model model) {
		getLinkAndTime(model);
		return "schoolpage/addmessage";
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
		return toAddMessage(model);
	}
	/**
	 * @param currentPage
	 * @param inquiry
	 * @param model
	 * @return 在学校官方页显示已回复的留言
	 */
	@RequestMapping("selectMessage")
	public String selectMessage(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,String inquiry, Model model) {
		getLinkAndTime(model);
		String meStatus = "已回复";
		inquiry = null;
		model.addAttribute("meStatus", meStatus);
		model.addAttribute("messages", messageService.findByPage(currentPage, meStatus, inquiry));// 回显分页数据
		return "schoolpage/message";
	}
	@RequestMapping("readMessage")
	public String readMessage(int meId, Model model) {
		getLinkAndTime(model);
		Message message = messageService.selectById(meId);
		model.addAttribute("message", message);
		return "schoolpage/messagenews";
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
