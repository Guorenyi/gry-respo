<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String login_url = request.getAttribute("basePath") + "/login.action" ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="/pages/plugins/common.jsp"/> 



<link rel="stylesheet" type="text/css" href="css/mldn.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="jquery/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div class="top-content">
		<div class="inner-bgx">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top"> 
							<div class="form-top-left">
								<h3>MLDN企业办公平台</h3>
							</div> 
							<div class="form-top-right">
								<i class="fa fa-lock"><img src="images/login-lock.png"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="<%=login_url%>" method="post" class="form-horizontal" id="myform">
								<div class="form-group" id="eidDiv">
									<div class="col-md-12">
										<!-- 定义表单输入组件 -->
										<input type="text" id="eid" name="eid" class="form-control"
											placeholder="请输入登录帐号">
									</div>
								</div>
								<div class="form-group" id="passwordDiv">
									<div class="col-md-12">
										<!-- 定义表单输入组件 -->
										<input type="password" id="password" name="password" class="form-control"
											placeholder="请输入登录密码...">
									</div>
								</div>
								<div class="form-group" id="codeDiv">
									<div class="col-md-6">
										<!-- 定义表单输入组件 -->
										<input type="text" id="code" name="code" class="form-control"
											placeholder="验证码..." size="4" maxlength="4" style="width:410px;">
									</div>  
									<div class="col-md-1 col-md-push-3"><img id="imageCode" src="ImageCode"></div>
									<div class="col-md-2 col-md-pull-1"></div>
								</div> 
								<button type="submit" class="btn">登录系统</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
