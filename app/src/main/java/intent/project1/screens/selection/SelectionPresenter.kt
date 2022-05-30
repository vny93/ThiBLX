package intent.project1.screens.selection

import intent.project1.data.api.ApiDegreeTypeService
import intent.project1.data.api.ApiExamTypeService
import intent.project1.data.model.DegreeType
import intent.project1.data.model.ExamType

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectionPresenter {
    var mselectionInterface : SelectionInterface

    constructor(mselectionInterface: SelectionActivity) {
        this.mselectionInterface = mselectionInterface
    }

    fun checkEmpty(id1: Int , id2: Int){
        if(id1 == 0|| id2 == 0){
            mselectionInterface.SelectionErrorEmpty()
            return
        }
        mselectionInterface.SelectionSuccess(id1, id2)
    }

    fun getExamType(){
        ApiExamTypeService.ApiLoaide.API_EXAM_TYPE_SERVICE.getListLoaide().enqueue(object : Callback<List<ExamType>>{
            override fun onResponse(call: Call<List<ExamType>>, response: Response<List<ExamType>>) {
                if(response.isSuccessful){
                    var list : List<ExamType> = ArrayList()
                    list = response.body()!!
                    println("list"+list.get(0).tenloaide)
                    mselectionInterface.SetAdapterLD(list)
                }
            }
            override fun onFailure(call: Call<List<ExamType>>, t: Throwable) {
                mselectionInterface.SelectionError()
                println("xảy ra lổi")
            }
        })
    }

    fun getDriverLicense(){
        ApiDegreeTypeService.ApiLoaiBL.API_DEGREE_TYPE_SERVICE.getListLoaibang().enqueue(object : Callback<List<DegreeType>>{
            override fun onResponse(call: Call<List<DegreeType>>, response: Response<List<DegreeType>>)
            {
                if(response.isSuccessful){
                    var list : List<DegreeType> = ArrayList()
                    list = response.body()!!
                    mselectionInterface.SetAdapterLBL(list)
                }
            }
            override fun onFailure(call: Call<List<DegreeType>>, t: Throwable) {
                mselectionInterface.SelectionError()
                println("xảy ra lổi")
            }
        })
    }
}