<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/28
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>顾客-主页面</title>
    <link href="css/Site.css" rel="stylesheet" type="text/css" />
    <link href="css/zy.layout.css" rel="stylesheet" />
    <link href="css/zy.form.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <style type="text/css">
        .headerlitooleulsubitem_gray {
            background-Color: White;
            position: absolute;
            border-left: 1px solid #BCD4E5;
            border-right: 1px solid #BCD4E5;
            border-bottom: 1px solid #BCD4E5;
            box-shadow: 0px 0px 5px #BCD4E5;
            width: 230px;
            margin-left: -170px;
            color: Black;
            display: none;
        }

        .headerlitooleulsubitem_red {
            background-Color: White;
            position: absolute;
            border-left: 1px solid #E5BCD4;
            border-right: 1px solid #E5BCD4;
            border-bottom: 1px solid #E5BCD4;
            box-shadow: 0px 0px 5px #E5BCD4;
            width: 230px;
            margin-left: -170px;
            color: Black;
            display: none;
        }

        .headerlitooleulsubitem_gray>li, .headerlitooleulsubitem_red>li {
            height: 45px;
            background-color: White;
            padding: 0px 10px;
            border-bottom: 1px solid #E4ECF3;
            font-size: 14px;
            line-height: 26px;
        }

        .headerlitoolelisubitemtitle_gray {
            height: 35px !important;
            line-height: 35px !important;
            background-color: #ECF2F7 !important;
            margin: 0px !important;
            color: #8090A0 !important;
            font-size: 14px;
            font-weight: bold;
            border-bottom: 1px solid #BCD4E5 !important;
        }

        .headerlitoolelisubitemtitle_red {
            height: 35px !important;
            line-height: 35px !important;
            background-color: #F7ECF2 !important;
            margin: 0px !important;
            color: #B471A0 !important;
            font-size: 14px;
            font-weight: bold;
            border-bottom: 1px solid #E5BCD4 !important;
        }

        .headerlitooleulsubitem_gray>li:hover {
            background-Color: #F4F9FC;
        }

        .headerlitooleulsubitem_red>li:hover {
            background-color: #FCF4F9;
        }

        .ulsubitemitems>li {
            float: left;
            height: 20px;
            font-size: 13px;
            font-weight: normal !important;
            color: #555 !important;
        }

        .ulsubitemitems>li:last-child {
            clear: both;
            width: 100%;
            height: 10px;
            margin-top: 8px;
            background-color: #DADADA;
        }

        .headerlitools_info {
            background-color: #0a318d;
            height: 45px;
            padding: 0px 10px;
            width: 135px;
        }

        .headeruserface {
           background-image: url("images/logo.png");
            width: 40px;
            height: 40px;
            background-color: white;
            margin: 2px 10px 2px 2px;
            border-radius: 20px;
            float: left;
        }

        .headerlitools_ulinfo {
            background-Color: white;
            border-left: 1px solid #D1D1D1;
            border-right: 1px solid #D1D1D1;
            border-bottom: 1px solid #D1D1D1;
            box-shadow: 0px 0px 5px #D1D1D1;
            width: 160px;
            margin-left: -20px;
            color: Black;
            display: none;
        }

        .headerlitools_ulinfo>li {
            height: 35px;
            background-color: White;
            padding: 0px 10px;
            font-size: 14px;
            line-height: 36px;
        }

        .headerlitools_ulinfo>li:hover {
            background-Color: #FEE188;
        }

        .dvcontent {
            padding: 0px 20px;
            margin: 45px auto 0px auto;
            overflow: auto;
        }

        .dvpagerecord {
            padding: 6px 12px;
            background-color: #EAEFF2;
            color: #2283C5;
            float: left;
            border: 1px solid #D9D9D9;
            text-decoration: underline;
            font-size: 14px;
            cursor: pointer;
        }

        .dvpagerecord:hover {
            cursor: pointer;
        }

        .dvpagerecord:hover i {
            text-decoration: underline;
        }

        .ulpageRecord {
            max-width: 165px;
            float: left;
            white-space: nowrap;
            overflow: hidden;
            margin: 0px;
            padding: 0px;
        }

        .ulpageRecord li {
            margin: 0px;
            padding: 6px 12px;
            background-color: #EAEFF2;
            color: #2283C5;
            display: inline-block;
            font-size: 14px;
            border: 1px solid #D9D9D9;
        }

        .ulpageRecord li:hover {
            text-decoration: underline;
            cursor: pointer;
        }

        .currentPage {
            background-color: #2468a9 !important;
            color: white !important;
        }

        #warn {
            width: 300px;
        }

        #warn tr {
            width: 300px;
            height: 20px;
        }

        #warn tr td {
            width: 90px;
            height: 20px;
            text-align: center;
        }

        iframe {
            border: none;
        }
    </style>
    <link href="css/zy.menu.css" rel="stylesheet" />
</head>
<body>
<div class="dvheader">
    <div class="dvheadertools">
        <span class="headerspantitle">尊敬的顾客，您好！</span>
        <ul class="headerultools">
            <li class="headerlitools_info headerlitools"
                style="background-color: #075597">
                <div class="headeruserface" style="text-align: center;">
                    <i class="icon-user" style="color: black; font-size: 19px;"></i>
                </div>顾客<i style="margin-left: 8px;" class="icon-caret-down"></i>
                <ul class="headerlitools_ulinfo">

                    <li style="border-top: 1px solid #E4ECF3;"><i
                            class="icon-off" style="margin-right: 10px;"></i> <a
                            style="color: black; text-decoration: none;">退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="dvcontent">

    <ul class="ulleftmenu" style="border-right: 1px solid #ddd;">

        <li class="limenuitem"><i class="icon-cog menuicon"></i>操作菜单<b
                class="arrow icon-angle-down arrow-down"></b>
            <ul class="ulleftsubitems">
                <a href="PetServlet?action=schFlower1&itemId=${item.id}" target="right">
                    <li>浏览宠物</li>
                </a>
                    <a href="PetServlet?action=schFlowerSalesRecord" target="right">
                        <li>查看订单</li>
                    </a>
<%--                </a>--%>
                    <!-- <a href="user.jsp" target="right">
                            <li>用户管理</li>
                        </a> -->
                    <!-- <a href="updatePwd.jsp" target="right">
                            <li>修改密码</li>
                        </a>  -->

            </ul></li>
    </ul>
    <div style="position: absolute; left: 191px; right: 20px;">
        <iframe src="welcome.jsp" scrolling="no" width="100%" height="1200"
                name="right" border="none"></iframe>
    </div>
</div>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/plugs/Jqueryplugs.js" type="text/javascript"></script>
<script src="js/_layout.js"></script>
</body>
</html>