$(function(){
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