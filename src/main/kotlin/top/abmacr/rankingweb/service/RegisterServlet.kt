package top.abmacr.rankingweb.service

import top.abmacr.rankingweb.dao.UserDao
import top.abmacr.rankingweb.database.DatabaseUtil
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "register", value = ["/register"])
class RegisterServlet : HttpServlet() {
    private var userName: String = ""
    private var userPassword: String = ""
    private var userSno: String = ""

    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"
        userName = request.getParameter("userName")
        userPassword = request.getParameter("userPassword")
        userSno = request.getParameter("UserSno")

        if (UserDao.checkExists(userName)) {
            request.setAttribute("info", "Error user exist!")
            request.setAttribute("title", "Register Fail")
            request.getRequestDispatcher("message.jsp").forward(request, response)
        } else if (UserDao.checkRegister(userSno)) {
            request.setAttribute("info", "Error sno exist!")
            request.setAttribute("title", "Register Fail")
            request.getRequestDispatcher("message.jsp").forward(request, response)
        } else {
            UserDao.register(userName, userPassword, userSno)
            request.setAttribute("title", " Register Success")
            request.setAttribute("info", "Register Success! Please login!")
            request.getRequestDispatcher("message.jsp").forward(request, response)
        }
    }
}