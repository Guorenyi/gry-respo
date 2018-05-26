$(function(){
	$(selall).on("click",function(){
		$("input[id^=eid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
	}) ;
	$("img").each(function(){
		$(this).on("click",function(){
		src = $(this).attr("src") ; 
		console.log("src = " + src) ;
		$("#modelImg").attr("src",src);
		$("#ImgModal").modal("toggle") ;
	}) ;
	}) ;
	$("span[id^=eid--]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("--")[1] ;
//			console.log("雇员编号：" + eid) ;
			$.post("pages/back/admin/emp/list_info.action",
					{"eid":eid} , function(data){
						$("#photos").attr("src","upload/"+ data.emp.photo) ;
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
	$("#rmBtn").on("click",function(){	// 进行删除事件的绑定处理
		ids = "" ; // 保存所有要删除数据的id
		$("input[id^=eid-]:checked").each(function() {
			eid = $(this).attr("id").split("--") [1] ;
			ids += eid + ";" ;
		})
		if (ids == "") {	// 没有要移除的商品
			operateAlert(false,"","请先选择要删除的数据！") ;
		} else {	// 现在有了要删除的数据，此时应该发送ajax异步请求进行删除调用
			$.post("pages/back/admin/emp/delete_emp.action",
					{"ids" : ids} , function(data){
						if (data.flag) {
							$("input[id^=eid-]:checked").each(function() {
								ed = $(this).attr("id").split("--") [1] ;
//								console.log("****ed***" + ed) ;
								$("#ooo--" + ed).remove() ;
							})
						}
						operateAlert(data.flag,"雇员信息删除成功！","雇员信息删除失败！") ;
					},"json") ;
		}
	}
	) ;
})