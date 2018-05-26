<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_career_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="22"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success"> 
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;员工职业背景&nbsp;<button type="button" class="btn btn-danger" id="addCareer">增加职业背景</button></strong>
			</div>
			<div class="panel-body">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">原公司名称</th> 
							<th class="text-center">职位</th>
							<th class="text-center">待遇</th>
							<th class="text-center">入职日期</th>
							<th class="text-center">离职日期</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allCareers }" var="car">
						<tr id="xxx-${car.ecarid }">
							<td class="text-center"><input type="checkbox" id="eid-${car.ecarid }" value="${car.ecarid }"></td>
							<td class="text-center">${car.company }</td> 
							<td class="text-center">${car.position }</td>
							<td class="text-center">${car.salary }</td>
							<td class="text-center">${car.entry }</td>
							<td class="text-center">${car.quit }</td>
							<td class="text-center">
								<button type="button" class="btn btn-primary btn-xs" id="edit-${car.ecarid }">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</button>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除职业背景</button>
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
	<jsp:include page="/pages/plugins/back/admin/emp/emp_career_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/admin/emp/emp_career_edit_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
