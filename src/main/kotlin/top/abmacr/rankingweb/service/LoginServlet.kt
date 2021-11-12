package top.abmacr.rankingweb.service

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoginServlet: HttpServlet() {
    private var userName: String = ""
    private var userPassword: String = ""
    override fun init() {
        userName = ""
        userPassword = ""
    }

    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"
        userName = request.getParameter("userName")
        userPassword = request.getParameter("userPassword")
    }

    override fun destroy() {
    }
}