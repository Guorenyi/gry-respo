<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/dept/dept_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="12"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;部门信息列表</strong>
			</div>
			<div class="panel-body">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-left" style="width:30%;">部门名称</th> 
							<th class="text-left" style="width:10%;">名额上限</th>
							<th class="text-center" style="width:30%;">领导姓名</th>
							<th class="text-center" style="width:10%;">当前员工数</th>
							<th class="text-center" style="width:20%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center"><input type="text" id="dname-1" class="form-control" value="技术部" style="width:400px;"></td>
							<td class="text-center"><input type="text" id="maxnum-1" class="form-control" value="10" style="width:100px;"></td>
							<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td> 
							<td class="text-center"><span class="text-danger">10</span></td>
							<td class="text-center">
								<button id="edit-1" class="btn btn-warning">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</button>
							</td>
						</tr>
						<tr>
							<td class="text-center"><input type="text" id="dname-2" class="form-control" value="市场部" style="width:400px;"></td>
							<td class="text-center"><input type="text" id="maxnum-2" class="form-control" value="10" style="width:100px;"></td>
							<td class="text-center"><span id="eid-7566" style="cursor:pointer;">老李</span></td>
							<td class="text-center"><span class="text-success">2</span></td>
							<td class="text-center">
								<button id="edit-2" class="btn btn-warning">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer" style="height:100px;">
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
	<jsp:include page="/pages/plugins/back/info/emp_complete_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
