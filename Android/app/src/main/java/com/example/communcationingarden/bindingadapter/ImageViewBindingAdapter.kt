package com.example.communcationingarden.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun ImageView.loadImage(imageSrc: String?) {
    imageSrc ?: return
    Glide.with(context)
        .load(imageSrc)
        .into(this)
}
