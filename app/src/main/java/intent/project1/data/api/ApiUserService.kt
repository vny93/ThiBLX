package intent.project1.data.api

import intent.project1.data.model.Account
import intent.project1.data.model.User
import retrofit2.Call
import retrofit2.http.*



//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

interface ApiUserService {


    @GET("user/get")
    fun getListUser(): Call<List<User>>

    @GET("user/getById")
    fun getUserByID(@Query("email") email: String): Call<User>

    @GET("user/getuserbytk")
    fun getUserByTk(
        @Query("email") email: String,
        @Query("pass") pass: String
    ): Call<User>

    @POST("user/insert")
    fun insertTK(
        @Query("email") email: String,
        @Query("hoten") hoten: String,
        @Query("sdt") sdt: String,
        @Query("matkhau") mk: String
    ): Call<User>

    @PUT("user/update")
    fun update(@Body user: User): Call<User>

    @PUT("user/updateTK")
    fun updateTK(@Body account: Account): Call<Account>

    object ApiUser {
        val apiUserService: ApiUserService by lazy { BaseApi().retrofit.create(ApiUserService::class.java)}
    }
}