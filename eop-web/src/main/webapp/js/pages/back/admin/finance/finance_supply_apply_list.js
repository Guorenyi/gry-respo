$(function(){
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#userInfo").modal("toggle") ; 
		}) ;
	}) ;
})