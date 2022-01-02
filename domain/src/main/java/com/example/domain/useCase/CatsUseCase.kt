package com.example.domain.useCase

import com.example.domain.models.CatModel
import com.example.domain.repositories.RetrofitServices
import com.example.domain.utils.CatsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatsUseCase(private val listener: Cats) {
    // think about variable names

    fun getCats() {
        val api = CatsService.getCats().create(RetrofitServices::class.java)

        api.checkLevel().enqueue(object : Callback<List<CatModel>> {
            override fun onResponse(
                call: Call<List<CatModel>>,
                response: Response<List<CatModel>>
            ) {
                updateResults(response.body()?.get(0)?.url ?: "")
            }

            override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {}
        })
    }

    fun updateResults(cats : String) {
        listener.sendCats(cats)
    }

    interface Cats {
        fun sendCats(cats: String)
        fun errorCats()
    }

}