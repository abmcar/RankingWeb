package top.abmacr.rankingweb.config


import org.bukkit.configuration.file.YamlConfiguration

object ConfigData {

    private val config: YamlConfiguration = ConfigUtil.loadYaml("rankingConfig.yml")!!

    val USER: String? = config.getString("user")
    val PASSWORD: String? = config.getString("password")
    val URL: String? = config.getString("url")
    val OJ_NAMES: List<String> = config.getStringList("ojNames")

}