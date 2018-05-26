<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String SUPPLY_EMP_APPLY_HANDLE_URL = "pages/back/admin/resource_audit/audit.action" ;
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
							<td><span>${Empresource.subdate}</span></td>
						</tr>
						<tr>
							<td><strong>用品数量：</strong></td>
							<td>${Empresource.amount}</td>
						</tr>
						<tr>
							<td><strong>总金额：</strong></td>
							<td>${Empresource.money}</td>
						</tr>
						<tr>
							<td><strong>申请状态：</strong></td>
							<td>
							<c:forEach items="${itemList}" var="status">
									<c:if test="${status.value==Empresource.status }">${status.title}</c:if>
							    </c:forEach>
							</td>
						</tr>
						<tr>
							<td><strong>备注：</strong></td>
							<td><pre class="pre-scrollable" style="width:500px;height:100px;">${Empresource.note}</pre></td>
						</tr>
					</table>
				</div>
				<div class="panel-group" id="news">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="news" href="#contentOne">
									<strong><span class="glyphicon glyphicon-tasks"></span>&nbsp;办公用品清单</strong>
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
									<c:forEach items="${resourcedetails}" var="resource">
										<tr id="travel-1">
											<td class="text-center">
												<img src="upload/${resource.photo}" style="width:20px;"/> 
											</td>
											<td class="text-center">${resource.title}</td>
											<td class="text-center">${resource.price}</td>
											<td class="text-center">${resource.amount}</td>
											<td class="text-center">${resource.price*resource.amount}</td>
										</tr>
									</c:forEach> 
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div> 
				<div>
					<form class="form-horizontal" action="<%=SUPPLY_EMP_APPLY_HANDLE_URL%>" id="myform" method="post">
						<input id="eresid" name="eresid" type="hidden" value="${Empresource.eresid}"/>
						<fieldset>
							<div class="form-group" id="auditDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="audit">审核结论：</label>
								<div class="col-md-6">
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit" <c:if test="${Empresource.status==3}">checked</c:if> value="3" checked>
											&nbsp;<span class="text-danger">拒绝</span></label>
									</div> 
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit" <c:if test="${Empresource.status==2}">checked</c:if> value="2">
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
										class="form-control" placeholder="请输入审核所给出的意见信息" rows="10">${Empresource.renote}</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
								  <c:if test="${Empresource.status==1}">
									<button type="submit" class="btn btn-primary">处理</button>
									<button type="reset" class="btn btn-warning">重置</button>
								  </c:if>
								  <button type="button" onclick="javascript :history.back(-1);" class="btn btn-primary">返回</button>
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
		<jsp:include page="/pages/plugins/back/admin/supply/supply_img_modal.jsp" />
		<jsp:include page="/pages/plugins/back/info/emp_info_modal.jsp"/>
		<jsp:include page="/pages/plugins/back/admin/plan/plan_details_modal.jsp"/>
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
