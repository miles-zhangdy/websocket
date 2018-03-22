<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ssm.common.model.EnvironmentUserVO"%>
<%@ page import="com.ssm.util.Const"%>
<div class="navbar navbar-default" role="navigation">

	<div class="navbar-inner">
		<button type="button" class="navbar-toggle pull-left animated flip">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="admin/index"> <img
			alt="Charisma Logo"
			src="static/img/logo20.png"
			class="hidden-xs" /> <span>zhangdy</span> </a>

		<!-- user dropdown starts -->
		<div class="btn-group pull-right">
			<button class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<i class="glyphicon glyphicon-user"></i><span
					class="hidden-sm hidden-xs"><%-- ${userVO.nickname } --%></span> <span
					class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#">Profile</a>
				</li>
				<li class="divider"></li>
				<li><a href="admin/logout">退出</a>
				</li>
			</ul>
		</div>
		<!-- user dropdown ends -->
       <ul class="collapse navbar-collapse nav navbar-nav top-menu">
          <c:forEach var="menuVO"  items="${menuList1 }" varStatus="status">
           		 <li <c:if test="${parentId eq menuVO.menuId }"> class="active" </c:if>  >
           		 <a href="/${menuVO.menuUrl}/${menuVO.menuId}">${menuVO.menuName }</a></li>
           </c:forEach>
       </ul>
		
	</div>
</div>
