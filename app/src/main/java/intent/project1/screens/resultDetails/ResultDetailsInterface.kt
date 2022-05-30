package intent.project1.screens.resultDetails

interface ResultDetailsInterface {
    fun PositionUp(pos : Int)
    fun PositionBack(pos : Int)
    fun getResultSuccess()
    fun getResultError()
    fun getResultNumError()
}