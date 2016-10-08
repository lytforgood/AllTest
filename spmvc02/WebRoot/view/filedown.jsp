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
						文件下载
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<form action="" 
								method="post">
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="firstName" class="control-label">
											文件下载 ---请求地址user/download.do?fileName=qqq.png修改fileName即可
										</label>
										<div id="newUpload2">
											<a href="user/download.do?fileName=qqq.png">下载</a>
										</div>
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
