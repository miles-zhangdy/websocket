<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="static/top.jsp"%>

<title>账户注册</title>
</head>
<body>
	<div class="ch-container">
		<div class="row">

			<div class="row">
				<div class="col-md-12 center login-header">
					<h2>请输入注册信息</h2>
				</div>
				<!--/span-->
			</div>
			<!--/row-->

			<div class="row">
				<div class="well col-md-5 center login-box">
					<form class="form-horizontal" id="registerForm"
						action="${pageContext.request.contextPath}/portal/register/register"
						method="post">
						<fieldset>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user red"></i> </span> <input type="text"
									class="form-control" name="userName" id="userName" required maxlength="30"
									minlength="6" placeholder="用户名">
							</div>
							<div class="clearfix"></div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user red"></i> </span> <input type="text" required
									class="form-control" name="nickname" id="nickname" maxlength="20" minlength="3"
									placeholder="昵称">
							</div>
							<div class="clearfix"></div>
							<br>

							<div class="input-group input-group-lg">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock red"></i> </span> 
								<input type="password" id="password" name="password"
								maxlength="20" minlength="6" required
									class="form-control" placeholder="密码">
							</div>
							<div class="clearfix"></div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock red"></i> </span> 
								<input type="password" name="eqpassword" id="eqpassword"
								maxlength="20" minlength="6" required equalTo="#password"
									class="form-control" placeholder="重复密码">
							</div>
							<div class="clearfix"></div>
							<br>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope red"></i> </span> 
									<input type="text" name="email" id="email" class="form-control" 
									maxlength="30" minlength="6" required  email="true"
									placeholder="邮箱">
							</div>
							<div class="clearfix"></div>
							<p class="center col-md-5">
								<button type="submit" class="btn btn-primary">注册</button>
							</p>
						</fieldset>
					</form>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
		</div>
		<!--/fluid-row-->

	</div>
	<!--/.fluid-container-->
</body>
<script>
/* 	validateRegisterForm();
	function validateRegisterForm() {
		$("#registerForm").validate({
			submitHandler : function(form) {
				alert("提交事件!");
			}
		});
	} */
</script>
</html>

