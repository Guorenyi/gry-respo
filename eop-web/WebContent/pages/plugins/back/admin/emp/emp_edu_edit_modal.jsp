<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="empEduEditModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;教育经历</strong>
				</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="myform2" method="post">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="schooleduDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="schooledu">毕业院校：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="schooledu" name="schooledu" class="form-control"
										placeholder="请输入毕业院校名称">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="schooleduMsg"></div>
							</div>
							<div class="form-group" id="majoreduDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="majoredu">主修专业：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="majoredu" name="majoredu" class="form-control"
										placeholder="请输入所学专业名称">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="schoolMsg"></div>
							</div>
							<div class="form-group" id="degreeeduDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="degreeedu">学历层次：</label>
								<div class="col-md-7">
									<select id="degreeedu" name="degreeedu" class="form-control">
										<option value="">====== 请选择学历层次 ======</option>
										<c:forEach items="${allDegrees}" var="deg">
										<option value="${deg.title}" >${deg.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="degreeeduMsg"></div>
							</div>
							<div class="form-group" id="entranceeduDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="entranceedu">入学日期：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="entranceedu" name="entranceedu" class="form-control"
										placeholder="请选择入学日期">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="entranceeduMsg"></div>
							</div>
							<div class="form-group" id="graduationeduDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="graduationedu">毕业日期：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="graduationedu" name="graduationedu" class="form-control"
										placeholder="请选择毕业日期">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="graduationeduMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteeduDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="noteedu">备注信息：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<textarea id="noteedu" name="noteedu"
										class="form-control" placeholder="请输入雇员的学历相关信息" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteeduMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<input type="hidden" id="eid" name="eid" value="${eid}">
									<input type="hidden" id="eeduids" name="eeduids" >
									<button type="submit" id="editNewEducation" class="btn btn-primary">更新</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
