<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/supply/supply_details_list.js"></script>
<%!
	public static final String SUPPLY_GOODS_EDIT_URL = "pages/back/admin/supply/supply_goods_edit_pre.action" ;
    public static final String SUPPLY_GOODS_ADD_URL = "pages/back/admin/supply/supply_goods_add_pre.action" ;
    public static final String SUPPLY_GOODS_SUBMIT_URL = "pages/back/admin/supply/supply_submit.action" ;

%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="8"/>
			<jsp:param name="msi" value="82"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
		 <form id="goodsForm" action="<%=SUPPLY_GOODS_SUBMIT_URL%>" method="post">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;采购申请单基本信息</strong>
			</div>
			<input type="hidden" id="spid" name="spid" value="${spid}">
			<input type="hidden" id="status" name="status" value="${supply.status}">
			<div class="panel-body">
				<div>
					<table class="table table-condensed" >
						<tr>
							<td >申请日期：</td>
							<td>${supply.pubdate}</td>
							<td >申请状态：</td>
							<td>
							<c:forEach items="${supplyStatus }" var="status">
								
								<c:if test="${status.value==supply.status }"><span id="supplyStatus" >${status.title}</span></c:if>
							</c:forEach>
							</td>
						</tr>
						<tr>
						<td>用品数量：</td>
						<td id="total_amount">${supply.amount}</td>
						<td>总金额：</td>
						<td id="total_money"><fmt:formatNumber value="${supply.money}" type="currency"></fmt:formatNumber> </td>
						</tr>
						<tr>
							<td><strong>备注：</strong></td>
							<td><textarea rows="3" cols="60" disabled="disabled">${supply.note}</textarea></td>
						</tr>
						<tr>
							<td >审核日期：</td>
							<td>${supply.pubdate}</td>
							<td >审核人：</td>
							<td>${supply.aeid}</td>
						</tr>
						<tr>
							<td><strong>审核备注：</strong></td>
							<td><textarea rows="3" cols="60" disabled="disabled">${supply.anote}</textarea></td>
						</tr>
					</table>
				</div>
				<h4 class="panel-title"> 
						<strong><span class="glyphicon glyphicon-tasks"></span>&nbsp;申请单明细</strong>
				</h4>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center"><input type="checkbox" id="selall"></th>
							<th class="text-center">图片</th>
							<th class="text-center">办公用品名称</th>
							<th class="text-center">单价</th>
							<th class="text-center">数量</th>
							<th class="text-center">操作</th> 
						</tr>
					</thead>
					<tbody id="supplyListTable">
						<c:forEach items="${supplyDetailList }" var="resource">
						<tr id="tr-${resource.resid}">
							<td class="text-center"><input type="checkbox" id="resid-${resource.resid}" value="${resource.resid }"></td>
							<td class="text-center"><img src="upload/${resource.photo}" style="width:30px;"></td>
							<td class="text-center">${resource.title}</td>
							<td class="text-center" id="price-${resource.resid}">${resource.price}</td>
							<td class="text-center" id="amount-${resource.resid}">${resource.amount}</td>
							<td class="text-center">
								<a type="button" class="btn btn-primary btn-xs" href="<%=SUPPLY_GOODS_EDIT_URL%>?resid=${resource.resid}">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-success" id="addBtn" href="<%=SUPPLY_GOODS_ADD_URL%>?spid=${spid}"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;追加待采购商品</a>
				<div class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除待采购商品</div>
				<div class="btn btn-primary" id="subBtn"><span class="glyphicon glyphicon-ok"></span>&nbsp;提交采购申请</div>
				
				<div id="splitBarDiv" style="float:right">
				</div>
			</div>
			<div class="panel-footer">
				<jsp:include page="/pages/plugins/include_alert.jsp"/>
			</div>
			</form>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<jsp:include page="/pages/plugins/back/admin/supply/supply_modal.jsp" />
		<jsp:include page="/pages/plugins/back/admin/supply/supply_img_modal.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
