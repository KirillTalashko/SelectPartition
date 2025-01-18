package com.example.selectpartition.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.selectpartition.data.model.Products
import com.example.selectpartition.databinding.ItemProductBinding
import com.example.selectpartition.presentation.viewHolder.ProductViewHolder

class ProductAdapter() : ListAdapter<Products, ProductViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Products>() {
            override fun areItemsTheSame(oldItem: Products, newItem: Products) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Products, newItem: Products) =
                oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemProductBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}