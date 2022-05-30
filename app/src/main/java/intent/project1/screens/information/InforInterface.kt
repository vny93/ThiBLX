package intent.project1.screens.information

import intent.project1.data.model.User

interface InforInterface {
    fun InforList(user : User)
    fun InforError()
    fun InforEmpty()
    fun InforSuccess()
}