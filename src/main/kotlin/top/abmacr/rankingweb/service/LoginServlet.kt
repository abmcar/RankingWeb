package top.abmacr.rankingweb.service

import top.abmacr.rankingweb.dao.UserDao
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "login", value = ["/login"])
class LoginServlet: HttpServlet() {
    private var userName: String = ""
    private var userPassword: String = ""

    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"
        userName = request.getParameter("userName")
        userPassword = request.getParameter("userPassword")
        if (!UserDao.checkExists(userName)) {
            request.setAttribute("info", "Error user not exist!")
            request.setAttribute("title", "Login Fail")
            request.getRequestDispatcher("message.jsp").forward(request, response)
        }else if (UserDao.checkLogin(userName,userPassword)) {
            request.setAttribute("title", "Login Fail")
            request.setAttribute("info", " Error wrong password!")
            request.getRequestDispatcher("message.jsp").forward(request, response)
        }else {
            val nowUser = UserDao.login(userName,userPassword)
            request.setAttribute("user", nowUser)
            request.getRequestDispatcher("user.jsp").forward(request, response)
        }


    }

}