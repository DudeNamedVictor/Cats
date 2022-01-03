package com.example.domain.useCase

import com.example.data.models.CatModel
import com.example.data.repositories.RetrofitServices
import com.example.data.utils.CatsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainUseCase(private val listener: CatsListListener) {

    fun getCatsList() {
        val catsService = CatsService.getCatsList().create(RetrofitServices::class.java)

        catsService.checkLevel().enqueue(object : Callback<List<CatModel>> {
            override fun onResponse(
                call: Call<List<CatModel>>,
                response: Response<List<CatModel>>
            ) {
                sendCatsList(response.body()?.get(0)?.url ?: "")
            }

            override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {
                sendError(t.message ?: "")
            }
        })
    }

    private fun sendCatsList(cats : String) {
        listener.sendCats(cats)
    }

    private fun sendError(error: String) {
        listener.errorCats(error)
    }

    interface CatsListListener {
        fun sendCats(cats: String)
        fun errorCats(error: String)
    }

}