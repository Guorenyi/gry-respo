amountOldValue=0
$(function() {
	$("#selall").on("click",function(){
		$("input[id^=reuid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
		calcAllPrice();
	}) ;
	function calcAllPrice() {
		allPrice=0.0;
		$("input[id^=amount-]").each(function(){
			gid = $(this).attr("id").split("-")[1];
			amount = parseInt($(this).val());
			price = parseFloat($("#price-" + gid).text());
			allPrice += amount * price;
		});
		$("#allPrice").text(round(allPrice,2));
	}
   
	$("button[id^=add-]").each(function(){
		$(this).on("click",function() {
			resid = this.id.split("-")[1] ;
			amount = parseInt($("#amount-" + resid).val());
			$("#amount-" + resid).val(amount+1);
			operateAlert(true,"数量增加成功","数量增加失败") ;
		}) ;
	}) ;
	
	$("button[id^=sub-]").each(function(){
		$(this).on("click",function(){
			resid = this.id.split("-")[1];
			amount = parseInt($("#amount-" + resid).val());
			if (amount <= 1) {
				$("#amount-" + resid).val(1);
				operateAlert(true,"数量不能少于1","数量不能少于1") ;
			} else {
				$("#amount-" + resid).val(amount - 1);
				operateAlert(true,"数量减少成功","商品减少失败") ;
			}
			
		});
	});
	
	$("input[id^=amount-]").each(function(){
		$(this).on("focus",function(){
			amountOldValue = $(this).val();
		});
		$(this).on("blur",function(){
			val = $(this).val();
			if (!/^\d+$/.test(val)) {
				$(this).val(amountOldValue);
				operateAlter(false,"","商品数量只允许输入数字!");
			}
		});
	}); 
	
	$("#rmBtn").on("click",function(){
		ids="";
		$("input[id^=reuid-]:checked").each(function(){
			ids += $(this).val() + ";";
			//console.log("要移除购物车的商品ID： " + ${this}.val());
		})
		if (ids == "") {
			operateAtert(false,"","请先选择要移除的商品！");
		} else {
			$.post("/eop/pages/back/admin/resource/shopcar_remove.action",
					{"ids" : ids},function(data){
						if (data.flag) {
							$("input[id^=reuid-]:checked").each(function(){
								$("#goods-" + $(this).val()).remove();
							})
							calcAllPrice();
						}
						operateAlert(data.flag,"购物车商品移除成功!","购物车商品移除失败!");
					},"json");
		}
	});
	
	$("button[id^=updateBtn-]").each(function(){
		$(this).on("click",function(){
			update_resid=$(this).attr("id").split("-")[1];
			amount=parseInt($("#amount-" + update_resid).val());
			if (amount != 0) {
				$.post("/eop/pages/back/admin/resource/shopcar_edit.action",{"resid" : update_resid,"amount" : amount},function(data){
					operateAlert(data.flag,"购物车商品信息修改成功!","购物车商品信息修改失败!");
				},"json");
			} else {
				$.post("/eop/pages/back/admin/resource/shopcar_remove.action",{"resid" : update_resid},function(data) {
					$("#goods-" + update_resid).remove();
					operateAlert(data.flag,"购物车商品移除成功!","购物车商品移除失败!");
				},"json");
			}
			calcAllPrice();
		});
	});
	
	$("button[id^=applyBtn-]").on("click",function(){
			allPrice = $("#allPrice").text();
			note = $("#note").val();
			update_resid=$(this).attr("id").split("-")[1];
			var tempAmt;
			var allamount=0;
			$("input[id^=amount-]").each(function(){
				tempAmt =parseInt($(this).val());
				allamount +=tempAmt ; 
			});
			$.post("/eop/pages/back/admin/resource/empresource_add.action",{"money" : allPrice,"amount" : allamount,"note" : note},function(data){
				$("#allgoods-" + update_resid).remove();
				$("#note").remove();
				operateAlert(data.flag,"申请单添加成功","申请单添加失败");
			},"json");
			
		});
})