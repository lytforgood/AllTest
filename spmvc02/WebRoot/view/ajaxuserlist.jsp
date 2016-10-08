<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						ajax用户列表
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
								<h4 class="margin-bottom-15">
									<a href="view/jsuseradd.jsp">JS添加新用户</a>
								</h4>
								${msg}<div id="info"></div>
								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th>
												用户账户
											</th>
											<th>
												密码
											</th>
											<th>
												用户名
											</th>
											<th>
												用户类型
											</th>
											<th>
												用户角色
											</th>
											<th>
												操作
											</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="userlist">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<jsp:include page="/view/footer.jsp" />
		<script type="text/javascript">
function deleteUser(id) { //点击“删除角色”事件
	alert(id);
}
$(document).ready(
		function() {
			jQuery.ajax( {
				type : 'GET',
				contentType : 'application/json',
				url : 'user/ajaxuserlist.do',
				dataType : 'json',
				success : function(data) {
					if (data && data.success == "true") {
						$('#info').html("共" + data.total + "条数据。<br/>");
						$.each(data.datalist, function(i, item) {
							$('#userlist').append(
									"<tr><td>" + item.name + "</td><td>" + item.password
											+ "</td><td>" + item.uname+ "</td><td>" + item.utype
											+  "</td><td>" + item.urole
											+ "</td><td><a href='javascript:void(0)' onclick='deleteUser("
											+ item.id + ")'>显示ID</a></td></tr>");
						});
					}
				},
				error : function() {
					alert("error")
				}
			});
		});
</script>
		</body>
</html>
