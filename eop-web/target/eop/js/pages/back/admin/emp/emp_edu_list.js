$(function(){
	$("button[id^=edit-]").each(function() {
		$(this).on("click",function() {
//			console.log("使用ajax进行异步数据加载，获取一份员工教育背景并且进行表单回填...") ;
//			$("#empEduEditModal").modal("toggle") ; 
			eeduid = $(this).attr("id").split("-") [1] ;
			$.post("pages/back/admin/emp/list_edu_id.action",{"eeduid":eeduid},function(data){
				$("#schooledu").attr("value",data.school) ;
				$("#majoredu").attr("value",data.major) ;
				$("#degreeedu option[value='"+data.degree+"']").attr("selected",true);
				$("#entranceedu").attr("value",new Date(data.entrance).format("yyyy-mm-dd")) ;
				$("#graduationedu").attr("value",new Date(data.graduation).format("yyyy-mm-dd")) ;
				$("#noteedu").val(data.note) ;
			},"json");
			$("#eeduids").attr("value",eeduid) ;
			$("#empEduEditModal").modal("toggle") ; 
		}) ;
	}) ;
	$("#selall").on("click",function(){
		$("input[id^=eid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	$("#rmBtn").on("click",function(){	// 进行删除事件的绑定处理
		ids = "" ; // 保存所有要删除数据的id
		$("input[id^=eid-]:checked").each(function() {
			eeduid = $(this).attr("id").split("-") [1] ;
			ids += eeduid + ";" ;
//			console.log("*******ids*" + ids) ;
			//console.log("要移除购物车的商品ID：" + $(this).val()) ;
		})
		if (ids == "") {	// 没有要移除的商品
			operateAlert(false,"","请先选择要删除的数据！") ;
		} else {	// 现在有了要删除的数据，此时应该发送ajax异步请求进行删除调用
			$.post("pages/back/admin/emp/delete_emp_edu.action",
					{"ids" : ids} , function(data){
						if (data.flag) {
							$("input[id^=eid-]:checked").each(function() {
								ed = $(this).attr("id").split("-") [1] ;
								$("#sss-" + ed).remove() ;
							})
						}
						operateAlert(data.flag,"教育背景删除成功！","教育背景删除失败！") ;
					},"json") ;
		}
	}) ;
	$("#addEdu").on("click",function(){
		$("#empEduModal").modal("toggle") ;
	}) ;
	$("#entrance").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
	    todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
	    autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
	    todayHighlight: 1,	// 如果为true, 高亮当前日期
	    startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
	    forceParse: 1,		// 当选择器关闭的时候，是否强制解析输入框中的值。
	    showMeridian: 1 , 	// 选项里是否有天或小时
	    minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
	    format: 'yyyy-mm-dd' 
    });
	$("#entranceedu").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
		todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
		autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
		todayHighlight: 1,	// 如果为true, 高亮当前日期
		startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
//		forceParse: 0,		// 当选择器关闭的时候，是否强制解析输入框中的值。
		showMeridian: 1 , 	// 选项里是否有天或小时
		minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
//		format: 'yyyy-mm-dd' 
	});
	$("#graduation").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
	    todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
	    autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
	    todayHighlight: 1,	// 如果为true, 高亮当前日期
	    startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
	    forceParse: 1,		// 当选择器关闭的时候，是否强制解析输入框中的值。
	    showMeridian: 1 , 	// 选项里是否有天或小时
	    minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
	    format: 'yyyy-mm-dd' 
    });
	$("#graduationedu").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
		todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
		autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
		todayHighlight: 1,	// 如果为true, 高亮当前日期
		startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
		forceParse: 1,		// 当选择器关闭的时候，是否强制解析输入框中的值。
		showMeridian: 1 , 	// 选项里是否有天或小时
		minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
		format: 'yyyy-mm-dd' 
	});
	$("#editEducationss").on("click",function(){
		school = $("#school").val() ;
		eid = $("#eid").val() ;
		major = $("#major").val() ;
		degree = $("#degree").val() ;
		entrance = $("#entrance").val() ;
		graduation = $("#graduation").val() ;
		note = $("#note").val() ;
		$.post("pages/back/admin/emp/emp_add_edu.action",{"eid":eid,"school":school,"major":major,"degree":degree,
			"entrance":entrance,"graduation":graduation,"note":note},"json");
	}) ;
	$("#editNewEducation").on("click",function(){
		school = $("#schooledu").val() ;
		eeduid=$("#eeduids").val() ;
		eid = $("#eid").val() ;
		major = $("#majoredu").val() ;
		degree = $("#degreeedu").val() ;
		entrance = $("#entranceedu").val() ;
		graduation = $("#graduationedu").val() ;
		note = $("#noteedu").val() ;
		$.post("pages/back/admin/emp/emp_edit_edu.action",{"eeduid":eeduid,"eid":eid,"school":school,"major":major,"degree":degree,
			"entrance":entrance,"graduation":graduation,"note":note},"json");
	}) ;
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 增加之后利用dom处理实现表格操作
//			console.log("执行ajax异步请求操作实现数据增加。。") ; 
			$("#empEduModal").modal("toggle") ; 
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
			"school" : {
				required : true
			} ,
			"major" : {
				required : true
			},
			"degree" : {
				required : true
			},
			"entrance" : {
				required : true ,
				dateISO : true
			},
			"graduation" : {
				required : true ,
				dateISO : true
			}, 
			"note" : {
				required : true
			}
		}
	});
	$("#myform2").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 增加之后利用dom处理实现表格操作
//			console.log("执行ajax异步请求操作实现数据增加。。") ; 
			$("#empEduEditModal").modal("toggle") ; 
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
			"schooledu" : {
				required : true
			} ,
			"majoredu" : {
				required : true
			},
			"degreeedu" : {
				required : true
			},
			"entranceedu" : {
				required : true ,
				dateISO : true
			},
			"graduationedu" : {
				required : true ,
				dateISO : true
			}, 
			"noteedu" : {
				required : true
			}
		}
	});
})