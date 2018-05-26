$(function(){
	//点击移除按钮的操作
	$("button[id^=remove--]").each(function(){
		$(this).on("click",function() {
			debugger
			eid = this.id.split("--")[1] ;
			pid = this.id.split("--")[2];

			//console.log(eid);
			$.post("pages/back/admin/plan/plan_delete_emp.action",{"eid":eid,"pid":pid},function(data){
				debugger
				//$("#remove--"+eid).remove();
				//$("#remove--"+eid).empty();
				$("#info-"+eid).remove();  //删除相应的行
				

				operateAlert(data==true,"任务人员删除成功！","任务人员删除失败！") ;
				
			},"json") ;

			
		}) ;
	}) ;


	//点击雇员姓名进入的模块窗口
	$("span[id^=eid--]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("--")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#userInfo").modal("toggle") ;
			//$.post("pages/back/admin/plan/plan_add_emp.action",{"eid":eid,"pid":pid},function(data){
			$.post("pages/back/admin/plan/plan_emp.action",{"eid":eid},function(data){
				debugger
				//console.log(data);
				$("#photo").attr("src","upload/emp/"+data.photo);
				$("#ename").html(data.ename);
				$("#title").html(data.title);
				$("#dname").html(data.dname);
				$("#phone").html(data.phone);
				
			},"json") ;
		}) ;
	}) ;
	
	//进入增加任务人员的模态窗口
	$("#addEmpBut").on("click",function(){
		$("#planEmpInfo").modal("toggle") ;

		// $.post("pages/back/admin/plan/plan_details_modal.action",{},function(){
		// 	operateAlert(true,"任务发布成功，所有人员等待执行！","任务发布失败，请修改后重新发布！") ;
		// },"json") ;


		
	}) ;
	

	// $("#did").on("change",function(){
	// 	did = $(this).val() ; // 获取当前的选中内容
	// 	if (did != "") {	// 选中了操作数据
	// 		$.post("pages/back/admin/plan/plan_details_modal.action",{"did":did},function(data){
	// 			//$("#cid option:gt(0)").remove() ;	//  清空已有数据
	// 			for (x = 0 ; x < data.length ; x ++) {
	// 				$("#cid").append("<option value='" + data[x].cid + "'>"
	// 										+ data[x].title + "</option>");
	// 			}
				
	// 		},"json") ;
	// 	}});
	

	//模态窗口内点击部门数据的更新操作
	$("#did").on("change",function(){
		debugger
		did = $(this).val() ; // 获取当前的选中内容
		//if (did != ""  did!=0) {	// 选中了操作数据
		if (did!=0) {
			$.post("pages/back/admin/plan/plan_list_dept.action",{"did":did},function(data){
				debugger
				console.log(data);
				//$("#cid option:gt(0)").remove() ;	//  清空已有数据
				//$("#did tr:gt(0)").remove();
				//console.log(eval("("+data+")"));
				// for (x = 0 ; x < data.length ; x ++) {
				// 	$("#cid").append("<option value='" + data[x].cid + "'>"
				// 							+ data[x].title + "</option>");
				// }
				

				//data = this.data;
				$("tr[id^=emp-]").each(function(){
				//$("tr[id^=-eid]").each(function(){
					//$(this).on("click",function(){
						debugger
						edid = this.id.split("-")[1] ;
						//console.log("雇员编号：" + eid) ;
						if(edid != did){
							this.remove();
						}
						debugger
						if(edid=""){
							
							$.post("pages/back/admin/plan/plan_list_dept.action",{"did":did},function(data){},"json") ;
							
						}
						
						console.log(this.id.split("-")[1]);
						
						//console.log(this.id[0]);
						//$("#userInfo").modal("toggle") ;
					//}) ;
				}) ;

				// $("tr[id^=emp-]").each(function(){
				// 		eeid = this.id.split("-")[1] ;
				// 		debugger
						
				// 		console.log(eeid);
				// 		//console.log("雇员编号：" + eid) ;
				// 		//this.append("<td class="text-center">"+<img src="upload/emp/data.value.photo" +style="width:20px;"/> 
				// 			//	</td>);
				// 		//this.append("<td class=\"text-center\">"+ data.allEmps[0].eid+"</td>");
				// 		//this.append(data.allEmps[0].eid);
				// 		//$("tr[emp-0]").append("<td class=\"text-center\">"+ data.allEmps.eid+"</td>");
				// 		$("#emp-"+eeid).append("<td class=\"text-center\">"+ data.allEmps[0].eid+"</td>");
				// 		$("#emp-"+eeid).append("<td class=\"text-center\">"+ data.allEmps[0].ename+"</td>");
				// 		$("#emp-"+eeid).append("<td class=\"text-center\">"+ data.allEmps[0].title+"</td>");
						
				// }) ;


			},"json") ;


			
		}else if(did==0){
			debugger
			$.post("pages/back/admin/plan/plan_list_dept.action","did:did",function(data){
				$("tr[id^=emp-]").each(function(){
						 eeid = this.id.split("-")[1] ;
						 debugger
						console.log(data.allEmps.length);
						// console.log(eeid);
						for (x = 0 ; x < data.allEmps.length ; x ++) {
							$("#emp-"+eeid).append("<td class=\"text-center\">"+ data.allEmps[x].eid+"</td>");
							$("#emp-"+eeid).append("<td class=\"text-center\">"+ data.allEmps[x].ename+"</td>");
							$("#emp-"+eeid).append("<td class=\"text-center\">"+ data.allEmps[x].title+"</td>");
						}
						
				}) ;

				
			},"json") ;
			//alert("*****************");
		}else{

		}
		
	});

	//模态窗口内点击增加的操作
	$("button[id^=add--]").each(function(){
		$(this).on("click",function() {
			debugger
			eid = this.id.split("--")[1] ;
			pid = this.id.split("--")[2];
			console.log(pid);
			$.post("pages/back/admin/plan/plan_add_emp.action",{"eid":eid,"pid":pid},function(data){
				debugger
				console.log(data);
				console.log($(this));
				$("add--"+eid).html("已增加");
				//$("#add--"+eid).context.innerText="已增加";
				$("#add--"+eid).context.className="btn btn-primary btn-xs";
				// $("button[id^=add--]").each(function(){
				// 	debugger
				// 	$("#add--"+eid).context.innerText="已增加";
				// 	$("#add--"+eid).context.className="btn btn-primary btn-xs";
					
				// });
				//$(#showDiv).replaceWith("<span class="glyphicon glyphicon-plus-sign" id="showDiv"></span>&nbsp;已增加</button>");
				operateAlert(data==true,"任务人员添加成功！","任务人员添加失败！") ;
			},"json") ;
			
		}) ;
	}) ;
})