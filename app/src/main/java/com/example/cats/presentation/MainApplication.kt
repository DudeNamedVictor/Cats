package com.example.cats.presentation

import android.app.Application
import com.example.cats.presentation.di.AppComponent
import com.example.cats.presentation.di.DaggerAppComponent

open class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}