/**
 * 
 */
window.onload=clock;
//function closewin() {
//	window.location.href="index.jsp"; 
////	self.opener = null;
////	self.close();
//}
function clock() {
	
	i = i - 1
//	document.title = "本窗口将在" + i + "秒后自动关闭!";
	if (i > 0){
		setTimeout("clock();", 2000);
		var interval = 1000;
		window.setInterval(function(){
			var message=document.getElementById("message");
			message.innerHTML=i+"秒";
		}, interval);
	}else {
		$(function(){
					var url = "/school/removeCode";
					var msg=document.getElementById("msg");
					$.post(url,function(date){
						if (date == "true") {
							  msg.innerHTML="<font color='red'>验证码已失效</font>";
							  document.getElementById("submit").disabled = true;
						}
					});
		})
	}
	
	}
	var i = 90
