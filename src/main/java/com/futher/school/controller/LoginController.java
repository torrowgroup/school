package com.futher.school.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.User;
import com.futher.school.util.Email;
import com.google.code.kaptcha.Constants;

@Controller()
public class LoginController extends BaseController {

//	@RequestMapping("/index")
//	public void loginTest(String usEmail) throws IOException{
//			response.setContentType("html/text");
//		   PrintWriter pw=response.getWriter();
//		User user = userService.loginTest(usEmail);
//		if (user != null) {
//			String identityname = user.getUsIdentityname();
//			 if (identityname.equals("officialemail")) {
//				 pw.print(false);
//				} else {
//					pw.print(true);
//				}
//		} else {
//			pw.print(false);
//		}
//		pw.close();
//	}
	@RequestMapping("/verifyAccount")
	@ResponseBody
	public void verifyAccount(String usEmail) throws IOException{
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		String result = "";
		User user = userService.loginTest(usEmail);
		if (user != null) {
			String identityname = user.getUsIdentityname();
			 if (identityname.equals("officialemail")) {
				 result = "false";
				 out.print(result);
				} else {
					result = "true";
					out.print(result);
				}
		} else {
			 result = "false";
			 out.print(result);
		}
		out.close();
	}
	@RequestMapping("/login")
	public String login(String usEmail, String usPassword,String identityCode, Model model) {
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String pathurl = "index";
		/*if(identityCode == null&& identityCode.equals("")){
			model.addAttribute("news", "验证码错误,请重新输入");
		} else {
			if (identityCode.equals(code)) {*/
				User user = userService.login(usEmail, usPassword);
				if (user != null) {
					String identityname = user.getUsIdentityname();
					if (identityname.equals("manager")) {
						session.setAttribute("manager", user);
						model.addAttribute("noStatus", "未回复");
						model.addAttribute("yesStatus", "已回复");
						pathurl = "/manager/homepage";
					} else if (identityname.equals("officialemail")) {
						model.addAttribute("news", "此用户不用作登录");
					}
					 
					 else if (identityname.equals("teacher")) {
						session.setAttribute("teacher", user);
						pathurl = "teacher/index";
					 }else if (identityname.equals("teachergroup")) {
							session.setAttribute("teachergroup", user);
							pathurl = "teachergroup/index";
				
					} else if (identityname.equals("educationoffice")){
					session.setAttribute("educationoffice", user);
					pathurl = "educationoffice/index";
					} else {
					model.addAttribute("news", "用户名或密码错误,请重新输入");
				}
				}
//		/*if (identityCode.equals(code)) {*/
//			User user = userService.login(usEmail, usPassword);
//			if (user != null) {
//				String identityname = user.getUsIdentityname();
//				if (identityname.equals("manager")) {
//					session.setAttribute("manager", user);
//					pathurl = "/WEB-INF/index";
//				} else if (identityname.equals("officialemail")) {
//					model.addAttribute("news", "此用户不用作登录");
//				}else if (identityname.equals("teacher")) {
//			
////				} else if (identityname.equals("teachergroup")) {
////					session.setAttribute("teachergroup", user);
////					pathurl = "/WEB-INF/";
////				} else if (identityname.equals("educationoffice")){
////					session.setAttribute("educationoffice", user);
////					pathurl = "/WEB-INF/";
////				}
			/*} else {
				model.addAttribute("news", "验证码错误,请重新输入");
			}*/
		
		return pathurl;
	}

	@RequestMapping("/forget")
	public String forget(){
		return "forgotpassword";
	}
//	@RequestMapping("/forgetPassword")
//		/*}*/
//		
//		return pathurl;
//	}
	
	@RequestMapping("forgetPassword")
	public String forgetPassword(String usEmail, Model model){
		System.err.println(usEmail+"============================================");
		String pathurl = "forgotpassword";
		User user = userService.getPassword(usEmail);
		if(user != null){
			String identityname = "officialemail";
			User useremail = userService.getEmail(identityname);
			if (useremail != null) {
				session.setAttribute("user", user);
				String code = "";
				for(int i=0;i<6;i++){
					int c = (int)(Math.random()*9);
					code +=c;
				}
				String officialemail = useremail.getUsEmail();
				String password = useremail.getUsPassword();
				String host = useremail.getUsName();
				String email = user.getUsEmail();
				String mailcontent = "尊敬的用户"+email+"您好，您的验证码是"+code+"请勿转发";
				try {
					Email.sendMail(officialemail,password,host,"验证码", email, "找回密码", mailcontent);
				} catch (Exception e) {
					model.addAttribute("news", "你输入的邮箱不存在");
//					e.printStackTrace();
				} 
//				try {
//					Email.subject("找回密码")
//					.from("职称评审系统")
//					.to(userName)
//					.text(userName+"您好，欢迎您使用职称评审系统，您的验证码是"+code)
//					.send();
//				} catch (MessagingException e) {
//					request.put("message", "发送失败，邮箱不存在");
//				}
				session.setAttribute("code",code);
				model.addAttribute("time", 0);
				pathurl = "comparecode";
			} else {
				model.addAttribute("news", "没有添加官方邮箱");
			}
			
		} else {
			model.addAttribute("news", "你输入的邮箱有误");
		}
		return pathurl;
	}
	@RequestMapping("compareCode")
	public String compareCode(String code,int times, Model model){
		String pathurl = "comparecode";
		String codeUser = (String)session.getAttribute("code");
		if(codeUser.equals(code)){
			session.removeAttribute("code");
			return "resetpassword";
		} else {
			String news = "你输入的验证码有误";
			times++;
			if (times >= 4) {
				session.removeAttribute("code");
				news = "验证次数超过三次，请重新验证";
				pathurl = "forgotpassword";
			}
			model.addAttribute("time", times);
			model.addAttribute("news", news);
		}
		return pathurl;
	}
	@RequestMapping("resetpassword")
	public String resetPassword(String password, Model model){
		User user = (User) session.getAttribute("user");
		user.setUsPassword(password);
		System.err.println(password);
		int judge = userService.updatePassword(user);
		if (judge == 1) {
			session.removeAttribute("user");
			model.addAttribute("news", "密码修改成功");
//			try {
//				response.setContentType("text/html;charset=UTF-8");  
//				response.setCharacterEncoding("UTF-8");  
//				PrintWriter out = response.getWriter();  
//				out.println( "<script language=\"javascript\">" + "alert(\"修改密码成功\");</script>");
//				out.close();
//				} catch (IOException e) {
//				e.printStackTrace();
//				}
		}
		return startSchool();
	}
	@RequestMapping("startschool")
	public String startSchool(){
		return "index";
	}
	@RequestMapping("enterschool")
	public String enterSchool(Model model){
		List<Resource> schoolviewlist = resourceService.selectByPid(9,4);
		List<Resource> informlist = resourceService.selectByPid(8,5);
		List<Resource> newslist = resourceService.selectByPid(4,4);
		model.addAttribute("schoolviewlist", schoolviewlist);
		model.addAttribute("informlist", informlist);
		model.addAttribute("newslist", newslist);
		return "schoolindex";
	}
}
