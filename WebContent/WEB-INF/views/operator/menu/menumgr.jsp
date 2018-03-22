<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../static/top.jsp"%>
<title>菜单管理</title>
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
						<li><a href="#">菜单管理</a>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> 菜单管理
								</h2>
								<div class="box-icon">
								 <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
									 <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i> </a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i> </a>
								</div>
							</div>
							<div class="box-content">
								<div class="alert alert-info">
									菜单管理
								</div>
								<table class="table table-striped table-bordered bootstrap-datatable" id="menuTable">
									<thead>
										<tr>
											<th>菜单名称</th>
											<th>菜单url</th>
											<th>菜单级别</th>
											<th>添加时间</th>
											<th>操作</th>
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

		

	<div class="modal fade" id="childMenuModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog" style="width:800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<div class="row">
							<div class="col-md-3">
								<h3>菜单列表</h3>
							</div>
							<div class="col-md-2 col-md-offset-7">
								<button type="button" class="btn btn-default" id="insertChildMenuBtn" val="">添加子菜单</button>
							</div>
						</div>
					</div>
					<div class="modal-body">
						<table class="table table-striped table-bordered bootstrap-datatable" id="childMenuTable">
							<thead>
								<tr>
									<th>菜单名称</th>
									<th>菜单url</th>
									<th>菜单级别</th>
									<th>添加时间</th>
									<th>操作</th>
								</tr>
							</thead>
						</table>
						<div class="row">
							<div class="col-md-12">
								<div id="childPageTable" class="pagination"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button href="#" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog" style="width:800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>添加菜单</h3>
					</div>
					<form class="form-horizontal validate" id="insertMenuform">
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单名称</label>
								<div class="col-sm-7">
									<input name="menuName" id="menuName" type="text" maxlength=20
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单地址</label>
								<div class="col-sm-7">
									<input name="menuUrl" id="menuUrl" type="text" 
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">是否有效</label>
								<div class="col-sm-7">
								    <div class="radio">
					                    <label>
					                        <input type="radio" name="aliveFlag" value="1" checked>是
					                    </label>
					                      <label>
					                        <input type="radio" name="aliveFlag" value="0" >否
					                    </label>
					                </div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-7">
								   <textarea name="remark" id="remark" class="form-control" rows="6"></textarea>
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

	<div class="modal fade" id="insertChildModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog" style="width:800px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>添加菜单</h3>
					</div>
					<form class="form-horizontal validate" id="insertChildMenuform">
						<input type="hidden" name="parentId" id="parentId">
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单名称</label>
								<div class="col-sm-7">
									<input name="menuName" id="menuName" type="text" maxlength=20
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单地址</label>
								<div class="col-sm-7">
									<input name="menuUrl" id="menuUrl" type="text" 
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">是否有效</label>
								<div class="col-sm-7">
								    <div class="radio">
					                    <label>
					                        <input type="radio" name="aliveFlag" value="1" checked>是
					                    </label>
					                      <label>
					                        <input type="radio" name="aliveFlag" value="0" >否
					                    </label>
					                </div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-7">
								   <textarea name="remark" id="remark" class="form-control" rows="6"></textarea>
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
	</script>
	<script src="pages/operator/menu/menumgr.js"></script>
</body>
</html>
