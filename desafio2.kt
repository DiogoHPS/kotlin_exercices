import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.Properties

object ConfigManager {
    private var config: MutableMap<String, String> = mutableMapOf()

    init {
        carregarConfiguracoes() // Carrega as configurações ao inicializar
    }

    private fun carregarConfiguracoes() {
        try {
            val properties = Properties()
            val inputStream = FileInputStream("config.properties")
            properties.load(inputStream)

            // Converte as propriedades para o map configurado
            properties.forEach { key, value -> config[key.toString()] = value.toString() }
        } catch (e: Exception) {
            println("Erro ao carregar configurações: ${e.message}")
        }
    }

    fun getConfiguracao(chave: String): String? {
        return config[chave]
    }

    fun setConfiguracao(chave: String, valor: String) {
        config[chave] = valor
        salvarConfiguracoes()
    }

    private fun salvarConfiguracoes() {
        try {
            val properties = Properties()
            val outputStream = FileOutputStream("config.properties")

            config.forEach { (key, value) -> properties.setProperty(key, value) }

            properties.store(outputStream, null) // Salva no arquivo
        } catch (e: Exception) {
            println("Erro ao salvar configurações: ${e.message}")
        }
    }
}

fun main() {
    ConfigManager.setConfiguracao("app.theme", "dark")
    ConfigManager.setConfiguracao("app.language", "en")
    ConfigManager.setConfiguracao("app.version", "2.0")
    ConfigManager.setConfiguracao("app.promptSound", "solaris.ogg")
    // valores postos em ConfigManager serão setados por setConfiguracao
    
    println("app.theme=${ConfigManager.getConfiguracao("app.theme")}")
    println("app.language=${ConfigManager.getConfiguracao("app.language")}")
    println("app.version=${ConfigManager.getConfiguracao("app.version")}")
    println("app.promptSound=${ConfigManager.getConfiguracao("app.promptSound")}")
    // e printados pelo getConfiguracao
}