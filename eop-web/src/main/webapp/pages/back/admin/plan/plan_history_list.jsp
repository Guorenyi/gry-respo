<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/plan/plan_history_list.js"></script>
<%!
	public static final String PLAN_DETAILS_URL = "pages/back/admin/plan/plan_details_list.jsp" ;
	public static final String PLAN_PUBLIC_URL = "" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="5"/>
			<jsp:param name="msi" value="52"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;历史任务</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">任务名称</th>
							<th class="text-center">任务类型</th>
							<th class="text-center">开始日期时间</th>
							<th class="text-center">结束日期时间</th>
							<th class="text-center">任务人数</th>
							<th class="text-center">任务状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center"><input type="checkbox" id="misid-1" value="1"></td>
							<td class="text-center"><span id="re-1" style="cursor:pointer;">小强陪洗任务</span></td>
							<td class="text-center">部门工作</td>
							<td class="text-center">2019-10-10 09:00:00</td>
							<td class="text-center">2019-10-10 21:00:00</td>
							<td class="text-center">9</td>
							<td class="text-center">草稿</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=PLAN_DETAILS_URL%>?reid=">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;详情</a>
								<button type="button" class="btn btn-primary btn-xs" id="pub-1">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;任务发布</button>
							</td>
						</tr>
					</tbody>
				</table>
				<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除未开始任务</button>
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
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
