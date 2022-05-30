package intent.project1.data.api


import intent.project1.data.model.TipsType
import intent.project1.data.model.Tips
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiTipsService {

    @GET("meo/getLoaiMeo")
    fun getListLoaiMeo(): Call<List<TipsType>>

    @GET("meo/getMeo")
    fun getMeo(@Query("maloaimeo") maloaimeo: Int): Call<Tips>

    object ApiMeo {
        val API_MEO_SERVICE: ApiTipsService by lazy { BaseApi().retrofit.create(ApiTipsService::class.java) }
    }
}