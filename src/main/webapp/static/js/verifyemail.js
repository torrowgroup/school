$(function(){
	$("#usEmail").change(function(){
		var value = $(this).val();
		value = $.trim(value);
		if(value != ""){
			var url = "/school/user/verifyEmail";
			var args = {"usEmail":value, "time":new Date()};
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
		value = $.trim(value);
		if(value != ""){
			var url = "/school/type/verifyTypeName";
			var args = {"tyCategoryname":value, "time":new Date()};
			var msg=document.getElementById("msg");
			$.post(url,args,function(date){
				if (date == "true") {
					  msg.innerHTML="<font color='green'>可添加为此类别名称</font>";
					  document.getElementById("submit").disabled = false;
				} else {
					  msg.innerHTML="<font color='red'>不可添加为此类别名称，请重新输入</font>";
					  document.getElementById("submit").disabled = true;
				}
			});
		}
	});
	
	
	
	
})