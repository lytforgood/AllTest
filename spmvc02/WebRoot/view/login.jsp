<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>登录</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width">
		<link rel="stylesheet" href="source/css/templatemo_main.css">
		<link rel="icon" type="image/ico" href="source/fav2.ico">
	</head>
	<body>
		<div id="main-wrapper">
			<div class="navbar navbar-inverse" role="navigation">
				<div class="navbar-header">
					<div class="logo">
						<h1>
							<a href="index.jsp">后台管理系统</a>-管理员登录
						</h1>
					</div>
				</div>
			</div>
			<div class="template-page-wrapper">
				<form action="user/login.do" method="post"
					class="form-horizontal templatemo-signin-form" role="form">
					<div class="form-group">
						<div class="col-md-12">
							<label for="username" class="col-sm-2 control-label">
								账户名
							</label>
							<div class="col-sm-10">
								<input type="text" name="name" class="form-control" id="username"
									placeholder="账户名">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<label for="password" class="col-sm-2 control-label">
								密&nbsp;&nbsp;&nbsp;码
							</label>
							<div class="col-sm-10">
								<input type="password" name="password" class="form-control" id="password"
									placeholder="Password">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" value="登录" class="btn btn-default">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
