<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String contextPath = request.getContextPath();
	String httpPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ contextPath + "/";
%>
<script>
</script>
<base href="<%=httpPath%>">	
<link href="static/css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="static/css/charisma-app.css" rel="stylesheet">
<link href="static/bower_components/fullcalendar/dist/fullcalendar.css" rel='stylesheet'>
<link href='static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
<link href='static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
<link href='static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
<link href='static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='static/css/jquery.noty.css' rel='stylesheet'>
<link href='static/css/noty_theme_default.css' rel='stylesheet'>
<link href='static/css/elfinder.min.css' rel='stylesheet'>
<link href='static/css/elfinder.theme.css' rel='stylesheet'>
<link href='static/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='static/css/uploadify.css' rel='stylesheet'>
<link href='static/css/animate.min.css' rel='stylesheet'>
<!-- <link href="static/css/jsTree/style.min.css" rel="stylesheet"> -->
<link href="static/css/sweetalert/sweetalert.css" rel="stylesheet">
<script src="static/js/jquery-1.7.1.min.js"></script>
<!-- <script src="static/js/jstree.min.js"></script> -->
 <link rel="stylesheet" href="static/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="static/js/ztree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="static/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="static/js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="static/js/ztree/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="static/js/ztree/jquery.ztree.exhide-3.5.js"></script>
	
<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!-- The fav icon -->
<link rel="shortcut icon" href="static/img/favicon.ico">

<script src="static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="static/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='static/bower_components/moment/min/moment.min.js'></script>
<script src='static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='static/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="static/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="static/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="static/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="static/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="static/js/jquery.history.js"></script>
<script src="static/js/sweetalert/sweetalert-dev.js"></script>
<!-- application script for Charisma demo -->
<script src="static/js/charisma.js"></script>
<script src="static/js/jquery.table.js"></script>
<script src="static/js/jqPaginator.min.js"></script>
<script src="static/js/jquery.validate.min.js"></script>
<script src="static/js/jqueryValidationExtend.js"></script>
