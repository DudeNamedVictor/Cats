package com.example.cats.utils

import com.example.cats.CatModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitServices {
    @Headers("x-api-key: ${Constants.CATS_KEY}")
    @GET("v1/images/search")
    fun checkLevel(): Call<List<CatModel>>
}