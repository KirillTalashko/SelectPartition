package com.example.selectpartition.presentation.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.selectpartition.data.model.Products
import com.example.selectpartition.databinding.ItemProductBinding

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(products: Products) {
        binding.customViewProduct.setData(
            text = products.price,
            imageMain = products.image
        )
    }
}