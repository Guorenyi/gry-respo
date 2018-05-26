$(function(){
	$("span[id^=resid-]").each(function(){
		$(this).on("click",function(){
			resid = this.id.split("-")[1] ;
			$("#resourceModal").modal("toggle") ;
		}) ;
	}) ;
})