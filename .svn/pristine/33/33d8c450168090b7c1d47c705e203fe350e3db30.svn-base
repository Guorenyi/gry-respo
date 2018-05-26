$(function() {
	$("button[id^=add-]").each(function(){
		$(this).on("click",function() {
			eresid = this.id.split("-")[1];
			resid = this.id.split("-")[2] ;
			amount = parseInt($("#amount-" + eresid + "-" + resid).val());
			$("#amount-"+ eresid + "-" + resid).val(amount + 1);
			operateAlert(true,"待领取商品添加成功，请至待领取清单查询。","") ;
		}) ;
	}) ;
	
	
	$("button[id^=sub-]").each(function(){
		$(this).on("click",function(){
			eresid = this.id.split("-")[1];
			resid = this.id.split("-")[2] ;
			amount = parseInt($("#amount-" + eresid + "-" + resid).val());
			if (amount <= 0) {
				$("#amount-"+ eresid + "-" + resid).val(amount);
			} else {
				$("#amount-"+ eresid + "-" + resid).val(amount - 1);
				operateAlert(true,"待领取商品添加成功，请至待领取清单查询。","") ;
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
				operateAlert(false,"","商品数量只允许输入数字!");
			}
		});
	}); 
	
	function calcAllPrice() {
		allPrice=0.0;
		allamount=0;
		$("input[id^=amount-]").each(function(){
			eresid = $(this).attr("id").split("-")[1];
			resid = $(this).attr("id").split("-")[2];
			amount = parseInt($(this).val());
			price = parseFloat($("#price-" + eresid + "-" + resid).text());
			allPrice += amount * price;
			allamount += amount;
		});
		$("#allPrice").text(round(allPrice,2));
		$("#allamount").text(allamount);
	}
	
	$("#selall").on("click",function(){
		$("input[id^=reuid-]").each(function(){
			$(this).prop("checked",$(selall).prop("checked")) ;
		}) ;
		calcAllPrice();
	}) ;

	
	$("#rmBtn").on("click",function(){
		
		resid="";
		eresid="";
		$("input[id^=reuid-]:checked").each(function(){
			resid += $(this).val() + ";";
			eresid = this.id.split("-")[1];	
		})
		if (resid == "") {
			operateAtert(false,"","请先选择要移除的商品！");
		} else {
			$.post("/eop/pages/back/admin/resource/Details_delete.action",
					{"resid" : resid,"eresid" : eresid},function(data){
						if (data.flag) {
							console.log(data);
							$("input[id^=reuid-]:checked").each(function(){
								$("#goods-" + $(this).val()).remove();
							})
							calcAllPrice();
						}
						operateAlert(data.flag,"购物车商品移除成功!","购物车商品移除失败!");
					},"json");
		}
	});
	
	
	
	$("button[id^=save-]").on("click",function(){
		$(this).on("click",function(){
			eresid=$(this).attr("id").split("-")[1];
			resid=$(this).attr("id").split("-")[2];
			price = parseFloat($("#price-" + eresid + "-" + resid).text());
			amount=parseInt($("#amount-"+ eresid + "-" + resid).val());
			money = price * amount;
			if (amount != 0) {
				$.post("/eop/pages/back/admin/resource/Details_editamount.action",{"resid" : resid,"eresid" : eresid,"amount" : amount,"money" : money},function(data){
					operateAlert(data.flag,"购物车商品信息修改成功!","购物车商品信息修改失败!");
				},"json");
			} else {
				$.post("/eop/pages/back/admin/resource/Details_delete.action",{"resid" : resid,"eresid" : eresid},function(data) {
					$("#goods-" + resid).remove();
					operateAlert(data.flag,"购物车商品移除成功!","购物车商品移除失败!");
				},"json");
			}
			calcAllPrice();
			$("#money-"+ eresid + "-" + resid).text(money);
	});
	});
	
	
	$("#subBtn").on("click",function(){
		money=0.0;
		amount=0;
		$("input[id^=amount-]").each(function(){
			eresid = $(this).attr("id").split("-")[1];
			resid = $(this).attr("id").split("-")[2];
			amounts = parseInt($(this).val());
			price = parseFloat($("#price-" + eresid + "-" + resid).text());
			money += amounts * price;
			amount += amounts;
		});
		$("#allPrice").text(round(money,2));
		$("#allamount").val(amount);
		$.post("/eop/pages/back/admin/resource/Details_editempres.action",{"eresid" : eresid,"amount" : amount,"money" : money},function(data){
			operateAlert(data.flag,"购物车商品信息修改成功!","购物车商品信息修改失败!");
		},"json");
		calcAllPrice();
	});

})