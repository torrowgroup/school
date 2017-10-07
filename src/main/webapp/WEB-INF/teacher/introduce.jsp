<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${rootPath}setting/DepartmentManage_update" method="post">
<span>教师简介</span>
<img alt="${user.name} " src="${user.img }">
<span>单位ID:</span>
<input type="text"  name="usName" style="margin-left:18px;"   value="${usName} "  readonly="readonly"  ><br>
	<input type="text"  name="usSex" style="margin-left:18px;"   value="${usSex} "  readonly="readonly"  ><br>
	<input type="text"  name="usEmail" style="margin-left:18px;"   value="${unit.un_id} "  readonly="readonly"  ><br>
	<input type="text"  name="usTel" style="margin-left:18px;"   value="${unit.un_id} "  readonly="readonly"  ><br>
	<input type="text"  name="usIntroduce" style="margin-left:18px;"   value="${unit.un_id} "  readonly="readonly"  ><br>
	<input type="text"  name="usIdentityname" style="margin-left:18px;"   value="${unit.un_id} "  readonly="readonly"  ><br>
	</form>
</body>
</html>