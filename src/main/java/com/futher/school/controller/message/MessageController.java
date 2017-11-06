package com.futher.school.controller.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;

/** 
* @ClassName: MessageController 
* @Description: Message
* @author wqjhky@gmail.com
* @date 2017年11月6日 上午8:50:24 
*  
*/

@RequestMapping("/message")
@Controller()
public class MessageController  extends BaseController{

	@RequestMapping(value="/saveMeassage")
	public String saveMeaasge() {
		return null;
	}
	@RequestMapping(value="replyMessage")
	public String replyMessage() {
		return null;
	}
	@RequestMapping(value="showMessage")
	public String showMessage() {
		return null;
	}
	
}
