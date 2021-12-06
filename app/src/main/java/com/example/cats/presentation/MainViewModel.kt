package com.example.cats.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cats.CatModel
import com.example.cats.utils.GithubApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var catMLD = MutableLiveData<String>()

    fun getUserData() {
        val api = GithubApi.RETROFIT_SERVICE.getCat()

        api.enqueue(object : Callback<List<CatModel>> {
            override fun onResponse(
                call: Call<List<CatModel>>,
                response: Response<List<CatModel>>
            ) {
                catMLD.value = response.body()?.get(0)?.url ?: ""
            }

            override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {}
        })
    }

}