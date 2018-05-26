<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="empEduModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;教育经历</strong>
				</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="myform" method="post">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="schoolDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="school">毕业院校：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="school" value="家里蹲一哈哈" name="school" class="form-control"
										placeholder="请输入毕业院校名称">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="schoolMsg"></div>
							</div>
							<div class="form-group" id="majorDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="major">主修专业：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="major" value="蹲一哈" name="major" class="form-control"
										placeholder="请输入所学专业名称">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="schoolMsg"></div>
							</div>
							<div class="form-group" id="degreeDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="degree">学历层次：</label>
								<div class="col-md-7">
									<select id="degree" name="degree" class="form-control">
										<option value="">====== 请选择学历层次 ======</option>
										<c:forEach items="${allDegrees}" var="deg">
										<option value="${deg.title}">${deg.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="degreeMsg"></div>
							</div>
							<div class="form-group" id="entranceDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="entrance">入学日期：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="entrance" name="entrance" class="form-control"
										placeholder="请选择入学日期">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="entranceMsg"></div>
							</div>
							<div class="form-group" id="graduationDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="graduation">毕业日期：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="graduation" name="graduation" class="form-control"
										placeholder="请选择毕业日期">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="graduationMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="note">备注信息：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入雇员的学历相关信息" rows="10">敦敦敦哈哈哈</textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<input type="hidden" id="eid" name="eid" value="${eid}">
									<button type="submit" id="editEducationss" class="btn btn-primary">更新</button>
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
