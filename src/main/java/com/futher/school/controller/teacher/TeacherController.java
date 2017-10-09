package com.futher.school.controller.teacher;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.User;

@RequestMapping("/teacher") 
@Controller()
public class TeacherController extends BaseController {
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload( @RequestParam("file") MultipartFile file ,Model model){
		 String path = request.getSession().getServletContext().getRealPath("/uploading"); 
		String msg="";
        try {
            if (!file.isEmpty()){
                Streams.copy(file.getInputStream(),new FileOutputStream("static/uploading"+file.getOriginalFilename()),true);
                System.out.println("文件上传成功");
                msg="文件上传成功";
            }
        } catch (IOException e) {
        	System.out.println("文件上传失败");
        	msg="抱歉，未知错误,文件上传失败";
        	e.printStackTrace();
        }
      model.addAttribute("msg", msg);
        return "teacher/upload";
    }
}

