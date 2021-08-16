package com.mobarok.rxjavaandmvvm.di

import com.mobarok.rxjavaandmvvm.model.CountriesApi
import com.mobarok.rxjavaandmvvm.model.CountriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    private val BASE_URL = "https://raw.githubusercontent.com"
    var count = 0 ;

    @Provides
    fun provideCountriesApi():CountriesApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }
    @Provides
    fun provideCountryService(): CountriesService{
        return CountriesService()
    }

    @Provides
    fun getCountVal(): Int{
        return  count
    }
}