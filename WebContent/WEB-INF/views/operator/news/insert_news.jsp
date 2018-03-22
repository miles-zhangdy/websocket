<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<%
	String contextPath = request.getContextPath();
	String httpPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ contextPath + "/";
%>
<base href="<%=httpPath%>">	
<link href="static/css/upload/zyUpload.css"  rel="stylesheet" />
<script src="static/js/jquery-2.1.1.js"></script>
<body>
<div id="picupload" class="picupload">
</div>
<script src="static/js/upload/zyUpload.js"></script>
<script src="static/js/upload/zyFile.js"></script>
<script src="static/js/upload/upload.js"></script>
</body>
</html>