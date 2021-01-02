<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

<head>
<base href="<%=basePath%>">
<title>宠物乐园——给您最满意的服务</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/login.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- //web-fonts -->
</head>

<body>
	<%--获取cookie中的用户名和密码 --%>
	<%
String username="";
String password="";
//清空cookie的已有的用户名和密码
  Cookie[] cookies= request.getCookies();
     if(cookies!=null)
    	 for(Cookie cookie:cookies){
    		if("COOKIE_username".equals(cookie.getName())){
    			username=cookie.getValue();
    		}
    		if("COOKIE_password".equals(cookie.getName())){
   			 password=cookie.getValue();
    		}
    		 
    	 }

%>
	<!--header-->
	<h1>
		<span>Wellcom</span> to<span> Log</span>inInterface
	</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="LoginServlet" method="post">
				<div class="form-style-agile">
					<label>用户名</label>
					<div class="pom-agile">
						<%--设置默认值 --%>
						<input placeholder="UserName" value="<%=username%>"
							name="username" type="text" required=""> <span
							class="fa fa-user-o" aria-hidden="true"></span>
					</div>
				</div>

				<div class="form-style-agile">
					<label>密码</label>
					<div class="pom-agile">
						<input placeholder="Password" value="<%=password%>"
							name="password" type="password" id="password1" required="">
						<span class="fa fa-key" aria-hidden="true"></span>
					</div>
				</div>

				<div class="sub-agile">
					<input type="checkbox" name="rememberMe" id="brand1" value="true">
					<label for="brand1"> <span></span>记住我
					</label>
				</div>
				<div class="clear">
					<input type="submit" value="登录"> 
					<a href="register.jsp" >立即注册</a>
				</div>
			
			</form>
		</div>
	</div>
	<!-- //content -->
	<!--footer-->
	<div class="footer">
		<h2>
			&copy; 2020 Classic Register Form. All rights reserved | Design by <a
				href="http://w3layouts.com">W3layouts</a>
		</h2>
	</div>
	<!--//footer-->
</body>

</html>