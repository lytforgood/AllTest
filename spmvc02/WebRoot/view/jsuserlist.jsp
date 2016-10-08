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
						JS用户列表
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
								<h4 class="margin-bottom-15">
									<a href="view/jsuseradd.jsp">JS添加新用户</a>
									<a href="javascript:void(0);" onclick="deleteall()">JS批量删除(弹出选中的所有id)</a>
									<input type="checkbox" id="all">
									<input type="button" value="全选" class="btn" id="selectAll">
									<input type="button" value="全不选" class="btn" id="unSelect">
									<input type="button" value="反选" class="btn" id="reverse">
									<input type="button" value="获得选中的所有值" class="btn" id="getValue">
								</h4>
								${msg}
								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th>
												批量删除
											</th>
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
									<tbody id="list">
										<c:forEach var="s" items="${userList}" varStatus="vs">
											<tr id="${s.id}">
												<td>
													<input type="checkbox" name="uid" value="${s.id}">
												</td>
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
													<a href="javascript:void(0)" class="btn btn-default"
														onclick="deleteUser(${s.id})">删除</a>
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
		<script type="text/javascript">
function deleteUser(id) { //点击“删除角色”事件
	$.ajax( {
		url : "user/jsdelete.do",
		type : "post",
		data : 'id=' + id,
		dataType : 'json',
		success : function(data) {
			if (data.success == "true") {
				alert(data.msg);
			}
			window.location.href = "user/list2.do?currentPage=0";
		},
		error : function() {
			alert("删除失败");
			window.location.href = "user/list2.do?currentPage=0";
		}
	});
}
function deleteall() { //批量删除
	var str = "";
	var sel = document.getElementsByName("uid");//获取checkbox的值
	for ( var i = 0; i < sel.length; i++)
		if (sel[i].checked == true)
			str += sel[i].value + ",";
	if (str == "") {
		alert("请至少选择一条记录");
		return false;
	}
	alert(str);

}
</script>
		<script type="text/javascript">
//函数allchk()就是用来检测全选框#all应该是选中状态还是未选中状态的
$(function() {
	//全选或全不选 
	$("#all").click(function() {
		if (this.checked) {
			$("#list :checkbox").prop("checked", true);
		} else {
			$("#list :checkbox").prop("checked", false);
		}
	});
	//全选   
	$("#selectAll").click(function() {
		$("#list :checkbox,#all").prop("checked", true);
	});
	//全不选 
	$("#unSelect").click(function() {
		$("#list :checkbox,#all").prop("checked", false);
	});
	//反选  
	$("#reverse").click(function() {
		$("#list :checkbox").each(function() {
			$(this).prop("checked", !$(this).prop("checked"));
		});
		allchk();
	});

	//设置全选复选框 
	$("#list :checkbox").click(function() {
		allchk();
	});

	//获取选中选项的值 
	$("#getValue").click(function() {
		var str = "";
		var sel = document.getElementsByName("uid");//获取checkbox的值
			for ( var i = 0; i < sel.length; i++) {
				if (sel[i].checked == true) {
					str += sel[i].value + ",";
				}
			}
			alert(str);
			//var valArr = new Array; 
			//$("#list :checkbox[checked]").each(function(i){ 
			//    valArr[i] = $(this).val(); 
			//}); 
			// var vals = valArr.join(','); 
			//   alert(vals); 
		});
});
function allchk() {
	var chknum = $("#list :checkbox").size();//选项总个数 
	var chk = 0;
	$("#list :checkbox").each(function() {
		if ($(this).prop("checked") == true) {
			chk++;
		}
	});
	if (chknum == chk) {//全选 
		$("#all").prop("checked", true);
	} else {//不全选 
		$("#all").prop("checked", false);
	}
}
</script>
	</body>
</html>
