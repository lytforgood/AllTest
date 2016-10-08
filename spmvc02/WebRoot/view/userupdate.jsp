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

		<title>管理</title>
		<jsp:include page="/view/header.jsp" />

		<div class="templatemo-content-wrapper">
			<div class="templatemo-content">
				<ol class="breadcrumb">
					<li>
						<a href="admin/index.jsp">首页</a>
					</li>
					<li class="active">
						修改用户
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<form action="user/update.do" method="post" role="form" id="templatemo-preferences-form">
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="firstName" class="control-label">
											用户账户名
										</label>
										<input type="hidden" name="id" class="form-control" id="firstName"
											value="${user.id}">
										<input type="text" name="name" class="form-control" id="firstName"
											value="${user.name}">
									</div>
									<div class="col-md-6 margin-bottom-15">
										<label for="lastName" class="control-label">
											密码
										</label>
										<input type="password" name="password" class="form-control" id="lastName"
											value="${user.password}">
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="password_1">
											用户名
										</label>
										<input type="text" name="uname" class="form-control" id="password_1"
											value="${user.uname}">
									</div>
									<div class="col-md-6 margin-bottom-15">
										<label for="password_2">
											用户类型
										</label>
										<input type="text" name="utype" class="form-control" id="password_2"
											value="${user.utype}">
										<input type="hidden" name="urole" class="form-control" id="password_2"
											value="${user.urole}">
									</div>
								</div>

								<div class="row templatemo-form-buttons">
									<div class="col-md-12">
										<button type="submit" class="btn btn-primary">
											提交
										</button>
										<button type="reset" class="btn btn-default">
											重置
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
		<jsp:include page="/view/footer.jsp" />
		</body>
</html>
