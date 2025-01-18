package com.example.selectpartition.presentation.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.selectpartition.R
import com.example.selectpartition.databinding.CustomViewCommonCardProductBinding
import com.example.selectpartition.presentation.utils.extension.loadPhoto

class CommonCardProductCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var _binding: CustomViewCommonCardProductBinding? = null
    private val binding
        get() = _binding!!

    init {
        _binding =
            CustomViewCommonCardProductBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setData(
        text: String?,
        imageMain: String?,
        imageTop: String? = null,
        imageButton: String? = null
    ) {
        binding.apply {
            textViewText.text = text
            imageViewMain.loadPhoto(imageMain)
            imageViewTop.loadPhoto(imageTop, error = R.drawable.ic_favorite_product)
            imageViewButton.loadPhoto(imageButton, error = R.drawable.ic_shop_basket)
        }
    }

}