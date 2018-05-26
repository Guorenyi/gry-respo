<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<%!
	public static final String PLAN_ADD_URL = "/eop/pages/back/admin/plan/plan_add.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/plan/plan_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="5"/>
			<jsp:param name="msi" value="51"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;工作任务安排</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=PLAN_ADD_URL%>" id="myform" method="post">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="title">任务名称：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" name="title" class="form-control"
										placeholder="请输入要创建的任务名称.">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="titleMsg"></div>
							</div>
							<div class="form-group" id="itemDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="item">任务类型：</label>
								<div class="col-md-7">
									<select id="type" name="item" class="form-control">
										<option value="">====== 请选择任务安排类型 ======</option>
										<c:forEach items="${all}" var="planDictory">
											<option value="${planDictory.title}">${planDictory.title}</option>
										</c:forEach>

									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="itemMsg"></div>
							</div>
							<div class="form-group" id="starttimeDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="starttime">开始时间：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="start" name="starttime" class="form-control"
										placeholder="请选择任务开始时间">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="starttimeMsg"></div>
							</div>
							<div class="form-group" id="endtimeDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="endtime">结束时间：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="end" name="endtime" class="form-control"
										placeholder="请选择任务结束时间">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="endtimeMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="note">备注信息：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入本次任务安排的详细描述" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">创建</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
					
						</fieldset>
					</form>
				</div>
				<div class="panel-footer">
					<jsp:include page="/pages/plugins/include_alert.jsp"/>
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
