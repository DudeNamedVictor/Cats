package com.example.cats.presentation.di

import com.example.cats.presentation.mainFragment.MainFragment
import com.example.data.utils.CatsService
import dagger.Component
import dagger.Module
import dagger.Provides


@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainFragment: MainFragment)

    val catsService: CatsService

}

@Module
object AppModule {

    @Provides
    fun provideCatsService(): CatsService {
        return CatsService
    }

}