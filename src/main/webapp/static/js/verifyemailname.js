$(function(){
	$("#usEmail").bind('input propertychange',function(){
		var value = $(this).val();
		value = $.trim(value);
		if(value != ""){
			var url = "/school/user/verifyEmailName";
			var args = {"usEmail":value, "time":new Date()};
			var msg=document.getElementById("msg");
			$.post(url,args,function(date){
				if (date == "true") {
					  msg.innerHTML="<font color='green'>可添加此账号</font>";
					  document.getElementById("submit").disabled = false;
				} else {
					  msg.innerHTML="<font color='red'>不可添加此账号，请重新输入</font>";
					  document.getElementById("submit").disabled = true;
				}
			});
		}
	});
})