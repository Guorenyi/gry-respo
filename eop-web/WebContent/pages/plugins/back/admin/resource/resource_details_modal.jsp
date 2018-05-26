<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>  
<div class="modal fade" id="resourceModal"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;办公用品领取详情</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div>
					<table class="table table-condensed" style="width:700px;">
						<tr>
							<td style="width:30%;"><strong>申请日期：</strong></td>
							<td><span id="subdate"></span></td>
						</tr>
						<tr>
							<td><strong>用品数量：</strong></td>
							<td id="amount"></td>
						</tr>
						<tr>
							<td><strong>总金额：</strong></td>
							<td id="money"></td>
						</tr>
						<tr>
							<td><strong>申请状态：</strong></td>
							<td id="status"></td>
						</tr>
						<tr>
							<td><strong>备注：</strong></td>
							<td><pre  class="pre-scrollable" style="width:500px;height:100px;"><span id="note"></span></pre></td>
						</tr>
					</table>
				</div>
				<div class="panel-group" id="news">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="news" href="#contentOne">
									<strong><span class="glyphicon glyphicon-user"></span>&nbsp;<span id="title"></span></strong>
								</a>
							</h4>
						</div>
						<div id="contentOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<table class="table table-condensed" id="ta">
									<thead>
										<tr>
											<th class="text-center"><strong>图片</strong></th>
											<th class="text-center"><strong>名称</strong></th>
											<th class="text-center">用品数量</th>
											<th class="text-center">单价</th>
											<th class="text-center">总价</th>
										</tr>
									</thead>
									<tbody>	
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
