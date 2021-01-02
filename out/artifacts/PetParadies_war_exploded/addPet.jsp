<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-宠物管理-添加宠物</title>
<link rel="stylesheet" />
<link rel="stylesheet" href="css/Site.css" />
<link rel="stylesheet" href="css/zy.all.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/amazeui.min.css" />
<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	<div class="dvcontent">
		<div>
			<!--tab start-->
			<div class="tabs">
				<div class="hd">
					<ul>
						<li class=""
							style="box-sizing: initial; -webkit-box-sizing: initial;"><a
							href="PetServlet?action=selectType">添加宠物</a></li>
					</ul>
				</div>
				<div class="bd">
					<ul class="theme-popbod dform">
						<div class="am-cf admin-main" style="padding-top: 0px;">
							<!-- content start -->
							<div class="am-cf admin-main" style="padding-top: 0px;">
								<!-- content start -->
								<div class="admin-content">
									<div class="admin-content-body">
										<div class="am-g">
											<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8"></div>
											<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4"
												style="padding-top: 30px;">
												<form class="am-form am-form-horizontal"
													action="PetServlet" method="post">
													<input type="hidden" name="action" value="addPet">
													<font>${errName}</font>
													<div class="am-form-group">
														<%--@declare id="name"--%><label for="name" class="am-u-sm-3 am-form-label">
															宠物名称</label>
														<div class="am-u-sm-9">
															<input type="text" id="itemName" placeholder="宠物名称"
																name="itemName" onblur="checkItem()"> <font
																id="message" style="color: red"></font>
														</div>
													</div>

													<div class="am-form-group">
														<%--@declare id="user-email"--%><label for="user-email" class="am-u-sm-3 am-form-label">
															分类</label>
														<div class="am-u-sm-9">
															<select name="itemType" required>
																<c:forEach items="${typeList}" var="t">
																	<option <c:if test="${t}" >selected=selected</c:if>
																		value="${t}">${t}</option>
																</c:forEach>

															</select>
														</div>
													</div>
													<div class="am-form-group">
														<label for="user-email" class="am-u-sm-3 am-form-label">
															进价</label>
														<div class="am-u-sm-9">
															<input type="text" id="pPrice" required
																placeholder="输入宠物进价" name="pPrice">
														</div>
													</div>
													<div class="am-form-group">
														<label for="user-email" class="am-u-sm-3 am-form-label">
															售价</label>
														<div class="am-u-sm-9">
															<input type="text" id="sPrice" required
																placeholder="输入宠物售价" name="sPrice">
														</div>
													</div>
													<div class="am-form-group">
														<label for="user-email" class="am-u-sm-3 am-form-label">
															库存</label>
														<div class="am-u-sm-9">
															<input type="text" id="number" required
																placeholder="输入宠物数量" name="number">
														</div>
													</div>
													<!-- 
						<div class="am-form-group">
								<label for="user-intro" class="am-u-sm-3 am-form-label">
									备注</label>
								<div class="am-u-sm-9">
									<textarea class="" rows="5" id="user-intro" name="remark"
										placeholder="输入备注"></textarea>
									<small>250字以内...</small>
								</div>
							</div>
							 -->
													<div class="am-form-group">
														<div class="am-u-sm-9 am-u-sm-push-3">
															<input type="submit" class="am-btn am-btn-success"
																value="添加" />
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
								<!-- content end -->
							</div>
							<!--添加 end-->
						</div>
					</ul>
				</div>
			</div>
			<!--tab end-->
		</div>

		<!--_footer 作为公共模版分离出去-->
		<script type="text/javascript"
			src="../h-ui/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="../h-ui/lib/layer/2.4/layer.js"></script>
		<script type="text/javascript"
			src="../h-ui/static/h-ui/js/H-ui.min.js"></script>
		<script type="text/javascript"
			src="../h-ui/static/h-ui.admin/js/H-ui.admin.js"></script>
		<!--/_footer 作为公共模版分离出去-->

		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript"
			src="../h-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>

		<script type="text/javascript"
			src="../h-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>

		<script type="text/javascript"
			src="../h-ui/lib/laypage/1.2/laypage.js"></script>

		<script type="text/javascript"
		     src="js/jquery-1.7.2.min.js"></script>

		<script type="text/javascript"
			 src="js/plugs/Jqueryplugs.js"></script>

		<script type="text/javascript"
		     src="js/_layout.js"></script>

		<script type="text/javascript"
			 src="js/plugs/jquery.SuperSlide.source.js"></script>
		<script>
			var num = 1;
			$(function() {
				$(".tabs").slide({
					trigger : "click"
				});
			});

			/*
			  ajax+JSON
			 */
			var xhr;
			function checkItem() {
				xhr = new XMLHttpRequest();
				var itemName = document.getElementById("itemName").value;
				//使用POST发送请求
				xhr.open("POST", "PetServlet?action=checkPet&itemName=" + itemName);
				xhr.onreadystatechange = chceckItemOut;
				xhr.send();
			}
			//设置异步响应事件处理
			function chceckItemOut() {
				if (xhr.status == 200 && xhr.readyState == 4) {
					var res = xhr.responseText;
					console.log(res);
					if (res == 'true') {
						document.getElementById("message").innerHTML = "该宠物已存在";
					} else {
						document.getElementById("message").innerHTML = "";
					}
				}
			}
			//ajax()请求JSON数据的方法
			var btn_save = function() {
				var pid = $("#RawMaterialsTypePageId  option:selected").val();
				var name = $("#RawMaterialsTypeName").val();
				var desc = $("#RawMaterialsTypeDescription").val();
				var ramark = $("#Ramark").val();
                console.log(remark);
				$.ajax({
					//获取数据的URL
					url : "/RawMaterialsType/AddRawMaterialsType",
					data :JSON.stringify({
						name : name,
						pid : pid,
						desc : desc,
						ramark : ramark,
					}),
					//http请求方法
					type : "post",
					//获取数据执行方式
					dataType:'JSON',
					success : function(data) {
						if (data > 0) {
							$.jq_Alert({
								message : "添加成功",
								btnOktext : "确认",
								dialogModal : true,
								btnOkClick : function() {
									// $("#RawMaterialsTypeName").val("");
									// $("#RawMaterialsTypeDescription").val("");
									// $("#Ramark").val("");
									// page1();
									location.reload();
								}
							});
						}
					}
				});
				alert(t);
			}
		</script>
	</div>
</body>

</html>