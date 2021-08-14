package com.mobarok.rxjavaandmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobarok.rxjavaandmvvm.databinding.ActivityMainBinding
import com.mobarok.rxjavaandmvvm.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : ListViewModel;
    private val countryAdapter = CountryListAdapter(arrayListOf())
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java);
        viewModel.refresh()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }

        observerViewModel()

    }

    fun observerViewModel(){
        viewModel.countries.observe(this, Observer {
            countries-> countries?.let{
                countryAdapter.updateCountries(it)
            }
        })

        viewModel.countryLoadError.observe(this,Observer{
            isError-> isError?.let{ binding.errorMessage.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                binding.progressDialog.visibility = if(isLoading) View.VISIBLE else View.GONE
                if(it) {
                    binding.errorMessage.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        })
    }
}