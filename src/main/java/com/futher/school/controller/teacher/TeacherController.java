package com.futher.school.controller.teacher;

import java.io.File;  
import java.io.IOException;  
import java.util.Iterator;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.commons.io.FileUtils;  
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.MediaType;  
import org.springframework.http.ResponseEntity;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.multipart.MultipartFile;  
import org.springframework.web.multipart.MultipartHttpServletRequest;  
import org.springframework.web.multipart.commons.CommonsMultipartResolver; 

import com.futher.school.base.BaseController;
import com.futher.school.entity.User;

@RequestMapping("/teacher") 
@Controller()
public class TeacherController extends BaseController {

	 @RequestMapping(value = "/upload", method = RequestMethod.POST)  
	 public String upload(MultipartFile file,HttpServletRequest request,Model model) throws IOException{  
	        String path = request.getSession().getServletContext().getRealPath("uploading");  
	        String fileName = file.getOriginalFilename();
	        String msg;
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法  
	        file.transferTo(dir);  
	        msg="文件上传成功";
	        model.addAttribute("msg", msg);
	        return "teacher/upload";
	    }  
	@RequestMapping(value = "/uploadEdit",method = RequestMethod.GET)
	public String uploadEdit(Model model) {
		return null;
	}
	
}

