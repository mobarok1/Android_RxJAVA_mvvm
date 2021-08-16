package com.mobarok.rxjavaandmvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobarok.rxjavaandmvvm.R
import com.mobarok.rxjavaandmvvm.databinding.FragmentBottomBinding
import com.mobarok.rxjavaandmvvm.viewmodel.TestViewModel


class BottomFragment : Fragment() {

    lateinit var viewModel: TestViewModel
    private lateinit var bind : FragmentBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = FragmentBottomBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
        viewModel.count.observe(requireActivity(), Observer {
                counts->counts?.let {
                bind.textBox.text = counts.toString()
                }
        })
        return bind.root
    }

}