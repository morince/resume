function pasvalidate(){
	var regex ="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
}

function checkPass(){
	var password = document.getElementById("pwd1").value;
	var password2 = document.getElementById("pwd2").value;
	if(password!=password2){
		document.getElementById("notice").innerHTML="<font color='red'>两次密码不相同</font>\n";
		document.getElementById("sbmt").disabled=true;
	}else{
		document.getElementById("notice").innerHTML="";
		document.getElementById("sbmt").disabled=false;
	}
}

(function(w,d,u){
	var loginForm = util.get('loginForm');
	if(!loginForm){
		return;
	}
	var userName = loginForm['userName'];
	var password = loginForm['password'];
	var password2 = loginForm['password2'];
	var email = loginForm['Email'];
	var isSubmiting = false;
	var loading = new Loading();
	var page = {
		init:function(){
			loginForm.addEventListener('submit',function(e){
				if(!isSubmiting && this.check()){
					if(password.value!=password2.value){
						isSubmiting = false;
					}else{
						isSubmiting = true;
					}
					var value1 = userName.value;
					var src = CryptoJS.MD5(password.value)+","+password.value;
					var value2 = encrypt(src);
					var value3 = email.value;
					loading.show();
					ajax({
						data:{userName:value1,password:value2,email:value3},
						url:'/api/register',
						success:function(result){
							loading.hide();
							alert('注册成功');
							location.href = '/login';
						},
						error:function(message){
							alert('注册失败');
							isSubmiting = false;
						}
					});
				}
			}.bind(this),false);
			[userName,password].forEach(function(item){
				item.addEventListener('input',function(e){
					item.classList.remove('z-err');
				}.bind(this),false);
			}.bind(this));
		},
		check:function(){
			var result = true;
			[
				[userName,function(value){return value == ''}],
				[password,function(value){return value == ''}]
			].forEach(function(item){
				var value = item[0].value.trim();
				if(item[1](value)){
					item[0].classList.add('z-err');
					result = false;
				}
				item[0].value = value;
			});
			return result;
		}
	};
	page.init();
})(window,document);