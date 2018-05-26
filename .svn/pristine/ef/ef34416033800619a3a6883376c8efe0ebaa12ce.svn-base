$(function(){
	$("button[id^=append-]").each(function(){
		$(this).on("click",function(){
			spid = this.id.split("-")[1] ; 
			console.log("办公用品编号，spid = " + spid) ;
			$("#supplyModal").modal("toggle") ;
		}) ;
	}) ;
	$("#rmBtn").on("click",function(){
		   //判断申请单状态是否可以删除明细
		    $.post("pages/back/admin/supply/supply_status_check.action",
				{"spid" : $("#spid").val()},
				function(data){
					if(!data){
						operateAlert(false,"","该申请单已提交或已审核，,不能删除！") ;
					}
				},"json");
		ids = "" ;
		console.log("ssss");
		$("input[id^=resid-]").each(function(){
			if($(this).prop("checked")) {
				ids = ids + $(this).val() + ";" ;
		}
	});
	if(ids != "") {
		$.post("pages/back/admin/supply/supply_goods_delete.action",
		{
			"resid" : ids,
			"spid" : $("#spid").val()
		},
		function(data){
			console.log("data===="+data);
			if(data==1) {
				$("input[id^=resid-]").each(function(){
					if($(this).prop("checked")) {
						//only status=0 can be remove
						
						//if($("#" + $(this).val()).attr("status") == 0) {
							$("#tr-" + $(this).val()).remove() ;
						//}
					}
				}) ;
			}
			console.log(data);
			operateAlert(data==1,"删除成功！","该申请单已提交或已审核，不能删除清单数据！") ;
		},"json");
	} else {
		operateAlert(false,"","未选择删除的数据") ;
	};	
	});
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 增加之后利用dom处理实现表格操作
			console.log("执行ajax异步请求操作实现数据增加。。") ; 
			$("#empCareerModal").modal("toggle") ; 
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
			"amount" : {
				required : true
			} 
		}
	});
})