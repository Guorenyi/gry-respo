$(function() {
	$("button[id^=add-]").each(function(){
		$(this).on("click",function() {
			resid = this.id.split("-")[1] ;
			console.log("追加待领取商品，resid = " + resid) ;
			operateAlert(true,"待领取商品添加成功，请至待领取清单查询。","") ;
		}) ;
	}) ;
})