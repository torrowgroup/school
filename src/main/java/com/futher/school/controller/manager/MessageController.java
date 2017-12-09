package com.futher.school.controller.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Message;

@RequestMapping("/messages")
@Controller
public class MessageController extends BaseController {

	@RequestMapping("selectMessage")
	public String selectMessage(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int replace,
			String inquiry, Model model) throws UnsupportedEncodingException {
		String meStatus = "";
		if (replace == 0) {
			meStatus = "未回复";
		} else if (replace == 1) {
			meStatus = "已回复";
		}
		model.addAttribute("meStatus", meStatus);
		model.addAttribute("replace", replace);
		model.addAttribute("messages", messageService.findByPage(currentPage, meStatus, inquiry));// 回显分页数据
		return "manager/selectmessage";
	}

	@RequestMapping("toreplyMessage")
	public String toreplyMessage(int meId, Model model) {
		Message message = messageService.selectById(meId);
		if (message == null) {
			model.addAttribute("news", "该留言已删除");
		} else {
			model.addAttribute("message", message);
		}
		return "manager/replymessage";
	}

	@RequestMapping("replyMessage")
	public String replyMessage(int meId, String meReplycontent, Model model) throws UnsupportedEncodingException {
		Message message = messageService.selectById(meId);
		if (message == null) {
			model.addAttribute("news", "该留言已删除");
		} else {
			int judge = messageService.replyMessage(meId, meReplycontent, "已回复");
			if (judge == 1) {
				model.addAttribute("news", "回复成功");
			} else {
				model.addAttribute("news", "回复失败");
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectMessage(1, 0, inquiry, model);
	}

	@RequestMapping("toUpdateMessage")
	public String toUpdateMessage(int meId, Model model) {
		Message message = messageService.selectById(meId);
		if (message == null) {
			model.addAttribute("news", "该留言已删除");
		} else {
			model.addAttribute("message", message);
		}
		return "manager/updatemessage";
	}

	@RequestMapping("updateMessage")
	public String updateMessage(Message message, MultipartFile file, Model model) throws UnsupportedEncodingException {
		Message replymessage = messageService.selectById(message.getMeId());
		int replace = 0;
		if (replymessage == null) {
			model.addAttribute("news", "该留言已被删除");
		} else {
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			message.setMeReleasedate(dateString);
			if (message.getMeReplycontent().equals("<p><br></p>")) {
				message.setMeStatus("未回复");
			} else {
				message.setMeStatus("已回复");
			}
			int judge = messageService.updateMessage(message);
			if (judge == 1) {
				model.addAttribute("news", "修改成功");
			} else {
				model.addAttribute("news", "修改失败");
			}
			String meStatus = replymessage.getMeStatus();
			if (meStatus.equals("未回复")) {
				replace = 0;
			} else if (meStatus.equals("已回复")) {
				replace = 1;
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectMessage(1, replace, inquiry, model);
	}

	@RequestMapping("deletMessage")
	public String deletMessage(int meId, Model model) throws UnsupportedEncodingException {
		Message message = messageService.selectById(meId);
		int replace = 0;
		if (message == null) {
			model.addAttribute("news", "该留言已删除");
		} else {
			int judge = messageService.deletMessage(meId);
			if (judge == 1) {
				model.addAttribute("news", "删除成功");
			} else {
				model.addAttribute("news", "删除失败");
			}
			String meStatus = message.getMeStatus();
			if (meStatus.equals("未回复")) {
				replace = 0;
			} else if (meStatus.equals("已回复")) {
				replace = 1;
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectMessage(1, replace, inquiry, model);
	}

	@RequestMapping("previewMessage")
	public String previewMessage(int meId, Model model) {
		Message message = messageService.selectById(meId);
		model.addAttribute("message", message);
		return "manager/previewmessage";
	}

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public void upload(MultipartFile myFileName) throws IOException {
		String realName = userService.uploadimage(myFileName, session);
		response.getWriter().write(request.getContextPath() + "/static/uploadImg/source/" + realName);
	}

//	public String uploadMessageFile(MultipartFile file, String truePath) {
//		String fileName = messageService.uploadResource(file, truePath, request);
//		return fileName;
//	}
}
