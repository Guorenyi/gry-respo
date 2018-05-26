<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="supplyModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;追加商品库存</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="amountDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-2 control-label" for="amount">追加库存量：</label>
								<div class="col-md-7">
									<!-- 定义表单输入组件 -->
									<input type="text" id="amount" name="amount" class="form-control"
										placeholder="请输入要增加的库存数量">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-3" id="amountMsg"></div>
							</div>
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">追加</button>
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
