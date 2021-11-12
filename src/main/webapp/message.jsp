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
<h3>学号:<%=snoStatus%>
</h3>
<h3>姓名:<%=snameStatus%>
</h3>
<h3>昵称:<%=fakeNameStatus%>
</h3>
<%
    for (String nowName : ConfigData.INSTANCE.getOJ_NAMES()) {
        String nowStatus = (String) request.getAttribute(nowName);
%>
<h3><%=nowName%>:<%=nowStatus%>
</h3>
<%
    }
    String[] logList = nowLog.split("\\.");
    for (String log : logList) {
%>
<h3><%=log%>
</h3>
<%
    }
%>
<a href="http://ranking.abmcar.top/">返回榜单</a>
</body>
</html>
