package com.example.selectpartition.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.selectpartition.domain.repository.ProductSelectionRepository
import com.example.selectpartition.presentation.fragment.viewModel.ProductSectionViewModel

class CustomViewModelFactory(
    private val repository: ProductSelectionRepository,
    private val error: String
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductSectionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductSectionViewModel(repository, error) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}