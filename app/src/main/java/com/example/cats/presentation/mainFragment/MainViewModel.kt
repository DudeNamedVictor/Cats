package com.example.cats.presentation.mainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cats.CatModel
import com.example.cats.utils.CatsService
import com.example.cats.utils.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var catMLD = MutableLiveData<String>()

    fun getUserData() {
        val api = CatsService.getCats().create(RetrofitServices::class.java)

        api.checkLevel().enqueue(object : Callback<List<CatModel>> {
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