package com.example.cats.presentation.mainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.useCase.CatsUseCase

class MainViewModel : ViewModel() {
    // think about variable names
    // add error exception

    var catMLD = MutableLiveData<String>()

    fun getUserData() {
        val catsUseCase = CatsUseCase(object : CatsUseCase.Cats {
            override fun sendCats(cats: String) {
                catMLD.value = cats
            }

            override fun errorCats() {
                TODO("Not yet implemented")
            }
        })
        catsUseCase.getCats()
    }

}