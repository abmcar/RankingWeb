<%@ page import="top.abmacr.rankingweb.model.User" %>
<%@ page import="top.abmacr.rankingweb.dao.UserDao" %>
<%@ page import="top.abmacr.rankingweb.config.ConfigData" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Abmcar
  Date: 2021/11/12
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>
    <link rel="stylesheet" href="layui/css/styles.css" type="text/css">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <style type="text/css">

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
            <dd><a href="table.html">退出</a></dd>
        </dl>
    </li>
</ul>
<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
        request.setAttribute("info", "Please login first!");
        request.setAttribute("title", "unLogin");
        response.sendRedirect("login.html");
    } else {
        String userName = user.getUserName();
        String UserSno = user.getUserSno();
%>
<table class="layui-table">
    <tbody>
    <tr>
        <td>
            <h3>用户名</h3>
        </td>
        <td>
            <h3>学号</h3>
        </td>
    </tr>
    <tr>
        <td>
            <h3 id="userName"><%=userName%>
            </h3>
        </td>
        <td>
            <h3 id="userSno"><%=UserSno%>
            </h3>
        </td>
    </tr>
    </tbody>
</table>
<div class="layui-collapse">
    <div class="layui-colla-item">
        <h2 class="layui-colla-title">个人信息</h2>
        <div class="layui-colla-content">
            <table class="layui-table">
                <tbody>
                <tr>
                    <td>OJ名称</td>
                    <td>OJ用户名/ID</td>
                    <td>OJ解题数</td>
                </tr>
                <%


                    user = UserDao.INSTANCE.querySolve(user);
                    user = UserDao.INSTANCE.queryId(user);
                    List<String> ojs = ConfigData.INSTANCE.getOJ_NAMES();
                    for (String nowOj : ojs) {
                %>
                <tr>
                    <td><%=nowOj %>
                    </td>
                    <td><%=user.getIdMap().get(nowOj)%>
                    </td>
                    <td><%=user.getSolutionMap().get(nowOj)%>
                    </td>
                </tr>
                <%
                        }
                    }

                %>
                </tbody>
            </table>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">修改密码</h2>
            <div class="layui-colla-content">
                <form class="layui-form" action="">

                    <div id="mima" class="layui-form-item">
                        <div class="layui-form-item">
                            <label class="layui-form-label">旧密码</label>
                            <div class="layui-input-block">
                                <input style="width:60%;text-align:center;" type="password" id="oldPassword" required lay-verify="required"
                                       placeholder="请输入旧密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-block">
                                <input style="width:60%;text-align:center;" type="password" id="newPassword" required lay-verify="required"
                                       placeholder="请输入新密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div  class="layui-form-item">
                            <label class="layui-form-label">确认密码</label>
                            <div class="layui-input-block">
                                <input style="width:60%;text-align:center;" type="password" id="confirmPassword" required lay-verify="required"
                                       placeholder="请重复输入新密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <input class="layui-btn" onclick="changeUserPassword()" type='button' name='submit' value='更改'>
                        </div>
                    </div>
                </form>
                <div id="result1">

                </div>

            </div>
        </div>
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">OJ用户名修改</h2>
            <div class="layui-colla-content">

                <form class="layui-form">

                    <div class="layui-form-item">
                        <label class="layui-form-label">选择OJ</label>
                        <div class="layui-input-block">
                            <select id="ojName" name="ojName" lay-verify="required">
                                <option value="id_nyoj">nyoj</option>
                                <option value="id_zzulioj">zzulioj</option>
                                <option value="id_codeforces">codeforces</option>
                                <option value="id_nowcoder">nowcoder</option>
                                <option value="id_fuquan">fuquan</option>
                                <option value="id_vjudge">vjudge</option>
                                <option value="id_luogu">luogu</option>
                                <option value="id_jzoj">jzoj</option>
                                <option value="id_hduoj">hduoj</option>
                                <option value="id_poj">poj</option>
                            </select>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">新ID</label>
                            <div class="layui-input-block">
                                <input  type="text" id="newId" name="newId" required lay-verify="required"
                                       placeholder="请输入新ID"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <%--                            <button class="layui-btn" onclick="updateOjId()">登录</button>--%>
                            <input class="layui-btn" onclick="updateOjId()" type='button' name='submit' value='更改'>
                        </div>
                    </div>
                    <div id="result">

                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="layui/layui.js"></script>
    <script src="user.js"></script>
</div>
</body>
</html>
