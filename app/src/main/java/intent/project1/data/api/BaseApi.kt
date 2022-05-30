package intent.project1.data.api

import intent.project1.data.model.Domand
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApi {
    public val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Domand.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}