package intent.project1.data.api

import intent.project1.data.model.Question
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiQuestionService {

    //test tạm thời
    @GET("cauhoi/get")
    fun get(): Call<List<Question>>
    //

    @GET("cauhoi/getCauhoiLT")
    fun getCauhoiLT(
        @Query("mabode") mabode: Int,
        @Query("maloailt") maloailt: Int
    ): Call<List<Question>>

    @GET("cauhoi/randDeThi")
    fun ranđDeThi(@Query("mabode") mabode: Int): Call<List<Question>>

    @GET("cauhoi/getkqch")
    fun getCauhoi_KQ(
        @Query("email") email: String,
        @Query("luotthi") luotthi: Int,
        @Query("mabode") mabode: Int
    ): Call<List<Question>>

    @GET("cauhoi/getcausai")
    fun getCausai(
        @Query("email") email: String,
        @Query("mabode") mabode: Int
    ): Call<List<Question>>

    object ApiCauhoi {
        val API_QUESTION_SERVICE: ApiQuestionService by lazy {BaseApi().retrofit.create(ApiQuestionService::class.java)}
    }
}