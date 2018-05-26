<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String SUPPLY_EMP_APPLY_HANDLE_URL = "" ;
%>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/supply/supply_emp_apply_handle.js"></script> 
<script type="text/javascript" src="js/common/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">  
	<div class="wrapper">  
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp"> 
			<jsp:param name="mi" value="8"/>
			<jsp:param name="msi" value="84"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;员工资源领取申请单</strong>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-condensed" style="width:700px;">
						<tr>
							<td style="width:30%;"><strong>申请日期：</strong></td>
							<td><span>2019-10-10</span></td>
						</tr>
						<tr>
							<td><strong>用品数量：</strong></td>
							<td>10</td>
						</tr>
						<tr>
							<td><strong>总金额：</strong></td>
							<td>￥1010</td>
						</tr>
						<tr>
							<td><strong>申请状态：</strong></td>
							<td>待审核</td>
						</tr>
						<tr>
							<td><strong>备注：</strong></td>
							<td><pre class="pre-scrollable" style="width:500px;height:100px;">发神经阿德里飞洒抵抗力 范德克鲁斯建立开放撒 方力申搭建了开发商的 发动机萨拉空间来看 234uop富士达会计分录款手机范德萨进来进来看范德萨克利夫兰斯顿卡机了开发商大量了快捷方式的拉开建立开放撒酒 刘嘉玲发撒旦机立刻地方撒刻录机弗拉基反抗螺丝钉</pre></td>
						</tr>
					</table>
				</div>
				<div class="panel-group" id="news">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="news" href="#contentOne">
									<strong><span class="glyphicon glyphicon-tasks"></span>&nbsp;办公用品清单（用品数量：10件）</strong>
								</a>
							</h4>
						</div>
						<div id="contentOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th class="text-center"><strong>图片</strong></th>
											<th class="text-center"><strong>名称</strong></th>
											<th class="text-center"><strong>价格</strong></th>
											<th class="text-center"><strong>数量</strong></th>
											<th class="text-center"><strong>总价</strong></th>
										</tr>
									</thead>
									<tbody>
										<tr id="travel-1">
											<td class="text-center">
												<img src="upload/resource/nophoto.png" style="width:20px;"/> 
											</td>
											<td class="text-center">小强药水</td>
											<td class="text-center">99.99</td>
											<td class="text-center">99.99</td>
											<td class="text-center">99.99</td>
										</tr> 
									</tbody>
								</table>
							</div>
						</div>
					</div>
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
