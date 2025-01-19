package com.example.selectpartition.presentation.fragment.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.selectpartition.data.model.Products
import com.example.selectpartition.databinding.ItemProductBinding

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(products: Products, defaultCurrency: String) {
        binding.customViewProduct.setData(
            text = products.listPrice[0].price.toString()
                .plus(products.currency ?: defaultCurrency),
            imageMain = products.image
        )
    }
}