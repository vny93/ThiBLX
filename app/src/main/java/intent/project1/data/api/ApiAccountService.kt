package intent.project1.data.api

import intent.project1.data.model.Account
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiAccountService {

    @GET("tk/get")
    fun getListTK(): Call<List<Account>>

    @GET("tk/getById")
    fun getTKByID(@Query("tendangnhap") tendn: String): Call<Account>

    @GET("tk/dangNhap")
    fun checkDN(
        @Query("tendangnhap") tendn: String,
        @Query("matkhau") mk: String
    ): Call<Boolean>

    object ApiTK {
        val API_ACCOUNT_SERVICE: ApiAccountService by lazy { BaseApi().retrofit.create(ApiAccountService::class.java) }
    }
}