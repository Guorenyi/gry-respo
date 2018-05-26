<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/reimbursement/reimbursement_list.js"></script>
<%!
	public static final String REIMBURSEMENT_DETAILS_URL = "pages/back/admin/reimbursement/reimbursement_details_list.action" ;
	public static final String REIMBURSEMENT_EDIT_URL = "pages/back/admin/reimbursement/reimbursement_editPre.action" ;
	public static final String REIMBURSEMENT_APPLY_URL = "pages/back/admin/reimbursement/reimbursement_editApply.action" ;
%>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;报销单信息列表</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">名称</th>
							<th class="text-center">报销类型</th>
							<th class="text-center">报销金额</th>
							<th class="text-center">创建日期</th>
							<th class="text-center">申请日期</th>
							<th class="text-center">申请状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allReims}" var="reim">
						<tr>
							<td class="text-center"><input type="checkbox" id="rbsid" value="${reim.rbsid }"></td>
							<td class="text-center">${reim.title}</td>
							<td class="text-center"><span id="re-${reim.rbsid}" style="cursor:pointer;">
							<c:forEach items="${allType}" var="type">
							${reim.item == type.dctid ? type.title : ""} 
							</c:forEach>							
							</span></td>							
							<td class="text-center">${reim.money}</td>
							<td class="text-center">${reim.credate}</td>
							<td class="text-center">${reim.subdate}</td>
							<c:choose>
							<c:when test="${reim.status == 0}">
							<td class="text-center"><span style="color: purple">草稿</span></td>
							</c:when>
							<c:when test="${reim.status == 1}">
							<td class="text-center"><span style="color: yellow">等待审核</span></td>
							</c:when>
							<c:when test="${reim.status == 2}">
							<td class="text-center"><span style="color: green">审核通过</span></td>
							</c:when>
							<c:otherwise>
							<td class="text-center"><span style="color: red">审核失败</span></td>
							</c:otherwise>
							</c:choose>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=REIMBURSEMENT_EDIT_URL%>?rbsid=${reim.rbsid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;修改信息</a>
								<a type="button" class="btn btn-primary btn-xs" href="<%=REIMBURSEMENT_DETAILS_URL%>?rbsid=${reim.rbsid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;详情</a>
								<a type="button" class="btn btn-primary btn-xs" href="<%=REIMBURSEMENT_APPLY_URL%>?rbsid=${reim.rbsid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;提交申请</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<button class="btn btn-danger" id="delBut"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除未处理报销单</button>
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
