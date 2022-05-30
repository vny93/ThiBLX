package intent.project1.screens.menu

import intent.project1.data.api.ApiTestKitService
import intent.project1.data.model.TestKit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuPresenter {
    var mMenuInterface : MenuInterface
    constructor(mMenuInterface: MenuInterface) {
        this.mMenuInterface = mMenuInterface
    }

    fun getExamCode( maLoaiBL: Int,maLoaide: Int){
        ApiTestKitService.ApiBodethi.API_BODETHI_SERVICE.getBode(maLoaiBL,maLoaide).enqueue(object : Callback<TestKit>{
            override fun onResponse(call: Call<TestKit>, response: Response<TestKit>) {
                if(response.isSuccessful){
                    MenuActivity.idTestKit = response.body()?.mabodethi!!
                    println("mã bộ đề:  "+MenuActivity.idTestKit)
                    mMenuInterface.getExamCode_Success()
                }
            }

            override fun onFailure(call: Call<TestKit>, t: Throwable) {
                mMenuInterface.getExamCode_Error()
            }

        })
    }
}