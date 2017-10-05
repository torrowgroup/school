<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="${rootPath}static/css/bootstrap.min.css">
<link rel="stylesheet" href="${rootPath}static/css/animate.css">
<link rel="stylesheet" href="${rootPath}static/css/style.css">
<script type="text/javascript" src="${rootPath}static/js/forget.js"></script>
</head>
<body>
		<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<!-- Start Sign In Form -->
				<form action="${rootPath}compareCode" class="fh5co-form animate-box" method="post">
					<h2>Forgot Password</h2>
					<span style="color:red;">${news}</span>
					<div class="form-group">
						<div class="alert alert-success" role="alert">Your email has been send</div>
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">Email</label> 
						<input type="text" name="code" class="form-control" id="email" placeholder="验证码"
							autocomplete="off">
							<input type="hidden" name="times" value="${time}">
					</div>
					<div class="form-group">
						<p>90秒后自动关闭界面</p>
					</div>
					<div class="form-group">
						<input type="submit" value="下一步" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>