package intent.project1.data.api

import intent.project1.data.model.DegreeType
import retrofit2.Call
import retrofit2.http.GET


interface ApiDegreeTypeService {
    @GET("loaibang/get")
    fun getListLoaibang(): Call<List<DegreeType>>


    object ApiLoaiBL {
        val API_DEGREE_TYPE_SERVICE: ApiDegreeTypeService by lazy {BaseApi().retrofit.create(ApiDegreeTypeService::class.java)}
    }
}