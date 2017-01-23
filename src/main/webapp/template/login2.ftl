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
						<h2>Sign In</h2>
						<form id="loginForm" method="post"  onsubmit="return false;">
							<input type="text" name="userName" placeholder="User Name" required="">
							<input type="password" name="password" placeholder="Password" required="">	 
							<input type="checkbox" id="brand" value="">
							<label for="brand"><span></span> Remember me ?</label> 
							<input type="submit" value="SIGN IN">
							<div class="signin-agileits-bottom"> 
								<p><a href="#">Forgot Password ?</a></p>    
							</div> 
						</form>
					</div>
					<div class="signin-firm">
						<div class="social-grids">
							<div class="social-text">
								<p>Or Sign in with</p>
							</div>
							<div class="social-icons">
								<ul>
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
								</ul>
							</div>
							<div class="clear"> </div>
						</div>
						
					</div>
					<div class="copyright">
						<p> © 2017 Different Multiple Form Widget . All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
					</div>
				</div>

			</div>

		</div>

</body>
<script type="text/javascript" src="${rc.contextPath}/js/md5.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/global.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/pageLogin.js"></script>	
</html>