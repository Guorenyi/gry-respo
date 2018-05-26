<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<%
	String EMP_ADD_URL = request.getAttribute("basePath") + "pages/back/admin/emp/emp_add.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="21"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;雇员入职</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=EMP_ADD_URL%>" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="eidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="eid">登录ID：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="eid" name="eid" value="mldn-lisen" class="form-control"
										placeholder="请输入雇员登录ID">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="eidMsg"></div>
							</div>
							<div class="form-group" id="passwordDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="password">登录密码：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="password" id="password" name="password" value="hello" class="form-control"
										placeholder="请输入雇员登录密码">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="passwordMsg"></div>
							</div>
							<div class="form-group" id="enameDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="ename">雇员姓名：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="ename" name="ename" value="雷迪森" class="form-control"
										placeholder="请输入雇员真实姓名">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="enameMsg"></div>
							</div>
							<div class="form-group" id="phoneDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="phone">联系电话：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="phone" name="phone" value="14562314578" class="form-control"
										placeholder="请输入雇员联系电话">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="phoneMsg"></div>
							</div>
							<div class="form-group" id="didDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="did">所属部门：</label>
								<div class="col-md-5">
									<select id="did" name="did" class="form-control">
										<option value="">====== 请选择所在部门 ======</option>
										<c:forEach items="${allDepts }" var="dept">
											<option value="${dept.did}">${dept.dname}（剩余${dept.maxnum-dept.currnum}人）</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="didMsg"></div>
							</div>
							<div class="form-group" id="lidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="lid">雇员职位：</label>
								<div class="col-md-5">
									<select id="lid" name="lid" class="form-control">
										<option value="">====== 请选择雇员职位 ======</option>
										<c:forEach items="${allLevels}" var="level">
										<option value="${level.lid }">${level.title }（${level.losal}~${level.hisal }）</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="lidMsg"></div>
							</div>
							<div class="form-group" id="salaryDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="salary">基本工资：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="salary" value="1000" name="salary" class="form-control"
										placeholder="请输入雇员基本工资">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="salaryMsg"></div>
							</div>
							<div class="form-group" id="photoDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="photo">雇员照片：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="file" id="photo" name="photo" class="form-control"
										placeholder="请选择雇员照片">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="photoMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">备注信息：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入雇员的面试情况" rows="10">唉吆，哎呀，唉吆呀，哎呀吆，咬牙诶，要诶亚</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">增加</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
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
