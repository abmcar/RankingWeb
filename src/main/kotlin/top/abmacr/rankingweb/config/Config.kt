package top.abmacr.rankingweb.config

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class Config {
    private var configFile: File? = null
    private var configYaml: YamlConfiguration? = null

    fun Config(configFile: File?, configYaml: YamlConfiguration?) {
        setConfigFile(configFile)
        setConfigYaml(configYaml)
    }

    fun getConfigYaml(): YamlConfiguration? {
        return configYaml
    }

    fun setConfigYaml(configYaml: YamlConfiguration?) {
        this.configYaml = configYaml
    }

    fun getConfigFile(): File? {
        return configFile
    }

    fun setConfigFile(configFile: File?) {
        this.configFile = configFile
    }

}