<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="source/css/templatemo_main.css">
<link rel="icon" type="image/ico" href="source/fav2.ico">
</head>
<body>
	<div class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<div class="logo">
				<a href="view/index.jsp"><h1>
						后台管理系统
					</h1>
				</a>
			</div>
		</div>
		<div style="float: right; text-align: right; margin-top: 15px;">
			<span class="icon-bar"><a href="view/index.jsp"><i
					class="fa fa-home"></i>首页</a>
			</span> &nbsp;
			<span class="icon-bar"><a href="view/login.jsp"><i
					class="fa fa-users"></i>${sessionScope.user.name}登录</a>
			</span> &nbsp;
			<span class="icon-bar"><a href="user/out.do"><i
					class="fa fa-sign-out"></i>退出</a>
			</span> &nbsp;
		</div>
	</div>
	<div class="template-page-wrapper">
		<div class="navbar-collapse collapse templatemo-sidebar">
			<ul class="templatemo-sidebar-menu">
			<li>
					<a href="user/list.do?currentPage=0"><i class="fa fa-cog"></i>用户资料管理</a>
				</li>
				<li>
					<a href="user/test1.do?name=qq"><i class="fa fa-cog"></i>传user里的值</a>
				</li>
				<li>
					<a href="user/list2.do?currentPage=0"><i class="fa fa-cog"></i>js提交各种操作</a>
				</li>
				<li>
					<a href="view/ajaxselect.jsp"><i class="fa fa-cog"></i>ajax选择列表</a>
				</li>
				<li>
					<a href="view/ajaxuserlist.jsp"><i class="fa fa-cog"></i>ajax用户列表</a>
				</li>
				<li>
					<a href="view/fileadd.jsp"><i class="fa fa-cog"></i>文件上传</a>
				</li>
				<li>
					<a href="view/filedown.jsp"><i class="fa fa-cog"></i>文件下载</a>
				</li>
				<li>
					<a href="user/out.do" ><i
						class="fa fa-sign-out"></i>退出</a>
				</li>
			</ul>
		</div>
		<!--/.navbar-collapse -->