<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String contextPath = request.getContextPath();
	String httpPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ contextPath + "/";
%>
<base href="<%=httpPath%>">	
<!DOCTYPE HTML>
<html>
  <head>
  	
    <link href="${pageContext.request.contextPath}/static/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/static/css/charisma-app.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/bower_components/fullcalendar/dist/fullcalendar.css" rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${pageContext.request.contextPath}/static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/jquery.noty.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/noty_theme_default.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/elfinder.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/elfinder.theme.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/uploadify.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/static/css/animate.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="static/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script src="${pageContext.request.contextPath}/static/bower_components/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="static/js/ztree/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript" src="static/js/ztree/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="static/js/ztree/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="static/js/ztree/jquery.ztree.exedit-3.5.js"></script>
	<script type="text/javascript" src="static/js/ztree/jquery.ztree.exhide-3.5.js"></script>
	

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
  	
  	<script src="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.cookie.js"></script>
	<script src='${pageContext.request.contextPath}/static/bower_components/moment/min/moment.min.js'></script>
	<script src='${pageContext.request.contextPath}/static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<script src='${pageContext.request.contextPath}/static/js/jquery.dataTables.min.js'></script>
	<script src="${pageContext.request.contextPath}/static/bower_components/chosen/chosen.jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.noty.js"></script>
	<script src="${pageContext.request.contextPath}/static/bower_components/responsive-tables/responsive-tables.js"></script>
	<script src="${pageContext.request.contextPath}/static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.raty.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.iphone.toggle.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.autogrow-textarea.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.uploadify-3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.history.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/charisma.js"></script>
	<%--   	<script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jqueryValidationExtend.js"></script> --%>
  </head>
  <script>
  	var ctx = '${pageContext.request.contextPath}';
  </script>
  <body>
  </body>
</html>
