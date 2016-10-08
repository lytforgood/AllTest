<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
            <li><a href="admin/index.jsp">首页</a></li>
            <li class="active">欢迎您使用该系统</li>
          </ol>
          <div class="margin-bottom-30">
            <div class="row">
            ${fileUrl}
            </div>
          </div>         

        </div>
      </div>
     <jsp:include page="/view/footer.jsp" />
  </body>
</html>
