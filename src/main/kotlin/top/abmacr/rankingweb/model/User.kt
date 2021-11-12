package top.abmacr.rankingweb.model

import top.abmacr.rankingweb.config.ConfigData

class User {
    private var userName: String? = null
    private var userPassword: String? = null
    private var solveMap: MutableMap<String,Int> = HashMap<String,Int>()
    private var totSolves: Int = 0

    fun User(userName: String, userPassword: String) {
        this.userName = userName
        this.userPassword = userPassword
    }

    fun getUserName(): String { return userName!!}
    fun setUserName(value: String) { userName = value}
    fun getUserPassword(): String { return userPassword!!}
    fun setUserPassword(value: String) { userPassword = value}
    fun getSolutionMap(): MutableMap<String,Int> { return solveMap}
    fun getTotalSolves(): Int {
        var nowTotal = 0
        solveMap.forEach() {
            nowTotal += it.value
        }
        return nowTotal
    }
    fun setOjSolve(ojName: String , solveNum: Int) {
        solveMap[ojName] = solveNum
    }

    fun initSolveMap() {
        val ojs: List<String> = ConfigData.OJ_NAMES
//        for (ojName in ojs)
    }

}