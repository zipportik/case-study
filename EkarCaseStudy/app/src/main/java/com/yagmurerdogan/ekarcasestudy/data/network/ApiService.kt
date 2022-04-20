package com.yagmurerdogan.ekarcasestudy.data.network

import com.yagmurerdogan.ekarcasestudy.data.model.response.CarResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("specs")
    suspend fun getSpecs(
        @Query("key") key: String,
        @Query("vin") vin: String
    ): Response<CarResponse>
}