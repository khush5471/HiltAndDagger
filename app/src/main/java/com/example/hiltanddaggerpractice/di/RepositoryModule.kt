package com.example.hiltanddaggerpractice.di

import com.example.hiltanddaggerpractice.network.WebService
import com.example.hiltanddaggerpractice.views.fragment.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {


    @Singleton
    @Provides
    fun getRepositoryInstance(webService: WebService): WeatherRepository {
        return WeatherRepository(webService)
    }
}