<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../static/top.jsp"%>
<title>首页</title>
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
						<li><a href="#">Home</a></li>
						<li><a href="#">Dashboard</a></li>
					</ul>
				</div>

				<div class=" row">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<a data-toggle="tooltip" title="6 new members."
							class="well top-block" href="#"> <i
							class="glyphicon glyphicon-user blue"></i>

							<div>Total Members</div>
							<div>507</div> <span class="notification">6</span> </a>
					</div>

					<div class="col-md-3 col-sm-3 col-xs-6">
						<a data-toggle="tooltip" title="4 new pro members."
							class="well top-block" href="#"> <i
							class="glyphicon glyphicon-star green"></i>

							<div>Pro Members</div>
							<div>228</div> <span class="notification green">4</span> </a>
					</div>

					<div class="col-md-3 col-sm-3 col-xs-6">
						<a data-toggle="tooltip" title="$34 new sales."
							class="well top-block" href="#"> <i
							class="glyphicon glyphicon-shopping-cart yellow"></i>

							<div>Sales</div>
							<div>$13320</div> <span class="notification yellow">$34</span> </a>
					</div>

					<div class="col-md-3 col-sm-3 col-xs-6">
						<a data-toggle="tooltip" title="12 new messages."
							class="well top-block" href="#"> <i
							class="glyphicon glyphicon-envelope red"></i>

							<div>Messages</div>
							<div>25</div> <span class="notification red">12</span> </a>
					</div>
				</div>


				<div class="row">
					<div class="box col-md-4">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-list"></i> Buttons
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i> </a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i> </a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i> </a>
								</div>
							</div>
							<div class="box-content buttons">
								<p class="btn-group">
									<button class="btn btn-default">Left</button>
									<button class="btn btn-default">Middle</button>
									<button class="btn btn-default">Right</button>
								</p>
								<p>
									<button class="btn btn-default btn-sm">
										<i class="glyphicon glyphicon-star"></i> Icon button
									</button>
									<button class="btn btn-primary btn-sm">Small button</button>
									<button class="btn btn-danger btn-sm">Small button</button>
								</p>
								<p>
									<button class="btn btn-warning btn-sm">Small button</button>
									<button class="btn btn-success btn-sm">Small button</button>
									<button class="btn btn-info btn-sm">Small button</button>
								</p>
								<p>
									<button class="btn btn-inverse btn-default btn-sm">Small
										button</button>
									<button class="btn btn-primary btn-round btn-lg">Round
										button</button>
									<button class="btn btn-round btn-default btn-lg">
										<i class="glyphicon glyphicon-ok"></i>
									</button>
									<button class="btn btn-primary">
										<i class="glyphicon glyphicon-edit glyphicon-white"></i>
									</button>
								</p>
								<p>
									<button class="btn btn-default btn-xs">Mini button</button>
									<button class="btn btn-primary btn-xs">Mini button</button>
									<button class="btn btn-danger btn-xs">Mini button</button>
									<button class="btn btn-warning btn-xs">Mini button</button>
								</p>
								<p>
									<button class="btn btn-info btn-xs">Mini button</button>
									<button class="btn btn-success btn-xs">Mini button</button>
									<button class="btn btn-inverse btn-default btn-xs">Mini
										button</button>
								</p>
							</div>
						</div>
					</div>
					<!--/span-->

					<div class="box col-md-4">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-list"></i> Buttons
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i> </a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i> </a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i> </a>
								</div>
							</div>
							<div class="box-content  buttons">
								<p>
									<button class="btn btn-default btn-lg">Large button</button>
									<button class="btn btn-primary btn-lg">Large button</button>
								</p>
								<p>
									<button class="btn btn-danger btn-lg">Large button</button>
									<button class="btn btn-warning btn-lg">Large button</button>
								</p>
								<p>
									<button class="btn btn-success btn-lg">Large button</button>
									<button class="btn btn-info btn-lg">Large button</button>
								</p>
								<p>
									<button class="btn btn-inverse btn-default btn-lg">Large
										button</button>
								</p>
								<div class="btn-group">
									<button class="btn btn-default btn-lg">Large Dropdown</button>
									<button class="btn dropdown-toggle btn-default btn-lg"
										data-toggle="dropdown">
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#"><i class="glyphicon glyphicon-star"></i>
												Action</a>
										</li>
										<li><a href="#"><i class="glyphicon glyphicon-tag"></i>
												Another action</a>
										</li>
										<li><a href="#"><i
												class="glyphicon glyphicon-download-alt"></i> Something else
												here</a>
										</li>
										<li class="divider"></li>
										<li><a href="#"><i class="glyphicon glyphicon-tint"></i>
												Separated link</a>
										</li>
									</ul>
								</div>

							</div>
						</div>
					</div>
					<!--/span-->

					<div class="box col-md-4">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-list"></i> Weekly Stat
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i> </a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i> </a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i> </a>
								</div>
							</div>
							<div class="box-content">
								<ul class="dashboard-list">
									<li><a href="#"> <i
											class="glyphicon glyphicon-arrow-up"></i> <span class="green">92</span>
											New Comments </a></li>
									<li><a href="#"> <i
											class="glyphicon glyphicon-arrow-down"></i> <span class="red">15</span>
											New Registrations </a></li>
									<li><a href="#"> <i class="glyphicon glyphicon-minus"></i>
											<span class="blue">36</span> New Articles </a></li>
									<li><a href="#"> <i
											class="glyphicon glyphicon-comment"></i> <span class="yellow">45</span>
											User reviews </a></li>
									<li><a href="#"> <i
											class="glyphicon glyphicon-arrow-up"></i> <span class="green">112</span>
											New Comments </a></li>
									<li><a href="#"> <i
											class="glyphicon glyphicon-arrow-down"></i> <span class="red">31</span>
											New Registrations </a></li>
									<li><a href="#"> <i class="glyphicon glyphicon-minus"></i>
											<span class="blue">93</span> New Articles </a></li>
									<li><a href="#"> <i
											class="glyphicon glyphicon-comment"></i> <span class="yellow">254</span>
											User reviews </a></li>
								</ul>
							</div>
						</div>
					</div>
					<!--/span-->
				</div>
				<!--/row-->
				<!-- content ends -->
			</div>
			<!--/#content.col-md-0-->
		</div>
		<!--/fluid-row-->

		<!-- Ad, you can remove it -->
		<div class="row">
			<div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
				<script async
					src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<!-- Charisma Demo 2 -->
				<ins class="adsbygoogle"
					style="display:inline-block;width:728px;height:90px"
					data-ad-client="ca-pub-5108790028230107" data-ad-slot="3193373905"></ins>
				<script>
					(adsbygoogle = window.adsbygoogle || []).push({});
				</script>
			</div>
			<div
				class="col-md-2 col-lg-3 col-sm-12 col-xs-12 email-subscription-footer">
				<div class="mc_embed_signup">
					<form
						action="//halalit.us3.list-manage.com/subscribe/post?u=444b176aa3c39f656c66381f6&amp;id=eeb0c04e84"
						method="post" id="mc-embedded-subscribe-form"
						name="mc-embedded-subscribe-form" class="validate" target="_blank"
						novalidate>
						<div>
							<label>Keep up with my work</label> <input type="email" value=""
								name="EMAIL" class="email" placeholder="Email address" required>

							<div class="power_field">
								<input type="text" name="b_444b176aa3c39f656c66381f6_eeb0c04e84"
									tabindex="-1" value="">
							</div>
							<div class="clear">
								<input type="submit" value="Subscribe" name="subscribe"
									class="button">
							</div>
						</div>
					</form>
				</div>

				<!--End mc_embed_signup-->
			</div>

		</div>
		<!-- Ad ends -->

		<hr>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>Settings</h3>
					</div>
					<div class="modal-body">
						<p>Here settings can be configured...</p>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
						<a href="#" class="btn btn-primary" data-dismiss="modal">Save
							changes</a>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="../static/footer.jsp"%>

		<!--/.fluid-container-->
</body>
</html>
