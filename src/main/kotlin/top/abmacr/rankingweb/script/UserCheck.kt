package top.abmacr.rankingweb.script

import top.abmacr.rankingweb.dao.UserDao
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
        val action = request.getParameter("action").toString()
        when (action) {
            "updateOjId" -> updateOjId(request,response)
            "updateUserPassword" -> updateUserPassword(request,response)
        }
    }

    private fun updateOjId(request: HttpServletRequest, response: HttpServletResponse) {
        val userSno: String = request.getParameter("userSno")
        val ojName: String = request.getParameter("ojName")
        val newId: String = request.getParameter("newId")
        val out = response.writer
        if (UserDao.updateOjId(userSno,ojName,newId)) {
            out.println("<h3>ID更新完成</h3>")
            out.println("<h3>新ID:$newId</h3>")
        }else {
            out.println("<h3>ID更新失败</h3>")
        }
        out.flush()
        out.close()
    }

    private fun updateUserPassword(request: HttpServletRequest, response: HttpServletResponse) {
        val userSno: String = request.getParameter("userSno")
        val oldPassword = request.getParameter("oldPassword")
        val newPassword = request.getParameter("newPassword")
        val confirmPassword = request.getParameter("confirmPassword")
        val out = response.writer
        out.println("<h3>1$oldPassword</h3>")
        out.println("<h3>2$newPassword</h3>")
        out.println("<h3>3$confirmPassword</h3>")
        if (newPassword != confirmPassword) {
            out.println("<h3>新密码和确认密码不同！<h3>")
        }else if (UserDao.updateUserPassword(userSno,oldPassword,newPassword)) {
            out.println("<h3>密码更新完成</h3>")
        }else {
            out.println("<h3>密码更新失败</h3>")
            out.println("<h3>可能是因为原密码错误或者其他未知原因</h3>")
        }
        out.flush()
        out.close()
    }
}