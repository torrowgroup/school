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

@RequestMapping("/user")
@Controller()
public class TeacherController extends BaseController {
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String upload( @RequestParam("file") MultipartFile file){
        //分别获取的是变量名file---文件类型---文件名
        System.out.println(file.getName()+"---"+file.getContentType()+"---"+file.getOriginalFilename());
        try {
            if (!file.isEmpty()){
            //使用StreamsAPI方式拷贝文件
                Streams.copy(file.getInputStream(),new FileOutputStream("E:/temp/"+file.getOriginalFilename()),true);
            }
        } catch (IOException e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
        }
        return "user/login";
    }
}
