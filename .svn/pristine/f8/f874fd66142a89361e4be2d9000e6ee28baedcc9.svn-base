$(function(){

		$("#subBtn").on("click",function(){
			//提交前检查是否有申请单明细
			 $.post("pages/back/admin/supply/supply_submit_check.action",
				{"spid" : $("#spid").val()},
				function(data){
					console.log(data);
					console.log(data==2);
					 // -1:表示已提交或已审核，不能再次提交
					 //			0:表示无明细，不能提交
					 //			1:表示可以正常提交
						if(data==2||data==0){
							console.log("ssss");
							operateAlert(data==2,"该申请单不是草稿状态,不能提交！","请加入明细后再提交！") ;
							return;
						}
						var message = confirm("确认提交采购申请单吗");
						console.log(message);
						if(message==true){
							$(window).attr('location',"pages/back/admin/supply/supply_submit.action?spid="+$("#spid").val());
						}else{
							return;
						}
				},"json");
			
		});	

		if(($("#status").val()==1||$("#status").val()==3)){
			$("#subBtn").remove();
		}
		//根据申请单的状态设置按钮是否可用
		   $.post("pages/back/admin/supply/supply_status_check.action",
			{"spid" : $("#spid").val()},
			function(data){
				if(!data){
					//$("#addBtn").attr("disabled","true");
					//$("#addBtn").attr("href","/");
					$("#addBtn").remove();
					$("#rmBtn").remove();
				}
			},"json");
		 
			$("img").each(function(){
				$(this).on("click",function(){
				src = $(this).attr("src") ; 
				console.log("src = " + src) ;
				$("#modelImg").attr("src",src);
				$("#ImgModal").modal("toggle") ;
			}) ;
		}) ;
		
		$("#rmBtn").on("click",function(){
			   //判断申请单状态是否可以删除明细
			    $.post("pages/back/admin/supply/supply_status_check.action",
					{"spid" : $("#spid").val()},
					function(data){
						if(!data){
							operateAlert(false,"","该申请单不是草稿状态,不能删除清单记录！") ;
						}
					},"json");
			ids = "" ;
			$("input[id^=resid-]").each(function(){
				if($(this).prop("checked")) {
					ids = ids + $(this).val() + ";" ;
				}
		})
		if(ids != "") {
			$.post("pages/back/admin/supply/supply_goods_delete.action",
			{
				"resid" : ids,
				"spid" : $("#spid").val()
			},
			function(data){
				if(data==1) {
					$("input[id^=resid-]").each(function(){
						if($(this).prop("checked")) {
							//only status=0 can be remove
							//if($("#" + $(this).val()).attr("status") == 0) {
								$("#tr-" + $(this).val()).remove() ;
							//}
						}
					}) ;
				}

				//删除成功，重新计算总数量与总金额
				var totalAmt=0;
				var totalMoney=0.0;
				$("#supplyListTable tr[id^=tr-]").each(function(index,tr){
					trid=$(tr).attr("id");
					totalAmt+=parseInt($("#"+trid+" td[id^=amount-]").text());
					totalMoney+=parseFloat($("#"+trid+" td[id^=price-]").text())*parseInt($("#"+trid+" td[id^=amount-]").text());
				});
				//设置总数量与总金额
				$("#total_amount").text(totalAmt);
				$("#total_money").text(totalMoney);
				operateAlert(data==1,"删除成功！","该申请单不是草稿状态,不能删除清单记录！") ;
			},"json");
		} else {
			operateAlert(false,"","未选择删除的数据") ;
		};	
		});

		
	$("#selall").click(function(){
		$("input[id^=resid-]").prop("checked",this.checked);
	});
});
