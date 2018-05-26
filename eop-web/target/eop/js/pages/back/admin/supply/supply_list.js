
$(function(){
	var resid;
	$("button[id^=append-]").each(function(){
		$(this).on("click",function(){
			resid = this.id.split("-")[1] ; 
			console.log("办公用品编号，spid = " + resid) ;
			
			$("#supplyModal").modal("toggle") ;
		}) ;
	}) ;
	$("img").each(function(){
			$(this).on("click",function(){
			src = $(this).attr("src") ; 
			console.log("src = " + src) ;
			$("#modelImg").attr("src",src);
			$("#ImgModal").modal("toggle") ;
		}) ;
	}) ;
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 增加之后利用dom处理实现表格操作
			console.log("执行ajax异步请求操作实现数据增加。。") ; 
			$.post("pages/back/admin/supply/supply_goods_appendQty.action",
					{
						"resid" : resid,
						"appendQty":$("#amount").val()
					},
					function(data){
						if(data) {
						console.log(data);
						operateAlert(data,"追加成功！","追加失败！") ;
					}
				   $(window).attr('location',"pages/back/admin/supply/supply_goods_list.action");	
					},"json");
			$("#supplyModal").modal("toggle") ; 
			
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