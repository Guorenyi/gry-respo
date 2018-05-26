$(function(){
	$("button[id^=rdtid-]").each(function() {
		$(this).on("click",function(){
			$("#reimbursementModal").modal("toggle") ;
		}) ;
	}) ;
	$("#addBtn").on("click",function(){
		$("#reimbursementModal").modal("toggle") ;
	}) ;
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