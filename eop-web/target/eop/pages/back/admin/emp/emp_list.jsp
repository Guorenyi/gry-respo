<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_list.js"></script>
<%
	String EMP_EDIT_URL = request.getAttribute("basePath") + "pages/back/admin/emp/emp_edit_pre.action" ;
	String EMP_EDU_URL = request.getAttribute("basePath") + "pages/back/admin/emp/emp_edu_list.action" ;
	String EMP_CAREER_URL = request.getAttribute("basePath") + "pages/back/admin/emp/emp_career_list.action" ;
%>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;雇员信息列表</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">照片</th> 
							<th class="text-center">姓名</th>
							<th class="text-center">级别</th>
							<th class="text-center">所在部门</th>
							<th class="text-center">雇佣日期</th>
							<th class="text-center">基本工资</th>
							<th class="text-center">联系电话</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${allEmps}" var="emp">
						<tr id="ooo--${emp.eid }">
							<td class="text-center"><input type="checkbox" id="eid--${emp.eid }" value="${emp.eid }"></td>
							<td class="text-center">
								<img src="upload/${emp.photo }" style="width:20px;"/> 
							</td> 
							<td class="text-center"><span id="eid--${emp.eid}" style="cursor:pointer;">${emp.ename }</span></td>
							<td class="text-center">
							<c:forEach items="${allLevels}" var="level">
							${emp.lid == level.lid ? level.title : ""}
							</c:forEach>
							</td>
							<td class="text-center">
							<c:forEach items="${allDepts}" var="dept">
							${dept.did == emp.did ? dept.dname : "" }
							</c:forEach>
							</td>
							<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${emp.hiredate }"/></td>
							<td class="text-center">${emp.salary}</td>
							<td class="text-center">${emp.phone }</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=EMP_EDIT_URL%>?eid=${emp.eid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;基本信息</a>
								<a type="button" class="btn btn-primary btn-xs" href="<%=EMP_EDU_URL%>?eid=${emp.eid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;教育背景</a>
								<a type="button" class="btn btn-primary btn-xs" href="<%=EMP_CAREER_URL%>?eid=${emp.eid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;工作经历</a> 
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<button class="btn btn-danger" id=rmBtn><span class="glyphicon glyphicon-remove"></span>&nbsp;删除雇员</button>
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
		<jsp:include page="/pages/plugins/back/info/emp_complete_info_modal.jsp"/>
		<jsp:include page="/pages/plugins/back/admin/supply/supply_img_modal.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
