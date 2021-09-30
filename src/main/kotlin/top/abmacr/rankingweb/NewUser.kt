package top.abmacr.rankingweb

import java.sql.DriverManager
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.sql.*

@WebServlet(name = "newUser", value = ["/newUser"])
class NewUser : HttpServlet() {
    private lateinit var message: String

    override fun init() {
        message = "如有Bug或者其他问题,欢迎在<a href=\"https://github.com/abmcar/RankingWeb/issues\">https://github.com/abmcar/RankingWeb/issues</a> 提issue"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"
        response.characterEncoding = "UTF-8"
        // Hello
        val out = response.writer
        out.println("<html><body>")
        out.println("<h3>$message</h3>")
        out.println("</body></html>")
        val nowName = request.getParameter("name")
        val nowSno = request.getParameter("sno")
        val nowFakeName = request.getParameter("fakeName")
        val now_name_zzulioj = request.getParameter("id_zzulioj")
        val now_name_codeforces = request.getParameter("id_codeforces")
        val now_name_nowcoder = request.getParameter("id_nowcoder")
        val now_name_nyoj = request.getParameter("id_nyoj")
        val now_name_fuquanoj = request.getParameter("id_fuquanoj")

        val JDBC_DRIVER = "com.mysql.jdbc.Driver"
        val DB_URL = "jdbc:mysql://db.abmcar.top:10019/NYIST_ACM"
        Class.forName(JDBC_DRIVER)
        val USER = "nyist"
        val PASS = "password=NULL0"
        val conn = DriverManager.getConnection(DB_URL, USER, PASS)
        val stat = conn.createStatement()
        var nowSql = "INSERT INTO ranking (sno) VALUES ($nowSno)"
        try {
            stat.execute(nowSql)
            out.println("<h1>已在数据库新建学号为 $nowSno 的记录</h1>")
        } catch (e: Exception) {
//            e.printStackTrace()
            out.println("<h1>数据库中学号为 $nowSno 的记录已经存在</h1>")
        }

        val query = conn.createStatement()
        val querySql = "select * from ranking where sno=\'$nowSno\'"
        val queryResult = query.executeQuery(querySql)
        queryResult.next()

        if (nowName.isEmpty())
            out.println("<h1>表单中姓名未填写</h1>")
        else {
            nowSql = "UPDATE ranking SET sname=$nowFakeName where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>姓名填写成功</h1>")
        }

        if (nowFakeName.isEmpty())
            out.println("<h1>表单中昵称未填写</h1>")
        else {
            nowSql = "UPDATE ranking SET fakeName=$nowFakeName where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>昵称填写成功</h1>")
        }

        if (now_name_zzulioj.isEmpty())
            out.println("<h1>表单中zzulioj未填写</h1>")
        else if (queryResult.getString("id_zzulioj") != null) {
            out.println("<h1>数据库中zzulioj已存在,将覆盖原数据</h1>")
            nowSql = "UPDATE ranking SET id_zzulioj=$now_name_zzulioj where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>zzulioj覆盖</h1>")
        }
        else {
            nowSql = "UPDATE ranking SET id_zzulioj=$now_name_zzulioj where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>zzulioj填写成功</h1>")
        }

        if (now_name_codeforces.isEmpty())
            out.println("<h1>表单中codeforces未填写</h1>")
        else if (queryResult.getString("id_codeforces") != null) {
            out.println("<h1>数据库中codeforces已存在,将覆盖原数据</h1>")
            nowSql = "UPDATE ranking SET id_codeforces=$now_name_codeforces where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>codeforces覆盖成功</h1>")
        }
        else {
            nowSql = "UPDATE ranking SET id_codeforces=$now_name_codeforces where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>codeforces填写成功</h1>")
        }

        if (now_name_nowcoder.isEmpty())
            out.println("<h1>表单中nowcoder未填写</h1>")
        else if (queryResult.getString("id_nowcoder") != null) {
            out.println("<h1>数据库中nowcoder存在,将覆盖原数据</h1>")
            nowSql = "UPDATE ranking SET id_nowcoder=$now_name_nowcoder where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>nowcoder覆盖成功</h1>")
        }
        else {
            nowSql = "UPDATE ranking SET id_nowcoder=$now_name_nowcoder where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>nowcoder填写成功</h1>")
        }

        if (now_name_nyoj.isEmpty())
            out.println("<h1>表单中nyoj未填写</h1>")
        else if (queryResult.getString("id_nyoj") != null) {
            out.println("<h1>数据库中nyoj存在,将覆盖原数据</h1>")
            nowSql = "UPDATE ranking SET id_nyoj=$now_name_nyoj where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>nyoj覆盖成功</h1>")
        }
        else {
            nowSql = "UPDATE ranking SET id_nyoj=$now_name_nyoj where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>nyoj填写成功</h1>")
        }

        if (now_name_fuquanoj.isEmpty())
            out.println("<h1>表单中fuquanoj未填写</h1>")
        else if (queryResult.getString("id_fuquan") != null) {
            out.println("<h1>数据库中fuquan存在,将覆盖原数据</h1>")
            nowSql = "UPDATE ranking SET id_fuquan=$now_name_fuquanoj where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>fuquanoj覆盖成功</h1>")
        }
        else {
            nowSql = "UPDATE ranking SET id_fuquan=$now_name_fuquanoj where sno=\'$nowSno\'"
            stat.execute(nowSql)
            out.println("<h1>fuquanoj填写成功</h1>")
        }
            out.println("<h1><a href=\"http://ranking.abmcar.top/\">返回榜单</a></h1>")

    }

    override fun destroy() {
    }
}