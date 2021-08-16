package com.mobarok.rxjavaandmvvm.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.mobarok.rxjavaandmvvm.R

fun getProgressDrawable(context : Context) : CircularProgressIndicator{
    return CircularProgressIndicator(
        context
    ).apply {

    }
}

fun ImageView.loadImage(uri:String?,progressIndicator : CircularProgressIndicator?){
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher)
        .circleCrop()
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)

        .into(this)
}