package intent.project1.screens.trafficlaws

import intent.project1.data.model.TrafficLaws

interface TrafficLawsInterface {
    fun SetAdapterLaw(list : List<TrafficLaws> )
    fun LawError()
}