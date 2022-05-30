package intent.project1.screens.theoryType

import intent.project1.data.api.ApiTheoryTypeService
import intent.project1.data.model.TheoryType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheoryTypePresenter {
    var mTheoryTypeInterface: TheoryTypeInterface

    constructor(mTheoryTypeInterface: TheoryTypeInterface) {
        this.mTheoryTypeInterface = mTheoryTypeInterface
    }

    fun loadListTheoryType(){
        ApiTheoryTypeService.ApiLoailt.ApiService.getListLoailt().enqueue(object : Callback<List<TheoryType>>{
            override fun onResponse(call: Call<List<TheoryType>>,response: Response<List<TheoryType>>) {
                if(response.isSuccessful){
                    var list: List<TheoryType> = ArrayList()
                    list = response.body()!!
                    mTheoryTypeInterface.SetAdapter(list)
                }
            }

            override fun onFailure(call: Call<List<TheoryType>>, t: Throwable) {
                mTheoryTypeInterface.TheoryTypeError()
            }

        })
    }
}