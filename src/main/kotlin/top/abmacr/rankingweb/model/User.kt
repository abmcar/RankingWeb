package top.abmacr.rankingweb.model

class User {
    private var userName: String = ""
    private var userPassword: String = ""
    private var userSno: String = ""
    private var solveMap: MutableMap<String, Int> = HashMap<String, Int>()
    private var totSolves: Int = 0

    constructor(userName: String, userPassword: String, userSno: String) {
        this.userName = userName
        this.userPassword = userPassword
        this.userSno = userSno
    }

    fun getUserName(): String {
        return userName
    }

    fun setUserName(value: String) {
        userName = value
    }

    fun getUserPassword(): String {
        return userPassword
    }

    fun setUserPassword(value: String) {
        userPassword = value
    }

    fun getUserSno(): String {
        return userSno
    }

    fun setUserSno(value: String) {
        userSno = value
    }

    fun getSolutionMap(): MutableMap<String, Int> {
        return solveMap
    }

    fun getTotalSolves(): Int {
        var nowTotal = 0
        solveMap.forEach() {
            nowTotal += it.value
        }
        return nowTotal
    }

    fun setOjSolve(ojName: String, solveNum: Int) {
        solveMap[ojName] = solveNum
    }

}