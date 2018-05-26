<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/resource/resource_supply_edit.js"></script>
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
							<td>${empresource.subdate}</td>
							<td >申请状态：</td>
							<td>
							<%-- <c:forEach items="${resourceStatus }" var="status">
								<c:if test="${status.value==empresource.status }">${status.title}</c:if>
							</c:forEach> --%>
							<c:choose>
								<c:when test="${empresource.status == 1 }"><span style="color: blue">审核中</span></c:when>
								<c:when test="${empresource.status == 2 }"><span style="color: green">审核通过</span></c:when>
								<c:otherwise><span style="color: red">审核不通过</span></c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
						<td>用品数量：</td>
						<td id="allamount">${empresource.amount}</td>
						<td>总金额：</td>
						<td id="allPrice">${empresource.money}</td>
						</tr>
						<tr>
							<td><strong>备注：</strong></td>
							<td><textarea rows="3" cols="60" disabled="disabled">${empresource.note}</textarea></td>
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
							<th class="text-center">名称</th>
							<th class="text-center" >数量</th>
							<th class="text-center">单价</th>
							<th class="text-center">总价</th> 
							<th class="text-center">操作</th> 
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resourcedetails}" var="resourcedetails">
						<tr id="goods-${resourcedetails.resid}">
							<td class="text-center"><input type="checkbox" id="reuid-${resourcedetails.eresid}-${resourcedetails.resid}" value="${resourcedetails.resid}"></td>
							<td class="text-center"><img src="upload/${resourcedetails.photo}" style="width:30px;"></td>
							<td class="text-center">${resourcedetails.title}</td>
							<c:if test="${empresource.status != 3 }">
							<td class="text-center">${resourcedetails.amount}</td>
							</c:if>
							
							<c:if test="${empresource.status == 3}">
							<td class="text-center">
								<button class="btn btn-primary" id="sub-${resourcedetails.eresid}-${resourcedetails.resid}">-</button>
								<input type="text" id="amount-${resourcedetails.eresid}-${resourcedetails.resid}" name="amount-${resourcedetails.eresid}-${resourcedetails.resid}" class="shopcar-form-control " size="4" maxlength="4" value="${resourcedetails.amount}">
								<button class="btn btn-primary" id="add-${resourcedetails.eresid}-${resourcedetails.resid}">+</button> 
							</td>
							</c:if>
							<td class="text-center" id="price-${resourcedetails.eresid}-${resourcedetails.resid}">${resourcedetails.price}</td>
							<td class="text-center" id="money-${resourcedetails.eresid}-${resourcedetails.resid}">${resourcedetails.money}</td>
							<td class="text-center">
								<c:if test="${empresource.status == 3}">
								<button class="btn btn-primary btn-xs" id="save-${resourcedetails.eresid}-${resourcedetails.resid}">保存</button> 
							</c:if>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${empresource.status == 3}">
				<div class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除商品</div>
				<button class="btn btn-primary" id="subBtn">更新申请</button> 
				</c:if>
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
		//<jsp:include page="/pages/plugins/back/admin/supply/supply_modal.jsp" />
		//<jsp:include page="/pages/plugins/back/admin/supply/supply_img_modal.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
