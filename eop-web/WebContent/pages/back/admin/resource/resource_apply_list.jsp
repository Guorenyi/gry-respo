<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>  
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/resource/resource_apply_list.js" charset="utf-8"></script>
<%!
	public static final String SUPPLY_EDIT_URL = "pages/back/admin/resource/resource_Details_list.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="43"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;我的办公用品申请记录</strong>
			</div>
			<div class="panel-body">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center">申请记录</th> 
							<th class="text-center">申请日期</th>
							<th class="text-center">用品数量</th>
							<th class="text-center">金额</th>
							<th class="text-center">申请状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${empresourcelist}" var="empresource">
						<tr>
							<td class="text-center"><span id="resid-${empresource.eresid}" style="cursor:pointer;">${empresource.title}</span></td>
							<td class="text-center"><fmt:formatDate value="${empresource.subdate}" pattern="yyyy-MM-dd"/></td>
							<td class="text-center">${empresource.amount}</td>
							<td class="text-center">${empresource.money}</td>
							<td class="text-center">
							<c:forEach items="${resourceStatus }" var="status">
								<c:if test="${status.value==empresource.status }">${status.title}</c:if>
							</c:forEach>
							</td>
							<td><a type="button" class="btn btn-primary btn-xs" href="<%=SUPPLY_EDIT_URL%>?eresid=${empresource.eresid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;详情</a></td>
						</tr>
						</c:forEach>
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
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
