
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zxx">

<head>
<base href="<%=basePath%>">
<title>宠物乐园——做您最好的体验</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
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
	<!--header-->
	<h1>
	<span>Wellcom</span> to<span> Reg</span>isterInterface
	</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="RegisterServlet" method="post">
				<div class="form-style-agile">
					<label>用户名</label>
					<div class="pom-agile">
						<input placeholder="Username" name="username" type="text"
							required=""> <span class="fa fa-user-o"
							aria-hidden="true"></span>
					</div>
				</div>

				<div class="form-style-agile">
					<label>密&nbsp;&nbsp;码</label>
					<div class="pom-agile">
						<input placeholder="Password" name="password" type="password"
							id="password1" required=""> <span class="fa fa-key"
							aria-hidden="true"></span>
					</div>
				</div>
				<div class="form-style-agile">
					<label>确认密码</label>
					<div class="pom-agile">
						<input placeholder="Confirm Password" name="Confirm Password"
							type="password" id="password2" required=""> <span
							class="fa fa-key" aria-hidden="true"></span>
					</div>
				</div>
				<div class="form-style-agile">
					<label>请选择用户类型</label>
						<select name="tselect">
                        <option value="管理员">管理员</option>
                        <option value="顾客">顾客</option>
                        </select>
				</div>
				<div class="sub-agile">
					<input type="checkbox" id="brand1" value=""> <label
						for="brand1"> <span></span>我接受注册许可协议
					</label>
				</div>
				<div class="clear">
					<input type="submit" value="注册"> 
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


	<!-- password-script -->
	<script>
		window.onload = function() {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity(
						"两次输入的密码不匹配！");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

</body>

</html>