<%--
  Created by IntelliJ IDEA.
  User: Abmcar
  Date: 2021/11/11
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<% Object title = (String) request.getAttribute("title"); %>
<%@ page import="top.abmacr.rankingweb.config.ConfigData" %>
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
            margin: 3% 35%;
            z-index: 500;
            /*display: inline-block;*/
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

        /*.right{*/
        /*    float: left;*/
        /*    width: 40%;*/
        /*    text-align: center;*/
        /*    margin:auto 0;*/
        /*}*/
    </style>
</head>
<body>
<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="http://ranking.abmcar.top"><img src="ICPC.jpg" class="layui-nav-img">NYIST_ACM
        Ranking List</a></li>
    <li class="layui-nav-item"><a href="http://ranking.abmcar.top">榜单</a></li>
    <li class="layui-nav-item layui-this"><a
            href="http://www.abmcar.top:8080/RankingWeb/form.html">信息填写</a></li>
    <li class="layui-nav-item"><a href="http://www.abmcar.top/archives/nyistacmrankinglistfaq">榜单FAQ</a></li>
    <li class="layui-nav-item"><a href="https://github.com/abmcar/RankingWeb/issues">问题反馈</a></li>
    <!--  <li class="layui-nav-item">-->
</ul>
<%
    String snoStatus = (String) request.getAttribute("snoStatus");
    String snameStatus = (String) request.getAttribute("snameStatus");
    String fakeNameStatus = (String) request.getAttribute("fakeNameStatus");
    String nowLog = (String) request.getAttribute("log");
%>
<div class="message">
    <div class="right">
<h2>学号:<%=snoStatus%>
</h2>
<h2>姓名:<%=snameStatus%>
</h2>
<h2>昵称:<%=fakeNameStatus%>
</h2>
<%
    for (String nowName : ConfigData.INSTANCE.getOJ_NAMES()) {
        String nowStatus = (String) request.getAttribute(nowName);
%>
<h2><%=nowName%>:<%=nowStatus%>
</h2>
<%
    }
    if (nowLog != null) {
        String[] logList = nowLog.split("\\.");
        for (String log : logList) {


%>
<h2><%=log%>
</h2>
<%
        }
    }
%>
        </br>
        </br></br>
<a class="layui-btn" href="http://ranking.abmcar.top/">返回榜单</a> </br>
</div>
</div>
</body>
</html>
