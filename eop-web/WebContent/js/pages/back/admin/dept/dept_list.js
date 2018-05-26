$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = $(this).attr("id").split("-")[1] ;
			dname = $("#dname-" + did).val() ;
			note = $("#note-" + did).val() ;
			maxnum = $("#maxnum-" + did).val() ;
			if (dname == "") { 
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/dept/dept_edit.action",{
					"did" : did ,
					"dname" : dname,
					"note" : note,
					"maxnum" : maxnum
				},function(data){
					operateAlert(data,"部门信息修改成功！","部门信息修改失败！") ;
				},"json");
			}
		}) ;
	}) ;
	$("span[id^=eid--]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("--")[1] ;
			$.post("pages/back/admin/emp/list_info.action",
					{"eid":eid} , function(data){
						console.log("*******" + data.emp.photo) ;
						$("#photos").attr("src","upload/emp/"+ data.emp.photo) ;
						$("#ename").html(data.emp.ename) ;
						$("#title").html(data.emp.title) ;
						$("#salary").html(data.emp.salary) ;
						$("#dname").html(data.emp.dname) ;
						$("#phone").html(data.emp.phone) ;
						$("#hiredate").html(data.emp.hiredate) ;
						$("#note").html(data.emp.note) ;
						$("#ta tbody").html("") ;
						$("#tb tbody").html("") ;
						for(var i = 0 ;i<data.allEmpsCars.length ;i++){
							$("#ta tbody").prepend("<tr><td>"+data.allEmpsCars[i].company+"</td><td>"+data.allEmpsCars[i].position+"</td><td>"+data.allEmpsCars[i].salary+"</td><td>"+new Date(data.allEmpsCars[i].entry).format("yyyy-MM-dd")+"</td><td>"+new Date(data.allEmpsCars[i].quit).format("yyyy-MM-dd")+"</td>"+"</tr>");
						};
						for(var i = 0 ;i<data.allEmpEdus.length ;i++){
							$("#tb tbody").prepend("<tr><td>"+data.allEmpEdus[i].school+"</td><td>"+data.allEmpEdus[i].degree+"</td><td>"+data.allEmpEdus[i].major+"</td><td>"+new Date(data.allEmpEdus[i].entrance).format("yyyy-MM-dd")+"</td><td>"+new Date(data.allEmpEdus[i].graduation).format("yyyy-MM-dd")+"</td>"+"</tr>");
						};
					},"json") ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;