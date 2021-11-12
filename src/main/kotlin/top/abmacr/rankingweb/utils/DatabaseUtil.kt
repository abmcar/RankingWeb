package top.abmacr.rankingweb.utils

import top.abmacr.rankingweb.database.DatabaseUtil

object DatabaseUtil {
    fun getSolveNum(ojName: String, ojId: String): Int {
        return try {
            val nowSql = "select * from ranking where id_$ojName=$ojId"
            val query = DatabaseUtil.getConnection().createStatement()
            val queryResult = query.executeQuery(nowSql)
            if (queryResult.next())
                queryResult.getInt("solve_$ojName")
            else
                0

        } catch (e: Exception) {
            0
        }
    }
}