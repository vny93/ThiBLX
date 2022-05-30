package intent.project1.screens.trafficlaws

import intent.project1.data.api.ApiTrafficLawsService
import intent.project1.data.model.TrafficLaws
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrafficLawsPresenter {
    var mluatGTInterface : TrafficLawsInterface

    constructor(mluatGTInterface: TrafficLawsInterface) {
        this.mluatGTInterface = mluatGTInterface
    }

    fun loadListLaw(maLoaiLuat : Int){
        ApiTrafficLawsService.ApiLuatGT.API_LUAT_SERVICE.getLuat(maLoaiLuat).enqueue(object : Callback<List<TrafficLaws>>{
            override fun onResponse(call: Call<List<TrafficLaws>>,response: Response<List<TrafficLaws>>)
            {
                if (response.isSuccessful){
                    var list:List<TrafficLaws> = ArrayList()
                    list = response.body()!!
                    mluatGTInterface.SetAdapterLaw(list)
                }
            }

            override fun onFailure(call: Call<List<TrafficLaws>>, t: Throwable) {
                mluatGTInterface.LawError()
            }

        })
    }
}