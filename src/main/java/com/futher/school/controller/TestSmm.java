package com.futher.school.controller;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;
import com.futher.school.entity.User;
import com.futher.school.service.UserService;

@RequestMapping("/spring")
@Controller()
public class TestSmm extends BaseController{
	@Resource
	private UserService userService;

	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map){
		User user = new User("12122","121","121","13","111","1212","121","112","21","12","1212");
		int id = userService.getUser(user);
		System.out.println(user);
		return "success";
	}

}
