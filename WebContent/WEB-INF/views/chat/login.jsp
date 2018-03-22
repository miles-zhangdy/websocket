<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>聊天登录</title>
<link rel="stylesheet" href="static/chat/css/reset.css">
<link rel="stylesheet" href="static/chat/css/supersized.css">
<link rel="stylesheet" href="static/chat/css/style.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
</head>

<body>

	<div class="page-container">
		<h1>Login</h1>
		<form action="chat/login" method="post" id="loginForm">
			<div>
				<input type="text" name="userName" class="userName"
					placeholder="Username" autocomplete="off" />
			</div>
			<div>
				<input type="password" name="password" class="password"
					placeholder="Password" oncontextmenu="return false"
					onpaste="return false" />
			</div>
			<input id="submit" type="submit" value="登录">
		</form>
		<div class="connect">
			<p>If we can only encounter each other rather than stay with each
				other,then I wish we had never encountered.</p>
			<p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
		</div>
	</div>
	<div class="alert" style="display:none">
		<h2>消息</h2>
		<div class="alert_con">
			<p id="ts"></p>
			<p style="line-height:70px">
				<a class="btn">确定</a>
			</p>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/static/bower_components/jquery/jquery.min.js"></script>
	<script src="static/chat/js/supersized.3.2.7.min.js"></script>
	<script src="static/chat/js/supersized-init.js"></script>
	<script>
		$(".btn").click(function() {
			is_hide();
		})
		var u = $("input[name=userName]");
		var p = $("input[name=password]");
		$("#submit").click(function() {
			if (u.val() == '' || p.val() == '') {
				$("#ts").html("用户名或密码不能为空~");
				is_show();
				return false;
			} else {
				var reg = /^[0-9A-Za-z]+$/;
				if (!reg.exec(u.val())) {
					$("#ts").html("用户名错误");
					is_show();
					return false;
				}
			}
			$("#loginForm").submit();
		});
		window.onload = function() {
			$(".connect p").eq(0).animate({
				"left" : "0%"
			}, 600);
			$(".connect p").eq(1).animate({
				"left" : "0%"
			}, 400);
		}
		function is_hide() {
			$(".alert").animate({
				"top" : "-40%"
			}, 300)
		}
		function is_show() {
			$(".alert").show().animate({
				"top" : "45%"
			}, 300)
		}
	</script>
</body>
</html>
