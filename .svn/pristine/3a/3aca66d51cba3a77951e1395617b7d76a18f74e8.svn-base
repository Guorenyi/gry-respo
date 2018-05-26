<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<%!
	public static final String RESOURCE_APPLY_ADD_URL = "pages/back/admin/resource/resource_apply_add.jsp" ;
%>
<script type="text/javascript" src="js/pages/back/admin/resource/resource_undraw_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="42"/> 
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;办公资源待领取列表</strong>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th width="10%" class="text-center"><input type="checkbox" id="selall"></th>
									<th width="50%" class="text-center">名称</th>
									<th width="10%" class="text-center">单价</th>
									<th width="20%" class="text-center">数量</th>
									<th width="10%" class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center"><input type="checkbox" id="reuid-1" value="1"></td>
									<td class="text-center"><span id="re-1" style="cursor:pointer;">小强版画板</span></td>
									<td class="text-center"><span id="price-1">19.8</span></td>
									<td class="text-center">
										<button class="btn btn-primary" id="sub-1">-</button>
										<input type="text" id="amount-1" name="amount-1" class="shopcar-form-control " size="4" maxlength="4" value="20">
										<button class="btn btn-primary" id="add-1">+</button> 
									</td>
									<td class="text-center">
										<button class="btn btn-primary" id="updateBtn-2">修改</button>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="text-right">
							总价￥<span id="allPrice" class="text-danger h2">78.9</span>
						</div>
						<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;移除待领清单</button>
						<a class="btn btn-primary" id="applyBtn" href="<%=RESOURCE_APPLY_ADD_URL%>"><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;创建申请单</a>
					</div>
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
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
