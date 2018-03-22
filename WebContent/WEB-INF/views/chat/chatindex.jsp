<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.ssm.common.model.EnvironmentUserVO" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	EnvironmentUserVO userVO = (EnvironmentUserVO)session.getAttribute("SESSION_ENVIR");
	
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>聊天室</title>
<link rel="shortcut icon" href="static/img/favicon.ico">
		<link href="static/chat/plugins/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
<link href="static/chat/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="static/chat/css/core.css" rel="stylesheet" type="text/css" />
<link href="static/chat/css/components.css" rel="stylesheet"
	type="text/css" />
<link href="static/chat/css/icons.css" rel="stylesheet" type="text/css" />
<link href="static/chat/css/pages.css" rel="stylesheet" type="text/css" />
<link href="static/chat/css/responsive.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div id="wrapper">
		<!-- Start content -->
		<div class="content">
			<div class="container">
				<div class="row" id="chatContainer">
					<div class="col-md-12">
						<div class="col-md-10 col-md-offset-1">
							<h4 class="page-header header-title">聊天室</h4>
						</div>
					</div>
					<div class="col-md-4 col-md-offset-1">
						<div class="card-box">
							<h4 class="m-t-0 m-b-20 header-title">
								<b>用户列表</b>
							</h4>
							<div class="inbox-widget nicescroll mx-box" id="userList">
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
<script src="static/chat/js/jquery.min.js"></script>
<script src="static/chat/js/bootstrap.min.js"></script>
<script src="static/chat/js/detect.js"></script>
<script src="static/chat/js/fastclick.js"></script>
<script src="static/chat/js/jquery.slimscroll.js"></script>
<script src="static/chat/js/jquery.blockUI.js"></script>
<script src="static/chat/js/waves.js"></script>
<script src="static/chat/js/wow.min.js"></script>
<script src="static/chat/js/jquery.nicescroll.js"></script>
<script src="static/chat/js/jquery.scrollTo.min.js"></script> 

<!-- jQuery  -->
<script src="static/chat/plugins/moment/moment.js"></script>

<!-- jQuery  -->
<script src="static/chat/plugins/waypoints/lib/jquery.waypoints.js"></script>
<script src="static/chat/plugins/counterup/jquery.counterup.min.js"></script>

<!-- jQuery  -->
<script src="static/chat/plugins/sweetalert/dist/sweetalert.min.js"></script>

<!-- skycons -->
<script src="static/chat/plugins/skyicons/skycons.min.js"
	type="text/javascript"></script>

<script src="static/chat/plugins/peity/jquery.peity.min.js"></script>

<script src="static/chat/pages/jquery.widgets.js"></script>

<!-- Todojs  -->
<script src="static/chat/pages/jquery.todo.js"></script>

<!-- chatjs  -->
<script src="static/chat/pages/jquery.chat.js"></script>

<!-- Knob -->
<script src="static/chat/plugins/jquery-knob/jquery.knob.js"></script>

<script
	src="static/chat/plugins/jquery-sparkline/jquery.sparkline.min.js"></script>

<script src="static/chat/js/jquery.core.js"></script>


<script>
	var userId = '<%=userVO.getUserId()%>';
	var nickName = '<%=userVO.getNickname()%>';
	var headPic =  '<%=userVO.getHeadPic()%>'
</script>

<script src="pages/chat/chat.js"></script>
</body>


</html>
