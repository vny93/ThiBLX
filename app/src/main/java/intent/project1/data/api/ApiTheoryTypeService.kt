package intent.project1.data.api

import intent.project1.data.model.TheoryType
import retrofit2.Call
import retrofit2.http.GET


interface ApiTheoryTypeService {
    @GET("loailt/get")
    fun getListLoailt(): Call<List<TheoryType>>

    object ApiLoailt {
        val ApiService: ApiTheoryTypeService by lazy {BaseApi().retrofit.create(ApiTheoryTypeService::class.java)}
    }
}
