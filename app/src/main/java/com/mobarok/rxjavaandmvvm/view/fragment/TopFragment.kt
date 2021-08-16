package com.mobarok.rxjavaandmvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobarok.rxjavaandmvvm.R
import com.mobarok.rxjavaandmvvm.databinding.FragmentTopBinding
import com.mobarok.rxjavaandmvvm.viewmodel.TestViewModel

class TopFragment : Fragment() {

    lateinit var bind : FragmentTopBinding
    lateinit var viewModel: TestViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        bind = FragmentTopBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(requireActivity()).get(TestViewModel::class.java)

        viewModel.count.observe(requireActivity(), Observer {
            counts->counts?.let {
            bind.textBox.text = counts.toString()
        }
        })

        return bind.root
    }
}