package com.example.cats

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CatsService {
    @GET("v1/images/search")
    fun getCat(): Call<List<CatModel>>
}

object GithubApi {
    val RETROFIT_SERVICE: CatsService by lazy {
        retrofit.create(CatsService::class.java)
    }
}