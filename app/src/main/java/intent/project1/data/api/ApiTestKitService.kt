package intent.project1.data.api

import intent.project1.data.model.TestKit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiTestKitService {

    @GET("bodethi/getBodethi")
    fun getBode(
        @Query("maloaibang") maloaibang: Int,
        @Query("maloaide") maloaide: Int
    ): Call<TestKit>

    object ApiBodethi {
        val API_BODETHI_SERVICE: ApiTestKitService by lazy {BaseApi().retrofit.create(ApiTestKitService::class.java)}
    }
}