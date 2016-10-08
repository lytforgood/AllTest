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
						用户列表
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
								<h4 class="margin-bottom-15">
									<a href="view/useradd.jsp">添加新用户</a>
								</h4>
								${msg}
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
									<tbody>
										<c:forEach var="s" items="${userList}" varStatus="vs">
											<tr>
												<td>
													${s.name}
												</td>
												<td>
													${s.password}
												</td>
												<td>
													${s.uname}
												</td>
												<td>
													${s.utype}
												</td>
												<td>
													${s.urole}
												</td>
												<td>
													<a href="user/updatequery.do?id=${s.id}"
														class="btn btn-default">修改</a>
												</td>
												<td>
													<a href="user/delete.do?id=${s.id}"
														class="btn btn-default">删除</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<ul class="pagination pull-right">
								<li>
									<a href="javascript:void(0);">共${page.totalPage}页</a>
								</li>
								<c:choose>
									<c:when test="${page.hasPrePage}">
										<li>
											<a href="user/list.do?currentPage=${page.currentPage -1 }">«</a>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="javascript:void(0);">«</a>
										</li>
									</c:otherwise>
									</c:choose>
									
									<li>

										<a href="javascript:void(0);">第${page.currentPage}页 </a>
									</li>
									<c:choose>
									<c:when test="${page.hasNextPage}">
										<li>
											<a href="user/list.do?currentPage=${page.currentPage + 1 }">»</a>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="javascript:void(0);">»</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
		<jsp:include page="/view/footer.jsp" />
		</body>
</html>
