<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="modal fade" id="planEmpInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<!-- 定义表单提示文字 -->
					<label class="col-md-2 control-label" for="did">员工所在部门：</label>
					<div class="col-md-5">
						
						<select id="did" name="did" class="form-control">
							
							<option value="0">====== 请选择雇员所在部门 ======</option>
			
								<c:forEach items="${allDepts}" var="dept">
									<option value="${dept.did}">${dept.dname}</option>
								</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-body">
				<div id="memberBasicInfo">
					<table class="table table-condensed table-hover" id="empTable">
						<thead>
							<tr>
								<th class="text-center"><strong>照片</strong></th>
								<th class="text-center"><strong>雇员编号</strong></th>
								<th class="text-center"><strong>姓名</strong></th>
								<th class="text-center"><strong>级别</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allEmpLevels}" var="emplevel">
							
							
							<!--<tr id="emp-${emplevel.eid}">-->
								<tr id="emp-${emplevel.did}">
								<td class="text-center">
									<img src="upload/emp/${emplevel.photo}" style="width:20px;"/> 
								</td>
								<td class="text-center">${emplevel.eid}</td>
								<td class="text-center" id="${emplevel.did}">${emplevel.ename}</td>
								<td class="text-center">${emplevel.title}</td>
								<td class="text-center">
									<button class="btn btn-danger btn-xs" id="add--${emplevel.eid}--${pid}">
										<span class="glyphicon glyphicon-plus-sign" id="showDiv"></span>&nbsp;增加</button>
								</td>
							</tr> 
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!--<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
				</div>-->
				

			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>