package com.mobarok.rxjavaandmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobarok.rxjavaandmvvm.model.Country

class ListViewModel : ViewModel(){
    val countries = MutableLiveData<List<Country>>();
    val countryLoadError = MutableLiveData<Boolean>();
    val loading = MutableLiveData<Boolean>();

    fun refresh(){
        fetchCountries();
    }
    private fun fetchCountries(){
        val mockData:List<Country> = listOf(
            Country(countryName = "Country A"),
            Country(countryName = "Country B"),
            Country(countryName = "Country C"),
            Country(countryName = "Country D"),
            Country(countryName = "Country E"),
            Country(countryName = "Country F"),
            Country(countryName = "Country G"),
            Country(countryName = "Country H"),
            Country(countryName = "Country I"),
            Country(countryName = "Country J"),
        );
        countryLoadError.value = false;
        loading.value = false;
        countries.value = mockData;

    }

}