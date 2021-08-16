package com.mobarok.rxjavaandmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobarok.rxjavaandmvvm.di.DaggerApiComponent
import com.mobarok.rxjavaandmvvm.model.CountriesService
import com.mobarok.rxjavaandmvvm.model.Country
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel : ViewModel() {
    @Inject
    lateinit var  countryService : CountriesService
    private val disposable = CompositeDisposable()

    val countries = MutableLiveData<List<Country>>();
    val countryLoadError = MutableLiveData<Boolean>();
    val loading = MutableLiveData<Boolean>();

    fun refresh() {
        fetchCountries();
    }
    init {
        DaggerApiComponent.create().inject(this)
    }

    private fun fetchCountries() {
        loading.value = true
        disposable.add(
            countryService.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(value: List<Country>?) {
                        countries.value = value!!;
                        countryLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        countryLoadError.value = true;
                        loading.value = false;
                    }

                })

        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}