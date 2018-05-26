<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="userInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看员工信息</strong>
				</div>
			</div>
			<div class="modal-body">
				<div id="costBasicInfo">
					<div class="row">
						<div class="col-xs-3">
							<img src="" id="photos" style="width:200px;">
						</div>
						<div class="col-xs-9">
							<table class="table table-condensed" style="width:700px;">
								<tr>
									<td style="width:30%;"><strong>雇员姓名：</strong></td>
									<td><span id="ename"></span></td>
								</tr>
								<tr>
									<td><strong>雇员职务：</strong></td>
									<td><span id="title"></span></td>
								</tr>
								<tr>
									<td><strong>基本工资：</strong></td>
									<td><span id="salary"></span></td>
								</tr>
								<tr>
									<td><strong>所属部门：</strong></td>
									<td><span id="dname"></span></td>
								</tr>
								<tr>
									<td><strong>联系电话：</strong></td>
									<td><span id="phone"></span></td>
								</tr>
								<tr>
									<td><strong>雇佣日期：</strong></td>
									<td><span id="hiredate"></span></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12"><strong>备注信息：</strong></div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<pre class="pre-scrollable" id="note" style="width:970px;height:110px;"></pre>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12"><strong>职业经历：</strong></div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="ta" class="table table-condensed table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="text-center">原公司名称</th> 
										<th class="text-center">职位</th>
										<th class="text-center">待遇</th>
										<th class="text-center">入职日期</th>
										<th class="text-center">离职日期</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="text-center"><span id="company"></span></td> 
										<td class="text-center"><span id="position"></span></td>
										<td class="text-center"><span id="salarys"></span></td>
										<td class="text-center"><span id="entry"></span></td>
										<td class="text-center"><span id="quit"></span></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12"><strong>教育背景：</strong></div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="tb" class="table table-condensed table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="text-center">学校</th> 
										<th class="text-center">学历</th>
										<th class="text-center">专业</th>
										<th class="text-center">入学日期</th>
										<th class="text-center">毕业日期</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="text-center"><span id="school"></span></td> 
										<td class="text-center"><span id="degree"></span></td>
										<td class="text-center"><span id="major"></span></td>
										<td class="text-center"><span id="entrance"></span></td>
										<td class="text-center"><span id="graduation"></span></td>
									</tr>
								</tbody>
							</table>
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
