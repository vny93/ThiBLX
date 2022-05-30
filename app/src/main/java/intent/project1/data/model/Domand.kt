package intent.project1.data.model

import java.io.Serializable

class Domand : Serializable {
    companion object{
         const val BASE_URL ="https://api-huogdoituong.herokuapp.com/api/"
    }
    fun getDomand(): String? {
        return "https://api-huogdoituong.herokuapp.com/api/"
    }
}