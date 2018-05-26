<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/reimbursement/reimbursement_details_list.js"></script>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;报销单详情</strong>
			</div>
			<div class="panel-body">
				<div id="reimbursementInfoDiv" class="row">
					<div class="col-xs-12">
						<table class="table table-condensed table-striped table-hover">
							<tr>
								<td style="width:20%;"><strong>报销申请单名称：</strong></td>
								<td>为了报销而报销的报销</td>
							</tr>
							<tr>
								<td><strong>总费用：</strong></td>
								<td><span id="cost">￥2332</span></td>
							</tr>
							<tr>
								<td><strong>报销单说明：</strong></td>
								<td>我们一起去改变吧</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="detailsTable" class="row">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th width="10%" class="text-center"><input type="checkbox" id="selall"></th>
								<th width="50%" class="text-center">名称</th>
								<th width="20%" class="text-center">费用</th>
								<th width="20%" class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center"><input type="checkbox" id="re-1" value="1"></td>
								<td class="text-center">车票</td>
								<td class="text-center">2.0</td>
								<td class="text-center">
									<button type="button" class="btn btn-primary btn-xs" id="rdtid-1">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</button>
								</td>
							</tr>
						</tbody>
					</table>
					<button class="btn btn-primary" id="addBtn"><span class="glyphicon glyphicon-file"></span>&nbsp;增加报销项</button>
					<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除报销项</button>
				</div>
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
		<jsp:include page="/pages/plugins/back/admin/reimbursement/reimbursement_modal.jsp"/> 
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
