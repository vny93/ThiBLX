package intent.project1.screens.resultDetails

import intent.project1.data.api.ApiQuestionService
import intent.project1.data.api.ApiResultService
import intent.project1.data.model.Question
import intent.project1.data.model.Result
import intent.project1.screens.login.LoginActivity
import intent.project1.screens.menu.MenuActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultDetailsPresenter {
    var resultDetailsInterface : ResultDetailsInterface
    var email = LoginActivity.id
    var mabode = MenuActivity.idTestKit

    constructor(resultDetailsInterface: ResultDetailsInterface) {
        this.resultDetailsInterface = resultDetailsInterface
    }

    fun upResult(positon : Int, size: Int){
        if(positon < (size-1)){
            resultDetailsInterface.PositionUp(positon+1)
        }
        else return
    }

    fun backResult(position: Int){
        if(position > 0){
            resultDetailsInterface.PositionBack(position-1)
        }
        else return
    }

    fun getResultDetails(numExam : Int){
        ApiQuestionService.ApiCauhoi.API_QUESTION_SERVICE.getCauhoi_KQ(email, numExam, mabode).enqueue(object : Callback<List<Question>>{
            override fun onResponse(call: Call<List<Question>>,response: Response<List<Question>>) {
                ResultDetailsActivity.listQuestion = response.body()!!
                resultDetailsInterface.getResultSuccess()
            }

            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                resultDetailsInterface.getResultError()
            }

        })
    }

    fun getResultNumExam(numExam : Int){
        ApiResultService.ApiKQ.API_RESULT_SERVICE.getLuotthi(email,numExam,mabode).enqueue(object : Callback<List<Result>>{
            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                ResultDetailsActivity.listResultChoose = response.body()!!
                getResultDetails(numExam)
            }

            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                resultDetailsInterface.getResultNumError()
            }

        })
    }
}