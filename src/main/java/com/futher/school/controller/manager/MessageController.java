package com.futher.school.controller.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Message;

@RequestMapping("/message")
@Controller
public class MessageController extends BaseController{
	@RequestMapping("toAddMessage")
	public String toAddMessage() {
		return "manager/addmessage";
	}
	
	@RequestMapping("addMessage")
	public String addMessage(Message message, MultipartFile file, Model model) {
		message.setMeReleasedate(new Date());
		message.setMeStatus("未回复");
		if (!file.isEmpty()) {
			String truePath = "static/uploadImg/messagefile";
			String fileName = uploadMessageFile(file, truePath);
			message.setMeImage(fileName);
		}
		int judge = messageService.addMessage(message);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		}else {
			model.addAttribute("news", "添加失败");
		}
		return toAddMessage();
	}
	
	@RequestMapping("selectMessage")
	public String selectMessage(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,String meStatus, Model model) throws UnsupportedEncodingException{
		model.addAttribute("meStatus", meStatus);
		model.addAttribute("messages", messageService.findByPage(currentPage, meStatus));// 回显分页数据
		return "manager/selectmessage";
	}
	
	@RequestMapping("toreplyMessage")
	public String toreplyMessage(int meId, Model model) {
		Message message = messageService.selectById(meId);
		model.addAttribute("message", message);
		return "manager/replymessage";
	}
	
	@RequestMapping("replyMessage")
	public String replyMessage(int meId, String meReplycontent, Model model) throws UnsupportedEncodingException{
		int judge = messageService.replyMessage(meId, meReplycontent,"已回复");
		if (judge == 1) {
			model.addAttribute("news", "回复成功");
		}else {
			model.addAttribute("news", "回复失败");
		}
		String meStatus = "未回复";
		return selectMessage(1, meStatus, model);
	}
	
	@RequestMapping("toUpdateMessage")
	public String toUpdateMessage(int meId, Model model) {
		Message message = messageService.selectById(meId);
		model.addAttribute("message", message);
		return "manager/updatemessage";
	}
	@RequestMapping("updateMessage")
	public String updateMessage(Message message, MultipartFile file, Model model) throws UnsupportedEncodingException{
		Message replymessage = messageService.selectById(message.getMeId());
		if (!file.isEmpty()) {
			String truePath = "static/uploadImg/messagefile";
			String fileName = uploadMessageFile(file, truePath);
			message.setMeImage(fileName);
		}else {
			System.out.println(message+"95656+55+62+952659669+626826563986526568596268596");
			message.setMeImage(replymessage.getMeImage());
		}
		int judge = messageService.updateMessage(message);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		String meStatus = replymessage.getMeStatus();
		 meStatus = new String(meStatus.getBytes("utf-8"),"iso-8859-1");
		return selectMessage(1, meStatus, model);
	}
	@RequestMapping("deletMessage")
	public String deletMessage(int meId, Model model) throws UnsupportedEncodingException {
		Message message = messageService.selectById(meId);
		int judge = messageService.deletMessage(meId);
		if (judge == 1) {
			model.addAttribute("news", "删除成功");
		}else {
			model.addAttribute("news", "删除失败");
		}
		return selectMessage(1, message.getMeStatus(), model);
	}
	
	@RequestMapping("previewMessage")
	public String previewMessage(int meId, Model model){
		Message message = messageService.selectById(meId);
		model.addAttribute("message", message);
		return "manager/previewmessage";
	}
	
	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public void upload(MultipartFile myFileName) throws IOException {
		String realName = userService.uploadimage(myFileName,session);
		response.getWriter().write(request.getContextPath() + "/static/uploadImg/source/" + realName);
	}
	
	public String uploadMessageFile(MultipartFile file, String truePath) {
		String fileName = messageService.uploadResource(file, truePath, request);
		return fileName;
	}
}
