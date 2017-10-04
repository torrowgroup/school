package com.futher.school.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SchoolListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		   // TODO Auto-generated method stub
    	String rootPath = arg0.getServletContext().getContextPath()+"/";
    	arg0.getServletContext().setAttribute("rootPath",rootPath);
	}

}
