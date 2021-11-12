package top.abmacr.rankingweb.config

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object ConfigUtil {
    fun loadYaml(configName: String): YamlConfiguration? {
        val configFile = File(configName)
        return YamlConfiguration.loadConfiguration(configFile)
    }
}