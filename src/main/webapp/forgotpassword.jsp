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
				<form action="${rootPath}forgetPassword" class="fh5co-form animate-box">
					<h2>Forgot Password</h2>
					<span style="color:red;">${news}</span>
					<div class="form-group">
						<div class="alert alert-success" role="alert">Your email will receive the verification code</div>
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">Email</label> 
						<input type="email" name="usEmail" class="form-control" id="email" placeholder="Your email"
							autocomplete="off" required>
					</div>
					<div class="form-group">
						<p>90秒后自动关闭界面</p>
					</div>
					<div class="form-group">
						<input type="submit" value="Send Email" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>