package com.futher.school.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.futher.school.service.MessageService;
import com.futher.school.service.ResourceService;
import com.futher.school.service.TypeService;
import com.futher.school.service.UserService;

public abstract  class BaseController {

	@Resource
	protected UserService userService;
	@Resource
	protected MessageService messageService;
	@Resource
	protected ResourceService resourceService;
	@Resource
	protected TypeService typeService;
	@Resource
	protected HttpServletRequest request;
	@Resource
	protected HttpSession session; 
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
