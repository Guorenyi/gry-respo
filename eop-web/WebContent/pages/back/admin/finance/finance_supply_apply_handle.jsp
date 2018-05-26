<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String SUPPLY_EMP_APPLY_HANDLE_URL = "pages/back/admin/finance/finance_supply_audit.action" ;
%>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/finance/finance_supply_apply_handle.js"></script> 
<script type="text/javascript" src="js/common/split_page.js"></script>

<script type="text/javascript" >

function displayResult()
{   
	if (document.getElementById("anote").value!=null||document.getElementById("anote").value!=""){
		anote.setAttribute("disabled","disabled");
	}
}

</script>

<body class="hold-transition skin-blue sidebar-mini">  
	<div class="wrapper">  
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp"> 
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="72"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;办公用品采购单</strong>
			</div>
			<div class="panel-body">
				<div id="reimbursementInfoDiv" class="row">
					<div class="col-xs-12">
						<table class="table table-condensed table-striped table-hover">
						<input type="hidden" id="spid" name="spid" value="${spid}">
							<tr>
								<td style="width:20%;"><strong>资源采购申请名称：</strong></td>
								
								<td>${supply.title}</td>
							</tr>
							<tr>
								<td><strong>申请状态：</strong></td>
								<td>
								<c:forEach items="${supplyStatus }" var="status">
									<c:if test="${status.value==supply.status }">${status.title}</c:if>
								</c:forEach>
								</td>
							</tr>
							<tr>
								<td><strong>商品总数量：</strong></td>
								<td>${supply.amount}</td>
							</tr>
							<tr>
								<td><strong>总金额：</strong></td>
								<td><fmt:formatNumber type="currency" value="${supply.money}"></fmt:formatNumber> </td>  
							</tr>
							<tr>
								<td><strong>申请说明：</strong></td>
								<td><pre class="pre-scrollable" style="width:500px;height:100px;">${supply.note}</pre></td>
							</tr>
						</table>
					</div>
				</div>
				<div id="detailsTable" class="row">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th width="20%" class="text-center">图片</th>
								<th width="40%" class="text-center">商品名称</th>
								<th width="20%" class="text-center">单价</th>
								<th width="20%" class="text-center">数量</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${supplyDetailList}" var="supplyDetail">
							<tr>
								<td class="text-center"><img src="upload/${supplyDetail.photo}" style="width:30px;"></td>
								<td class="text-center">${supplyDetail.title}</td>
								<td class="text-center">${supplyDetail.price}</td>
								<td class="text-center">${supplyDetail.amount}</td>
								
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div>
					<form  class="form-horizontal" action="<%=SUPPLY_EMP_APPLY_HANDLE_URL%> "  name="myform" id="myform"    method="post">
						<fieldset>
							<div class="form-group" id="auditDiv">
							    <input type="hidden" id="spid" name="spid" value="${spid}">
							   
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="audit">审核结论：</label>
								<div class="col-md-6"  >
									<div class="radio-inline">
									
										<label><input type="radio" id="audit" name="audit" value="2" <c:if test="${supply.status==2}">checked</c:if> >
											&nbsp;<span class="text-danger">拒绝</span></label>
									</div> 
									<div class="radio-inline">
										<label><input type="radio" id="audit" name="audit" value="1" <c:if test="${supply.status==3}"></c:if>>
											&nbsp;<span class="text-success">通过</span></label>
									</div> 
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="auditMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="anoteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="anote" >审核备注：</label>
								<div class="col-md-6">
									<!-- 定义表单输入组件 -->
									<textarea id="anote" name="anote" rows="3"  
										class="form-control" placeholder="请输入审核所给出的意见信息" rows="10"  >${supply.anote}</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="anoteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<!-- 只有状态为已提交的申请单才可以显示处理按钮 -->
									<c:if test="${supply.status==1}">
										<input   type="hidden"   name="url"value=<%=request.getRequestURL()%> > 
										<button type="submit" class="btn btn-primary"  id="subimt">处理</button>
										<button type="reset" class="btn btn-warning">重置</button>
									</c:if>
									<button type="button" onclick="javascript :history.back(-1);" class="btn btn-primary">返回</button>
								 </div>
							</div>
							<div>${errorMsg}</div>
						</fieldset>
					</form>
				</div>
			</div>
			<div class="panel-footer">
				<jsp:include page="/pages/plugins/include_alert.jsp"/>
			</div>
		</div>
		</div>
		<jsp:include page="/pages/plugins/back/admin/supply/supply_img_modal.jsp" />
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
