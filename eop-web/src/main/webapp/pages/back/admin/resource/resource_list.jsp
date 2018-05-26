<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/resource/resource_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="41"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;办公资源列表</strong>
			</div>
			<div class="panel-body">
				<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				<div class="row">
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<img src="upload/resource/nophoto.png" style="width:100px;"/> 
							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12"><strong>小强画板</strong></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<strong>
											<button class="btn btn-warning btn-xs" id="add-1">
												<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;待领取</button>
											</strong>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
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
