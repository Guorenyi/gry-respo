<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String SUPPLY_EMP_APPLY_HANDLE_URL = "" ;
%>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/finance/finance_reimbursement_apply_handle.js"></script> 
<script type="text/javascript" src="js/common/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">  
	<div class="wrapper">  
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp"> 
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="71"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;员工财务报销单</strong>
			</div>
			<div class="panel-body">
				<div id="reimbursementInfoDiv" class="row">
					<div class="col-xs-12">
						<table class="table table-condensed table-striped table-hover">
							<tr>
								<td style="width:20%;"><strong>报销申请单名称：</strong></td>
								<td>为了报销而报销的报销</td>
							</tr>
							<tr>
								<td><strong>总费用：</strong></td>
								<td><span id="cost">￥2332</span></td>
							</tr>
							<tr>
								<td><strong>报销单说明：</strong></td>
								<td><pre class="pre-scrollable" style="width:500px;height:100px;">我们一起去改变吧</pre></td>
							</tr>
						</table>
					</div>
				</div>
				<div id="detailsTable" class="row">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th width="50%" class="text-center">名称</th>
								<th width="20%" class="text-center">费用</th>
								<th width="20%" class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">车票</td>
								<td class="text-center">2.0</td>
								<td class="text-center">
									<button type="button" class="btn btn-primary btn-xs" id="rdtid-1">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div>
					<form class="form-horizontal" action="<%=SUPPLY_EMP_APPLY_HANDLE_URL%>" id="myform" method="post">
						<fieldset>
							<div class="form-group" id="auditDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="audit">审核结论：</label>
								<div class="col-md-6">
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit" value="2" checked>
											&nbsp;<span class="text-danger">拒绝</span></label>
									</div> 
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit" value="1">
											&nbsp;<span class="text-success">通过</span></label>
									</div> 
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="auditMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="note">审核备注：</label>
								<div class="col-md-6">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note" rows="3"
										class="form-control" placeholder="请输入审核所给出的意见信息" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">处理</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
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
		
		<jsp:include page="/pages/plugins/back/info/emp_info_modal.jsp"/>
		<jsp:include page="/pages/plugins/back/admin/plan/plan_details_modal.jsp"/>
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
