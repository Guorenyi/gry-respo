<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/supply/supply_apply_list.js"></script>
<%!
	public static final String SUPPLY_DETAILS_URL = "pages/back/admin/supply/supply_details_list.jsp" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="8"/>
			<jsp:param name="msi" value="82"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;资源采购申请单</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center">申请名称</th>
							<th class="text-center">购买数量</th>
							<th class="text-center">总价</th>
							<th class="text-center">申请状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">办公用品2020采购</td>
							<td class="text-center">50</td>
							<td class="text-center">￥20.00</td>
							<td class="text-center">未提交</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=SUPPLY_DETAILS_URL%>?reid=">
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
		<jsp:include page="/pages/plugins/back/admin/supply/supply_modal.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
