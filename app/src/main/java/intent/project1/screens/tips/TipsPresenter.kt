package intent.project1.screens.tips

import intent.project1.data.api.ApiTipsService
import intent.project1.data.model.TipsType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipsPresenter {
    var mTipsInterface: TipsInterface

    constructor(tipsInterface: TipsInterface) {
        this.mTipsInterface = tipsInterface
    }

    fun loadListTips(){
        ApiTipsService.ApiMeo.API_MEO_SERVICE.getListLoaiMeo().enqueue(object : Callback<List<TipsType>>{
            override fun onResponse(call: Call<List<TipsType>>, response: Response<List<TipsType>>) {
                if(response.isSuccessful){
                    var list:List<TipsType> = ArrayList()
                    list = response.body()!!
                    mTipsInterface.SetAdapterTips(list)
                }
            }

            override fun onFailure(call: Call<List<TipsType>>, t: Throwable) {
                mTipsInterface.TipsError()
            }

        })
    }
}