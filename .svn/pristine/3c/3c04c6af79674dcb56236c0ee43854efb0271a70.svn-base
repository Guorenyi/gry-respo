$(function() {
	//点击任务发布
	$("button[id^=pub-]").each(function(){
		$(this).on("click",function() {
			console.log(this.id);
			pid = this.id.split("-")[1] ;
			
			$.post("pages/back/admin/plan/plan_publish.action",{pid:pid},function(data){
			//console.log(data);
			debugger
			//$("#status").html("已发布");statusDiv
			var statusMsg=document.getElementById("statusDiv");
			statusMsg.className="text-danger";
			statusMsg.innerHTML="已发布";
			operateAlert(data==true,"任务发布成功，所有人员等待执行！","任务发布失败，请修改后重新发布！") ;

		},"json") ;
			
		}) ;
	}) ;
	//点击全选
	$(selall).on("click",function(){
		$("input[id^=misid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;

		}) ;
	}) ;


	//点击删除任务
		$("#rmBtn").on("click",function(){	// 进行删除事件的绑定处理
		ids = "" ; // 保存所有要删除数据的id
		$("input[id^=misid-]:checked").each(function(){		
			ids += $(this).val()+";";
			console.log("要移除购物车的任务ID：" + $(this).val()) ;
			console.log(ids);
		}) ;

		if (ids == "") {	// 没有要移除的商品
			operateAlert(false,"","请先选择要移除的任务！") ;
		} else {	// 现在有了要删除的数据，此时应该发送ajax异步请求进行删除调用
			$.post("pages/back/admin/plan/plan_delete.action",
					{"ids" : ids} , function(data){
						if (data.flag) {
							//$("#gid:checked").each(function() {
							$("input[id^=misid-]:checked").each(function(){
								$("#plan-" + $(this).val()).remove() ;
							})
							
						}
						operateAlert(data.flag,"任务移除成功！","任务已发布，移除失败") ;
					},"json") ;
		}
	}) ;
})