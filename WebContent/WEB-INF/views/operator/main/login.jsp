<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="../static/top.jsp"%>
<title>登录</title>
</head>
<body>
	<div class="ch-container">
		<div class="row">

			<div class="row">
				<div class="col-md-12 center login-header">
					<h2>请输入账号信息</h2>
				</div>
				<!--/span-->
			</div>
			<!--/row-->

			<div class="row">
				<div class="well col-md-5 center login-box">
					<form class="form-horizontal" id="registerForm"
						action="admin/login"
						method="post">
													<input type="hidden" name="token" id="token" value="${token }">
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
									class="glyphicon glyphicon-lock red"></i> </span> 
								<input type="password" id="password" name="password"
								maxlength="20" minlength="6" required
									class="form-control" placeholder="密码">
							</div>
							<div class="clearfix"></div>
							<br>
							<div class="row">
								<div class="col-md-6">
									<div class="input-group input-group-lg">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-eye-open red"></i> </span> 
										<input type="text" id="validateCode" name="validateCode" 
											maxlength="4"  required class="form-control" placeholder="验证码">
									</div>
								</div>
								<div class="col-md-6">
									<img src="/" id="validatiCodeImg"  style="padding-top: 10px; height:40px">
									<a onclick="checkImg()" style="margin:20px">换一张</a>
								</div>
							</div>
							<div class="clearfix"></div>
							<br>
							<p class="center col-md-5">
								<button type="submit" class="btn btn-primary">登录</button>
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
$(function(){
	checkImg();
});

function checkImg(){
	var data = Math.random();
	$("#validatiCodeImg").attr('src',"${pageContext.request.contextPath}/action/validatecode/getValidateCode?data="+data);
}


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

