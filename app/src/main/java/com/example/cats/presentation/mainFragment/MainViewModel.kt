package com.example.cats.presentation.mainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.utils.CatsService
import com.example.domain.useCase.MainUseCase

class MainViewModel : ViewModel() {
    // add error exception

    var catsListMLD = MutableLiveData<String>()

    fun getUserData(catsService: CatsService) {
        val mainUseCase = MainUseCase(object : MainUseCase.CatsListListener {
            override fun sendCats(cats: String) {
                catsListMLD.value = cats
            }

            override fun errorCats(error: String) {
                TODO("Not yet implemented")
            }
        })
        mainUseCase.getCatsList(catsService)
    }

}