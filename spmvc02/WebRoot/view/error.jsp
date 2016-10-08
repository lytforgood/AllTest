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
		<title>错误</title>
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
							<a href="index.jsp">后台管理系统</a>错误页面
						</h1>
					</div>
				</div>
			</div>
			<div class="template-page-wrapper">
				<form class="form-horizontal templatemo-signin-form" role="form">
					<div class="form-group">
						<div class="col-md-12">
							<label for="username" class="col-sm-2 control-label">
								错误页面
							</label>
							<label for="username" class="col-sm-6 control-label">
								请求页面找不到
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<label for="password" class="col-sm-2 control-label">
								<a href="view/index.jsp">返回首页</a>
							</label>
							<label for="username" class="col-sm-6 control-label">
								<a href="javascript:history.go(-1)">返回上一页</a>
							</label>
						</div>
					</div>
				</form>
			</div>

		</div>
	</body>
</html>
