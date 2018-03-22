<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../static/top.jsp"%>
<title>角色管理</title>
</head>

<body>
	<%@ include file="../static/header.jsp"%>
	<div class="ch-container">
		<div class="row">
			<%@ include file="../static/left.jsp"%>
			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div>
					<ul class="breadcrumb">
						<li><a href="#">首页</a>
						</li>
						<li><a href="#">角色管理</a>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> 角色管理
								</h2>
								<div class="box-icon">
								 <a href="javascript:void(0)" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
									 <a href="javascript:void(0)"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i> </a> <a href="javascript:void(0)"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i> </a>
								</div>
							</div>
							<div class="box-content">
								<div class="alert alert-info">
									角色管理
								</div>
								<table class="table table-striped table-bordered bootstrap-datatable" id="roleTable">
									<thead>
										<tr>
											<td>角色名称</td>
											<td>添加时间</td>
											<td>操作</td>
										</tr>
									</thead>
								</table>
								<div class="row">
									<div class="col-md-12">
										<div id="pagetable" class="pagination"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--/span-->
				</div>
				<!--/row-->
			</div>
			<!--/#content.col-md-0-->
		</div>
		<!--/fluid-row-->
		<hr>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width:800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>添加角色</h3>
					</div>
					<form class="form-horizontal validate" id="insertMenuform">
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label"></label>
								<div class="col-sm-7">
									<input name="menuName" id="menuName" type="text" maxlength=20
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"></label>
								<div class="col-sm-7">
									<div id="menuTree" class="ztree">
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button href="#" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">保存</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="../static/footer.jsp"%>

	</div>
	<script>
		var dataInfo = ${data};
		var menuList = ${menuList};
	</script>
	<script src="pages/operator/role/rolemgr.js"></script>
</body>
</html>
