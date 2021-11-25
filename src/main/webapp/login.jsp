<%--
  Created by IntelliJ IDEA.
  User: Abmcar
  Date: 2021/11/12
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="layui/css/styles.css" type="text/css">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <style type="text/css">
        body {
            background-image: url(photos/bg.png); /*加载背景图*/
            background-position: center center; /* 背景图垂直、水平均居中 */
            background-repeat: no-repeat; /* 背景图不平铺 */
            background-attachment: fixed; /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
            background-size: cover; /* 让背景图基于容器大小伸缩(此条属性必须设置否则可能无效) */
            background-color: #ffffff; /* 设置背景颜色，背景图加载过程中会显示背景色 */
            width: 100%;
        }

        #forms {
            top: 250px;
            margin: 0 auto;
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
<div id="formS" style="width: 650px; position: relative;">


    <form class="layui-form" action="login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="userName" required lay-verify="required" placeholder="请输入用户名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="userPassword" required lay-verify="required" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                <a class="layui-btn" href="http://ranking.abmcar.top/">返回榜单</a>
                <!--      <a href="register.jsp"><button class="layui-btn layui-btn-primary">注册</button></a>-->
            </div>
        </div>

    </form>
</div>

<script src="layui/layui.js"></script>
</body>
</html>