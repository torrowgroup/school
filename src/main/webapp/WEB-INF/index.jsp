<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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

  
    <form action="${rootPath}uploadfile" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="上传文件"> 
	</form>

  修改个人资料：<a href="${rootPath}user/getMyMessage">ganga</a>
<%--     <form action="${rootPath}uploadfile" method="post" enctype="multipart/form-data"> --%>
<!-- 		<input type="file" name="file"> -->
<!-- 		<input type="submit" value="上传文件"> -->
<!-- 	</form> -->

    
  </body>
</html>
