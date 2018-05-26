<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/supply/supply_apply_list.js"></script>
<%!
	public static final String SUPPLY_DETAILS_URL = "pages/back/admin/supply/supply_detail_list.action" ;
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
							<th class="text-center"><input id="checkAll" type="checkbox"></th>
							<th class="text-center">申请名称</th>
							<th class="text-center">购买数量</th>
							<th class="text-center">总价</th>
							<th class="text-center">申请状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead> 
					<tbody>
						<c:forEach items="${supplyList}" var="supply">
						<tr id="apply-${supply.spid}">
						    <th class="text-center"><input id="chb-${supply.spid}" type="checkbox"></th>
							<td class="text-center">${supply.title}</td>
							<td class="text-center">${supply.amount}</td>
							<td class="text-center">${supply.money}</td>
							
							<td class="text-center">
							
							<c:choose>
								<c:when test="${supply.status == 0}">
								<td class="text-center"><span style="color: purple">草稿</span></td>
								</c:when>
								<c:when test="${supply.status == 1}">
								<td class="text-center"><span style="color: yellow">等待审核</span></td>
								</c:when>
								<c:when test="${supply.status == 3}">
								<td class="text-center"><span style="color: green">审核通过</span></td>
								</c:when>
								<c:otherwise>
								<td class="text-center"><span style="color: red">审核未通过</span></td>
								</c:otherwise>
							</c:choose>
							
							</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=SUPPLY_DETAILS_URL%>?spid=${supply.spid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;详情</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
				</div>
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
