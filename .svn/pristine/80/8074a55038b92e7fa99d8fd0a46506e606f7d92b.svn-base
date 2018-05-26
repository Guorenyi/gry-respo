$(function(){
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
	
	$("#addEmpBut").on("click",function(){
		$("#planEmpInfo").modal("toggle") ;
	}) ;
	
	$("button[id^=remove-]").each(function(){
		$(this).on("click",function() {
			eid = this.id.split("-")[1] ;
			operateAlert(true,"任务人员移除成功！","任务人员移除失败！") ;
		}) ;
	}) ;
})