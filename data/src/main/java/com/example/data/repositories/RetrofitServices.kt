package com.example.data.repositories

import com.example.data.models.CatModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("v1/images/search")
    fun getCats(): Call<List<CatModel>>
}