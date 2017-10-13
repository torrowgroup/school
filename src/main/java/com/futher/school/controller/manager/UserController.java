package com.futher.school.controller.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Type;
import com.futher.school.entity.User;

@RequestMapping("/user")
@Controller()
public class UserController extends BaseController {
	
	@RequestMapping("/verifyemail")
	@ResponseBody
	public void verifyEmail(String usEmail) throws IOException{
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		String result = "";
		User usernews = (User) session.getAttribute("manager");
		if (usEmail.equals(usernews.getUsEmail())) {
			result = "true";
			out.print(result);
		} else {
			List<User> userlist = userService.getAllUsers();
			int sign = 1;
			for (int i = 0; i < userlist.size(); i++) {
				if (usEmail.equals(userlist.get(i).getUsEmail())) {
					sign = 0;
				}
			}
			if (sign == 1) {
				result = "true";
				out.print(result);
			} else {
				result = "false";
				out.print(result);
			}
		}
		out.close();
	}
	
	
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

	@RequestMapping("toaddUser")
	public String toaddUser(String identity, Model model) {
		model.addAttribute("identity", identity);
		return "manager/adduser";
	}

	@RequestMapping(value = "/uploadImg")
	public void uploadImg(File myFileName) throws IOException {
		// HttpServletRequest req2 = ServletActionContext.getRequest();
		// HttpServletResponse res2 = ServletActionContext.getResponse();
		String name = myFileName.getName();
		// 提取文件拓展名
		String fileNameExtension = name.substring(name.indexOf("."), name.length() - 1);
		// 生成实际存储的真实文件名
		String realName = UUID.randomUUID().toString() + fileNameExtension;
		// 图片存放的真实路径
		String realPath = ((HttpSession) response).getServletContext().getRealPath("/uploadImg/source") + "/"
				+ realName;
		// 将文件写入指定路径下
		InputStream in = new FileInputStream(myFileName);
		File uploadFile = new File(realPath);
		OutputStream out = new FileOutputStream(uploadFile);
		byte[] buffer = new byte[1024 * 1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();

		// 返回图片的URL地址
		response.getWriter().write(request.getContextPath() + "/uploadImg/source/" + realName);
	}

	@RequestMapping("/addUser")
	public String addUser(User user,MultipartFile file,Model model){
		model.addAttribute("identity", user.getUsIdentityname());
		if (user.getUsIdentityname().equals("manager")) {
			Type type = typeService.getId(user.getUsIdentityname());
			user.setUsIdentityid(type.getTyId());
			List<User> userlist = userService.getAllUsers();
			int sign = 1;
			for (int i = 0; i < userlist.size(); i++) {
				if (user.getUsEmail().equals(userlist.get(i).getUsEmail())) {
					sign = 0;
				}
			}
			if (sign == 1) {
				int judge = userService.addUser(user);
				if (judge == 1) {
					model.addAttribute("news", "添加成功");
				} else {
					model.addAttribute("news", "添加失败");
				}
			} else {
				model.addAttribute("news", "已有此用户，添加失败");
			}
		} else {
			if (file.isEmpty() == true) {
				model.addAttribute("news", "请上传图片，添加失败");
			} else {
		        String path = request.getSession().getServletContext().getRealPath("uploadImg");
		    	File fileLocation = new File(path);
				// 此处也可以在应用根目录手动建立目标上传目录
				if (!fileLocation.exists()) {
					boolean isCreated = fileLocation.mkdir();
					if (!isCreated) {
						// 目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。
						return path;
					}
				}
		        String fileName = file.getOriginalFilename(); 
		        user.setUsImage(fileName);
		        File targetFile = new File(path, fileName);  
		        if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        }  
		        //保存  
		        try {  
		            file.transferTo(targetFile);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }
				Type type = typeService.getId(user.getUsIdentityname());
				user.setUsIdentityid(type.getTyId());
				List<User> userlist = userService.getAllUsers();
				int sign = 1;
				for (int i = 0; i < userlist.size(); i++) {
					if (user.getUsEmail().equals(userlist.get(i).getUsEmail())) {
						sign = 0;
					}
				}
				if (sign == 1) {
					int judge = userService.addUser(user);
					if (judge == 1) {
						model.addAttribute("news", "添加成功");
					} else {
						model.addAttribute("news", "添加失败");
					}
				} else {
					model.addAttribute("news", "已有此用户，添加失败");
				}
			}
		}
		return "manager/adduser";
	}
}
