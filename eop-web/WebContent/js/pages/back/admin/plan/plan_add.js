$(function(){
	
	// $("#type").on("blur",function(){
	// 	$.post("pages/back/admin/plan/plan_add_pre.action",{},function(data){
	// 		console.log(data);
	// 		$("#type option:gt(0)").remove() ;	//  清空已有数据
	// 		for (x = 0 ; x < data.length ; x ++) {
	// 			$("#type").append("<option value='" + data[x].dctid + "'>"
	// 									+ data[x].title + "</option>");
	// 		}

	// 	},"json") ;
	// });


	$("#start").datetimepicker({  
        format: 'yyyy-mm-dd hh:ii:ss',  
        minuteStep:1,  
        minView:'hour',  
        language: 'zh-CN',  
        pickerPosition:'bottom-right',  
        autoclose:true,  
    }).on("click",function(){  
        $("#start").datetimepicker("setEndDate",$("#end").val());  
    });
	$("#end").datetimepicker({  
        format: 'yyyy-mm-dd hh:ii:ss',  
        minuteStep:1,  
        minView:'hour',  
        language: 'zh-CN',  
        autoclose:true,  
        }).on("click",function(){  
            $("#end").datetimepicker("setStartDate",$("#start").val());  
        }); 
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
			operateAlert(true,"任务发布成功，所有人员等待执行！","任务发布失败，请修改后重新发布！") ;
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
			"type" : {
				required : true ,
				digits: true
			},
			"start" : {
				required : true 
			},
			"end" : {
				required : true 
			},
			"note" : {
				required : true
			}
		}
	});
})