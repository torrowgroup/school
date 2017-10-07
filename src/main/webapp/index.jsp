<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <script type="text/javascript">  
        function changeVerifyCode() {  
            var time=new Date().getTime();  
            document.getElementById("kaptchaImage").src="${rootPath}/kaptcha?d="+time;//为了不让验证码缓存，为了安全起见，需要次次都刷新  
        }  
    </script> 
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<!--     This is my JSP page. <br> -->
<%--     ${news} --%>
<%--      <form action="${rootPath}login" method="post"> --%>
<!--      username:<input type="text" name="usEmail" placeholder="请输入你的邮箱号"><br> -->
<!--      password:<input type="text" name="usPassword" placeholder="请输入密码"><br> -->
<!--      IdentityCode:<input type="text" name="identityCode" placeholder="请输入验证码"><br> -->
<%--      <img alt="验证码" id="kaptchaImage" src="${rootPath}/kaptcha"  onclick="changeVerifyCode()" /><br> --%>
<!--      <input type="submit" value="登录"> -->
<!--      </form><br> -->
<!--      <a href="" onclick="windowOpennews()" >忘记密码</a> -->
<%--      <script type="text/javascript" src="${rootPath}static/js/forgotpassword.js"></script> --%>
 <jsp:forward page="/startschool"></jsp:forward>
  </body>
</html>
