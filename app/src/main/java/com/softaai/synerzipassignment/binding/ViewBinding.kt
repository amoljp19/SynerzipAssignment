package com.softaai.synerzipassignment.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.softaai.synerzipassignment.model.ImImage

@BindingAdapter("loadImage")
fun bindLoadImage(view: AppCompatImageView, imageList: List<ImImage>) {
    Glide.with(view.context)
        .load(imageList[0].label)
        .into(view)
}