package intent.project1.data.api

import intent.project1.data.model.ExamType
import retrofit2.Call
import retrofit2.http.GET

interface ApiExamTypeService {
    @GET("loaide/get")
    fun getListLoaide(): Call<List<ExamType>>

    object ApiLoaide {
        val API_EXAM_TYPE_SERVICE: ApiExamTypeService by lazy {BaseApi().retrofit.create(ApiExamTypeService::class.java)}
    }
}