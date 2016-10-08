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
						用户名Ajax获取
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<form action="" method="post" role="form"
								id="templatemo-preferences-form">
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="lastName" class="control-label">
											用户名Ajax获取
										</label>
										<select name="" class="form-control margin-bottom-15"
											id="select">
											<option selected="selected" id="000">
												默认选中
											</option>
										</select>
									</div>
								</div>
								<div class="row templatemo-form-buttons">
									<div class="col-md-12">
										<button type="button" class="btn btn-primary"
											onclick="submit22()">
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
function submit22() {
	var aa = $('#select').val();
	alert(aa); // + 号显示多个  
};
$(document).ready(
		function s() {
			jQuery.ajax( {
				type : 'GET',
				contentType : 'application/json',
				url : 'user/ajaxlist.do',
				dataType : 'json',
				success : function(data) {
					if (data && data.success == "true") {
						$.each(data.datalist, function(i, item) {
							$('#select').append(
									"<option value='" + item.id + "'>"
											+ item.name + "</option>");

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
