package com.mobarok.rxjavaandmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobarok.rxjavaandmvvm.R
import com.mobarok.rxjavaandmvvm.databinding.ActivitySecondBinding
import com.mobarok.rxjavaandmvvm.view.fragment.TopFragment
import com.mobarok.rxjavaandmvvm.viewmodel.ListViewModel
import com.mobarok.rxjavaandmvvm.viewmodel.TestViewModel

class SecondActivity : AppCompatActivity() {
    lateinit var bind : ActivitySecondBinding;
    lateinit var viewModel : TestViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bind.root)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java);


        supportFragmentManager.commit {
            add(R.id.frameLayoutTop,TopFragment())
        }
        supportFragmentManager.commit {
            add(R.id.frameLayoutBottom,TopFragment())
        }

        viewModel.count.observe(this, Observer{
            counts->counts?.let{
                println(counts)
            }
        })

        bind.buttonC.setOnClickListener{
            viewModel.add()
        }


    }
}