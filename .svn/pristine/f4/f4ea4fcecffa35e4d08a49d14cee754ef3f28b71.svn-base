$(function(){
	$(selall).on("click",function(){
		$("input[id^=re-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	$("button[id^=rdtid-]").each(function() {
		$(this).on("click",function(){
			rbdid=$(this).attr("id").split("-") [1] ;
			$.post("pages/back/admin/reimbursement/edit_details_pre.action",{"rbdid":rbdid},function(data){
				$("#titless").attr("value",data.vo.title) ;
				$("#moneyss").attr("value",data.vo.money) ;
				$("#rbdid").attr("value",data.vo.rbdid) ;
				$("#notess").html(data.vo.note) ;
			},"json");
			$("#editmodal").modal("toggle") ;
		}) ;
	}) ;
	$("#geng").on("click",function(){
		rbsid=$("#rbsid").val() ;
		title = $("#titlede").val() ;
		money = $("#moneyde").val() ;
		note = $("#notede").val() ;
		$.post("pages/back/admin/reimbursement/add_details.action",{"rbsid":rbsid,"title":title,"money":money,"note":note,},function(data){
			operateAlert(data,"报销项创建成功！","报销项创建失败！") ;
		},"json");
	}) ;
	$("#xin").on("click",function(){
		rbdid=$("#rbdid").val() ;
		rbsid=$("#rbsid").val() ;
		title = $("#titless").val() ;
		money = $("#moneyss").val() ;
		note = $("#notess").val() ;
		console.log("***rbdid****" + rbdid) ;
		console.log("**money*****" + money) ;
		$.post("pages/back/admin/reimbursement/edit_details.action",{"rbdid":rbdid,"rbsid":rbsid,"title":title,"money":money,"note":note,},function(data){
			operateAlert(data,"报销项修改成功！","报销项修改失败！") ;
		},"json");
	}) ;
	$("#addBtn").on("click",function(){
		$("#reimbursementModal").modal("toggle") ;
	}) ;
	$("#rmBtn").on("click",function(){	// 进行删除事件的绑定处理
		ids = "" ; // 保存所有要删除数据的id
		$("input[id^=re-]:checked").each(function() {
			eid = $(this).attr("id").split("-") [1] ;
			rbsid = $(this).attr("id").split("-") [2] ;
			console.log("******rbsid***" + rbsid) ;
			ids += eid + ";" ;
//			console.log("*****ids**" + ids) ;
		})
		if (ids == "") {	// 没有要移除的商品
			operateAlert(false,"","请先选择要删除的数据！") ;
		} else {	// 现在有了要删除的数据，此时应该发送ajax异步请求进行删除调用
			$.post("pages/back/admin/reimbursement/delete_details.action",
					{"ids" : ids,"rbsid":rbsid} , function(data){
						if (data.flag) {
							$("input[id^=re-]:checked").each(function() {
								ed = $(this).attr("id").split("-") [1] ;
								$("#ooo-" + ed).remove() ;
							})
						}
						operateAlert(data.flag,"报销项信息删除成功！","报销项信息删除失败！") ;
					},"json") ;
		}
	}
	) ;
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 使用ajax进行表单提交处理
			$("#reimbursementModal").modal("toggle") ;
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"title" : {
				required : true
			} ,
			"money" : {
				required : true ,
				digits: true
			},
			"note" : {
				required : true
			}
		}
	});
})