package top.abmacr.rankingweb.script

import top.abmacr.rankingweb.database.DatabaseUtil
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "userCheck", value = ["/userCheck"])
class UserCheck : HttpServlet() {
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        request.characterEncoding = "utf-8"
        response.characterEncoding = "utf-8"
        val action = request.getParameter("action")
        when (action) {
            "changeOjId" -> changeOjId(request,response)
        }
    }

    private fun changeOjId(request: HttpServletRequest, response: HttpServletResponse) {
        val userSno: String = request.getParameter("userSno")
        val ojName: String = request.getParameter("ojName")
        val newId: String = request.getParameter("newId")
        val out = response.writer
        out.println("<h3>$ojName</h3>")
        try {
            val stat = DatabaseUtil.getStatement()
            val nowSql = "UPDATE ranking SET $ojName='$newId' where sno='$userSno'"
            stat.execute(nowSql)
            out.println("<h3>更新完成</h3>")
        } catch (e:Exception) {
            out.println("<h3>更新失败</h3>")
        }
        out.flush()
        out.close()
    }
}