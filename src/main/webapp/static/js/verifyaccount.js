$(function(){
	$("#usEmail").change(function(){
		var value = $(this).val();
		value = $.trim(value);
		if(value != ""){
			var url = "/school/verifyAccount";
			var args = {"usEmail":value, "time":new Date()};
			var msg=document.getElementById("msg");
			$.post(url,args,function(date){
				if (date == "true") {
					  msg.innerHTML="<font color='green'>账号存在，可登录</font>";
	                  document.getElementById("submit").disabled = false;
				} else {
					  msg.innerHTML="<font color='red'>账号不存在或不可登录</font>";
	                  document.getElementById("submit").disabled = true;
				}
			});
		}
	});
})
//function doVerify(){
//      //获取界面的账号
//      var account = $("#usEmail").val();
//      //获取账号后的提示信息文本
//      var accountText = document.getElementById("accountText");
//      //如果账号输入不为空，执行该方法
//      if(account !=""){
//        $.ajax({
//          url:"${basePath}nsfw/userAction_verifyAccout.action",//后台查询验证的方法
//          data:{"user.account": account},//携带的参数
//          type: "post",
//          success: function(msg){
//            //根据后台返回前台的msg给提示信息加HTML
//            if("true" !=msg){
//              // 账号已经存在
//              accountText.innerHTML = "<font color='red'>抱歉，"+account+"已被注册，请更换！</font>"
//            }
//            else{
//              // 账号不存在
//              accountText.innerHTML = "<font color='green'>恭喜，"+account+"可以注册！</font>"
//            }
//          }
//        });
//      }
//    }