package com.futher.school.base;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.futher.school.service.MessageService;
import com.futher.school.service.ResourceService;
import com.futher.school.service.TypeService;
import com.futher.school.service.UserService;

public abstract  class BaseController {

	@Resource
	private UserService userService;
	@Resource
	private MessageService messageService;
	@Resource
	private ResourceService resourceService;
	@Resource
	private TypeService typeService;
	
	 /**
     * 返回一个 ModelAndView 实例
     * @return
     */
    protected ModelAndView getMV(){
        return new ModelAndView();
    }
    protected Logger log;
    public BaseController() {
        if(log == null){
            log = Logger.getLogger(this.getClass());
        }
        log.info("log对象创建成功");
    }
}
