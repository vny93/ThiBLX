package intent.project1.screens.selection

import intent.project1.data.model.DegreeType
import intent.project1.data.model.ExamType


interface SelectionInterface {
    fun SelectionSuccess(id1:Int, id2:Int)
    fun SetAdapterLD(list : List<ExamType> )
    fun SetAdapterLBL(list : List<DegreeType> )
    fun SelectionErrorEmpty()
    fun SelectionError()
}