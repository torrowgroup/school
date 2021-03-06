package com.futher.school.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.futher.school.base.BaseController;
import com.futher.school.entity.User;
import com.futher.school.entity.Type;
import com.futher.school.util.Email;
import com.google.code.kaptcha.Constants;

@Controller()
public class LoginController extends BaseController {

	@RequestMapping("/verifyAccount")
	@ResponseBody
	public void verifyAccount(String usEmail) throws IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
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
	public String login(String usEmail, String usPassword, String identityCode, Model model) {
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String pathurl = "index";
		User user = userService.login(usEmail, usPassword);
		System.out.println(user);
		if (user != null) {
//			if ("remember".equals(isLogin)) {
//				// 创建两个Cookie对象
//				Cookie nameCookie = new Cookie("usEmail", usEmail);
//				// 设置Cookie的有效期为3天
//				nameCookie.setMaxAge(60 * 60 * 24 * 3);
//				Cookie pwdCookie = new Cookie("usPassword", usPassword);
//				pwdCookie.setMaxAge(60 * 60 * 24 * 3);
//				response.addCookie(nameCookie);
//				response.addCookie(pwdCookie);
//			}
			String identityname = user.getUsIdentityname();
			if (identityname.equals("manager")) {
				session.setAttribute("manager", user);
				model.addAttribute("noStatus", "未回复");
				model.addAttribute("yesStatus", "已回复");
				model.addAttribute("user", user);
				pathurl = "/manager/homepage";
			} else if (identityname.equals("officialemail")) {
				model.addAttribute("news", "此用户不用作登录");
			}

			else if (identityname.equals("teacher")) {
				typeService.getType(model);
				session.setAttribute("teacher", user);
				pathurl = "teacher/index";
			} else if (identityname.equals("teachergroup")) {
				session.setAttribute("teachergroup", user);
				pathurl = "teachergroup/index";

			} else if (identityname.equals("educationoffice")) {
				session.setAttribute("educationoffice", user);
				pathurl = "educationoffice/index";
			} else {
				model.addAttribute("news", "用户名或密码错误,请重新输入");
			}
		}
		return pathurl;
	}

	@RequestMapping("/forget")
	public String forget() {
		return "forgotpassword";
	}

	@RequestMapping("forgetPassword")
	public String forgetPassword(String usEmail, Model model) {
		String pathurl = "forgotpassword";
		User user = userService.getPassword(usEmail);
		if (user != null) {
			String identityname = "officialemail";
			User useremail = userService.getEmail(identityname);
			if (useremail != null) {
				session.setAttribute("user", user);
				String code = "";
				for (int i = 0; i < 6; i++) {
					int c = (int) (Math.random() * 9);
					code += c;
				}
				String officialemail = useremail.getUsEmail();
				String password = useremail.getUsPassword();
				String host = useremail.getUsName();
				String email = user.getUsEmail();
				String mailcontent = "尊敬的用户" + email + "您好，您的验证码是" + code + "请勿转发";
				try {
					Email.sendMail(officialemail, password, host, "验证码", email, "找回密码", mailcontent);
				} catch (Exception e) {
					model.addAttribute("news", "你输入的邮箱不存在");

				}
				session.setAttribute("code", code);
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

	@RequestMapping("removeCode")
	@ResponseBody
	public void removeCode() throws IOException {
		session.removeAttribute("code");
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "true";
		out.print(result);
		out.close();
	}

	@RequestMapping("compareCode")
	public String compareCode(String code, int times, Model model) {
		String pathurl = "comparecode";
		String codeUser = (String) session.getAttribute("code");
		if (codeUser.isEmpty() || codeUser == null) {
			String news = "验证码已失效";
		} else {
			if (codeUser.equals(code)) {
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
		}
		return pathurl;
	}

	@RequestMapping("resetpassword")
	public String resetPassword(String password, Model model) {
		User user = (User) session.getAttribute("user");
		user.setUsPassword(password);
		System.err.println(password);
		int judge = userService.updatePassword(user);
		if (judge == 1) {
			session.removeAttribute("user");
			model.addAttribute("news", "密码修改成功");
		}
		return startSchool();
	}

	@RequestMapping("adminschool")
	public String startSchool() {
//		String usEmail = "";
//		String usPassword = "";
//		// 获取当前站点的所有Cookie
//		Cookie[] cookies = request.getCookies();
//		for (int i = 0; i < cookies.length; i++) {// 对cookies中的数据进行遍历，找到用户名、密码的数据
//			if ("usEmail".equals(cookies[i].getName())) {
//				usEmail = cookies[i].getValue();
//			} else if ("usPassword".equals(cookies[i].getName())) {
//				usPassword = cookies[i].getValue();
//			}
//		}
//		model.addAttribute("usEmail", usEmail);
//		model.addAttribute("usPassword", usPassword);
		return "index";
	}
	
	@RequestMapping("logout")
	public String logout(String identity){
		session.removeAttribute(identity);
		return startSchool();
	}

	@RequestMapping("index")
	public String enterSchool(@RequestParam(value = "identity", defaultValue = "省市名师", required = false)String identity, Model model) throws UnsupportedEncodingException {
		List<Type> typeList = typeService.getAllTypes();
		if (typeList == null) {
			model.addAttribute("typeList", typeList);
		} else {
			resourceService.getAllResource(typeList, model);
			List<User> teacherList = userService.selectByPid(5,identity);
			typeService.getType(model);
			model.addAttribute("teacherList", teacherList);
		}
		return "schoolpage/index";
	}
	@RequestMapping("getTeacher")
	@ResponseBody
	public Map<String , Object> getTeacher(String identity) throws IOException{
		identity = new String(identity.getBytes("iso-8859-1"), "utf-8");
		List<User> teacherList = userService.selectByPid(5,identity);
		Map<String , Object>  map = new HashMap<String , Object>();
		map.put("user", teacherList);
		return map;
	}
}
