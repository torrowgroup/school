package com.futher.school.controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Type;
import com.futher.school.entity.User;

@RequestMapping("/user")
@Controller()
public class UserController extends BaseController {
	/**
	 * @param model
	 * @return 转发到修改个人资料的界面
	 */
	@RequestMapping("/getMyMessage")
	public String getMyMessage(Model model) {
		User user = (User) session.getAttribute("manager");
		if (user == null) {
			model.addAttribute("news", "该用户已被删除");
		} else {
			model.addAttribute("user", user);
		}
		return "/manager/myself";
	}

	/**
	 * @param user
	 * @return 修改个人资料
	 */
	@RequestMapping("/updateMyNews")
	public String updateMyNews(@ModelAttribute("form") User user, Model model) {
		User usernews = (User) session.getAttribute("manager");
		if (usernews == null) {
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
				if (!(userlist.isEmpty())) {
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
				} else {
					model.addAttribute("news", "没有用户信息,请添加");
				}
			}
		}
		return this.getMyMessage(model);
	}

	/**
	 * @param tyPid
	 * @return 转发到添加用户的界面
	 */
	@RequestMapping("toaddUser")
	public String toaddUser(Integer tyPid, Model model) {
		List<Type> list = typeService.selectTypeName(tyPid);
		if (list.isEmpty()) {
			model.addAttribute("news", "请添加用户类型");
		} else {
			model.addAttribute("typelist", list);
		}
		return "manager/adduser";
	}

	/**
	 * @param user
	 * @param file
	 * @return 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(User user, MultipartFile file, Model model) {
		model.addAttribute("identity", user.getUsIdentityname());
		Type type = typeService.getId(user.getUsIdentityname());
		if (type == null) {
			model.addAttribute("news", "请添加用户类型");
		} else {
			if (file.isEmpty() == true) {
				model.addAttribute("news", "请上传图片，添加失败");
			} else {
				uploadImage(user, file);
				user.setUsIdentityid(type.getTyId());
				int judge = userService.addUser(user);
				if (judge == 1) {
					model.addAttribute("news", "添加成功");
				} else {
					model.addAttribute("news", "添加失败");
				}
			}
		}
		return toaddUser(1, model);
	}

	/**
	 * @param tyPid
	 * @return 转发到添加官方邮箱的界面
	 */
	@RequestMapping("toaddOfficialUser")
	public String toaddOfficialUser(Integer tyPid, Model model) {
		List<Type> list = typeService.selectTypeName(tyPid);
		if (list.isEmpty()) {
			model.addAttribute("news", "请添加用户类型");
		} else {
			for (int i = 0; i < list.size(); i++) {
				int sign = 0; 
				if (list.get(i).getTyCategoryname().equals("officialemail")) {
					model.addAttribute("officialemail", list.get(i).getTyCategoryname());
					sign = 1;
				}
				if (sign == 0) {
					model.addAttribute("news", "请添加官方邮箱类型");
				}
			}
//			model.addAttribute("typelist", list);
		}
		return "manager/addofficialuser";
	}

	/**
	 * @param user
	 * @return 添加官方邮箱
	 */
	@RequestMapping("addOfficialUser")
	public String addOfficialUser(User user, Model model) {
		Type type = typeService.getId(user.getUsIdentityname());
		if (type == null) {
			model.addAttribute("news", "请添加官方邮箱类型");
		} else {
			user.setUsIdentityid(type.getTyId());
			User olduser = userService.getEmail(user.getUsIdentityname());
			if (olduser == null) {
				int judge = userService.addUser(user);
				if (judge == 1) {
					model.addAttribute("news", "添加成功");
				} else {
					model.addAttribute("news", "添加失败");
				}
			} else {
				model.addAttribute("news", "已有官方邮箱");
			}
		}
		return toaddOfficialUser(1, model);
	}

	@RequestMapping("selectOfficialUser")
	public String selectOfficialUser(String identity, Model model) {
		User user = userService.getEmail(identity);
		model.addAttribute("user", user);
		return "manager/selectofficialuser";
	}

	@RequestMapping("selectUser")
	public String selectUser(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			Model model) {
		model.addAttribute("messages", userService.findByPage(currentPage));// 回显分页数据
		return "manager/selectuser";
	}

	@RequestMapping("deletUser")
	public String deletUser(int usId, Model model) {
		User user = (User) session.getAttribute("manager");
		if (user.getUsId().equals(usId)) {
			model.addAttribute("news", "不能删除自己");
		} else {
			User oldUser = userService.selectByUserId(usId);
			if (oldUser == null) {
				model.addAttribute("news", "因不可知原因,已删除");
			} else {
				int sign = userService.deletByUserId(usId);
				if (sign == 1) {
					model.addAttribute("news", "删除成功");
				} else {
					model.addAttribute("news", "删除失败");
				}
			}
		}
		return selectUser(1, model);

	}

	@RequestMapping("toUpdateOfficialUser")
	public String toUpdateOfficialUser(int usId, Model model) {
		User user = userService.selectByUserId(usId);
		if (user == null) {
			model.addAttribute("news", "该用户已被删除");
		} else {
			List<Type> list = typeService.selectTypeName(1);
			if (list.isEmpty()) {
				model.addAttribute("news", "请添加用户类型");
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getTyCategoryname().equals("officialemail")) {
						model.addAttribute("officialemail", list.get(i).getTyCategoryname());
					}
				}     
			}
		}
		model.addAttribute("usernews", user);
		return "manager/updateofficialuser";
	}

	@RequestMapping("updateOfficialUser")
	public String updateOfficialUser(User user, Model model) {
		Type type = typeService.getId(user.getUsIdentityname());
		if (type == null) {
			model.addAttribute("news", "请添加当前修改的用户类型");
		} else {
			User olduser = userService.selectByUserId(user.getUsId());
			if (olduser == null) {
				model.addAttribute("news", "该用户已删除");
			} else {
				user.setUsIdentityid(type.getTyId());
				int judge = userService.updatePassword(user);
				if (judge == 1) {
					model.addAttribute("news", "添加成功");
				} else {
					model.addAttribute("news", "添加失败");
				}
			}
		}
		return selectOfficialUser(user.getUsIdentityname(), model);
	}

	@RequestMapping("toUpdateUser")
	public String toUpdateUser(int usId, Model model) {
		User user = userService.selectByUserId(usId);
		if (user == null) {
			model.addAttribute("news", "该用户已被删除");
		} else {
			List<Type> list = typeService.selectTypeName(1);
			if (list.isEmpty()) {
				model.addAttribute("news", "请添加用户类型");
			} else {
				model.addAttribute("typelist", list);
				model.addAttribute("usernews", user);
			}
		}
		return "manager/updateuser";

	}

	@RequestMapping("updateUser")
	public String updateUser(User user, MultipartFile file, Model model) {
		User olduser = userService.selectByUserId(user.getUsId());
		if (olduser == null) {
			model.addAttribute("news", "该用户已被删除");
		} else {
			Type type = typeService.getId(user.getUsIdentityname());
			if (type == null) {
				model.addAttribute("news", "该用户类型已被删除");
			} else {
				if (file.isEmpty() == true) {
					user.setUsImage(olduser.getUsImage());
				} else {
					uploadImage(user, file);
					user.setUsIdentityid(type.getTyId());
					int judge = userService.updatePassword(user);
					if (judge == 1) {
						model.addAttribute("news", "添加成功");
					} else {
						model.addAttribute("news", "添加失败");
					}
				}
			}
		}
		return selectUser(1, model);
	}

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public void upload(MultipartFile myFileName) throws IOException {
		String realName = userService.uploadimage(myFileName, session);
		response.getWriter().write(request.getContextPath() + "/static/uploadImg/source/" + realName);
	}

	@RequestMapping("verifyEmailName")
	@ResponseBody
	public void verifyEmailName(String usEmail) throws IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "true";
		List<User> userlist = userService.getAllUsers();
		if (!(userlist.isEmpty())) {
			for (int i = 0; i < userlist.size(); i++) {
				if (usEmail.equals(userlist.get(i).getUsEmail())) {
					result = "false";
				}
		}
		}
		out.print(result);
		out.close();
	}

	@RequestMapping("verifyUser")
	@ResponseBody
	public void verifyUser(int usId, String usEmail) throws IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "true";
		User user = userService.selectByUserId(usId);
		if (user == null) {
			result = "false";
		} else {
			if (usEmail.equals(user.getUsEmail())) {
				result = "true";
			} else {
				List<User> userlist = userService.getAllUsers();
				if (userlist.isEmpty()) {
					result = "false";
				} else {
					for (int i = 0; i < userlist.size(); i++) {
						if (usEmail.equals(userlist.get(i).getUsEmail())) {
							result = "false";
						}
				}
				}
			}
			out.print(result);
			out.close();
		}
	}

	@RequestMapping("/verifyEmail")
	@ResponseBody
	public void verifyEmail(String usEmail) throws IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		String result = "";
		User usernews = (User) session.getAttribute("manager");
		if (usernews == null) {
			result = "false";
		} else {
			if (usEmail.equals(usernews.getUsEmail())) {
				result = "true";
			} else {
				List<User> userlist = userService.getAllUsers();
				if (userlist.isEmpty()) {
					result = "false";
				} else {
					int sign = 1;
					for (int i = 0; i < userlist.size(); i++) {
						if (usEmail.equals(userlist.get(i).getUsEmail())) {
							sign = 0;
						}
					}
					if (sign == 1) {
						result = "true";
					} else {
						result = "false";
					}
				}
			}
		}
		out.print(result);
		out.close();
	}

	public void uploadImage(User user, MultipartFile file) {
		String path = "/static/uploadImg";
		String fileName = userService.uploadResource(file, path, request);
		user.setUsImage(fileName);
	}
}
