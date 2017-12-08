package com.futher.school.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.futher.school.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean sign = true;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // 转码
		HttpServletRequest schoolRequest = (HttpServletRequest) request;
		User manager = (User) schoolRequest.getSession().getAttribute("manager");// 获得登陆用户
		String returnUrl = schoolRequest.getContextPath() + "/adminschool";
		String path = schoolRequest.getRequestURI();
		if (manager != null && path.indexOf("user") != -1 || path.indexOf("resource") != -1 || path.indexOf("type") != -1 || path.indexOf("messages") != -1) {
			chain.doFilter(request, response);
		} else {
			sign = false;
		}
		if (!sign) {
			response.getWriter()
			.println("<script language=\"javascript\">" +"alert(\"登录失效！请重新登录\");"+ "if(window.opener==null){window.top.location.href=\""
					+ returnUrl + "\";}else{window.opener.top.location.href=\"" + returnUrl
					+ "\";window.close();}</script>");
			return;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
