<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%!
	public static final String INDEX_URL = "pages/back/index.jsp" ;	

	public static final String DEPT_LIST_URL = "pages/back/admin/dept/dept_list.jsp" ;
	public static final String DEPT_ADD_URL = "pages/back/admin/dept/dept_add.jsp" ;
	
	public static final String EMP_ADD_URL = "pages/back/admin/emp/emp_add.jsp" ;
	public static final String EMP_LIST_URL = "pages/back/admin/emp/emp_list.jsp" ;
	
	public static final String REIMBURSEMENT_ADD_URL = "pages/back/admin/reimbursement/reimbursement_add.jsp" ;
	public static final String REIMBURSEMENT_LIST_URL = "pages/back/admin/reimbursement/reimbursement_list.jsp" ;
	
	public static final String RESOURCE_LIST_URL = "pages/back/admin/resource/resource_list.jsp" ;
	public static final String RESOURCE_UNDRAW_LIST_URL = "pages/back/admin/resource/resource_undraw_list.jsp" ;
	public static final String RESOURCE_APPLY_LIST_URL = "pages/back/admin/resource/resource_apply_list.jsp" ;
	
	public static final String SCHEDULE_LIST_URL = "pages/back/admin/schedule/schedule_list.jsp" ;
	
	public static final String PLAN_ADD_URL = "pages/back/admin/plan/plan_add.jsp" ;
	public static final String PLAN_PREPARE_LIST_URL = "pages/back/admin/plan/plan_prepare_list.jsp" ;
	public static final String PLAN_HISTORY_LIST_URL = "pages/back/admin/plan/plan_history_list.jsp" ;
	
	public static final String SUPPLY_ADD_URL = "pages/back/admin/supply/supply_apply_add.jsp" ;
	public static final String SUPPLY_APPLY_LIST_URL = "pages/back/admin/supply/supply_apply_list.jsp" ;
	public static final String SUPPLY_LIST_URL = "pages/back/admin/supply/supply_list.jsp" ;
	public static final String SUPPLY_RESOURCE_LIST_URL = "pages/back/admin/supply/supply_emp_apply_list.jsp" ;
	
	
	public static final String AUDIT_REIMBURSEMENT_LIST_URL = "pages/back/admin/finance/finance_reimbursement_apply_list.jsp" ;
	public static final String AUDIT_SUPPLY_LIST_URL = "pages/back/admin/finance/finance_supply_apply_list.jsp" ;
%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="upload/emp/nophoto.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>小李同学</p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-university"></i> MLDN办公平台</li>
					<li class="treeview ${param.mi==1 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-institution"></i> <span>部门管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==11 ? 'active' : ''}"><a href="<%=DEPT_ADD_URL%>"><i class="fa fa-cube"></i>
								增加部门</a></li>
							<li class="${param.msi==12 ? 'active' : ''}"><a href="<%=DEPT_LIST_URL%>"><i class="fa fa-object-group"></i>
								部门列表</a></li>
					</ul></li>
					<li class="treeview ${param.mi==2 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>人事管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==21 ? 'active' : ''}"><a href="<%=EMP_ADD_URL%>"><i class="fa fa-user-plus"></i>
								增加雇员</a></li>
							<li class="${param.msi==22 ? 'active' : ''}"><a href="<%=EMP_LIST_URL%>"><i class="fa fa-users"></i>
								雇员列表</a></li>
					</ul></li>
					<li class="treeview ${param.mi==3 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa  fa-car"></i>
						<span>财务报销</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==31 ? 'active' : ''}"><a href="<%=REIMBURSEMENT_ADD_URL%>"><i
								class="fa fa-train"></i> 创建报销单</a></li>
							<li class="${param.msi==32 ? 'active' : ''}"><a href="<%=REIMBURSEMENT_LIST_URL%>"><i
								class="fa fa-history"></i> 报销单列表</a></li>
					</ul></li>
					<li class="treeview  ${param.mi==4 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-bitbucket-square"></i>
						<span>办公资源</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==41 ? 'active' : ''}"><a href="<%=RESOURCE_LIST_URL%>"><i
								class="fa fa-tasks"></i> 资源列表</a></li>
							<li class="${param.msi==42 ? 'active' : ''}"><a href="<%=RESOURCE_UNDRAW_LIST_URL%>"><i
								class="fa fa-file-archive-o"></i> 待申请资源</a></li>
							<li class="${param.msi==43 ? 'active' : ''}"><a href="<%=RESOURCE_APPLY_LIST_URL%>"><i
								class="fa fa-clipboard"></i> 领取记录</a></li>
					</ul></li>
					<li class="treeview  ${param.mi==5 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-tachometer"></i>
						<span>工作调度</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==51 ? 'active' : ''}"><a href="<%=PLAN_ADD_URL%>"><i
								class="fa fa-calendar"></i> 工作安排</a></li>
							<li class="${param.msi==52 ? 'active' : ''}"><a href="<%=PLAN_HISTORY_LIST_URL%>"><i
								class="fa fa-list-alt"></i> 任务列表</a></li>
					</ul></li> 
					
					<li class="treeview  ${param.mi==6 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-odnoklassniki-square"></i>
						<span>工作计划</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==61 ? 'active' : ''}"><a href="<%=SCHEDULE_LIST_URL%>"><i
								class="fa fa-cubes"></i> 我的任务</a></li>
					</ul></li> 
					
					<li class="treeview  ${param.mi==7 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-map-o"></i>
						<span>财务审核</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==71 ? 'active' : ''}"><a href="<%=AUDIT_REIMBURSEMENT_LIST_URL%>"><i
								class="fa fa-puzzle-piece"></i> 报销单审核</a></li>
							<li class="${param.msi==72 ? 'active' : ''}"><a href="<%=AUDIT_SUPPLY_LIST_URL%>"><i
								class="fa fa-reddit"></i> 采购申请</a></li>
					</ul></li> 
										
					<li class="treeview  ${param.mi==8 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-medium"></i>
						<span>资源管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==81 ? 'active' : ''}"><a href="<%=SUPPLY_ADD_URL%>"><i
								class="fa fa-joomla"></i> 购买申请</a></li>
							<li class="${param.msi==82 ? 'active' : ''}"><a href="<%=SUPPLY_APPLY_LIST_URL%>"><i
								class="fa fa-list-alt"></i> 申请列表</a></li>
							<li class="${param.msi==83 ? 'active' : ''}"><a href="<%=SUPPLY_LIST_URL%>"><i
								class="fa fa-leanpub"></i> 资源库存</a></li>
							<li class="${param.msi==84 ? 'active' : ''}"><a href="<%=SUPPLY_RESOURCE_LIST_URL%>"><i
								class="fa fa-stack-overflow"></i> 领取申请</a></li>
					</ul></li> 
					

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>