package intent.project1.screens.theoryType

import intent.project1.data.model.TheoryType

interface TheoryTypeInterface {
    fun SetAdapter(list: List<TheoryType>)
    fun TheoryTypeError()
}