<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="reimbursementModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;报销项</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="title">名称：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" name="title" class="form-control"
										placeholder="请输入报销项名称"> 
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="titleMsg"></div>
							</div>
							<div class="form-group" id="moneyDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="money">金额：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="money" name="money" class="form-control"
										placeholder="请输入本项费用">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="moneyMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="note">备注信息：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入本报销项的说明" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">更新</button>
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
