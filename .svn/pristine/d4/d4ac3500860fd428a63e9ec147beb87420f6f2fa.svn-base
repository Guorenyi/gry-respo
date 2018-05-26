$(function() {
	$("button[id^=addcar-]").each(function(){
		var resid = $(this).attr("id").split("-")[1];
		console.log(resid);
		$(this).on("click",function() {
			//$.post("/pages/back/admin/resource/shopcar_add.action",{
			$.post("/eop/pages/back/admin/resource/shopcar_add.action",{
			"resid" : resid	
			},function(data){
				operateAlert(true,"待领取商品添加成功，请至待领取清单查询。","") ;	
			},"json");	
		}) ;
	}) ;
})