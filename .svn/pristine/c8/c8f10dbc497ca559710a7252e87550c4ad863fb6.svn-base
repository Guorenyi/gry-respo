<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="empCareerEditModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;职业经历</strong>
				</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="myform" method="post">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="companycarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="companycar">公司名称：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="companycar" name="companycar" class="form-control"
										placeholder="请输入曾就职公司名称">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="companycarMsg"></div>
							</div>
							<div class="form-group" id="salarycarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="salarycar">工资待遇：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="salarycar" name="salarycar" class="form-control"
										placeholder="请输入层就职公司待遇">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="salarycarMsg"></div>
							</div>
							<div class="form-group" id="positioncarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="positioncar">原属职位：</label>
								<div class="col-md-7">
									<select id="positioncar" name="positioncar" class="form-control">
										<option value="">====== 请选择原属职位 ======</option>
										<c:forEach items="${allPositions }" var="posi">
										<option value="${posi.title}">${posi.title }</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="positioncarMsg"></div>
							</div>
							<div class="form-group" id="entrycarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="entrycar">入职日期：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="entrycar" name="entrycar" class="form-control"
										placeholder="请选择入职日期">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="entrycarMsg"></div>
							</div>
							<div class="form-group" id="quitcarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="quitcar">离职日期：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="quitcar" name="quitcar" class="form-control"
										placeholder="请选择离职日期">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="quitcarMsg"></div>
							</div>
							<div class="form-group" id="reasoncarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="reasoncar">离职原因：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="reasoncar" name="reasoncar" class="form-control"
										placeholder="请输入员工离职主要原因">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="reasoncarMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="notecarDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="notecar">备注信息：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<textarea id="notecar" name="notecar"
										class="form-control" placeholder="请输入雇员的学历相关信息" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="notecarMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<input type="hidden" id="eid" name="eid" value="${eid}">
									<input type="hidden" id="ecarids" name="ecarid" >
									<button type="submit" id="editNewCareer" class="btn btn-primary">更新</button>
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
