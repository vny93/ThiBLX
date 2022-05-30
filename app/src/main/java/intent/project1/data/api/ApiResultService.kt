package intent.project1.data.api

import intent.project1.data.model.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiResultService {

    @GET("ketqua/max")
    fun getMaxluotthi(@Query("id") email: String,
                      @Query("mabode") maloailt: Int): Call<Int>


    @POST("ketqua/insertKetqua")
    fun insertKetqua(@Body result: Result): Call<Result>

    @GET("ketqua/getLuotThi")
    fun  //get lượt thi để lấy ra kết quả đã chọn
            getLuotthi(@Query("email") email: String,
            @Query("luotthi") luotthi: Int,
            @Query("mabode") mabode: Int): Call<List<Result>>

    @GET("ketqua/deleteKQ")
    fun xoaKQ(@Query("luotthi") luotthi: Int,
              @Query("email") email: String ): Call<Void>

    @GET("ketqua/getSTT")
    fun getSTT(@Query("email") email: String,
               @Query("mabode") mabode: Int): Call<List<Int>>

    object ApiKQ {
        val API_RESULT_SERVICE: ApiResultService by lazy {BaseApi().retrofit.create(ApiResultService::class.java)}
    }
}