package com.mobarok.rxjavaandmvvm.di

import com.mobarok.rxjavaandmvvm.model.CountriesService
import com.mobarok.rxjavaandmvvm.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
    fun inject(viewModel:ListViewModel)
}