<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String contextPath = request.getContextPath();
	String httpPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
%>
<base href="<%=httpPath%>">
<!DOCTYPE HTML>
<html>
<head>
<title>jQuery WebGL Ripples</title>
<style>
* {
	margin: 0;
	padding: 0;
}

html {
	height: 100%;
}

body {
	color: #fff;
	font-size: 16px;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	background-image: url(static/portal/images/bg2.jpg);
	background-size: cover;
	background-position: 50% 0;
	height: 90%;
	text-align: center;
}

body:before {
	content: '';
	display: inline-block;
	vertical-align: middle;
	height: 100%;
}

main {
	display: inline-block;
	vertical-align: middle;
	background: url(static/portal/images/bg.jpg);
	padding: 150px;
	max-width: 400px;
	text-shadow: 0 1px 2px rgba(0, 0, 0, 0.5);
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.5);
}

h1 {
	font-size: 32px;
}

h2 {
	font-size: 18px;
	margin-top: 6px;
}

p {
	text-align: left;
	margin-top: 20px;
}

a {
	color: #ff6800;
}

pre {
	text-align: left;
	margin-top: 20px;
}

.error {
	display: none;
	position: fixed;
	bottom: 0;
	left: 0;
	background: #000;
	color: #f00;
	padding: 5px;
	max-width: 50%;
}

.disable {
	position: fixed;
	bottom: 0;
	right: 0;
	max-width: 50%;
}
</style>
</head>
<body>
	<div class="error"></div>

	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="static/portal/js/jquery.ripples.js"></script>
	<script>
		$(document).ready(function() {
			try {
				$('body').ripples({
					resolution : 512,
					dropRadius : 20, //px
					perturbance : 0.04,
				});
				$('main').ripples({
					resolution : 128,
					dropRadius : 10, //px
					perturbance : 0.04,
				});
			} catch (e) {
				$('.error').show().text(e);
			}

			$('.disable').show().on('click', function() {
				$('body, main').ripples('destroy');
				$(this).hide();
			});
		});
	</script>
</body>
</html>