package top.abmacr.rankingweb.database

import com.sun.org.apache.xpath.internal.operations.Bool
import top.abmacr.rankingweb.config.ConfigData
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object DatabaseUtil {
    var nowConnected: Connection? = null
    var nowStat: Statement? = null
    init {
        val JDBC_DRIVER = "com.mysql.jdbc.Driver"
        val DB_URL = ConfigData.URL
        Class.forName(JDBC_DRIVER)
        val USER = ConfigData.USER
        val PASS = ConfigData.PASSWORD
        nowConnected = DriverManager.getConnection(DB_URL, USER, PASS)
        nowStat = nowConnected!!.createStatement()
        print("DatabaseUtilInit")
    }

    fun checkConnection(): Boolean {
        val testSql = "select * from user";
        try {
            nowStat!!.executeQuery(testSql)
            return true
        } catch (e :Exception) {
            return false
        }
    }

    fun reConnect() {
        val JDBC_DRIVER = "com.mysql.jdbc.Driver"
        val DB_URL = ConfigData.URL
        Class.forName(JDBC_DRIVER)
        val USER = ConfigData.USER
        val PASS = ConfigData.PASSWORD
        nowConnected = DriverManager.getConnection(DB_URL, USER, PASS)
        nowStat = nowConnected!!.createStatement()
        print("DatabaseReConnect")
    }

    fun getStatement(): Statement {
        if (!checkConnection())
            reConnect()
        return nowStat!!
    }

    fun getConnection(): Connection {
        if (!checkConnection())
            reConnect()
        return nowConnected!!
    }
}