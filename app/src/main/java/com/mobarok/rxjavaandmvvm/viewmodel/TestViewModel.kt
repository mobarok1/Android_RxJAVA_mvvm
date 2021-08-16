package com.mobarok.rxjavaandmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel :ViewModel() {
    val count  = MutableLiveData<List<Int>>();

    init {
        setDemoData();
    }

    private fun setDemoData() {
        val ls = listOf<Int>(1,2,3,4,5,6)
        count.value = ls
    }
    fun add(){
        var ls :MutableList<Int> = count.value!!.toMutableList();
        ls.add(10);
        count.value = ls;
    }
}