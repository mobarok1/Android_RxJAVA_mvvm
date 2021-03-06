package com.mobarok.rxjavaandmvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobarok.rxjavaandmvvm.R
import com.mobarok.rxjavaandmvvm.databinding.ItemCountryBinding
import com.mobarok.rxjavaandmvvm.model.Country
import com.mobarok.rxjavaandmvvm.util.getProgressDrawable
import com.mobarok.rxjavaandmvvm.util.loadImage

class CountryListAdapter(var countries:ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries:List<Country>){
        countries.clear();
        countries.addAll(newCountries);
        notifyDataSetChanged();
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position]);
    }

    override fun getItemCount() = countries.size

    class  CountryViewHolder(binding: ItemCountryBinding):RecyclerView.ViewHolder(binding.root){
        private val countryName = binding.countryName;
        private val capitalName = binding.capitalName;
        private val flagImage = binding.flagImage;
        private val _context = binding.root.context;

        fun  bind(country: Country){
            countryName.text = country.countryName;
            capitalName.text = country.capital
            flagImage.loadImage(country.flag, getProgressDrawable(_context))
        }
    }

}