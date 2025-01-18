package com.example.selectpartition.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.selectpartition.domain.repository.ProductSelectionRepository
import com.example.selectpartition.presentation.viewModel.ProductSectionViewModel

class CustomViewModelFactory(private val repository: ProductSelectionRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductSectionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductSectionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}