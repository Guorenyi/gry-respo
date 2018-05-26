$(function() {
	$("button[id^=pub-]").each(function(){
		$(this).on("click",function() {
			misid = this.id.split("-")[1] ;
			console.log("任务发布，misid = " + misid) ;
			operateAlert(true,"任务发布成功，所有人员等待执行！","任务发布失败，请修改后重新发布！") ;
		}) ;
	}) ;
	$(selall).on("click",function(){
		$("input[id^=misid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
})