<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<%!
	public static final String SUPPLY_GOODS_EDIT_URL = "pages/back/admin/supply/supply_goods_edit.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/supply/supply_goods_edit.js"></script>
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
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;修改商品采购信息</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=SUPPLY_GOODS_EDIT_URL%>" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
						    <input type="hidden" id="resid" name="resid" value="${resource.resid}">
						    <input type="hidden" id="spid" name="spid" value="${resource.spid}">
							<div class="form-group" id="nameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="name">商品名称：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" name="title" class="form-control"
										placeholder="请输入购买商品的名称" value="${resource.title}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="titleMsg"></div>
							</div>
							<div class="form-group" id="priceDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="price">商品单价：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="price" name="price" class="form-control"
										placeholder="请输入商品购买单价.." value="${resource.price}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="priceMsg"></div>
							</div>
							<div class="form-group" id="amountDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="amount">商品数量：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="amount" name="amount" class="form-control"
										placeholder="请输入商品购买数量.." value="${resource.amount}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="amountMsg"></div>
							</div>
							<div class="form-group" id="photoDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="photo">商品图片：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									
									<img alt="" src="upload/${resource.photo}" style="weight:100px;height: 100px">
									<input type="file" id="photo" name="photo" class="form-control"
										placeholder="请上传商品图片" value="${resource.photo }">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="photoMsg"></div>
							</div>
							<div class="form-group" id="itemTypeDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="itemType">用品类型：</label>
								<div class="col-md-5">
									<select id="itemType" name="itemType" class="form-control">
										<option value="">====== 请选择用品分类 ======</option>
										<c:forEach items="${itemList}" var="item">>
											<option value="${item.value}" <c:if test="${item.value==resource.itemType}">selected</c:if>>${item.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="itemTypeMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">备注信息：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入商品相关说明" rows="6" >${resource.note}</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
								  
									<!-- 只有在申请单状态为草稿或者审核不通过的时候才可以编辑 -->
									<c:if test="${supplyStatus==0||supplyStatus==2}">
										<button type="submit" class="btn btn-primary">修改</button>
										<button type="reset" class="btn btn-warning">重置</button>
									</c:if>
									<button type="button" onclick="javascript :history.back(-1);" class="btn btn-primary">返回</button>
								</div>
							</div>
							<div>
								<label class="text-danger">${saveMsg}</label>
							</div>
						</fieldset>
					</form>
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
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
