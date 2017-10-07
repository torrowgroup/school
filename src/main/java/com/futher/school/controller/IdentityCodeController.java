package com.futher.school.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.futher.school.base.BaseController;
import com.google.code.kaptcha.Constants;
@Controller() 
public class IdentityCodeController extends BaseController{
	  
	    @RequestMapping("/kaptcha")  
	    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{  
	        response.setDateHeader("Expires",0);  
	        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
	        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
	        response.setHeader("Pragma", "no-cache");  
	        response.setContentType("image/jpeg");  
	        String capText = kaptchaProducer.createText();  
	        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
	        BufferedImage bi = kaptchaProducer.createImage(capText);  
	        ServletOutputStream out = response.getOutputStream();  
	        ImageIO.write(bi, "jpg", out);  
	        try {  
	            out.flush();  
	        } finally {  
	            out.close();  
	        }  
	        return null;  
	    }  
}
