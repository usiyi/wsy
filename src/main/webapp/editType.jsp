<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-修改分类</title>
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
				<ul style="">

					<li class=""
						style="box-sizing: initial; -webkit-box-sizing: initial;">修改分类</li>

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
												  action="TypeServlet" method="post">
												<input type="hidden" name="action" value="editType">
												<input type="hidden" name="tid" value="${type.tid }">
												<div class="am-form-group">
													<label for="user-name" class="am-u-sm-3 am-form-label">
														分类名称</label>
													<div class="am-u-sm-9">
														<input type="text" id="user-name" required value="${type.tname }"
															   name="tname"> <small>10字以内...</small>
													</div>
												</div>
												<div class="am-form-group">
													<%--@declare id="user-description"--%><label for="user-description"
																								 class="am-u-sm-3 am-form-label"> 分类描述</label>
													<div class="am-u-sm-9">
															<textarea class="" rows="5" id="user-intro"
																	  name="tdescription" value="${type.description}"></textarea>
														<small>250字以内...</small>
													</div>
												</div>
												<div class="am-form-group">
													<label for="user-intro" class="am-u-sm-3 am-form-label">
														备注</label>
													<div class="am-u-sm-9">
															<textarea class="" rows="5" id="user-intro2"
																	  name="tremark" value="${type.remarks}"></textarea>
														<small>250字以内...</small>
													</div>
												</div>
												<div class="am-form-group">
													<div class="am-u-sm-9 am-u-sm-push-3">
														<input type="submit" class="am-btn am-btn-success"
															   value="保存" />
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<!-- content end -->
						</div>
						<!-- end-->
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

		var btn_save = function() {
			var pid = $("#RawMaterialsTypePageId  option:selected").val();
			var name = $("#RawMaterialsTypeName").val();
			var desc = $("#RawMaterialsTypeDescription").val();
			var ramark = $("#Ramark").val();
			$.ajax({
				type : "post",
				url : "/RawMaterialsType/AddRawMaterialsType",
				data : {
					name : name,
					pid : pid,
					desc : desc,
					ramark : ramark
				},
				success : function(data) {
					if (data > 0) {
						$.jq_Alert({
							message : "添加成功",
							btnOktext : "确认",
							dialogModal : true,
							btnOkClick : function() {
								//$("#RawMaterialsTypeName").val("");
								//$("#RawMaterialsTypeDescription").val("");
								//$("#Ramark").val("");
								//page1();
								location.reload();

							}
						});
					}
				}
			});
			alert(t);
		};

		var btn_edit = function (id) {
			$.jq_Panel({
				url: "/RawMaterialsType/EditRawMaterialsType?id=" + id,
				title: "编辑分类",
				dialogModal: true,
				iframeWidth: 500,
				iframeHeight: 400
			});
		};
		var btn_delete = function (id) {
			$.jq_Confirm({
				message: "您确定要删除吗?",
				btnOkClick: function () {
					$.ajax({
						type: "post",
						url: "/RawMaterialsType/DeleteRawMaterialsType",
						data: {
							id: id
						},
						success : function(data) {
							if (data > 0) {
								$.jq_Alert({
									message : "删除成功",
									btnOkClick : function() {
										page1();
									}
								});
							}
						}
					});
				}
			});
		}
	</script>
</div>
</body>
</html>