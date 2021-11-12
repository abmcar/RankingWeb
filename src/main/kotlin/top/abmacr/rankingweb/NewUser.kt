package top.abmacr.rankingweb

import top.abmacr.rankingweb.config.ConfigData
import top.abmacr.rankingweb.database.DatabaseUtil
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "newUser", value = ["/newUser"])
class NewUser : HttpServlet() {
    private lateinit var message: String

    override fun init() {
        message =
            "如有Bug或者其他问题,欢迎在<a href=\"https://github.com/abmcar/RankingWeb/issues\">https://github.com/abmcar/RankingWeb/issues</a> 提issue"
    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"
        response.characterEncoding = "UTF-8"
        val nowName = request.getParameter("name")
        val nowSno = request.getParameter("sno")
        val nowFakeName = request.getParameter("fakeName")
        val ojList: List<String> = ConfigData.OJ_NAMES
        val ids: MutableMap<String, String> = HashMap()
        for (ojName in ojList) {
            val nowParameter = "id_$ojName"
            ids[ojName] = request.getParameter(nowParameter)
        }

        val stat = DatabaseUtil.getStatement()
        var nowSql = "INSERT INTO ranking (sno) VALUES ($nowSno)"

        var nowLog = ""

        nowLog += try {
            stat.execute(nowSql)
            request.setAttribute("snoStatus", "√")
            "已在数据库新建学号为 $nowSno 的记录."
        } catch (e: Exception) {
            request.setAttribute("snoStatus", "×")
            "数据库中学号为 $nowSno 的记录已经存在."
        }

        val query = DatabaseUtil.getConnection().createStatement()
        val querySql = "select * from ranking where sno='$nowSno'"
        val queryResult = query.executeQuery(querySql)
        queryResult.next()

        if (nowName.isEmpty()) {
            request.setAttribute("snameStatus", "×")
            nowLog += "表单中姓名未填写."
        } else {
            nowSql = "UPDATE ranking SET sname='$nowName' where sno=\'$nowSno\'"
            stat.execute(nowSql)
            request.setAttribute("snameStatus", "√")
            nowLog += "姓名填写成功."
        }

        if (nowFakeName.isEmpty()) {
            request.setAttribute("fakeNameStatus", "×")
            nowLog += "表单中昵称未填写."
        } else {
            nowSql = "UPDATE ranking SET fakeName='$nowFakeName' where sno=\'$nowSno\'"
            stat.execute(nowSql)
            request.setAttribute("fakeNameStatus", "√")
            nowLog += "昵称填写成功."
        }

        for (ojName in ojList) {
            if (ids[ojName] == "") {
                request.setAttribute(ojName, "×")
                nowLog += "表单中id_$ojName 未填写."
                continue
            }
            if (queryResult.getString("id_$ojName") != null) {
                nowSql = "UPDATE ranking SET id_$ojName='${ids[ojName]}' where sno=\'$nowSno\'"
                stat.execute(nowSql)
                request.setAttribute(ojName, "√")
                nowLog += "数据库中id_$ojName 已存在,将覆盖原数据<."
            } else {
                nowSql = "UPDATE ranking SET id_$ojName='${ids[ojName]}' where sno=\'$nowSno\'"
                stat.execute(nowSql)
                request.setAttribute(ojName, "√")
                nowLog += "id_$ojName 填写成功<."
            }
        }
        request.setAttribute("log", nowLog)
        request.getRequestDispatcher("/message.jsp").forward(request, response)
    }
}