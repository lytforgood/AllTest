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
						文件上传-springMVC包装类上传文件
					</li>
				</ol>
				<div class="margin-bottom-30">
					<div class="row">
						<div class="col-md-12">
							<form action="user/upload.do" enctype="multipart/form-data"
								method="post">
								<div class="row">
									<div class="col-md-6 margin-bottom-15">
										<label for="firstName" class="control-label">
											文件上传
										</label>
										<div id="newUpload2">
											<input type="file" name="file">
										</div>
									</div>
								</div>

								<div class="row templatemo-form-buttons">
									<div class="col-md-12">
										
										<br/><input type="submit" value="上传">&nbsp;&nbsp;&nbsp;<input type="button" id="btn_add2" value="增加一行">
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
 i = 1;  
    j = 1;  
    $(document).ready(function(){  
        $("#btn_add2").click(function(){  
            document.getElementById("newUpload2").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';  
              j = j + 1;  
        });  
    });  
    function del_2(o){  
         document.getElementById("newUpload2").removeChild(document.getElementById("div_"+o));  
    }  
  
</script>
		</body>
</html>
