package top.abmacr.rankingweb

import top.abmacr.rankingweb.config.ConfigData
import javax.servlet.http.*
import javax.servlet.annotation.*

@WebServlet(name = "helloServlet", value = ["/hello-servlet"])
class HelloServlet : HttpServlet() {
    private lateinit var message: String

    override fun init() {
        message = "Hello World!"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"

        // Hello
        val out = response.writer
        out.println("<html><body>")
        out.println("<h1>$message</h1>")
        out.println("</body></html>")
        out.println(ConfigData.test())
    }

    override fun destroy() {
    }
}