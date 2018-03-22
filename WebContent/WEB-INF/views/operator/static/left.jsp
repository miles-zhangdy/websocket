<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- left menu starts -->
<div class="col-sm-2 col-lg-2">
	<div class="sidebar-nav">
		<div class="nav-canvas">
			<div class="nav-sm nav nav-stacked"></div>
			<ul class="nav nav-pills nav-stacked main-menu">
				<li class="nav-header">功能菜单</li>
				<%-- <li>
					<a class="ajax-link" href="${ctx}/admin/index">
						<i class="glyphicon glyphicon-home"></i>
						<span>首页</span> 
					</a>
				</li> --%>
				<c:forEach items="${menuList2}" var="menuvo" varStatus="status">
					<li>
						<a class="ajax-link" href="${menuvo.menuUrl}?parentId=${menuvo.parentId}">
							<span>${menuvo.menuName }</span>
						</a>
					</li>
				</c:forEach>
			<!-- <li><a class="ajax-link" href="admin/dictionary/dictionarypage"><i
						class="glyphicon glyphicon-book"></i><span>数据字典</span> </a></li>
				<li> -->
			</ul>
		</div>
	</div>
</div>
<!--/span-->
<!-- left menu ends -->

<noscript>
	<div class="alert alert-block col-md-12">
		<h4 class="alert-heading">Warning!</h4>

		<p>
			You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
				target="_blank">JavaScript</a> enabled to use this site.
		</p>
	</div>
</noscript>
