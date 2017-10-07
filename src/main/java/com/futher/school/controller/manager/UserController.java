package com.futher.school.controller.manager;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;
import com.futher.school.entity.User;

@RequestMapping("/user")
@Controller()
public class UserController extends BaseController {
	@RequestMapping("/getMyMessage")
	public String getMyMessage(Model model) {
		User user = (User) session.getAttribute("manager");
		model.addAttribute("user", user);
		return "/manager/myself";
	}

	@RequestMapping("/updateMyNews")
	public String updateMyNews(@ModelAttribute("form") User user, Model model) {
		User usernews = (User) session.getAttribute("manager");
		if (user.getUsEmail().equals(usernews.getUsEmail())) {
			int judge = userService.updatePassword(user);
			if (judge == 1) {
				session.setAttribute("manager", user);
				model.addAttribute("news", "修改成功");
			} else {
				model.addAttribute("news", "修改失败");
			}
		} else {
			List<User> userlist = userService.getAllUsers();
			int sign = 1;
			for (int i = 0; i < userlist.size(); i++) {
				if (user.getUsEmail().equals(userlist.get(i).getUsEmail())) {
					sign = 0;
				}
			}
			if (sign == 1) {
				int judge = userService.updatePassword(user);
				if (judge == 1) {
					session.setAttribute("manager", user);
					model.addAttribute("news", "修改成功");
				} else {
					model.addAttribute("news", "修改失败");
				}
			} else {
				model.addAttribute("news", "已有此账号,请重新填写");
			}
		}
		return this.getMyMessage(model);
	}

}
