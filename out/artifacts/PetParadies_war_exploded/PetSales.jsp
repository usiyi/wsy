<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客-查看订单-购买宠物</title>
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
			<div class="tabs" style="margin: 30px;">
				<div class="hd">
					<ul>
					
						<li class=""
							style="box-sizing: initial; -webkit-box-sizing: initial;">购买宠物</li>
					</ul>
				</div>
				<div class="bd">

					<ul class="theme-popbod dform" style="display: none;">
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
													<input type="hidden" name="action"
														value="addPetSalesRecord">

													<input type="hidden" name="action" value="selectPet2">
													<input type="hidden" name="id" value="${item.petid}">

													<div class="am-form-group">
														<%--@declare id="user-email"--%><label for="user-email" class="am-u-sm-3 am-form-label">
															宠物名称</label>
															<div class="am-u-sm-9">
																<input type="text" id="named" required name="itemName"
																	   value="${item.petname}">
															</div>
															<c:out value="${item.petname}"></c:out>
														<%--<div class="am-u-sm-9">
															<select name="itemName" required>
																<c:forEach items="${flowerList}" var="i">
																	<option <c:if test="${i}" >selected=selected</c:if>value="${i}">${i}</option>
																</c:forEach>
															</select>
														</div>--%>
													</div>

													<div class="am-form-group">
														<label for="name" class="am-u-sm-3 am-form-label">
															数量</label>
														<div class="am-u-sm-9">
															<input type="text" id="name" required placeholder="数量"
																name="otbnumber">
														</div>
													</div>
													
													<div class="am-form-group">
														<div class="am-u-sm-9 am-u-sm-push-3">
															<input type="submit" class="am-btn am-btn-success"
																value="提交" />
														</div>
													</div>
												</form>
											</div>
										</div>

									</div>
									<!-- content end -->
								</div>
								<!--添加 end-->
								<!--end-->
							</div>
						</div>
					</ul>
				</div>
			</div>
			<!--tab end-->

		</div>

		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/plugs/Jqueryplugs.js" type="text/javascript"></script>
		<script src="js/_layout.js"></script>
		<script src="js/plugs/jquery.SuperSlide.source.js"></script>
		<script>
			var num = 1;
			$(function() {
				$(".tabs").slide({
					trigger : "click"
				});
			});
			var btn_edit = function(id) {
				$.jq_Panel({
					url : "/RawMaterialsType/EditRawMaterialsType?id=" + id,
					title : "编辑分类",
					dialogModal : true,
					iframeWidth : 500,
					iframeHeight : 400
				});
			};
			var btn_delete = function(id) {
				$.jq_Confirm({
					message : "您确定要删除吗?",
					btnOkClick : function() {
					}
				});
			}
		</script>
	</div>
</body>

</html>