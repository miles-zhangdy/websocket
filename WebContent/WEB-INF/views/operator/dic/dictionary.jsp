<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../static/top.jsp"%>
<title>数据字典</title>
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
						<li><a href="#">数据字典</a>
						</li>
					</ul>
				</div>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> 数据字典管理
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
									数据字典
								</div>
								<table class="table table-striped table-bordered bootstrap-datatable" id="dictionaryTable">
									<thead>
										<tr>
											<th>字典名称</th>
											<th>字典编码</th>
											<th>添加时间</th>
											<th>操作</th>
										</tr>
									</thead>
								</table>
								<div class="row">
									<div class="col-md-12 col-md-offset-5">
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

			<div class="modal-dialog" style="width:600px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>添加字典</h3>
					</div>
					<form class="form-horizontal validate" id="insertDictionaryform">
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">字典名称</label>
								<div class="col-sm-7">
									<input name="dicName" id="dicName" type="text" 
										class="form-control">
								</div>
							</div>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">字典编码</label>
								<div class="col-sm-7">
									<input name="dicCode" id="dicCode" type="text" 
										class="form-control">
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

	<div class="modal fade" id="insertValueModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog" style="width:600px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>字典值</h3>
					</div>
					<form class="form-horizontal validate" id="insertDictionaryValueform">
						<input type="hidden" name="dicId" id="dicId"  >
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">字典值名称</label>
								<div class="col-sm-7">
									<input name="valueName" id="valueName" type="text" 
										class="form-control">
								</div>
							</div>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">字典值编码</label>
								<div class="col-sm-7">
									<input name="valueCode" id="valueCode" type="text" 
										class="form-control">
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
	<script src="pages/operator/dic/dictionary.js"></script>
	<!--/.fluid-container-->
</body>
</html>
