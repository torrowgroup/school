package com.futher.school.controller;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.User;
import com.futher.school.service.UserService;

//@RequestMapping("/test")j
@Controller()
public class TestSmm extends BaseController{
	@Resource
	private UserService userService;

//	@RequestMapping("/uploadfile")
//	public String uploadfile(MultipartFile file, Model model){
//
//        System.out.println("开始");  
//        String path = request.getSession().getServletContext().getRealPath("upload");
//    	File fileLocation = new File(path);
//		// 此处也可以在应用根目录手动建立目标上传目录
//		if (!fileLocation.exists()) {
//			boolean isCreated = fileLocation.mkdir();
//			if (!isCreated) {
//				// 目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。
//				return path;
//			}
//		}
//        String fileName = file.getOriginalFilename();  
////        String fileName = new Date().getTime()+".jpg";  
//        System.out.println(path);  
//        File targetFile = new File(path, fileName);  
//        if(!targetFile.exists()){  
//            targetFile.mkdirs();  
//        }  
//  
//        //保存  
//        try {  
//            file.transferTo(targetFile);  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//		return "/WEB-INF/index";
//	}
//	public String testMap(Map<String,Object> map){
//		User user = new User("12122","121","121","13","111","1212","121","112","21","12","1212");
////		int id = userService.getUser(user);
//		System.out.println(user);
//		return "success";
//	}

}
