$(function(){
	$("button[id^=edit-]").each(function() {
		$(this).on("click",function() {
			ecarid = $(this).attr("id").split("-") [1] ;
			$.post("pages/back/admin/emp/list_career_id.action",{"ecarid":ecarid},function(data){
				$("#companycar").attr("value",data.company) ;
				$("#salarycar").attr("value",data.salary) ;
				$("#positioncar option[value='"+data.position+"']").attr("selected",true);
				$("#entrycar").attr("value",new Date(data.entry).format("yyyy-mm-dd")) ;
				$("#quitcar").attr("value",new Date(data.quit).format("yyyy-mm-dd")) ;
				$("#reasoncar").attr("value",data.reason) ;
				$("#notecar").val(data.note) ;
			},"json");
			$("#ecarids").attr("value",ecarid) ;
			$("#empCareerEditModal").modal("toggle") ; 
		}) ;
	}) ;
	$(selall).on("click",function(){
		$("input[id^=eid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	$("#addCareer").on("click",function(){
		$("#empCareerModal").modal("toggle") ;
	}) ;
	$("#entry").datetimepicker({
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
	$("#entrycar").datetimepicker({
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
	$("#editCareer").on("click",function(){
		company = $("#company").val() ;
		salary = $("#salary").val() ;
		position = $("#position").val() ;
		entry = $("#entry").val() ;
		quit = $("#quit").val() ;
		reason = $("#reason").val() ;
		note = $("#note").val() ;
		eid = $("#eid").val() ;
		$.post("pages/back/admin/emp/emp_add_career.action",{"eid":eid,"company":company,"salary":salary,
			"position":position,"entry":entry,"quit":quit,"reason":reason,"note":note,},"json");
	}) ;
	$("#editNewCareer").on("click",function(){
		ecarid = $("#ecarids").val() ;
		eid = $("#eid").val() ;
		company = $("#companycar").val() ;
		salary = $("#salarycar").val() ;
		position = $("#positioncar").val() ;
		entry = $("#entrycar").val() ;
		quit = $("#quitcar").val() ;
		reason = $("#reasoncar").val() ;
		note = $("#notecar").val() ;
		$.post("pages/back/admin/emp/emp_edit_career.action",{"ecarid":ecarid,"eid":eid,"company":company,"salary":salary,
			"position":position,"entry":entry,"quit":quit,"reason":reason,"note":note,},"json");
	}) ;
	$("#rmBtn").on("click",function(){	// 进行删除事件的绑定处理
		ids = "" ; // 保存所有要删除数据的id
		$("input[id^=eid-]:checked").each(function() {
			ecarid = $(this).attr("id").split("-") [1] ;
			ids += ecarid + ";" ;
//			console.log("*******ids*" + ids) ;
			//console.log("要移除购物车的商品ID：" + $(this).val()) ;
		})
		if (ids == "") {	// 没有要移除的商品
			operateAlert(false,"","请先选择要删除的数据！") ;
		} else {	// 现在有了要删除的数据，此时应该发送ajax异步请求进行删除调用
			$.post("pages/back/admin/emp/delete_emp_career.action",
					{"ids" : ids} , function(data){
						if (data.flag) {
							$("input[id^=eid-]:checked").each(function() {
								ed = $(this).attr("id").split("-") [1] ;
								$("#xxx-" + ed).remove() ;
							})
						}
						operateAlert(data.flag,"职业经历删除成功！","职业经历删除失败！") ;
					},"json") ;
		}
	}) ;
	
	$("#quit").datetimepicker({
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
	$("#quitcar").datetimepicker({
		language: 'zh-CN', 	// 中文资源文件
		weekStart: 1,		// 一周从哪一天开始 0表示星期天
		todayBtn:  true,		// 日期时间选择器组件的底部显示一个 "Today" 按钮用以选择当前日期。
		autoclose: true, 		// 当选择一个日期之后是否立即关闭此日期时间选择器。
		todayHighlight: 1,	// 如果为true, 高亮当前日期
		startView: 2, 		// 日期时间选择器打开之后首先显示的视图。 2 or 'month' for month view (the default)
		forceParse: 0,		// 当选择器关闭的时候，是否强制解析输入框中的值。
		showMeridian: 1 , 	// 选项里是否有天或小时
		minView: "month" , 	// 选择日期后，不会再跳转去选择时分秒
		format: 'yyyy-mm-dd' 
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
			"company" : {
				required : true
			} ,
			"salary" : {
				required : true ,
				number : true
			},
			"position" : {
				required : true
			},
			"reason" : {
				required : true
			},
			"entry" : {
				required : true ,
				dateISO : true
			},
			"quit" : {
				required : true ,
				dateISO : true
			}, 
			"note" : {
				required : true
			}
		}
	});
})