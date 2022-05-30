package intent.project1.data.api


import intent.project1.data.model.TrafficLawsType
import intent.project1.data.model.TrafficLaws
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiTrafficLawsService {
    @GET("luat/getLoailuat")
    fun getListLoaiLuat(): Call<List<TrafficLawsType>>

    @GET("luat/getLuat")
    fun getLuat(@Query("maloailuat") maloailuat: Int): Call<List<TrafficLaws>>

    object ApiLuatGT {
        val API_LUAT_SERVICE: ApiTrafficLawsService by lazy { BaseApi().retrofit.create(ApiTrafficLawsService::class.java) }
    }
}