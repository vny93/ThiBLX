package intent.project1.screens.trafficlawsType

import intent.project1.data.api.ApiTrafficLawsService
import intent.project1.data.model.TrafficLawsType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrafficLawsTypePresenter {
    var mTrafficLawsTypeInterface : TrafficLawsTypeInterface

    constructor(mTrafficLawsTypeInterface: TrafficLawsTypeInterface) {
        this.mTrafficLawsTypeInterface = mTrafficLawsTypeInterface
    }


    fun loadListLawsType(){
        ApiTrafficLawsService.ApiLuatGT.API_LUAT_SERVICE.getListLoaiLuat().enqueue(object :Callback<List<TrafficLawsType>>{
            override fun onResponse(call: Call<List<TrafficLawsType>>,response: Response<List<TrafficLawsType>>) {
                if(response.isSuccessful){
                    var list:List<TrafficLawsType> = ArrayList()
                    list = response.body()!!
                    mTrafficLawsTypeInterface.SetAdapterLawsType(list)
                }
            }

            override fun onFailure(call: Call<List<TrafficLawsType>>, t: Throwable) {
                mTrafficLawsTypeInterface.LawsTypeError()
            }

        })


    }
}