package com.example.selectpartition.presentation.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.selectpartition.R


fun ImageView.loadPhoto(
    url: String?,
    placeholder: Int = R.drawable.ic_loading,
    error: Int = null ?: R.drawable.no_image
) {
    Glide.with(this.rootView)
        .load("https://szorin.vodovoz.ru".plus(url))
        .placeholder(placeholder)
        .error(error)
        .into(this)
}