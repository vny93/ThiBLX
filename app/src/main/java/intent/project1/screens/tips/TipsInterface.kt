package intent.project1.screens.tips

import intent.project1.data.model.TipsType

interface TipsInterface {
    fun SetAdapterTips(list : List<TipsType> )
    fun TipsError()
}