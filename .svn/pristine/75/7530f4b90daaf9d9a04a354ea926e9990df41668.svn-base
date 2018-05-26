window.onload=function(){
	selectAllHandle("selall","rbsid") ;
	deleteHandle("delBut","rbsid","/eop/pages/back/admin/reimbursement/reimbursement_delete.action") ;
}
function selectAllHandle(keyEle,eles) {
	keyObject = document.getElementById(keyEle) ;
	keyObject.addEventListener("click",function(){
		boxArray = document.all(eles) ;
		if (boxArray.length == undefined) {
			boxArray.checked = this.checked ;
		} else {
			for (x = 0 ; x < boxArray.length ; x ++) {
				boxArray[x].checked = this.checked ; 
			}
		}
	},false) ;
};
function deleteHandle(delBut,valBox,url) {
	delButObject = document.getElementById(delBut) ;
	delButObject.addEventListener("click",function(){
		ids = "" ;
		boxArray = document.all(valBox) ;
		if (boxArray.length == undefined) {	// 一个元素
			if (boxArray.checked) {	// 选中了数据
				ids += boxArray.value ;
			}
		} else {
			for (x = 0 ; x < boxArray.length ; x ++) {
				if (boxArray[x].checked) {
					ids += boxArray[x].value + "," ;
				} 
			}
		}
		if (ids == "") {// 现在没有数据被选择
//			alert("您还未选择任何要删除的数据。") ;
		} else {
			if (true) {
				window.location = url + "?ids=" + ids ;
			}
		}
	},false) ;
}