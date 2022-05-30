package intent.project1.screens.theory

import intent.project1.adapter.TheoryTypeAdapter
import intent.project1.data.api.ApiQuestionService
import intent.project1.data.model.Question
import intent.project1.screens.menu.MenuActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudyTheoryPresenter {
    var mstudyTheoryInterface: StudyTheoryInterface

    constructor(mstudyTheoryInterface: StudyTheoryInterface) {
        this.mstudyTheoryInterface = mstudyTheoryInterface
    }

    fun upQuestion(positon: Int, size : Int){
        if( positon < (size-1)){
            mstudyTheoryInterface.PositionUp(positon+1)
        }
        else return
    }

    fun backQuestion(position : Int){
        if(position > 0){
            mstudyTheoryInterface.PositionBack(position-1)
        }
        else return
    }

    fun loadListTheory(){
        ApiQuestionService.ApiCauhoi.API_QUESTION_SERVICE.getCauhoiLT(MenuActivity.idTestKit, TheoryTypeAdapter.idTheory).enqueue(object : Callback<List<Question>>{
            override fun onResponse(call: Call<List<Question>>,response: Response<List<Question>>) {
                StudyTheoryActivity.listQuestion = response.body()!!
                mstudyTheoryInterface.TheorySuccess()
            }

            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                mstudyTheoryInterface.TheoryError()
            }

        })
    }
}