$(function(){
	$("span[id^=misid-]").each(function(){
		$(this).on("click",function(){
			debugger
			pid = this.id.split("-")[1] ; 
			console.log("任务ID，pid = " + pid) ;
			$("#scheduleModal").modal("toggle") ;
			$.post("pages/back/admin/schedule/schedule_details.action",{"pid":pid},function(data){
				//debugger
				
				$("#title").html(data.plan.title);
				$("#item").html(data.plan.item);
				$("#amount").html(data.plan.amount);
				$("#starttime").html(data.plan.starttime);
				$("#endtime").html(data.plan.endtime);
				$("#note").html(data.plan.note);
				$("#currentCount").html(data.plan.amount);
				//$("#emp--").remove();
				$("tr[id^=emp--]").each(function(){
					//debugger
					$("#emp-- tr:gt(0)").remove();
					for(i=0;i<data.allEmpLevelDept.length;i++){
					$("#emp--").append("<tr><td class='text-center'><img src='upload/emp/"+data.allEmpLevelDept[i].photo+"' style='width:20px;' </>"+"</td><td class='text-center'>"+data.allEmpLevelDept[i].ename+"</td><td class='text-center'>"+data.allEmpLevelDept[i].title+"</td><td class='text-center'>"+data.allEmpLevelDept[i].dname+"</td><td class='text-center'>"+data.allEmpLevelDept[i].phone+"</td><td class='text-center'>"+"</tr>");
					}
				}) ;	
			},"json") ;
		}) ;
	}) ;
})