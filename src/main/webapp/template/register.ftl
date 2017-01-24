<!DOCTYPE html>
<#assign path="${rc.contextPath}">
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<#include "/include/head2.ftl">
	<body>
		<div class="main-agile">
		<h1>My resume</h1>
		<div class="content">
			<div class="top-grids">
				<div class="top-grids-left">
					<div class="signin-form">
						<h3>请&nbsp注&nbsp册</h3>
						<form id="loginForm" method="post"  onsubmit="return false;">
							<input type="text" name="userName" placeholder="User Name" required="">
							<input type="email" name="Email" placeholder="Your Email" required="">
							<input type="password" id="pwd1" name="password" placeholder="Password" required="">
							<input type="password" id="pwd2" name="password2" placeholder="Repeat Password" required="" onblur="checkPass()">
							<span id="notice"></span></input>
							<input type="checkbox" id="brand1" value="">
							<label for="brand1"><span></span>我同意使用条款</label>
							<input type="submit" id="sbmt" value="SIGN UP">
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
<script type="text/javascript" src="${rc.contextPath}/js/global.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/pageRegister.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/aes.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/AESEncrypt.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/md5.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/tripledes.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/cipher-core.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/core.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/encrypt/mode-ecb.js"></script>
</html>
