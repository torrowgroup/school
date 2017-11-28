window.onload=clock;
function validate() {
    var pwd1 = document.getElementById("pwd1").value;
    var pwd2 = document.getElementById("pwd2").value;
//	<!-- 对比两次输入的密码 -->
    if(pwd1 != pwd2) {
        document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
        document.getElementById("submit").disabled = true;
    } else {
    	document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
        document.getElementById("submit").disabled = false;
    }
 }

function closewin() {
	window.location.href="index.jsp"; 
}

function clock() {
	i = i - 1
	if (i > 0){
		setTimeout("clock();", 2000);
		var interval = 1000;
		window.setInterval(function(){
			var message=document.getElementById("message");
			message.innerHTML=i+"秒";
		}, interval);
	}
	else{
		closewin();
	}
	
	}
	var i = 90
