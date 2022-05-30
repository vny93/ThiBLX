package intent.project1.screens.test

import intent.project1.data.model.Answer

interface TestInterface {
    fun InsertSuccess()
    fun PositionUp(pos : Int)
    fun PositionBack(pos : Int)
    fun getMaxError()
    fun TestInsertError()
    fun GetlistQ()
    fun getListError()
}