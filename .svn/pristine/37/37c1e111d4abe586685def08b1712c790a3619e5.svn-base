<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/plan/plan_details_list.js"></script>
<script type="text/javascript" src="js/common/split_page.js"></script>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;任务详情</strong>
			</div>
			<div class="panel-body">
				<div class="row">
					<table class="table table-condensed table-striped table-hover">
						<tr>
							<td style="width:15%;"><strong>任务名称：</strong></td>
							<td>干四小强</td>
						</tr>
						<tr>
							<td><strong>任务类型：</strong></td>
							<td>常规工作</td>
						</tr>
						<tr>
							<td><strong>任务人数：</strong></td>
							<td><span id="empCount">9</span>人</td>
						</tr>
						<tr>
							<td><strong>开始时间：</strong></td>
							<td>2019-10-10 11:11:11</td>
						</tr>
						<tr>
							<td><strong>结束时间：</strong></td>
							<td>2020-10-10 11:11:11</td>
						</tr>
						<tr>
							<td><strong>任务说明：</strong></td>
							<td><pre class="pre-scrollable" style="width:500px;height:100px;">好好干死它。。。</pre></td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="button" class="btn btn-primary btn-lg" id="addEmpBut">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;增加任务人员</button>
							</td>
						</tr>
					</table>
				</div>
				<div class="row">
					<div class="panel-group" id="news">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h4 class="panel-title"> 
									<a data-toggle="collapse" data-parent="news" href="#contentOne">
										<strong><span class="glyphicon glyphicon-user"></span>&nbsp;任务参与人员清单（当前人数：<span id="currentCount">10</span>人）</strong>
									</a>
								</h4>
							</div>
							<div id="contentOne" class="panel-collapse collapse in">
								<div class="panel-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th class="text-center">照片</th> 
												<th class="text-center">姓名</th>
												<th class="text-center">级别</th>
												<th class="text-center">所在部门</th>
												<th class="text-center">联系电话</th>
												<th class="text-center">操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="text-center">
													<img src="upload/emp/nophoto.png" style="width:20px;"/> 
												</td> 
												<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td>
												<td class="text-center">经理</td>
												<td class="text-center">人事部</td>
												<td class="text-center">13010109992</td>
												<td class="text-center">
													<button type="button" class="btn btn-primary btn-xs" id="remove-1">
															<span class="glyphicon glyphicon-edit"></span>&nbsp;移除</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="splitBarDiv" style="float:right">
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
