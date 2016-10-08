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
						<a href="view/index.jsp">首页</a>
					</li>
					<li class="active">
						添加用户
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<form id="myform" method="post" role="form">
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="firstName" class="control-label">
											用户账户名
										</label>
										<input type="text" id="name" name="name" class="form-control"
											id="firstName" placeholder="账户名">
									</div>
									<div class="col-md-6 margin-bottom-15">
										<label for="lastName" class="control-label">
											密码
										</label>
										<input type="password" id="password" name="password"
											class="form-control" id="lastName" placeholder="Password">
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="password_1">
											用户名称
										</label>
										<input type="text" name="uname" class="form-control"
											id="password_1" placeholder="用户名称">
									</div>
									<div class="col-md-6 margin-bottom-15">
										<label for="password_1">
											用户类型
										</label>
										<input type="text" name="utype" class="form-control"
											id="password_1" placeholder="用户类型">
										<input type="hidden" name="urole" class="form-control"
											id="password_1" value="1"="用户权限">
									</div>
								</div>

								<div class="row templatemo-form-buttons">
									<div class="col-md-12">
										<button type="button" class="btn btn-primary" onclick="add()">
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
		<script>
function add() {
	var username = $("#name").val();
	var password = $("#password").val();
if (username == "" || username == null || username == "undefined") { //非空校验
		alert("用户名不能为空");
	} else if (password == "" || password == null || password == "undefined") {
		alert("密码不能为空");
	} else {
		var aa = $('#myform').serialize();//序列化表单
		alert(aa);
		$.ajax( {
			url : "user/jsadd.do",
			type : "post",
			data : aa,
			dataType : 'json',//返回json省去var data = eval('(' + data + ')');
			success:function(data){
				//var data = eval('(' + data + ')');
				if(data.success){
					alert(data.msg);
				}
				window.location.href="user/list2.do?currentPage=0";
            },
             error:function(){
            	alert("添加失败");
            }  
			
		});
	}
}
</script>
		</body>
</html>
