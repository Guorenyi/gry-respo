<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/finance/finance_reimbursement_apply_list.js"></script>
<%!
	public static final String FINANCE_REIMBURSEMENT_APPLY_HANDLE_URL = "pages/back/admin/finance/finance_reimbursement_apply_handle.jsp" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="71"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;报销单申请列表</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center">名称</th>
							<th class="text-center">申请人</th>
							<th class="text-center">报销类型</th>
							<th class="text-center">报销金额</th>
							<th class="text-center">创建日期</th>
							<th class="text-center">申请日期</th>
							<th class="text-center">申请状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">出差费用</td>
							<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td>
							<td class="text-center">差旅</td>
							<td class="text-center">28383.00</td>
							<td class="text-center">2019-10-10</td>
							<td class="text-center">2019-10-10</td>
							<td class="text-center">未提交</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=FINANCE_REIMBURSEMENT_APPLY_HANDLE_URL%>?reid=">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;详情</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
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
		<jsp:include page="/pages/plugins/back/info/emp_info_modal.jsp"/>
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
