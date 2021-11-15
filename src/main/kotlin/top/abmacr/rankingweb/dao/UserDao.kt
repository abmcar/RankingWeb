package top.abmacr.rankingweb.dao

import top.abmacr.rankingweb.config.ConfigData
import top.abmacr.rankingweb.database.DatabaseUtil
import top.abmacr.rankingweb.model.User
import java.sql.ResultSet
import java.sql.Statement

object UserDao {
    fun checkExists(userName: String): Boolean {
        val stat: Statement = DatabaseUtil.getStatement()
        val querySql: String = "select * from user where user='$userName'"
        val resultSet: ResultSet = stat.executeQuery(querySql)
        if (resultSet.next())
            return true
        return false
    }

    fun checkLogin(userName: String, userPassword: String): Boolean {
        val stat: Statement = DatabaseUtil.getStatement()
        val querySql: String = "select * from user where user='$userName'"
        val resultSet: ResultSet = stat.executeQuery(querySql)
        resultSet.next()
        val test = resultSet.getString("password")
        if (!resultSet.getString("password").equals(userPassword))
            return true;
        return false
    }

    fun checkRegister(userSno: String): Boolean {
        val stat: Statement = DatabaseUtil.getStatement()
        val querySql: String = "select * from user where sno='$userSno'"
        val resultSet: ResultSet = stat.executeQuery(querySql)
        if (resultSet.next())
            return true
        return false
    }

    fun login(userName: String, userPassword: String): User {
        val nowSno = querySno(userName)
        return User(userName, userPassword, nowSno)
    }

    fun register(userName: String, userPassword: String, userSno: String) {
        val stat: Statement = DatabaseUtil.getStatement()
        val sql = "insert into user values('$userName','$userPassword','$userSno')"
        stat.execute(sql)
    }


    fun querySolve(user: User): User {
        val ojs: List<String> = ConfigData.OJ_NAMES
        val stat: Statement = DatabaseUtil.getStatement()
        val nowQuery = "select * from ranking where sno='${user.getUserSno()}'"
        val rs: ResultSet = stat.executeQuery(nowQuery)
        if (rs.next()) {
            for (ojName in ojs)
                if (ojName.equals("fuquanoj"))
                    user.setOjSolve(ojName, rs.getInt("solve_fuquan"))
                else
                    user.setOjSolve(ojName, rs.getInt("solve_${ojName}"))
        }
        return user
    }

    fun queryId(user: User): User {
        val ojs: List<String> = ConfigData.OJ_NAMES
        val stat: Statement = DatabaseUtil.getStatement()
        val nowQuery = "select * from ranking where sno='${user.getUserSno()}'"
        val rs: ResultSet = stat.executeQuery(nowQuery)
        if (rs.next()) {
            for (ojName in ojs)
                if (ojName.equals("fuquanoj"))
                    user.setOjId(ojName, rs.getString("id_fuquan"))
                else
                    user.setOjId(ojName, rs.getString("id_${ojName}"))
        }
        return user
    }

    fun updateOjId(userSno: String, ojName: String, newId: String): Boolean {
        try {
            val stat = DatabaseUtil.getStatement()
            val nowSql = "UPDATE ranking SET $ojName='$newId' where sno='${userSno}'"
            stat.execute(nowSql)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun updateUserPassword(userSno: String, oldPassword: String, newPassword: String): Boolean {
        try {
            val stat: Statement = DatabaseUtil.getStatement()
            val nowQuery = "select * from user where sno='$userSno'"
            val rs: ResultSet = stat.executeQuery(nowQuery)
            rs.next()
            return if (rs.getString("password").equals(oldPassword))
                try {
                    val nowSql = "UPDATE user SET password='$newPassword' where sno='${userSno}'"
                    stat.execute(nowSql)
                    true
                } catch (e: Exception) {
                    false
                }
            else
                false
        } catch (e: Exception) {
            return false
        }
    }

    private fun querySno(userName: String): String {
        val stat: Statement = DatabaseUtil.getStatement()
        val nowQuery = "select * from user where user='$userName'"
        val rs: ResultSet = stat.executeQuery(nowQuery)
        rs.next()
        return rs.getString("sno")
    }


}
