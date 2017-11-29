$(function(){
	$("#usEmail").bind('input propertychange',function(){
		var usId = $("#usId").val();
		var value = $(this).val();
		value = $.trim(value);
		alert(value)
		if(value != ""){
			var url = "/school/user/verifyUser";
			var args = {"usId":usId,"usEmail":value, "time":new Date()};
			var msg=document.getElementById("msg");
			$.post(url,args,function(date){
				if (date == "true") {
					  msg.innerHTML="<font color='green'>可修改为此账号</font>";
					   document.getElementById("submit").disabled = false;
				} else {
					  msg.innerHTML="<font color='red'>不可修改为此账号，请重新输入</font>";
					   document.getElementById("submit").disabled = true;
				}
			});
		}
	});
	
	
	$("#tyCategoryname").bind('input propertychange',function(){
		var value = $(this).val();
		var tyId = $("#tyId").val();
		value = $.trim(value);
		if(value != ""){
			var url = "/school/type/verifyType";
			var args = {"tyId":tyId,"tyCategoryname":value, "time":new Date()};
			var msg=document.getElementById("msg");
			$.post(url,args,function(date){
				if (date == "true") {
					  msg.innerHTML="<font color='green'>可修改为此类别名称</font>";
					  document.getElementById("submit").disabled = false;
				} else {
					  msg.innerHTML="<font color='red'>不可修改为此类别名称，请重新输入</font>";
					  document.getElementById("submit").disabled = true;
				}
			});
		}
	});
	
	
})