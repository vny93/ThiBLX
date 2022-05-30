package intent.project1.screens.test

import intent.project1.data.api.ApiQuestionService
import intent.project1.data.api.ApiResultService
import intent.project1.data.model.Answer
import intent.project1.data.model.Question
import intent.project1.data.model.Result
import intent.project1.data.model.User
import intent.project1.screens.login.LoginActivity
import intent.project1.screens.menu.MenuActivity
import intetn.project1.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestPresenter {
    var mtestInterface: TestInterface

    constructor(mtestInterface: TestInterface) {
        this.mtestInterface = mtestInterface
    }

    fun createList(listQ: List<Question>) {
        TestActivity.listMyAnswer = ArrayList()
        for (i in 0..(listQ.size - 1)) {
            var myAnswer: Answer = Answer(i, " ")
            TestActivity.listMyAnswer.add(myAnswer)
        }
    }

//    fun getListExam(){
//        ApiQuestionService.ApiCauhoi.API_QUESTION_SERVICE.ranđDeThi(MenuActivity.idTestKit).enqueue(object : Callback<List<Question>>{
//            override fun onResponse(call: Call<List<Question>>,response: Response<List<Question>>) {
//                println("Bode: "+MenuActivity.idTestKit)
//                TestActivity.listMyQuestion = response.body()!!
//                createList(TestActivity.listMyQuestion)
//            }
//
//            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
//                mtestInterface.TestError()
//            }
//
//        })
//    }

    fun getListExam() { //test tạm thời vì ramdon bị lổi
        ApiQuestionService.ApiCauhoi.API_QUESTION_SERVICE.get()
            .enqueue(object : Callback<List<Question>> {
                override fun onResponse(
                    call: Call<List<Question>>,
                    response: Response<List<Question>>
                ) {
                    println("Bode: " + MenuActivity.idTestKit)
                    TestActivity.listMyQuestion = response.body()!!
                    createList(TestActivity.listMyQuestion)
                    mtestInterface.GetlistQ()
                }

                override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                    mtestInterface.getListError()
                }

            })
    }

    fun getMaxNumber() {
        var email = LoginActivity.id
        var testKit = MenuActivity.idTestKit
        ApiResultService.ApiKQ.API_RESULT_SERVICE.getMaxluotthi(email, testKit)
            .enqueue(object : Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    var max = response.body()
                    if (max != null) {
                        insertResult(max)
                    }
                }
                override fun onFailure(call: Call<Int>, t: Throwable) {
                    mtestInterface.getMaxError()
                }

            })
    }

    fun insertResult(max : Int){
        var listQ: List<Question> = TestActivity.listMyQuestion
        var listA: ArrayList<Answer> = TestActivity.listMyAnswer
        var size = listQ.size -1
        for (i in 0..size) {
//            var number = max + 1
//            var answer = listA.get(i).traloi
//            var userID = LoginActivity.id
//            var questionID = listQ.get(i).macauhoi
            var rs : Result = Result()
            rs.luotthi = max +1
            rs.phuongan = listA.get(i).traloi
            rs.mauser = LoginActivity.id
            rs.macauhoi = listQ.get(i).macauhoi
            insert(rs)
        }
    }

    fun insert(rs: Result) {
        ApiResultService.ApiKQ.API_RESULT_SERVICE.insertKetqua(rs).enqueue(object : Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                mtestInterface.InsertSuccess()
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                mtestInterface.TestInsertError()
            }

        })
    }

    fun countCorrect(): Int {
        var listQ = TestActivity.listMyQuestion
        var listA = TestActivity.listMyAnswer
        var count = 0
        for (i in 0..(listQ.size - 1)) {
            //   println("Cau tl: "+listA.get(i).traloi)
            var myAnswer = listA.get(i).traloi.trim()
            //    println("Dap an: "+listQ.get(i).dapan)
            var answer = listQ.get(i).dapan.trim()
            if (myAnswer.equals(answer)) {
                count = count + 1
            }
        }
        return count
    }

    fun upQuestion(positon: Int, size: Int) {
        if (positon < (size - 1)) {
            mtestInterface.PositionUp(positon + 1)
        } else return
    }

    fun backQuestion(positon: Int) {
        if (positon > 0) {
            mtestInterface.PositionBack(positon - 1)
        } else return
    }
}