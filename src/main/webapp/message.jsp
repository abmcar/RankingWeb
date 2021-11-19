<%--
Created by IntelliJ IDEA.
User: Abmcar
Date: 2021/11/11
Time: 15:37
To change this template use File | Settings | File Templates.
--%>
<% Object title = (String) request.getAttribute("title"); %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=title%>
    </title>
    <link rel="stylesheet" href="layui/css/styles.css" type="text/css">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <style type="text/css">
        body {
            background-image: url(photos/bg.png); /*加载背景图*/
            background-position: center center;  /* 背景图垂直、水平均居中 */
            background-repeat: no-repeat; /* 背景图不平铺 */
            background-attachment: fixed;  /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
            background-size: cover;  /* 让背景图基于容器大小伸缩(此条属性必须设置否则可能无效) */
            background-color: #ffffff; /* 设置背景颜色，背景图加载过程中会显示背景色 */
            width:100%;
        }
        .message{
            color: #000;
            background-color: #fff;
            padding: 2em 3em;
            margin: 20% 30%;
            z-index: 1000;
            display: inline-block;
            width: 34%;
        }

        .relogin{
            color: #000;
            font-size: 36px;
        }

        .left{
            float: left;
            width: 60%;
            text-align: left;
        }

        .right{
            float: left;
            width: 40%;
            text-align: center;
            margin:auto 0;
        }
    </style>
</head>
<body>
<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="http://ranking.abmcar.top"><img src="ICPC.jpg" class="layui-nav-img">NYIST_ACM
        Ranking List</a></li>
    <li class="layui-nav-item"><a href="http://ranking.abmcar.top">榜单</a></li>
    <li class="layui-nav-item"><a
            href="http://www.abmcar.top:8080/RankingWeb/form.html">信息填写</a></li>
    <li class="layui-nav-item"><a href="http://www.abmcar.top/archives/nyistacmrankinglistfaq">榜单FAQ</a></li>
    <li class="layui-nav-item"><a href="https://github.com/abmcar/RankingWeb/issues">问题反馈</a></li>
    <li class="layui-nav-item"><a>快捷提示</a>
        <dl class="layui-nav-child">
            <dd><a href="">按CTRL + F5可以清除缓存以看到最新榜单</a></dd>
            <dd><a href="">如果没有填某个oj的id,会默认按照昵称来爬取题数</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item layui-this"><a>我的信息</a>
        <dl class="layui-nav-child">
            <dd><a href="login.jsp">登录</a></dd>
            <dd><a href="register.jsp">注册</a></dd>
        </dl>
    </li>
</ul>
<div id="formS" class="message"style="width: 650px; position: relative;">
    <div class="left">


<%
    String info = (String) request.getAttribute("info");
%>
    <h1><%=info%></h1>

<a class="layui-btn" href="http://ranking.abmcar.top/">返回榜单</a>
</div>
</div>
</body>
</html>
