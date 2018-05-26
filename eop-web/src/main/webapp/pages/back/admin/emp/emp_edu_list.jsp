<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_edu_list.js"></script>
<%!
	public static final String EMP_EDIT_URL = "pages/back/admin/emp/emp_edit.jsp" ;
	public static final String EMP_EDU_URL = "pages/back/admin/emp/emp_edit.jsp" ;
	public static final String EMP_CAREER_URL = "pages/back/admin/emp/emp_edit.jsp" ;
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;员工教育背景&nbsp;<button type="button" class="btn btn-danger" id="addEdu">增加教育背景</button></strong>
			</div>
			<div class="panel-body">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">学校</th> 
							<th class="text-center">学历</th>
							<th class="text-center">专业</th>
							<th class="text-center">入学日期</th>
							<th class="text-center">毕业日期</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center"><input type="checkbox" id="eid-1" value="1"></td>
							<td class="text-center">清华大学</td> 
							<td class="text-center">本科</td>
							<td class="text-center">计算机科学与技术</td>
							<td class="text-center">1998-09-01</td>
							<td class="text-center">2002-07-20</td>
							<td class="text-center">
								<button type="button" class="btn btn-primary btn-xs" id="edit-1">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</button>
							</td>
						</tr>
					</tbody>
				</table>
				<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除教育背景</button>
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
	<jsp:include page="/pages/plugins/back/admin/emp/emp_edu_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
