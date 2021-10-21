package top.abmacr.rankingweb.config

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object ConfigData {
    //    private val config: YamlConfiguration = File({Context})

    private val config: YamlConfiguration? = ConfigUtil.loadYaml("database.yml")

    val USER: String? = config?.getString("user")
    val PASSWORD: String? = config?.getString("password")
    val URL: String? = config?.getString("url")

    fun test(): String {
        val tempFile: File = File("data.json");
        println(tempFile.absolutePath);
        return tempFile.absolutePath;
    }
}