package com.futher.school.controller.blog;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Message;

/**
 * @ClassName: BlogController
 * @Description: 博客系统
 * @author wqjhky@gmail.com
 * @date 2017年10月22日 下午3:42:31
 * 
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController extends BaseController {
	@RequestMapping(value = "/edit")
	public Message editBlog(Model model, HttpServletRequest request) {
		String blog = request.getParameter("edit");
		Message message = null;
		int userId = (int) session.getAttribute("teacher");
		message.setMeId(userId);
		message.setMeContent(blog);	 	
		String msg = null;
		return null;
	}

}
