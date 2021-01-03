<%--
  Created by IntelliJ IDEA.
  User: siyi
  Date: 2021/1/1
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Wellcome to buy goods</title>
    <link rel="stylesheet" type="text/css" href="/css/second.css" />
    <link rel="stylesheet" type="text/css" href="../css/font-awesome.css" />
    <script src="../js/jquery.min.js"></script>
    <script src="../js/detaildrawing.js"></script>
    </title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script language="JavaScript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }

        function check(){
            var k=window.alert("请登录账号！");
            if(k){
                event.returnValue=true;
            }else{
                event.returnValue=false;
            }
        }
    </script>
    <!-- Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="/css/second.css">
    <!-- Style-CSS -->
    <link rel="stylesheet" href="css/font-awesome.css">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->
    <!-- web-fonts -->
    <link href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <!-- //web-fonts -->
</head>

<body class="body">
<!--头部区域-->
<div class="header">
    <div class="list">
        <div class="w">
            <div class="leftList">
                <ul>
                    <li>
                        <a href="index.html">首页</a>
                    </li>
                    <li>
                        <a href="javascript:">宠物</a>
                    </li>
                    <li>
                        <a href="javascript:">礼品</a>
                    </li>
                    <li>
                        <a href="javascript:">咨讯</a>
                    </li>
                    <li>
                        <a href="javascript:">博客</a>
                    </li>
                    <li>
                        <a href="javascript:">专题</a>
                    </li>
                </ul>
            </div>

            <div class="rightList">
                <ul>
                    <li>
                        <a href="login.jsp">登录&nbsp; &nbsp;|</a>
                    </li>
                    <li>
                        <a href="register.jsp">&nbsp; &nbsp;注册</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!--商标品牌-->
    <div class="h-container">
        <div class="w">
            <div class="logo">
                <img src="/images/logo1.jpg" />
            </div>

            <div class="name" style="left: 80px">
                本地实体宠物店 1小时送货上门 不满意全额退款
            </div>

            <!--搜索栏-->
            <div class="search">
                <input type="text" placeholder="请输入关键字" />
                <div class="cion">
                    <a href="javascript:"><i style="color: black; font-size:25px" class="fa fa-search"></i></a>
                </div>

            </div>
        </div>
    </div>
</div>

<!--商品内容-->
<div class="banner">
    <div class="w">
        <!--详情左半部分-->
        <div class="left">
            <!--商品详情大图轮播部分-->
            <div class="big-view">
                <div id="big1" style="display:block;">
                    <img class="" src="/images/小柯基1.jpg" />
                </div>
                <div id="big2" style="display:none;">
                    <img class=""src="/images/小柯基2.jpg" />
                </div>
                <div id="big3" style="display:none;">
                    <img src="/images/小柯基3.jpg" />
                </div>
                <div id="big4" style="display:none;">
                    <img src="/images/小柯基4.jpg" />
                </div>
            </div>

            <div class="small-view">
                <ul>
                    <li class="current">
                        <a href="javascript:"><img src="/images/小柯基1.jpg" /></a>
                    </li>
                    <li class="">
                        <a href="javascript:"><img src="/images/小柯基2.jpg" /></a>
                    </li>
                    <li class="">
                        <a href="javascript:"><img src="/images/小柯基3.jpg" /></a>
                    </li>
                    <li class="">
                        <a href="javascript:"><img src="/images/小柯基4.jpg" /></a>
                    </li>
                    <li class="">
                        <a href="javascript:">
                            <div class="collection">
                                <i class="fa fa-star"></i>
                                <p>收藏</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <!--详情右半部分-->
        <div class="right">
            <div class="marks">
						<span class="title">
							${}柯基犬
			            <span class="number">商品编号：0692</span>
			            </span>
                <!--						<p style="font-size: 18px;">柯基犬即威尔士柯基犬（著名犬种）</p>-->
            </div>

            <div class="attr-box">
                <dl>
                    <dt>分类：</dt>
                    <dd>
                        <a href="">狗狗 <i style="color: black; font-size:18px" class="fa fa-angle-double-right"></i></a>
                    </dd>
                </dl>
                <dl>
                    <dt>简介：</dt>
                    <dd>柯基犬即威尔士柯基犬（著名犬种）。威尔士柯基犬共分两种：卡迪根威尔士柯基犬和彭布罗克威尔士柯基犬。两者比较，彭布罗克柯基犬的体形较短，
                        腿骨更直、更轻，而威尔士柯基犬背毛的质地更好；但在性情上，彭布罗克柯基犬显得不安分，容易激动，没有卡迪根威尔士柯基犬那么驯服。
                        从12世纪的理查一世到现在的女王伊丽莎白二世，柯基犬一直是英国王室的宠物。
                    </dd>
                </dl>
                <dl>
                    <dt>外形：</dt>
                    <dd>小型犬/短毛/25-30厘米</dd>
                </dl>
                <dl>
                    <dt>寿命：</dt>
                    <dd>12-14年</dd>
                </dl>
                <dl>
                    <dt>功能：</dt>
                    <dd>护卫犬</dd>
                </dl>
                <dl>
                    <dt>说明：</dt>
                    <dd>因宠物们外貌各有差异，提供照片仅供参考。但我们保证宠与说明一致，绝对纯正品种，谢谢。</dd>
                </dl>
            </div>

            <div class="sale-box">
                <dl>
                    <dt>宠物店售价</dt>
                    <dd>
                        <span class="price">￥5000.00</span>
                        <del style="color: gray;" class="market">￥5500.00</del>
                    </dd>
                </dl>

                <dl>
                    <dt class="count">统计</dt>
                    <dd>
                        已有
                        <span style="color: red;">
								5997
							</span> 人付款购买 &nbsp;&nbsp;|&nbsp;&nbsp;
                        <span>综合评分</span>
                        <span>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
							</span>
                    </dd>
                </dl>
            </div>

            <div class="buy">
                <div class="buttens">
                    <div class="shopbutten">
                        <a href="" onclick="check()">
                            <i class="fa fa-shopping-cart"></i> 加入购物车
                        </a>
                    </div>

                    <div class="buybutten">
                        <a href="" onclick="check()">
                            <i class="fa fa-flash"></i> 立即购买
<%--                            <input class="fa fa-flash" type="button" value="立即购买">--%>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--尾部区域-->
<div class="tail">
    <div class="top">
        <div class="w">
<%--            <img src="/images/bz.jpg"/>--%>
        </div>
        <div class="problem">
            <div class="w">
                <dl>
                    <dt class="dtitle">购物指南</dt>
                    <dd>
                        <a href="javascript:">物流流程</a>
                        <a href="javascript:">常见问题</a>
                        <a href="javascript:">联系客服</a>
                    </dd>
                </dl>
                <dl>
                    <dt class="dtitle">配送方式</dt>
                    <dd>
                        <a href="javascript:">包邮政策</a>
                        <a href="javascript:">快递说明</a>
                        <a href="javascript:">配送区域</a>
                    </dd>
                </dl>
                <dl>
                    <dt class="dtitle">支付方式</dt>
                    <dd>
                        <a href="javascript:">货到付款</a>
                        <a href="javascript:">在线支付</a>
                        <a href="javascript:">邮局汇款</a>
                    </dd>
                </dl>
                <dl>
                    <dt class="dtitle">售后服务</dt>
                    <dd>
                        <a href="javascript:">签到说明</a>
                        <a href="javascript:">退/换货政策</a>
                        <a href="javascript:">隐私保护</a>
                    </dd>
                </dl>
                <dl>
                    <dt class="dtitle">帮助中心</dt>
                    <dd>
                        <a href="javascript:">关于我们</a>
                        <a href="javascript:">注册协议</a>
                        <a href="javascript:">忘记密码</a>
                    </dd>
                </dl>
            </div>
        </div>
    </div>

    <div class="botten">
        <div class="w">
            <div class="b-top">
                <a href="javascript:">宠物乐园-</a>
                <a href="javascript:">关于我们-</a>
                <a href="javascript:">常见问题-</a>
                <a href="javascript:">全国宠物店-</a>
                <a href="javascript:">订宠物</a>
            </div>

            <div class="t-container">
                <div class="left">
                    <p>© 2020 宠物乐园{公司名字} 地址：{公司地址} 电话号码： {联系方式} 版权所有渝ICP备15003353号-1]</p>
                    <p>7x24小时宠物店子咨询热线：<strong style="font-size: 20px">400-9919-589</strong></p>
                    <p>投诉及建议邮箱：<strong style="font-size: 20px;">340325230@qq.com</strong></p>
                    <p>更多：网上订宠物 订宠物网站 订宠物网 订宠物网哪个好 宠物店 生日礼物 宠物乐园</p>
                </div>

                <div class="right">
                    <div class="QRcode1">
                        <img src="/images/QRCode.jpg" />
                        <p>app下载</p>
                    </div>
                    <div class="QRcode2">
                        <img src="/images/QRCode.jpg" />
                        <p>宠物乐园手机商城</p>
                    </div>
                    <div class="QRcode3">
                        <img src="/images/QRCode.jpg" />
                        <p>宠物乐园微信平台</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>