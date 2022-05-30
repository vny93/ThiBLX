package intent.project1.screens.result

import intent.project1.data.api.ApiResultService
import intent.project1.data.model.NumberResult
import intent.project1.screens.login.LoginActivity
import intent.project1.screens.menu.MenuActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultPresenter {
    var resultInterface :ResultInterface

    constructor(resultInterface: ResultInterface) {
        this.resultInterface = resultInterface
    }

    fun createList(){
        ResultActivity.exams = ArrayList<NumberResult>()
    }

    fun getNumberExam(){
        createList()
        var email = LoginActivity.id
        var mabode = MenuActivity.idTestKit
        ApiResultService.ApiKQ.API_RESULT_SERVICE.getSTT(email,mabode).enqueue(object : Callback<List<Int>>{
            override fun onResponse(call: Call<List<Int>>, response: Response<List<Int>>) {
                var list : List<Int>? = response.body()
                if (list != null) {
                    for( i in list) {
                        ResultActivity.exams.add(NumberResult(i,"Đề số: "+i))
                        resultInterface.setAdapterNumber()
                    }
                }
            }

            override fun onFailure(call: Call<List<Int>>, t: Throwable) {
                resultInterface.getNumberError()
            }

        })
    }
}