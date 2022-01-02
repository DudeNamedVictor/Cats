package com.example.data.repositories

import com.example.data.models.CatModel
import com.example.data.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitServices {
    // replace header

    @Headers("x-api-key: ${Constants.CATS_KEY}")
    @GET("v1/images/search")
    fun checkLevel(): Call<List<CatModel>>
}