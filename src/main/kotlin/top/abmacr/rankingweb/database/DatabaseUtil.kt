package top.abmacr.rankingweb.database

import com.sun.org.apache.xpath.internal.operations.Bool
import top.abmacr.rankingweb.config.ConfigData
import java.sql.Connection
import java.sql.DriverManager
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

    fun getStatement(): Statement {
        return nowStat!!
    }

    fun getConnection(): Connection {
        return nowConnected!!
    }
}