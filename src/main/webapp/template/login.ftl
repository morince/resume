<!DOCTYPE html>
<#assign path="${rc.contextPath}">
<html>
<#include "/include/head.ftl">
<body>
	<section class="login">
		<div class="titulo">Staff Login</div>
		<form method="post" id="loginForm"
			enctype="application/x-www-form-urlencoded"  onsubmit="return false;">
			<input type="text" name="userName" required title="Username required"
				placeholder="Username" data-icon="U"> <input type="password"
				name="password" required title="Password required" placeholder="Password"
				data-icon="x">
			<div class="olvido">
				<div class="col">
					<a href="#" title="Ver Carásteres">Register</a>
				</div>
				<div class="col">
					<a href="#" title="Recuperar Password">Fotgot Password?</a>
				</div>
			</div>
			<button type="submit" class="enviar">Submit</button>
		</form>
	</section>
<#include "/include/footer.ftl">
</body>
<script type="text/javascript" src="${rc.contextPath}/js/md5.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/global.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/pageLogin.js"></script>	
</html>