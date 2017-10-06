<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${news}
	<form action="${rootPath}/user/updateMyNews" method="post">
	<input type="hidden" name="usId" value="${user.usId}">
	username:<input type="text" name="usEmail" value="${user.usEmail}"><br>
	password:<input type="text" name="usPassword" value="${user.usPassword}"><br>
	name:<input type="text" name="usName" value="${user.usName}"><br>
	sex:<input type="text" name="usSex" value="${user.usSex}"><br>
	tellphone:<input type="text" name="usTel" value="${user.usTel}"><br>
	<input type="hidden" name="usIdentityid" value="${user.usIdentityid}">
	<input type="hidden" name="usIdentityname" value="${user.usIdentityname}">
	<input type="submit" value="修改">
	</form>
</body>
</html>