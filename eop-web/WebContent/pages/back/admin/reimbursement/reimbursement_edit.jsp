<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<%
	String REIMBURSEMENT_EDIT_URL = request.getAttribute("basePath") + "pages/back/admin/reimbursement/reimbursement_edit.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/reimbursement/reimbursement_edit.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="3"/>
			<jsp:param name="msi" value="32"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;编辑报销单</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=REIMBURSEMENT_EDIT_URL%>" id="myform" method="post">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="title">申请名称：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" value="${vo.title }" name="title" class="form-control"
										placeholder="请输入报销单申请的名称.">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="titleMsg"></div>
							</div>
							<div class="form-group" id="moneyDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="money">申请金额：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="money" readonly="readonly" name="money" value="${vo.money }" class="form-control"
										placeholder="请输入报销单申请的金额.">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="moneyMsg"></div>
							</div>
							<div class="form-group" id="typeDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="type">报销类型：</label>
								<div class="col-md-7">
									<select id="item" name="item" class="form-control">
										<option value="">====== 请选择报销类型 ======</option>
										<c:forEach items="${allType}" var="type">
											<option value="${type.dctid}" ${type.dctid==vo.item ? "selected" : "" }>
											${type.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="typeMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="note">备注信息：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入本次报销的详细描述" rows="10">${vo.note}</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<input type="hidden" id="rbsid" name="rbsid" value="${vo.rbsid}">
									<button type="submit" class="btn btn-primary">更新</button>
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
